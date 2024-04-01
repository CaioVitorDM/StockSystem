package com.imd.ufrn.stockservice.controllers;

import com.imd.ufrn.stockservice.models.Stock;
import com.imd.ufrn.stockservice.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/store/{storeId}")
    public ResponseEntity<List<Stock>> findStocksByStoreId(@PathVariable Long storeId) {
        List<Stock> stocks = stockService.findStocksByStoreId(storeId);
        if (stocks.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(stocks);
    }
}
