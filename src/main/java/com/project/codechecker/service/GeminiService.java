package com.project.codechecker.service;

import com.project.codechecker.config.GeminiConfig;
import com.project.codechecker.dto.GeminiRequest;
import com.project.codechecker.dto.GeminiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeminiService {

    @Autowired
    private GeminiConfig config;

    public String askGemini(String question){
        RestTemplate restTemplate = new RestTemplate();

        GeminiRequest request = new GeminiRequest(question);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // ✅ URL에 API Key를 붙이는 방식으로 변경
        String fullUrl = config.apiUrl + "?key=" + config.apiKey;

        HttpEntity<GeminiRequest> entity = new HttpEntity<>(request, headers);

        ResponseEntity<GeminiResponse> response = restTemplate.postForEntity(fullUrl, entity, GeminiResponse.class);

        return response.getBody().getCandidates().get(0).getContent().getParts().get(0).getText();
    }
}
