package com.tbd.bank_backend.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tbd.bank_backend.models.Account;
import com.tbd.bank_backend.services.AccountService;
import com.tbd.bank_backend.util.DataTransferObject;
import com.tbd.bank_backend.util.ResponseObject;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/accounts/")
public class AccountRestController {

    private static Logger logger = LoggerFactory.getLogger(AccountRestController.class);

    @Autowired
    private AccountService service;

    @PostMapping("/")
    public ResponseObject create(@Valid @RequestBody Account account, BindingResult br) {

        logger.info(String.format("Entering AccountController create with account = %s.", account));

        ResponseObject dto;

        try {

            if (br.hasErrors()) {

                List<String> errors = br.getFieldErrors().stream().map(x -> x.getDefaultMessage())
                        .collect(Collectors.toList());

                dto = new DataTransferObject<List<String>>(200, "Data Validation Errors", errors);

            } else {

                // make service call
                boolean result = service.create(account);

                // populate DTO
                dto = (result) ? new ResponseObject(200, "Success.") : new ResponseObject(200, "Failure.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            dto = new ResponseObject(500, "Internal Server Error.");
        }

        // return DTO
        return dto;
    }

    @GetMapping("/{userId}")
    public ResponseObject getByUserId(@PathVariable int userId) {

        logger.info(String.format("Entering AccountController getByUserId with userId = %s.", userId));

        ResponseObject dto;

        try {
            // make service call
            List<Account> accounts = service.getAllByUserId(userId);

            dto = new DataTransferObject<List<Account>>(200, "Success.", accounts);

        } catch (Exception e) {
            e.printStackTrace();
            dto = new ResponseObject(500, "Internal Server Error.");
        }

        return dto;
    }

}
