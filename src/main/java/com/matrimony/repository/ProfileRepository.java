package com.matrimony.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matrimony.entity.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer>{
	List<Profile> findByGenderNotLike(String profileGender);

	Profile findByProfileId(Integer profileId);
}
