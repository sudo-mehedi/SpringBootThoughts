package com.winrysoft.thought.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.winrysoft.thought.models.Thought;

@Repository
public interface ThoughtRepository extends JpaRepository<Thought, Integer> {

}

