package com.imd.ufrn.stocksystem.repository;

import com.imd.ufrn.stocksystem.models.Stock;
import com.imd.ufrn.stocksystem.models.enums.UF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock,Long> {


    List<Stock> findByStore_Id(Long storeId);

    Optional<Stock> existsByUfAndLocation(UF uf, String location);
}
