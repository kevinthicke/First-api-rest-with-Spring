package com.myfirstapirest.repository;

import com.myfirstapirest.model.Hangar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HangarRepository extends JpaRepository<Hangar, Long> {
    Optional<Hangar> findByName(String name);
}
