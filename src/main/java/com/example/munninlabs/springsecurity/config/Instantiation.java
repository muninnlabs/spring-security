package com.example.munninlabs.springsecurity.config;

import com.example.munninlabs.springsecurity.entities.User;
import com.example.munninlabs.springsecurity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args0) throws Exception {

        userRepository.deleteAll();

        User user1 = new User(
                null,                   // id (JPA manages this)
                "John",                     // name
                "Doe",                      // lastName
                "johndoe",                  // userName (@NonNull)
                "$2a$04$exTeiMzcYrr1jCx/mSPXkeGfYYEEo1MEcVnrRkk7b0vdkt/GvUE5C",              // password (@NonNull)
                "USER",                     // role
                "john.doe@example.com",     // email (@NonNull)
                "LOCAL",                    // provider
                null,                       // providerId
                null                        // profilePicture
        );

        userRepository.save(user1);

        User user2 = new User(
                null,                   // id (JPA manages this)
                "Jane",                     // name
                "Smith",                    // lastName
                "jane.oauth",               // userName (@NonNull)
                "$2a$04$exTeiMzcYrr1jCx/mSPXkeGfYYEEo1MEcVnrRkk7b0vdkt/GvUE5C",        // password (@NonNull, placeholder)
                "ADMIN",                    // role
                "jane.smith@oauth.com",     // email (@NonNull)
                "GOOGLE",                   // provider
                "1029384756",               // providerId
                "https://placeholder.com/jane-profile.jpg" // profilePicture
        );

        userRepository.save(user2);
    }

}
