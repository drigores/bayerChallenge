package com.monsanto.interview.FortuneCookieGenerator.rest;

import java.net.URI;
import java.net.URISyntaxException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.monsanto.interview.FortuneCookieGenerator.FortuneCookie;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FortuneCookieTEST {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void getFortune() throws URISyntaxException {

		final String baseUrl = "http://localhost:" + port + "/generateFortuneCookie";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		ResponseEntity<FortuneCookie> result;

		uri = new URI(baseUrl + "?client=Barney&company=SuperStore");
		result = this.testRestTemplate.getForEntity(uri, FortuneCookie.class);
		// Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertTrue(result.getBody().getMessage().contains("Barney"));

		uri = new URI(baseUrl + "?client=Sarah&company=SuperStore");
		result = this.testRestTemplate.getForEntity(uri, FortuneCookie.class);
		// Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertTrue(result.getBody().getMessage().contains("Sarah"));

	}

}
