package com.cimplist.cip.user.web.rest;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cimplist.cip.user.web.rest.UserProfileRESTroller;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={
		"classpath:spring/mvc-config-test.xml",		
		"classpath:spring/application-config.xml"
		})
public class UserProfileRESTrollerMockTest {
private static final String BASE_URI = "/rest";
    private MockMvc mockMvc;
    
    @Autowired
    private WebApplicationContext webApplicationContext;
    
    @Autowired
    private UserProfileRESTroller userProfileRestController;
    
    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    public void testGetUser(){
    	try {
			ResultActions result  = mockMvc.perform(get(BASE_URI+"/user/{userName}", "samm"));
			result.andDo(print());
			result.andExpect(status().isOk());
			result.andExpect(content().contentType(MediaType.APPLICATION_JSON));
			result.andExpect(jsonPath("key").value(3));
			result.andExpect(jsonPath("userName").value("samm"));
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(e.toString(),false);
		}
    }
    @Test
    public void testGetUserTeam(){
    	try {
			ResultActions result  = mockMvc.perform(get(BASE_URI+"/user/{userName}/team", "samm"));
			result.andDo(print());
			result.andExpect(status().isOk());
			result.andExpect(content().contentType(MediaType.APPLICATION_JSON));
			result.andExpect(jsonPath("[0].key").value(2));
			result.andExpect(jsonPath("[0].userName").value("markl"));
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(e.toString(),false);
		}
    }

}
