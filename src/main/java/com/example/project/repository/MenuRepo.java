package com.example.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.entity.MenuItem;

public interface MenuRepo extends JpaRepository<MenuItem,Long> {

}
