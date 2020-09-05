package com.home.app.util;

import java.net.URI;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.home.app.entities.Topic;

public class TopicRestClientUtil {

	public static void main(String[] args) {
		TopicRestClientUtil restClientUtil = new TopicRestClientUtil();
		//restClientUtil.getTopicByIdDemo();
		//restClientUtil.getAllTopicsDemo();
		//restClientUtil.addTopicDemo();
		//restClientUtil.updateTopicDemo();
		restClientUtil.deleteTopicDemo();
	}

	private void getTopicByIdDemo() {
		HttpHeaders headers = getHeaders();
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:9090/user/topic/{id}";
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<Topic> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Topic.class,1);
		Topic topic = responseEntity.getBody();
		System.out.println(topic);
	}

	private void getAllTopicsDemo() {
		HttpHeaders headers = getHeaders();
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:9090/user/topics";
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<Topic[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Topic[].class);
		Topic[] topicData = responseEntity.getBody();
		for (Topic topic : topicData) {
			System.out.println(topic);
		}
		
	}

	private void addTopicDemo() {
		HttpHeaders headers = getHeaders();
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:9090/user/topic";
		Topic topic =new Topic();
		topic.setTitle("Spring Rest Web Service");
		topic.setCategory("Spring Boot rest");
		HttpEntity<Topic> requestEntity = new HttpEntity<Topic>(topic,headers);
		URI uri = restTemplate.postForLocation(url, requestEntity);
		System.out.println(uri.getPath());
	}

	private void updateTopicDemo() {
		HttpHeaders headers = getHeaders();
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:9090/user/topic";
		Topic topic =new Topic();
		topic.setTopicId(4);
		topic.setTitle("Update:Spring Rest Web Service");
		topic.setCategory("Updated:Spring Boot rest");
		HttpEntity<Topic> requestEntity = new HttpEntity<Topic>(topic,headers);
		restTemplate.put(url, requestEntity);
	}

	private void deleteTopicDemo() {
		HttpHeaders headers = getHeaders();
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:9090/user/topic/{id}";
		HttpEntity<Topic> requestEntity = new HttpEntity<Topic>(headers);
		restTemplate.exchange(url, HttpMethod.DELETE, requestEntity,Void.class, 4);
	}

	private HttpHeaders getHeaders() {
		String credential = "vivek:v@123";
		String encodedCredential = new String(Base64.encodeBase64(credential.getBytes()));
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", "Basic " + encodedCredential);
		return headers;
	}

}
