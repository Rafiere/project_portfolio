package dev.picco.portfolio.personal.repositories;

import dev.picco.portfolio.personal.domain.PersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PersonalInfoRepository extends JpaRepository<PersonalInfo, Long> {

	@Query("SELECT pi FROM PersonalInfo pi LIMIT 1")
	Optional<PersonalInfo> findFirstPersonalInfo();
}
