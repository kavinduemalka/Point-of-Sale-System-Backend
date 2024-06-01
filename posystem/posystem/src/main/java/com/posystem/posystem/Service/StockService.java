package com.posystem.posystem.Service;

import com.posystem.posystem.entity.Stock;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StockService {

    List<Stock> getAllStocks();

    Stock getStockById(Long id);

    Stock createStock(Stock stock);

    Stock updateStock(Long id, Stock stock);

    void deleteStock(Long id);

}
