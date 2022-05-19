package com.example.floodwatch.FLmonthly;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FLmonthlyRepository extends JpaRepository<FLmonthly, Long> {
}
