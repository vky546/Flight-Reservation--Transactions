package com.ignek.tx.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ignek.tx.entity.PaymentInfo;
@Repository
public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, String>{

}
