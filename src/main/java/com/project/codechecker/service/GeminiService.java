package com.project.codechecker.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.*;

@Service
public class GeminiService {

    @Value("${GOOGLE_API_KEY}")
    private String apiKey;

    private final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=";

    public String askGemini(String prompt) {
        RestTemplate restTemplate = new RestTemplate();

        // 요청 본문 구성
        Map<String, Object> part = Map.of("text", prompt);
        Map<String, Object> content = Map.of("parts", List.of(part));
        Map<String, Object> body = Map.of("contents", List.of(content));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);
        ResponseEntity<Map> response = restTemplate.postForEntity(API_URL+apiKey, request, Map.class);


        try {
            List<Map<String, Object>> candidates = (List<Map<String, Object>>) response.getBody().get("candidates");
            Map<String, Object> firstCandidate = candidates.get(0);
            Map<String, Object> contentMap = (Map<String, Object>) firstCandidate.get("content");
            List<Map<String, String>> parts = (List<Map<String, String>>) contentMap.get("parts");

            return parts.get(0).get("text");
        } catch (Exception e) {
            return "오류 발생: " + e.getMessage();
        }
    }

    public String generateContent(String prompt) {
        // 요청 본문 생성
        Map<String, Object> part = new HashMap<>();
        part.put("text", prompt);

        Map<String, Object> content = new HashMap<>();
        content.put("parts", Collections.singletonList(part));

        Map<String, Object> body = new HashMap<>();
        body.put("contents", Collections.singletonList(content));

        // 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-goog-api-key", apiKey);

        System.out.println("Sending API key: " + apiKey);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        // 요청 보내기
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    API_URL,
                    HttpMethod.POST,
                    request,
                    String.class
            );

            return response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}