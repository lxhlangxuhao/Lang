package com.hao.xu.lang.controller;

import com.google.gson.Gson;
import com.hao.xu.lang.entity.User;
import core.BasejunitTest;
import core.MvcContrlBaseJunitTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;


import static org.junit.Assert.*;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 15:02 2019/6/25
 */
@Transactional
public class HelloControllerTest extends MvcContrlBaseJunitTest {

	@Test
	public void testGet() {

		try {
			MockHttpServletRequestBuilder getUrl = MockMvcRequestBuilders.get("/hello/testGet.do")
					.param("name", "小狼")
					.param("age", "23")
					.header("timestamp","12345")
					.accept(MediaType.APPLICATION_JSON);//返回值接收json

			MvcResult mvcResult = mockMvc.perform(getUrl)
					.andExpect(MockMvcResultMatchers.status().is(200))//设置返回状态200
					.andDo(MockMvcResultHandlers.print())//控制台打印
					.andReturn();
			String resultStr = mvcResult.getResponse().getContentAsString();
			System.out.println(resultStr);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testPost() {

		//准备数据
		User user = new User();
		user.setId(0);
		user.setName("小狼");
		user.setDepartment("IT");
		user.setScore(99);
		String jsonUser = new Gson().toJson(user);

		try {
			MockHttpServletRequestBuilder postUrl = MockMvcRequestBuilders.post("/hello/testPost")
//					.contentType(MediaType.APPLICATION_JSON)//数据的格式
					.param("id", "1")    //添加参数
					.param("name", "12")
					.param("department", "134")
					.param("score", "90");
			MvcResult mvcResult = mockMvc.perform(postUrl)
					.andExpect(MockMvcResultMatchers.status().is(200))//设置返回状态200
					.andDo(MockMvcResultHandlers.print())//控制台打印
					.andReturn();

			String contentAsString = mvcResult.getResponse().getContentAsString();
			System.out.println(contentAsString);
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	@Test
	public void testPostEntity() {
	}


}