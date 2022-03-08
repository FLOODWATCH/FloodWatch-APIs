package com.example.floodwatch.FLuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FLuserRepository extends JpaRepository<FLuser, Long> {
}
