package com.franciscokrieser.api.ai.stocksbot.controller;

import com.franciscokrieser.api.ai.stocksbot.controller.model.WebhookRequest;
import com.franciscokrieser.api.ai.stocksbot.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/webhook")
public class WebhookController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StockService stockService;

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    WebhookResponse webhook(@RequestBody WebhookRequest webhookRequest){

        logger.info("request: " + webhookRequest);
        Double quote = stockService.getQuote(getStockCodeFromRequest(webhookRequest));
        return new WebhookResponse(getStockCodeFromRequest(webhookRequest) + " = "  + quote, "Text ");
    }

    private String getStockCodeFromRequest(WebhookRequest webhookRequest) {
        return webhookRequest.getResult().getParameters().getAdditionalProperties().get("stockCode").toString();
    }
}
