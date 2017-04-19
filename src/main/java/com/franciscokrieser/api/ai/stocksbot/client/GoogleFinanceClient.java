package com.franciscokrieser.api.ai.stocksbot.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Component
public class GoogleFinanceClient {

    @Value("${googlefinance.url}")
    private String googleFinanceUrl;

    @Autowired
    private RestTemplate restTemplate;

    public GoogleFinanceResponse[] getQuote(String stockCode) throws IOException {
        String response = restTemplate.getForObject(googleFinanceUrl, String.class, stockCode);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(processResponse(response), GoogleFinanceResponse[].class);
    }

    private String processResponse(String response) {
        return response.substring(3);
    }
}
