package com.monsanto.interview.FortuneCookieGenerator.rest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.monsanto.interview.FortuneCookieGenerator.FortuneCookieController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMainTests {

	@Autowired
	private FortuneCookieController fortuneCookieController;

	@Test
	public void contextLoads() {
		Assert.assertNotNull(fortuneCookieController);
	}

}