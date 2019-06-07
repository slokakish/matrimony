package com.matrimony.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.matrimony.entity.Dashboard;

@Repository
public interface DashboardRepository extends JpaRepository<Dashboard, Long> {
	Dashboard findByProfileId(Integer profileId);

	@Query(value = "select * from dashboard where profile_id = ?1 and interested_profile_id is not null", nativeQuery = true)
	List<Dashboard> getAllInterestedProfiles(int profileId);

	@Query(value = "select * from dashboard where profile_id = ?1 and accepted_profileid is not null", nativeQuery = true)
	List<Dashboard> getAllAccepetedProfiles(int profileId);

	@Query(value = "select * from dashboard where profile_id = ?1 and rejected_profile_id is not null", nativeQuery = true)
	List<Dashboard> getAllRejectedProfiles(int profileId);

	Dashboard findByProfileIdAndInterestedProfileId(Integer profileId, Integer interestedProfileId);

	@Query(value = "select * from dashboard d where d.profile_id = :profId", nativeQuery = true)
	Dashboard findByProfileDashId(Integer profId);
}
