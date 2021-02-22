package com.techstar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techstar.entities.Founder;

public interface FounderRepository extends JpaRepository<Founder, Long> {

}
