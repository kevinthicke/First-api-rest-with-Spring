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

            Hangar hangar1 = new Hangar("Hangar Los Santos", "Located at international airport in the city of Los Santos, San Andreas, located to the west of the port and to the south of La Puerta in GTA V. The LSIA district is also the location of the airport's nearby warehouses, restaurants, and hotels.");
            Hangar hangar2 = new Hangar("Hangar Las Venturas", "Located at Las Venturas Airport is an international airport located in Las Venturas, right in the city centre, west of the Strip, featured in Grand Theft Auto: San Andreas.");
            Hangar hangar3 = new Hangar("Hangar San Fierro", "Located at Easter Bay International Airport an international airport serving San Fierro, San Andreas in Grand Theft Auto: San Andreas, and is the largest airport in the State of San Andreas.");

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