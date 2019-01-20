package com.example.eurekaClientStatement;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class StatementController {
	
	//@Autowired DiscoveryClient client;
	@Autowired RestTemplate template;

	@GetMapping("/")
	public String getStatement(){
		return getWord("EurekaClientSubject")+" "
				+getWord("EurekaClientVerb")+" "
				+getWord("EurekaClientNoun")+".";
	}
	
	private String getWord(String serviceName){
		/*List<ServiceInstance> list=client.getInstances(serviceName);
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
		return null;*/
		if (serviceName.equals("EurekaClientNoun"))
			return template.getForObject("http://" + serviceName + "/Noun", String.class);
		else
			return template.getForObject("http://" + serviceName, String.class);
	}
}
