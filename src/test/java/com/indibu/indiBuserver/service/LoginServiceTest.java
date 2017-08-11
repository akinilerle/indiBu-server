package com.indibu.indiBuserver.service;

import com.indibu.indiBuserver.IndiBuServerApplication;
import com.indibu.indiBuserver.data.entity.User;
import com.indibu.indiBuserver.data.repository.UserRepository;
import com.indibu.indiBuserver.model.IndibuException;
import com.indibu.indiBuserver.model.LoginRequestBody;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = IndiBuServerApplication.class)
@WebAppConfiguration
public class LoginServiceTest {

    @MockBean
    UserRepository userRepository;

    @Autowired
    AuthenticationService loginService;

    @Before
    public void setup() throws Exception {

        User alkin = new User();
        alkin.setFirstName("Alkın");
        alkin.setLastName("Sen");
        alkin.setNickname("sena");
        alkin.setEmail("alkin.sen@monitise.com");
        alkin.setPassword("Passw0rd");
        alkin.setId(1);

        Mockito.when(userRepository.findByNickname("sena")).thenReturn(alkin);
        Mockito.when(userRepository.findByEmail("alkin.sen@monitise.com")).thenReturn(alkin);
        Mockito.when(userRepository.findByNickname("ailerle")).thenReturn(null);
    }

    @Test
    public void succesfulLogin() {
        long loginResponse = loginService.login(new LoginRequestBody("sena", null, "Passw0rd"));
        assert loginResponse == 1;
        loginResponse = loginService.login(new LoginRequestBody(null, "alkin.sen@monitise.com", "Passw0rd"));
        assert loginResponse == 1;
    }

    @Test
    public void failedLoginWrongPassword() {
        try {
            long loginResponse = loginService.login(new LoginRequestBody("sena", null, "S1fr3"));
        } catch (IndibuException e) {
            assert e.getHttpStatus().equals(HttpStatus.UNAUTHORIZED);
        }
    }

    @Test
    public void failedLoginWrongPassword2() {
        try {
            long loginResponse = loginService.login(new LoginRequestBody(null, "alkin.sen@monitise.com", "S1fr3"));
        } catch (IndibuException e) {
            assert e.getHttpStatus().equals(HttpStatus.UNAUTHORIZED);
        }
    }

    @Test
    public void userNotFound() {
        try {
            long loginResponse = loginService.login(new LoginRequestBody("ailerle", null, "S1fr3"));
        } catch (IndibuException e) {
            assert e.getHttpStatus().equals(HttpStatus.UNAUTHORIZED);
        }
    }

    @Test
    public void failedBadRequest() {
        try {
            long loginResponse = loginService.login(new LoginRequestBody(null, null, "S1fr3"));
        } catch (IndibuException e) {
            assert e.getHttpStatus().equals(HttpStatus.BAD_REQUEST);
        }
    }


}
