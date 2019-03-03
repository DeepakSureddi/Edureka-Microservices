package com.apil.micorservices.testing.actuatormockitolombok.resource;

import com.apil.micorservices.testing.actuatormockitolombok.model.Employee;
import com.apil.micorservices.testing.actuatormockitolombok.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWebMvc
public class EmployeeResourceTest {

    MockMvc mockMvc;

    @Autowired
    EmployeeResource employeeResource;

    @Mock
    EmployeeService employeeService;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(this.employeeResource).build();
    }


    @Test
    public void testGetEmployeeDetails() throws Exception {

        Employee employee = new Employee();
            employee.setId(1);
            employee.setName("Apil");
            employee.setDesignation("Project Manager");
            employee.setEmployeeID("E07454677");
            employee.setSalary(Long.valueOf(10000));

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(employee);

        Mockito.when(employeeService.getEmployee(1)).thenReturn(employee);

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder =
                MockMvcRequestBuilders.get("/employee/{id}", 1);
        mockMvc
                .perform(mockHttpServletRequestBuilder)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(json));
    }

}
