package com.project.codechecker.dto;

import java.util.List;
import java.util.Map;

public class GeminiRequest {
    private List<Content> contents;

    public GeminiRequest(String userMessage) {
        this.contents = List.of(
                new Content("user", List.of(new Part(userMessage)))
        );
    }

    public List<Content> getContents() {
        return contents;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }

    public static class Content {
        private String role;
        private List<Part> parts;

        public Content(String role, List<Part> parts) {
            this.role = role;
            this.parts = parts;
        }

        public String getRole() { return role; }
        public void setRole(String role) { this.role = role; }

        public List<Part> getParts() { return parts; }
        public void setParts(List<Part> parts) { this.parts = parts; }
    }

    public static class Part {
        private String text;

        public Part(String text) {
            this.text = text;
        }

        public String getText() { return text; }
        public void setText(String text) { this.text = text; }
    }
}
