package com.indibu.indiBuserver.service;


import com.indibu.indiBuserver.model.LoginRequestBody;
import com.indibu.indiBuserver.model.RegisterRequestBody;

public interface AuthenticationService {

    long login(LoginRequestBody loginRequestBody);

    long register(RegisterRequestBody registerRequestBody);

}
