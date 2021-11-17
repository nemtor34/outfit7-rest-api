package com.fun7.backend.integration;

import com.fun7.backend.users.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.StringUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest

@AutoConfigureMockMvc
@ContextConfiguration
public class AdminIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    private Faker faker = new Faker();

    @Test
    @WithMockUser(username="admin", password="password",authorities={"user:write"})
    void canDeleteStudent() throws Exception {
        
    	
        String name = faker.name().firstName();
        
        String last_name = faker.name().lastName();
        
        String userId = String.format(
                "%s%s",
                name,
                last_name
        );

        String email = String.format("%s@fun7.com",
                StringUtils.trimAllWhitespace(userId.trim().toLowerCase()));

        User user = new User(
        		userId,
                name,
                last_name,
                email
        );

        mockMvc.perform(post("/admin/users/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk());
        
        boolean exists = userRepository.existsById(userId);
        assertThat(exists).isTrue();

        // when
        ResultActions resultActions = mockMvc
                .perform(delete("/admin/users/" + userId));

        // then
        resultActions.andExpect(status().isOk());
        exists = userRepository.existsById(userId);
        assertThat(exists).isFalse();
    }
}
