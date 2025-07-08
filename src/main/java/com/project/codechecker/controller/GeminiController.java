package com.project.codechecker.controller;

import com.project.codechecker.service.GeminiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

@RestController
@RequestMapping("/api/gemini")
public class GeminiController {

    @Autowired
    private GeminiService geminiService;

    @GetMapping("/ask")
    public String ask(@RequestParam String question) {
        return geminiService.askGemini(question);
    }
}