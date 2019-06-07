package com.matrimony.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matrimony.entity.Dashboard;

@Repository
public interface DashboardRepository extends JpaRepository<Dashboard, Long>{

}
