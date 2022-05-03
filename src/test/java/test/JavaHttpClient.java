package test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class JavaHttpClient {
	 
	  private final String baseUrl;
	 
	  public JavaHttpClient(String baseUrl) {
	    this.baseUrl = baseUrl;
	  }
	 
	  public int getRandomQuote() {
	    HttpClient client = HttpClient.newHttpClient();
	 
	    HttpRequest request = HttpRequest.newBuilder()
	      .uri(URI.create(baseUrl))
	      .header("Accept", "text/html")
	      .GET()
	      .build();
	 
	    try {
	      HttpResponse<String> httpResponse = client.send(request, BodyHandlers.ofString());
	      return httpResponse.statusCode();
	      
	    } catch (Exception e) {
	    	//System.out.println("Не найден сервер: " + baseUrl);
	      return -1;
	    }
	  }
}
