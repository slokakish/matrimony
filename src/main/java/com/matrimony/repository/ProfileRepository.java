package com.matrimony.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matrimony.entity.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long>{

}
