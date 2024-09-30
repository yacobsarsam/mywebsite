package com.example.mywebsite.Controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class HomeController {


    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping(path = "index")
    String Startsida() {
        return "index";
    }

    @GetMapping("view-pdf")
    public ResponseEntity<byte[]> viewPDF() throws IOException {
        ClassPathResource pdfFile = new ClassPathResource("static/CV-YacoubSarsam.pdf");
        byte[] pdfBytes = pdfFile.getInputStream().readAllBytes();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/pdf");
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=CV-YacoubSarsam.pdf");

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }

    @GetMapping(path = "cv")
    String MittCv() {
        return "mittcv";
    }


    @GetMapping(path = "error")
    public String handleError() {
        return "error";
    }

}
