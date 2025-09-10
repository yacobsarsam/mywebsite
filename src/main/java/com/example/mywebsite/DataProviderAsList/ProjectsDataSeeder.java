package com.example.mywebsite.DataProviderAsList;

import com.example.mywebsite.Models.Project;
import org.springframework.context.annotation.Bean;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


public class ProjectsDataSeeder {


    @Bean
    public List<Project> GetProjectsAsList() throws MalformedURLException {
       Project p0 = new Project("Webshop/webstore full-stack applikation",
                new URL("https://webshop-frontend-phi.vercel.app/"),
                                "This application has developed by me as a project to a fictive store. This version of the application represents a Minimal Viable Product (MVP), It includes the most important features that allow customers to browse products and manage shopping cart, it allows store staff to login and manage products, categories and users through a role-based admin interface. The application is designed to easily improve and expand it in the future. It consists of a frontend and a backend with a database, Development and version control have been handled via GitHub. DevOps methodology is used, i.e. CI/CD Pipeline, Docker, Tests, Database and Deployment.\n"
);

        Project p1 = new Project("MyWebsite",
                new URL("https://github.com/yacobsarsam/mywebsite"),
                " Webbapplikation (den här applikationen) som jag byggt har DevOps metodik används, dvs CI/CD Pipeline, Docker, Tests, Databas och Deployment. " +
                        "Webapplikationen visar mitt CV (nedladdningsbar), källkod och besrivning till några av mina " +
                        "projekt i Github och visar några spelare som hämtas från postgress databas i Neon");
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


        return List.of(p0, p1, p2, p3, p4);
    }
}
