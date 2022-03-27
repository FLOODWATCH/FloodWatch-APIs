package com.example.floodwatch.FLfile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FLfileRepository extends JpaRepository<FLfile, Long> {
}
