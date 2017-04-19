package com.franciscokrieser.api.ai.stocksbot.service;

import com.franciscokrieser.api.ai.stocksbot.client.GoogleFinanceClient;
import com.franciscokrieser.api.ai.stocksbot.client.GoogleFinanceResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GoogleFinanceClient googleFinanceClient;

    public Double getQuote(String stockCode) {
        Double quote = null;
        try {
            GoogleFinanceResponse[] response = googleFinanceClient.getQuote(stockCode);
            quote = Double.parseDouble(response[0].getL());
        } catch (Exception e) {
            logger.error("Error on trying to get quote", e);
        }
        return quote;
    }
}
