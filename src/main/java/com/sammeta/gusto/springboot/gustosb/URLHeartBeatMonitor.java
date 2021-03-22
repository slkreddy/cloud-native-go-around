package com.sammeta.gusto.springboot.gustosb;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class URLHeartBeatMonitor{

	private static final String template = "The URL: %s is %s; Response Message is %s";
	private static final String template_failure = "The URL: %s is %s";



	@GetMapping("/heartbeat" )
	public String getURLHeartBeatStatus(@RequestParam(value = "url", defaultValue = "https://www.google.com") String url) {
		String returnMsg = "";
		String respMessage = "";
		try {
			System.out.println("The URL to monitor is: "+url);
			URL urlObj = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			respMessage = conn.getResponseMessage();
			int respCodeCat = conn.getResponseCode() / 100;
			if (respCodeCat != 2) {
				returnMsg = String.format(template, url, "DOWN", respMessage);
			} else {
				returnMsg = String.format(template, url, "UP", respMessage);
			}

		} catch(MalformedURLException e) {
			returnMsg = String.format(template_failure, url, "MALFORMED", respMessage);;
		} catch(IOException e) {
			returnMsg = String.format(template_failure, url, "DOWN", respMessage);
		}
		
		System.out.println("The result of the URL heartbeat check: "+ returnMsg);
		
		return returnMsg;
	}
}
