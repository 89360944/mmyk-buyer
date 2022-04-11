package com.example.mmykbuyer.repository;

import com.example.mmykbuyer.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Long>, JpaSpecificationExecutor<Buyer> {

}
