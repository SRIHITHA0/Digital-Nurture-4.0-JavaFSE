package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.model.Stock;
import com.cognizant.orm_learn.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getStocksBetweenDates(String code, LocalDate from, LocalDate to) {
        return stockRepository.findByCodeAndDateBetween(code, from, to);
    }

    public List<Stock> getStocksAbovePrice(String code, BigDecimal price) {
        return stockRepository.findByCodeAndCloseGreaterThan(code, price);
    }

    public List<Stock> getTopVolumeStocks() {
        return stockRepository.findTop3ByOrderByVolumeDesc();
    }

    public List<Stock> getLowestCloseStocks(String code) {
        return stockRepository.findTop3ByCodeOrderByCloseAsc(code);
    }
}
