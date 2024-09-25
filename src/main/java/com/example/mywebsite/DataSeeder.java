package com.example.mywebsite;

import com.example.mywebsite.Services.Imp.ProjectImp;
import lombok.RequiredArgsConstructor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!test")
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {
    private final ProjectImp pImp;

    @Override
    public void run(String... args) throws Exception {

        //pImp.AddDataToDBIfNotSaved(CreateData());

    }

    /*@Bean
    private void SaveDataToDB (List<Project> projects) {
        pr.saveAll(projects);
    }*/

    /*
    @Bean
    private  List<Project> CreateData() throws MalformedURLException {
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
    }*/

}
