/*
 * Copyright (c) 2017.
 */

package com.aribanilia.rest.simple.controller;

import com.aribanilia.rest.simple.dto.ResponseServices;
import com.aribanilia.rest.simple.dto.SimpleRequest;
import com.aribanilia.rest.simple.hcms.dao.HRestLogEChannelDao;
import com.aribanilia.rest.simple.hcms.entity.TblHRestLogEChannel;
import com.aribanilia.rest.simple.logger.dao.LRestLogEChannelDao;
import com.aribanilia.rest.simple.logger.entity.TblLRestLogEChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/home")
public class HomeController {

    private final static Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired private HRestLogEChannelDao daoH;
    @Autowired private LRestLogEChannelDao daoL;

    @PostMapping(value = "/check", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseServices doCheckLog(@Valid @RequestBody SimpleRequest request, BindingResult result) throws Exception {
        logger.info("Incoming POST /home/check/ : " + request.getId());
        ResponseServices response = new ResponseServices();

        if (result.hasErrors()) {
            response.setResponseCode(HttpStatus.BAD_REQUEST.value() + "");
            response.setResponseDesc(result.getFieldError().getField() + ": " + result.getFieldError().getDefaultMessage());
            logger.error("Format Data field  " + result.getFieldError().getField()  + " tidak benar ");
            return response;
        }

        try {
            String reffSwitching = request.getId();
            TblLRestLogEChannel lLogEChannel = daoL.findByReffSwitchingAndRequestType(reffSwitching, "INQUIRY");
            if (lLogEChannel == null) {
                response.setResponseCode(HttpStatus.BAD_REQUEST.value() + "");
                response.setResponseDesc("TblRestLogEChannel not found : " + reffSwitching);
                logger.error("TblRestLogEChannel not found : " + reffSwitching);
                return response;
            }
            TblHRestLogEChannel hLogEChannel = daoH.findByReffSwitching(reffSwitching);
            if (hLogEChannel == null) {
                hLogEChannel = new TblHRestLogEChannel();
                hLogEChannel.setId(lLogEChannel.getId());
                hLogEChannel.setChannelId(lLogEChannel.getChannelId());
                hLogEChannel.setClientId(lLogEChannel.getClientId());
                hLogEChannel.setReffSwitching(lLogEChannel.getReffSwitching());
                daoH.save(hLogEChannel);
            }
            response.setResponseCode(HttpStatus.OK.value() + "");
            response.setResponseDesc(HttpStatus.OK.getReasonPhrase());
            response.setDataHcms(hLogEChannel.getId() + "");
            response.setDataLogger(lLogEChannel.getId() + "");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        logger.info("Outgoing POST /home/check : " + request.getId());
        return response;
    }
}
