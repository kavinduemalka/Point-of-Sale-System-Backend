package com.posystem.posystem.Service;

import com.posystem.posystem.entity.Stock;
import com.posystem.posystem.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Stock getStockById(Long id) {
        return stockRepository.findById(id).orElse(null);
    }

    @Override
    public Stock createStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock updateStock(Long id, Stock stock) {
        Stock existingStock = stockRepository.findById(id).orElse(null);
        if (existingStock != null) {
            existingStock.setQuantity(stock.getQuantity());
            existingStock.setLastUpdated(stock.getLastUpdated());
            existingStock.setItem(stock.getItem());
            return stockRepository.save(existingStock);
        }
        return null;
    }

    @Override
    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }
}
