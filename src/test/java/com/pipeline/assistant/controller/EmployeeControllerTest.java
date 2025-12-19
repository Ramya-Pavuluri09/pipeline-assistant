package com.pipeline.assistant.controller;

import com.pipeline.assistant.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class EmployeeControllerTest {

    private MockMvc mockMvc;
    private EmployeeService employeeService;
    private EmployeeController employeeController;

    @BeforeEach
    void setup() {
        employeeService = mock(EmployeeService.class);
        employeeController = new EmployeeController();
        ReflectionTestUtils.setField(employeeController, "employeeService", employeeService);
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    void getEmployeeGreeting_returnsGreeting() throws Exception {
        when(employeeService.generateGreeting("Alice")).thenReturn("Hello Alice");

        mockMvc.perform(get("/employee/greeting").param("name", "Alice"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Alice"));

        verify(employeeService).generateGreeting("Alice");
    }

    @Test
    void getEmployeeGreeting_missingName_returnsBadRequest() throws Exception {
        mockMvc.perform(get("/employee/greeting"))
                .andExpect(status().isBadRequest());

        verifyNoInteractions(employeeService);
    }

}
