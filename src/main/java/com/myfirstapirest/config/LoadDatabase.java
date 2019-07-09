package com.myfirstapirest.config;

import com.myfirstapirest.model.Hangar;
import com.myfirstapirest.repository.HangarRepository;
import com.myfirstapirest.repository.ProductRepository;
import com.myfirstapirest.model.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
class LoadDatabase
{
    @Bean
    CommandLineRunner init(ProductRepository productRepository,
                           HangarRepository hangarRepository) {
        return args -> {

            Hangar hangar1 = new Hangar("Hangar Los Santos");
            Hangar hangar2 = new Hangar("Hangar Las Venturas");
            Hangar hangar3 = new Hangar("Hangar San Fierro");

            hangar1.getProducts().add(new Product("Cocaine", "12.50$"));
            hangar1.getProducts().add(new Product("Methaqualone", "20.30$"));
            hangar1.getProducts().add(new Product("Rohypnol", "50.99$"));
            hangar1.getProducts().add(new Product("Ketamine Hydrochloride", "32.99$"));
            hangar1.getProducts().add(new Product("Amyl nitrate", "5.98$"));
            hangar1.getProducts().add(new Product("Mephedrone", "10.59$"));
            hangar1.getProducts().add(new Product("Lysergic acid diethylamide", "31.67$"));
            hangar1.getProducts().add(new Product("Shepherdess’s Herb", "9.99$"));
            hangar1.getProducts().add(new Product("Cannabis", "12.99$"));

            /*
            hangar1.setState(false);
            hangar2.setState(false);
            hangar3.setState(false);
            */

            hangarRepository.save(hangar1);
            hangarRepository.save(hangar2);
            hangarRepository.save(hangar3);

            /*
            productRepository.save(new Product("Cocaine", "12.50$", hangar1));
            productRepository.save(new Product("Methaqualone", "20.30$", hangar1));
            productRepository.save(new Product("Rohypnol", "50.99$", hangar1));
            productRepository.save(new Product("Lysergic acid diethylamide", "31.67$", hangar2));
            productRepository.save(new Product("Methaqualone", "20.30$", hangar2));
            productRepository.save(new Product("Shepherdess’s Herb", "9.99$", hangar2));
            productRepository.save(new Product("Cannabis", "12.99$", hangar2));
            */
        };
    }
}