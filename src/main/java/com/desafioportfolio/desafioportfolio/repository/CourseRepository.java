package com.desafioportfolio.desafioportfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.desafioportfolio.desafioportfolio.model.Course;

@Repository
@EnableJpaRepositories
public interface CourseRepository extends JpaRepository<Course, Long>{

}
