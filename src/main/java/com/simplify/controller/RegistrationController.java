package com.simplify.controller;

import com.simplify.dto.FashionistaDTO;
import com.simplify.services.FashionistaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class RegistrationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestController.class);

    @Autowired
    private FashionistaService fashionistaService;


    @RequestMapping(value = "/fashionistas",
                    method = RequestMethod.GET)
    String home() {
        LOGGER.info("Abhiuday coming inside home method");
        return "Hello Fashionistas!";
    }

    @RequestMapping(value = "/fashionistas",
                    method = RequestMethod.POST)
    public ResponseEntity createFahionista(@RequestBody @Valid  final FashionistaDTO fashionistaDTO) {
        LOGGER.debug("Inside createFahionista method");
        LOGGER.info("Recieved object :: " + fashionistaDTO.toString());
        if(fashionistaService.createFashionista(fashionistaDTO)) {
            return new ResponseEntity(HttpStatus.CREATED);
        } else
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
