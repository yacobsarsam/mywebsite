package com.example.mywebsite.DataProviderAsList;

import com.example.mywebsite.Models.Project;
import org.springframework.context.annotation.Bean;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


public class ProjectsDataSeeder {


    @Bean
    public List<Project> GetProjectsAsList() throws MalformedURLException {
        Project p1 = new Project("Shoping cart - Frontend",
                new URL("https://yacobsarsam.github.io/Store/html/index.html"),
                "Web Storage (website-frontend), lägga till produkter och varukorg.");
        Project p2 = new Project("Pensionat-application-Backend-course-1-2",
                new URL("https://github.com/yacobsarsam/Pensionat-application-Backend-course-1-2"),
                "Pensionat applikation, grupparbete. Funktioner: Inloggning med behörigheter och roller, API:er, " +
                        ", rumbokningar med av- ovh omboknings möjligheter samt mejlbekräftelse, köer och annat");
        Project p3 = new Project("Pensionat-application-Backend-course-1-2",
                new URL("https://github.com/yacobsarsam/Kalender-VG"),
                "Pensionat applikation, grupparbete. Funktioner: Inloggning med behörigheter och roller, API:er, " +
                        ", rumbokningar med av- ovh omboknings möjligheter samt mejlbekräftelse, köer och annat");

        return List.of(p1, p2, p3);
    }
}
