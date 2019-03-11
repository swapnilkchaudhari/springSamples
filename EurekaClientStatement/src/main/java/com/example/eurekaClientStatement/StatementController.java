package com.example.eurekaClientStatement;

import java.net.URI;
import java.util.List;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import feign.FeignException;
import feign.RequestLine;
import feign.hystrix.FallbackFactory;
import feign.hystrix.HystrixFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class StatementController {

    //@Autowired DiscoveryClient client;
	/*@Autowired
	private RestTemplate template;*/

	@Autowired
    private NounClientImpl nounClient;

    @Autowired
    private SubjectClient subjectClient;

    @Autowired
    private VerbClient verbClient;

    @GetMapping("/")
    public String getStatement() {
        return subjectClient.getSubject() + " "
                + verbClient.getVerb() + " "
                +nounClient.getNoun()+".";
		/*return getWord("EurekaClientSubject")+" "
				+getWord("EurekaClientVerb")+" "
				+getWord("EurekaClientNoun")+".";*/
    }

    /*private String getWord(String serviceName){
     *//*List<ServiceInstance> list=client.getInstances(serviceName);
		if (list != null && list.size() > 0 ) {
			URI uri;
			if(serviceName.equals("EurekaClientNoun"))
					uri = URI.create(list.get(0).getUri().toString()+"/Noun");
					else
						uri = list.get(0).getUri();
			if (uri !=null ) {
			    return (new RestTemplate()).getForObject(uri,String.class);
			  }
		}
		return null;*//*
		if (serviceName.equals("EurekaClientNoun"))
			return template.getForObject("http://" + serviceName + "/Noun", String.class);
		else
			return template.getForObject("http://" + serviceName, String.class);
	}*/
}

@Service
class NounClientImpl {

    @Autowired
    private NounClient nounClient;

    @com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand(fallbackMethod = "getNounFallBack")
    public String getNoun() {
        return nounClient.getNoun();
    }

    public String getNounFallBack() {
        return "HystrixCommandNoun";
    }
}

@FeignClient(name = "EurekaClientNoun"/*, fallback = SubjectFallback.class*/)
interface NounClient {
    @GetMapping("/Noun")
    String getNoun();
}

@FeignClient(name = "EurekaClientSubject", fallback = SubjectFallback.class)
interface SubjectClient {
    @GetMapping("/")
    String getSubject();
}

@FeignClient(name = "EurekaClientVerb", fallback = SubjectFallback.class)
interface VerbClient {
    @GetMapping("/")
    String getVerb();
}

@Component
class SubjectFallback implements SubjectClient, VerbClient {

    @Override
    public String getSubject() {
        return "defaultSubject";
    }

    @Override
    public String getVerb() {
        return "defaultVerb";
    }

    /*@Override
    public String getNoun() {
        return "defaultNoun";
    }*/
}