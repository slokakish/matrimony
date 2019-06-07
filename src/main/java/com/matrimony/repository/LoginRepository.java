package com.matrimony.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matrimony.entity.Login;
@Repository
public interface LoginRepository extends JpaRepository<Login, Long>{

	Login findByLoginNameAndPassword(String loginName, String password);


}
