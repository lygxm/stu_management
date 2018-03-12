package config;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


public class PasswordTest {

    @Test
    public void encoding() {
        PasswordEncoder passwordEncoder
                = new BCryptPasswordEncoder();
        System.out.println(
                passwordEncoder.encode("123456"));
    }

}