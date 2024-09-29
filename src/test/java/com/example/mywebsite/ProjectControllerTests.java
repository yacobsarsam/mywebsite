package com.example.mywebsite;

import com.example.mywebsite.Controller.ProjectController;
import com.example.mywebsite.DataProviderAsList.ProjectsDataSeeder;
import com.example.mywebsite.Models.Project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProjectController.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties") // Använd H2 för tester
public class ProjectControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProjectsDataSeeder projectsDataSeeder;

    @InjectMocks
    private ProjectController projectController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(projectController).build();
    }

    @Test
    public void testMinaprojekt() throws Exception {
        List<Project> allProjects = Arrays.asList(
                new Project(1, "Project 1", new URL("https://yacobsarsam.github.io/Store/html/index.html"), "Description 1"),
                new Project(2, "Project 2", new URL("https://yacobsarsam.github.io/Store/html/index.html"), "Description 2")
        );
        when(projectsDataSeeder.GetProjectsAsList()).thenReturn(allProjects);

        mockMvc.perform(MockMvcRequestBuilders.get("/minkod"))
                .andExpect(status().isOk())
                .andExpect(view().name("kod"))
                .andExpect(model().attributeExists("prList"))
                .andExpect(model().attribute("prList", hasSize(2)))
                .andExpect(model().attribute("prList", hasItem(
                        allOf(
                                hasProperty("id", is(1)),
                                hasProperty("name", is("Project 1")),
                                hasProperty("description", is("Description 1"))
                        ))));
    }
}