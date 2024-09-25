package com.example.mywebsite.Services;


import com.example.mywebsite.Dtos.ProjectDto;
import com.example.mywebsite.Models.Project;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ProjectService {
    public ProjectDto ProjectToProjectDto(Project project);
    //public Project getProjectDetailsById(int id);
    public void AddDataToDBIfNotSaved(List<Project> projects);

    List<ProjectDto> getAllProjectsDto();
}
