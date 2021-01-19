package com.sammeta.gusto.springboot.gustosb;

import java.io.IOError;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class URLHeartBeatMonitor{

	private final String IS_URL_UP = "The URL is up";
	private final String IS_URL_DOWN = "The URL isn't reachable";
	private final String INCORRECT_URL = "The URL is malformed";

	@GetMapping("/heartbeat" )
	public String getURLHeartBeatStatus(@RequestParam(value = "url", defaultValue = "https://www.google.com") String url) {
		String returnMsg = "";
		try {
			URL urlObj = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int respCodeCat = conn.getResponseCode() / 100;
			if (respCodeCat != 2) {
				returnMsg = IS_URL_DOWN;
			} else {
				returnMsg = IS_URL_UP;
			}

		} catch(MalformedURLException e) {
			returnMsg = INCORRECT_URL;
		} catch(IOException e) {
			returnMsg = IS_URL_DOWN;
		}
		
		return returnMsg;
	}
}