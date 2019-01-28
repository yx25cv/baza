package com.ds.baza.dsbaza.config;

import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderTest implements PasswordEncoder{
    //ovu sam klasu dodao da bih naterao spring da koristi password koji nije encode-ovan, poziva je kroz bean u SecurityConfig
        @Override
        public String encode(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override
        public boolean matches(CharSequence charSequence, String s) {
            return charSequence.toString().equals(s);
        }
    }
