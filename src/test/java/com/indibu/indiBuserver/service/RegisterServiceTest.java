package com.indibu.indiBuserver.service;

import com.indibu.indiBuserver.IndiBuServerApplication;
import com.indibu.indiBuserver.data.entity.User;
import com.indibu.indiBuserver.data.repository.UserRepository;
import com.indibu.indiBuserver.model.RegisterRequestBody;
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
public class RegisterServiceTest {

    @MockBean
    UserRepository userRepository;

    @Autowired
    AuthenticationService registerService;

    @Before
    public void setUp() {
        User user = new User();
        user.setId(1);
        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
    }

    @Test
    public void successfulSignUp() {
        RegisterRequestBody registerRequestBody = new RegisterRequestBody();
        registerRequestBody.setEmail("asd@gmail.com");
        registerRequestBody.setFirstName("akin");
        registerRequestBody.setLastName("ilerle");
        registerRequestBody.setPassword("asdas");
        registerRequestBody.setNickname("ailerle");
        registerService.register(registerRequestBody);
    }

}
