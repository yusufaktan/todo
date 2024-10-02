package com.aktanyusuf.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aktanyusuf.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, UUID>{

}
