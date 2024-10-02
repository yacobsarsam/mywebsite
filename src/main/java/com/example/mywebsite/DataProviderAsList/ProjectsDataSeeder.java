package com.example.mywebsite.DataProviderAsList;

import com.example.mywebsite.Models.Project;
import org.springframework.context.annotation.Bean;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


public class ProjectsDataSeeder {


    @Bean
    public List<Project> GetProjectsAsList() throws MalformedURLException {
        Project p1 = new Project("MyWebsite",
                new URL("https://github.com/yacobsarsam/mywebsite"),
                " Webbapplikation (denna webbsite/applikation) som jag byggt där DevOps metodik används, dvs CI/CD Pipeline, Docker, Tests, Databas och Deployment. " +
                        "Webapplikationen visar mitt CV, källkod och besrivning till några av mina " +
                        "projekt i Github och visar några spelare som hämtas från postgress databas i Render");
        Project p2 = new Project("Shoping cart - Frontend",
                new URL("https://yacobsarsam.github.io/Store/html/index.html"),
                "Web Storage (website-frontend), lägga till produkter i varukorg samt varukorg.");
        Project p3 = new Project("Pensionat-application-Backend-course-1-2",
                new URL("https://github.com/yacobsarsam/Pensionat-application-Backend-course-1-2"),
                "Pensionat applikation, grupparbete. Funktioner: Inloggning med behörigheter och roller, API:er, " +
                        ", rumbokningar med av- ovh omboknings möjligheter samt mejlbekräftelse, köer och annat");
        Project p4 = new Project("Kalender applikation",
                new URL("https://github.com/yacobsarsam/Kalender-VG"),
                "Kalender applikation. Swing använts som user interface. Möjlighet att viisa kalendern i olika" +
                        " vyn (månadsvy, veckovy och dagsvy. Dessutom kan man visa inlägg i form av påminnelser, dagbok " +
                        "och adressbok");

        return List.of(p1, p2, p3, p4);
    }
}
