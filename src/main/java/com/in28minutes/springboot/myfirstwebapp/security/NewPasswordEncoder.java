package com.in28minutes.springboot.myfirstwebapp.security;

import org.springframework.security.crypto.password.PasswordEncoder;

public class NewPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (rawPassword.toString().equals(encodedPassword)) {
            return true;
        }
        return false;
    }
    
}
