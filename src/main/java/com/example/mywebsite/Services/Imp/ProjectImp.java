package com.example.mywebsite.Services.Imp;



import com.example.mywebsite.Dtos.ProjectDto;
import com.example.mywebsite.Models.Project;
import com.example.mywebsite.Repositories.ProjectRepo;
import com.example.mywebsite.Services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class ProjectImp implements ProjectService {
    private final ProjectRepo projectRepo;

    @Override
    public ProjectDto ProjectToProjectDto(Project p) {
        return ProjectDto.builder().id(p.getId()).name(p.getName()).link(p.getLink())
                .description(p.getDescription()).build();
    }

    @Override
    public void AddDataToDBIfNotSaved(List<Project> projects) {
List<Project> projectsInDatabase = projectRepo.findAll();
        for(Project p: projects ){
            Project pToCheck = projectsInDatabase.stream().filter(c-> Objects.equals(c.getLink(),p.getLink())).findFirst().orElse(null);
            if(pToCheck == null){
            projectRepo.save(p);
            }
        }
         //   pr.saveAll(projects);
    }

    @Override
    public List<ProjectDto> getAllProjectsDto() {
        return projectRepo.findAll().stream().map(p -> ProjectToProjectDto(p)).toList();
    }
}
