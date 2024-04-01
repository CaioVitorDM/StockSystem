package com.imd.ufrn.stockservice.repositories;

import com.imd.ufrn.stockservice.models.Stock;
import com.imd.ufrn.stockservice.models.enums.UF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock,Long> {


    List<Stock> findByStore_Id(Long storeId);

    boolean existsByUfAndLocation(UF uf, String location);
}
