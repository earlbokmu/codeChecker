package com.project.codechecker.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GeminiConfig {
    @Value("${gemini.api-key}")
    public String apiKey;

    @Value("${gemini.api-url}")
    public String apiUrl;
}
