package com.franciscokrieser.api.ai.stocksbot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/webhook")
public class WebhookController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    WebhookResponse webhook(@RequestBody String obj){

        logger.info(obj);

        return new WebhookResponse("Hello! " + obj, "Text " + obj);
    }
}
