package com.example.mywebsite.Controller;

import com.example.mywebsite.DataProviderAsList.ProjectsDataSeeder;
import com.example.mywebsite.Models.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.MalformedURLException;
import java.util.List;

@Controller
public class ProjectController {


    ProjectsDataSeeder projectsDataSeeder = new ProjectsDataSeeder();

    @GetMapping(path="minkod")
    String MinaProjekt (Model model) throws MalformedURLException {
        List<Project> allProjects = projectsDataSeeder.GetProjectsAsList();
        for(int i =0; i < allProjects.size(); i++){
            System.out.println("MINA "+allProjects.get(i).getDescription());
        }
        model.addAttribute("prList", allProjects);


        //List<Project> projects = projectRepo.findAll();
        //String s = HashFileSearch.GetPass(kod);
        //model.addAttribute("ph", s);
        return "kod";
    }

}
