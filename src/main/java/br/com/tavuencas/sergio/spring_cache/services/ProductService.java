package br.com.tavuencas.sergio.spring_cache.services;

import br.com.tavuencas.sergio.spring_cache.models.Product;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {
    Map<Long, Product> products = new HashMap<>() {
        {
            put(1L, new Product(1L, "Notebook", "Macbook Pro"));
            put(2L, new Product(2L, "Notebook", "XPS"));
            put(3L, new Product(3L, "Notebook", "Macbook Pro"));
            put(4L, new Product(4L, "Notebook", "Macbook Pro"));
            put(5L, new Product(5L, "Notebook", "Macbook Pro"));
        }
    };

    @Cacheable("products")
    public Product getById(Long id) {
        System.out.println("Buscando produtos...");

        simulateLatency();

        return products.get(id);
    }

    private void simulateLatency() {
        try {
            long time = 1000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
