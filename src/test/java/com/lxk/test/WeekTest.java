package com.lxk.test;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lxk.bean.User;
import com.lxk.utils.StringUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:applicationContext-redis.xml")
public class WeekTest {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	ArrayList<User> userList = new ArrayList<User>();
	
	@Test
	public void testData(){
		
		for (int i = 0; i < 100000; i++) {
			User user = new User();
			
			//id
			user.setId(i+1);
			
			//随机姓名
			String randomChinese = StringUtils.getRandomChinese(3);
			user.setName(randomChinese);
			
			//随机性别
			Random random = new Random();
			String sex = random.nextBoolean()?"男":"女";
			user.setSex(sex);
			
			//随机手机号
			String phone = "13"+StringUtils.getRandomNumber(9);
			user.setPhone(phone);
			
			//随机邮箱
			int random2 = (int) (Math.random()*20);
			int len = random2<3?random2+3:random2;
			String randomSdstr = StringUtils.getRandomStr(len);
			String randomEmailSuffex = StringUtils.getRandomEmailSuffex();
			user.setEmail(randomSdstr+randomEmailSuffex);
			
			//随机生日
			String randomBirthday = StringUtils.randomBirthday();
			user.setBirthday(randomBirthday);
			
			userList.add(user);
		}
	}
	@Test
	public void testJDK(){
		//JDK
		System.out.println("JDK的序列化方式");
		long start = System.currentTimeMillis();
		BoundListOperations<String, Object> boundListOps = redisTemplate.boundListOps("jdk");
		Long leftPush = 0L;
		for (User user : userList) {
			leftPush = boundListOps.leftPush(user);
		}
		boundListOps.leftPush(userList);
		long end = System.currentTimeMillis();
		System.out.println("保存总数："+leftPush);
		System.out.println("耗时："+(end-start));
	}
	
	@Test
	public void testJSON(){
		//JSON
		System.out.println("JSON的序列化方式");
		long start = System.currentTimeMillis();
		BoundListOperations<String, Object> boundListOps = redisTemplate.boundListOps("jdk");
		Long leftPush = 0L;
		for (User user : userList) {
			leftPush = boundListOps.leftPush(user);
		}
		boundListOps.leftPush(userList);
		long end = System.currentTimeMillis();
		System.out.println("保存总数："+leftPush);
		System.out.println("耗时："+(end-start));
	}
	
	@Test
	public void testHash(){
		//Hash
		System.out.println("Hash的序列化方式");
		long start = System.currentTimeMillis();
		BoundHashOperations<String, Object, Object> boundHashOps = redisTemplate.boundHashOps("hash");
		for (User user : userList) {
			boundHashOps.put("hash", user);
		}
		boundHashOps.put("hash", userList);
		long end = System.currentTimeMillis();
		System.out.println("耗时："+(end-start));
	}
}
