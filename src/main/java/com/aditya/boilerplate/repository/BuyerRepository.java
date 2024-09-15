package com.aditya.boilerplate.repository;

import com.aditya.boilerplate.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, UUID> {
    List<Buyer> findByBookId(UUID bookId);
}
