package com.example.mywebsite.Repositories;

import com.example.mywebsite.Models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, Long> {
}
