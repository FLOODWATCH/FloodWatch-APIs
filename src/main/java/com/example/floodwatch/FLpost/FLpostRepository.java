package com.example.floodwatch.FLpost;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FLpostRepository extends JpaRepository<FLpost, Long> {
}
