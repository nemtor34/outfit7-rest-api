package com.fun7.backend.integration;

import com.fun7.backend.users.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;

@SpringBootTest

@AutoConfigureMockMvc
@ContextConfiguration
public class UserIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    
    private User user1 = new User("john", "John", "Wick", "johnwick@gmail.com");
    
    private User user2 = new User("janez", "Janez", "Novak", "janeznovak@gmail.com");
    
    @Test
    @WithMockUser(username="admin", password="password",authorities={"user:write"})
    void createUser() throws Exception {
        mockMvc.perform(post("/admin/users/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user1)))
                .andExpect(status().isOk());
        mockMvc.perform(post("/admin/users/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user2)))
                .andExpect(status().isOk());
    }

    @Test
    void testService() throws Exception {
    	
    	Request request1 = new Request("America/New_York", "john", "US");
    	Request request2 = new Request("Europe/Ljubljana", "janez", "SI");
    	
    	for (int i = 0; i < 5; i++) {
    	
    	MvcResult result1 = mockMvc.perform(post("/services/")
                .contentType(MediaType.APPLICATION_JSON)
                .param("timezone", request1.getTimezone())
                .param("userId", request1.getUserId())
                .param("cc", request1.getCc()))
    			.andReturn();
    	
    	JSONObject services1 = new JSONObject(result1.getResponse().getContentAsString());
    	
    	assertTrue(services1.get("multiplayer").equals("disabled"));
    	
    	}
    	
    	MvcResult result1 = mockMvc.perform(post("/services/")
                .contentType(MediaType.APPLICATION_JSON)
                .param("timezone", request1.getTimezone())
                .param("userId", request1.getUserId())
                .param("cc", request1.getCc()))
    			.andReturn();
    	
    	JSONObject services1 = new JSONObject(result1.getResponse().getContentAsString());
    	
    	assertTrue(services1.get("multiplayer").equals("enabled"));
    	
    	for (int i = 0; i < 5; i++) {
        	
    	MvcResult result2 = mockMvc.perform(post("/services/")
                .contentType(MediaType.APPLICATION_JSON)
                .param("timezone", request2.getTimezone())
                .param("userId", request2.getUserId())
                .param("cc", request2.getCc()))
    			.andReturn();
    	
    	JSONObject services2 = new JSONObject(result2.getResponse().getContentAsString());
    	
    	assertTrue(services2.get("multiplayer").equals("disabled"));
    	
    	}
    	
    	MvcResult result2 = mockMvc.perform(post("/services/")
                .contentType(MediaType.APPLICATION_JSON)
                .param("timezone", request2.getTimezone())
                .param("userId", request2.getUserId())
                .param("cc", request2.getCc()))
    			.andReturn();
    	
    	JSONObject services2 = new JSONObject(result2.getResponse().getContentAsString());
    	
    	assertTrue(services2.get("multiplayer").equals("disabled"));
        
    	
    }
}