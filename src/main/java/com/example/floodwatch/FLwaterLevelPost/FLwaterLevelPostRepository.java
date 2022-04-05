package com.example.floodwatch.FLwaterLevelPost;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FLwaterLevelPostRepository extends JpaRepository<FLwaterLevelPost, Long > {
}
