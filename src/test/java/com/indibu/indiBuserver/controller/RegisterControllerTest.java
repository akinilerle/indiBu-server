package com.indibu.indiBuserver.controller;

import com.indibu.indiBuserver.IndiBuServerApplication;
import com.indibu.indiBuserver.model.RegisterRequestBody;
import com.indibu.indiBuserver.service.AuthenticationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = IndiBuServerApplication.class)
@WebAppConfiguration
public class RegisterControllerTest {

    @MockBean
    AuthenticationService registerService;

    @Autowired
    AuthenticationController registerController;

    @Before
    public void setup() {
        Mockito.when(registerService.register(new RegisterRequestBody())).thenReturn((long) 1);
    }

    @Test(expected = NullPointerException.class)
    public void successfulSignUp() {
        registerController.register(new RegisterRequestBody());
    }


}
