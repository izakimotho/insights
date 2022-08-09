package com.lunna.insight.RestControllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class DefaultRest {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @GetMapping("/hello")
    public String getCountries() {

        try {
            return "hello world";
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(e.getMessage());
        }
    }

}
