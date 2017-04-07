package com.le.viet.mockito.controller;

import com.le.viet.mockito.exception.CredentialException;
import com.le.viet.mockito.model.PasswordRequest;
import com.le.viet.mockito.model.PasswordResponse;
import com.le.viet.mockito.service.CredentialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by onelazyguy on 4/6/17.
 */
@RestController
@RequestMapping("/rs")
public class CredentialController {
    private final Logger LOG = LoggerFactory.getLogger(CredentialController.class);
    @Autowired
    private CredentialService credentialService;

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST,  produces= MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PasswordResponse updatePassword(@RequestBody PasswordRequest passwordRequest){
       PasswordResponse passwordResponse = new PasswordResponse();
       try {
           this.credentialService.setCredentialRequest(passwordRequest);
           if(this.credentialService.doCredentialUpdate()){
               passwordResponse.setMessage("success");
               passwordResponse.setPasswordRequest(passwordRequest);
               passwordResponse.setStatusCd(1);
           }
       }catch (CredentialException me){
           me.printStackTrace();
           LOG.error("CrendtialException: " + me.toString());
       }catch (Exception e){
           e.printStackTrace();
           LOG.error("Exception: " + e.getMessage());
       }
       return passwordResponse;
    }
}
