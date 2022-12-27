package com.ignek.tx.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ignek.tx.entity.PassengerInfo;
@Repository
public interface PassengerInfoRepository extends JpaRepository<PassengerInfo, Long>{

}
