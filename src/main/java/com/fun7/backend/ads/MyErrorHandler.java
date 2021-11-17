package com.fun7.backend.ads;

import java.io.IOException;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

public class MyErrorHandler extends DefaultResponseErrorHandler {
	  @Override
	  public void handleError(ClientHttpResponse response) throws IOException {
	    System.out.println(response);
	  }
	}