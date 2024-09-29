package com.example.mywebsite;

import com.example.mywebsite.Controller.HomeController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HomeController.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class HomeControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private HomeController homeController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
    }

    @Test
    public void shouldReturnHomePage_whenGetRequestToRootUrl() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("index"));
    }

    @Test
    public void shouldReturnCvPage_whenGetRequestToCv() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/cv"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("mittcv"));
    }



    /*@Test
    public void shouldReturnMinKodPage_whenGetRequestKod() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/minkod"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("kod"));
    }


    @Test
    public void testMinaprojekt() throws Exception {
        // Arrange: Mock the ProjectService response
        List<ProjectDto> allProjectsDto = Arrays.asList(
                new ProjectDto(1,"Project 1", new URL("https://yacobsarsam.github.io/Store/html/index.html"),"Description 1"),
                new ProjectDto(2, "Project 2",new URL("https://yacobsarsam.github.io/Store/html/index.html"), "Description 2")
        );
        when(projectService.getAllProjectsDto()).thenReturn(allProjectsDto);

        // Act & Assert: Perform a GET request to "/minkod" and verify the result
        mockMvc.perform(get("/min-kod"))
                .andExpect(status().isOk()) // Expect a 200 OK status
                .andExpect(view().name("kod")) // Expect the view name to be "kod"
                .andExpect(model().attributeExists("prList")) // Ensure the model contains "prList"
                .andExpect(model().attribute("prList", allProjectsDto)); // Ensure "prList" contains the mocked projects
    }*/
}