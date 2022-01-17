package com.newcoder.community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;


//@SpringBootApplication
//@MapperScan("com.newcoder.community.dao")


//@RunWith(SpringRunner.class)

@ContextConfiguration(classes = CommunityApplication.class)
@SpringBootTest(classes = CommunityApplication.class)
@SpringBootApplication


public class CommunityApplication {
	public static void main(String[] args) {
		SpringApplication.run(CommunityApplication.class, args);
	}

}
