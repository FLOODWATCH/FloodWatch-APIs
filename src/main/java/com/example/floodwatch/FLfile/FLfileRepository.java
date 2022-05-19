package com.example.floodwatch.FLfile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FLfileRepository extends JpaRepository<FLfile, Long> {
//  Optional<FLfile> findByName(String name);
}
