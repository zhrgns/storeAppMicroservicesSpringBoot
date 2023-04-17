package com.store.productservice.initializer;

import com.store.productservice.model.Product;
import com.store.productservice.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestDataInitializer implements CommandLineRunner {

    private final ProductRepository productRepository;

    public TestDataInitializer(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Product product1 =new Product("P001", "Apple", "Electronics",
                "Apple iPhone 13 Pro",
                "The Apple iPhone 13 Pro is the latest flagship smartphone from Apple, featuring a stunning Super Retina XDR OLED display, A15 Bionic chip, Pro camera system, and 5G connectivity.",
                999.99, 50);

        Product product2= new Product("P002", "Nike", "Footwear",
                "Nike Air Max 270",
                "The Nike Air Max 270 is a popular sneaker known for its comfortable Air Max cushioning, stylish design, and lightweight feel. It features a breathable mesh upper and a durable rubber outsole.",
                129.99, 25);

        Product product3 = new Product("P003", "Amazon", "Smart Home",
                "Amazon Echo Dot (3rd Gen)",
                "The Amazon Echo Dot (3rd Gen) is a compact smart speaker that uses Amazon's Alexa voice assistant to play music, control smart home devices, answer questions, and more. It features a sleek fabric design and improved sound quality.",
                49.99, 100);


        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
    }
}
