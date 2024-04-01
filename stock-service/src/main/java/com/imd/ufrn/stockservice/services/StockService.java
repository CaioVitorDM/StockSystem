package com.imd.ufrn.stockservice.services;

import com.imd.ufrn.stockservice.models.Stock;
import com.imd.ufrn.stockservice.models.enums.UF;
import com.imd.ufrn.stockservice.repositories.StockRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public Page<Stock> findAll(Pageable pageable) {
        return stockRepository.findAll(pageable);
    }

    public Optional<Stock> findById(Long id) {
        return stockRepository.findById(id);
    }

    public List<Stock> findStocksByStoreId(Long storeId) {
        return stockRepository.findByStore_Id(storeId);
    }

    public boolean existsStockWithUfAndLocation(UF uf, String location) {
        return stockRepository.existsByUfAndLocation(uf, location);
    }


    @Transactional
    public void delete(Stock stock) {
        stockRepository.delete(stock);
    }

    @Transactional
    public Stock save(Stock parkingSpotModel) {
        return stockRepository.save(parkingSpotModel);
    }

}
