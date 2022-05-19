package com.example.floodwatch.FLvoters;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FLvotersRepository extends JpaRepository<FLvoters, Long> {
}
