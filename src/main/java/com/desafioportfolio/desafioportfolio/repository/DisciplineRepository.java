package com.desafioportfolio.desafioportfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafioportfolio.desafioportfolio.model.Discipline;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Long>{

}
