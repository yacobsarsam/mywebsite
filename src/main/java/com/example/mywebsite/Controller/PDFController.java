package com.example.mywebsite.Controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/pdf")
public class PDFController {

    @GetMapping("/view-pdf")
    public ResponseEntity<InputStreamResource> downloadPdf() {
        try {
            ClassPathResource pdfFile = new ClassPathResource("static/CV-YacoubSarsam.pdf");
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment; filename=CV-YacoubSarsam.pdf");
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(new InputStreamResource(pdfFile.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();  // Logga eventuella fel
            return ResponseEntity.status(404).body(null);  // Returnera 404 om filen inte hittas
        }
    }
}