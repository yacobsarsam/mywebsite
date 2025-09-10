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
                "This full-stack webstore application I have developed myself as a project to a fictive store. This version of the application represents a Minimal Viable Product (MVP), It includes the most important features that allow customers to browse products and store staff to login and manage products, categories, and users through a role-based admin interface, and it is designed to be improved and expanded in the future. The application consists of a frontend and a backend, it offers product browsing and cart functionality for customers without requiring registration. Only store staff members (with roles USER or ADMIN) can log in to manage the webstore's content. USER role can manage products and categories, while ADMIN role also grants access to manage staff accounts. This project involves the design and development of a modern and responsive web application for a webstore. The frontend is built using React, TypeScript, and Vite, while the backend is implemented in Java using the Spring Boot framework. To enhance the user interface (UI), Chakra UI, which is a comprehensive library of React components, has been used to build high-quality and flexible components and web applications. For secure staff user authentication and authorization, Spring Security and BCrypt Password Encoder is used for login and hashing the password, in addition JSON Web Token (JWT) is used where only store staff can access certain protected routes like /admin. The application handles different staff user roles, including ADMIN and USER, to have role-based access control. Development and version control have been handled via Git, and the project code is hosted in a GitHub repository. Git branches and commits have been used actively to follow development progress.\n" +
                        "Project links: -Link to the web application: https://webshop-frontend-phi.vercel.app/admin -Backend repo: https://github.com/yacobsarsam/webshop-backend -Frontend repo: https://github.com/yacobsarsam/webshop-frontend -ADMIN role Username admin@example.com password: admin123 -USER role: Username admin@example.com password: admin123 Note: The backend may take up to one minute to respond/wakeup on first visit due to server sleep mode (used to reduce resource consumption).\n" +
                        "Technical Stack: -Frontend: React, Vite, TypeScript, Chakra UI, Axios, Zustand, React Router -Backend: Java, Spring Boot, REST APIs, Spring Security, BCrypt, JWT -Database: PostgreSQL -Hosting: Vercel (Frontend), Render (Backend), Neon (Database) -Authentication: JWT with role-based access control -Dev Tools: Git, GitHub, IntelliJ IDEA, WebStorm -CI/CD: GitHub Actions, Docker");

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
