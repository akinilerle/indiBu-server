package com.indibu.indiBuserver.controller;

import com.indibu.indiBuserver.IndiBuServerApplication;
import com.indibu.indiBuserver.model.LoginRequestBody;
import com.indibu.indiBuserver.service.AuthenticationService;
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
public class LoginControllerTest {

    @MockBean
    AuthenticationService loginService;

    @Autowired
    AuthenticationController loginController;

    @Test
    public void before() {
        Mockito.when(loginService.login(new LoginRequestBody("username", null, "password"))).thenReturn((long) 1);
    }

    @Test(expected = NullPointerException.class)
    public void controllerTest() {
        loginController.loginAttempt(new LoginRequestBody("username", null, "password"));
    }

}
