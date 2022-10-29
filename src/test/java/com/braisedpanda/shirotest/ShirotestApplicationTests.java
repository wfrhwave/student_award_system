package com.braisedpanda.shirotest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShirotestApplicationTests {
	@Test
	public void contextLoads() {
	}




	@Test
	public void test01() {
		Date now = new Date();
		DateFormat format = DateFormat.getDateInstance();
		String formatNow = format.format(now);
		System.out.println(formatNow);
	}



}
