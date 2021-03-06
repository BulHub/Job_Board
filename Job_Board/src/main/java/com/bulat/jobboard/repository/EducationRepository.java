package com.bulat.jobboard.repository;

import com.bulat.jobboard.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
    Optional<Education> findByName(String name);
}
