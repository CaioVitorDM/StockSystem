package com.imd.ufrn.stocksystem.service;

import com.imd.ufrn.stocksystem.models.Stock;
import com.imd.ufrn.stocksystem.models.enums.UF;
import com.imd.ufrn.stocksystem.repository.StockRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Transactional
    public Stock save(Stock stockModel) {
        boolean stockExistsByUfAndLocation = stockRepository.existsByUfAndLocation(stockModel.getUf(), stockModel.getLocation());

        if(stockExistsByUfAndLocation){
            throw new IllegalStateException("Conflict: there is already a stock with this UF and Location");
        }
        return stockRepository.save(stockModel);
    }

    @Transactional
    public Stock update(Stock stock) {
        ArrayList<String> errosLog = new ArrayList<>();

        Optional<Stock> stockById = stockRepository.findById(stock.getId());

        if(stockById.isEmpty()){
            errosLog.add("Not found: Estoque não encontrado com o id: " + stock.getId());
        }

        Optional<Stock> existByUfAndLocation = stockRepository.existsByUfAndLocationOptional(stock.getUf(), stock.getLocation());
        if( existByUfAndLocation.isPresent() && existByUfAndLocation.get().getId() != stock.getId()){
            errosLog.add("Conflict: já existe um estoque cadastrado com essa localização");
        }

        if(!errosLog.isEmpty()){
            throw new IllegalStateException(String.join("\n", errosLog));
        }

        return stockRepository.save(stock);
    }

    @Transactional
    public Stock delete(Long id) {
        ArrayList<String> errosLog = new ArrayList<>();

        Optional<Stock> stockById = stockRepository.findById(id);

        if(stockById.isEmpty()){
            errosLog.add("Not found: Estoque não encontrado com o id: " + id );
        }

        if(!errosLog.isEmpty()){
            throw new IllegalStateException(String.join("\n", errosLog));
        }

        stockById.get().setActive(false);
        return stockRepository.save(stockById.get());
    }
}
