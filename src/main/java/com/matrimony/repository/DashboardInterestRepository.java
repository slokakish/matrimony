package com.matrimony.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matrimony.entity.DashboardInterest;

@Repository
public interface DashboardInterestRepository extends JpaRepository<DashboardInterest, Long> {

}
