package com.imd.ufrn.stocksystem.controller;

import com.imd.ufrn.stocksystem.models.Stock;
import com.imd.ufrn.stocksystem.service.StockService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping
    public ResponseEntity<Object> createStock(@Valid @RequestBody Stock stock){

        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(stockService.save(stock));
        }
        catch (IllegalStateException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateStock(@PathVariable(value = "id") Long id,
                                              @RequestBody @Valid Stock stock){

        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(stockService.update(stock));
        }
        catch (IllegalStateException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteStock(@PathVariable(value = "id") Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(stockService.delete(id));
        }
        catch (IllegalStateException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @GetMapping("/store/{storeId}")
    public ResponseEntity<List<Stock>> findStocksByStoreId(@PathVariable Long storeId) {
        List<Stock> stocks = stockService.findStocksByStoreId(storeId);
        if (stocks.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(stocks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable(value = "id") Long id){
        Optional<Stock> livroOptional = stockService.findById(id);
        if(livroOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(livroOptional.get());
    }

    @GetMapping("/listAll")
    public ResponseEntity<Page<Stock>> getAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(stockService.findAll(pageable));
    }



}
