package com.example.mywebsite;

import com.example.mywebsite.Controller.HomeController;
import com.example.mywebsite.Repositories.ProjectRepo;
import com.example.mywebsite.Services.ProjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HomeController.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties") // Använd H2 för tester
public class HomeControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProjectService projectService;

    @MockBean
    private ProjectRepo projectRepo;

    @InjectMocks
    private HomeController homeController;

    @MockBean
    private CommandLineRunner commandLineRunner;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
    }

    /*@Test
    public void shouldReturnIndexView_whenGetRequestToIndex111() throws Exception {
        mockMvc.perform(get("/index"))  // Simulates a GET request to /index
                .andExpect(status().isOk())  // Expects HTTP 200 OK
                .andExpect(view().name("index"));  // Expects the view name to be "index"
    }*/
    @Test
    public void shouldReturnHomePage_whenGetRequestToRootUrl() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("iiiindex"));
    }
    /*@Test
    public void shouldReturnHomePage_whenGetRequestToRoot() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/index"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("index"));
    }*/
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