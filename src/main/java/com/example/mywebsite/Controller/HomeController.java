package com.example.mywebsite.Controller;

import com.example.mywebsite.Services.ProjectService;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.io.IOException;

@Controller
//@RequiredArgsConstructor
public class HomeController {
    private final ProjectService projectService;
   // private final ProjectImp projectImp;
  // @Autowired
   public HomeController(ProjectService projectService) {
       this.projectService = projectService;
   }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping(path="index")
    String Startsida()
    {
        return "index";
    }

    @GetMapping("view-pdf")
    public ResponseEntity<byte[]> viewPDF() throws IOException {
        // Load the PDF file from the classpath or filesystem
        ClassPathResource pdfFile = new ClassPathResource("static/CV-YacoubSarsam.pdf");

        byte[] pdfBytes = pdfFile.getInputStream().readAllBytes();

        // Set headers for the PDF
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/pdf");
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=CV-YacoubSarsam.pdf");

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }

    @GetMapping("/show-content")
    public String showPdfContent(Model model) throws IOException {
        // Path to your PDF file
        File file = new File("src/main/resources/static/CV-YacoubSarsam.pdf");

        // Load the PDF document
        PDDocument document = PDDocument.load(file);

        // Extract text from the PDF
        PDFTextStripper pdfStripper = new PDFTextStripper();
        String text = pdfStripper.getText(document);

        // Close the document
        document.close();

        // Add the extracted text to the model
        model.addAttribute("pdfContent", text);

        // Return the Thymeleaf template to display the content
        return "pdf-view";
    }
//latest

    @GetMapping(path="cv")
    String MittCv() { return "mittcv";}


    @GetMapping(path="error")
    public String handleError(){
        return "error";
    }

}
