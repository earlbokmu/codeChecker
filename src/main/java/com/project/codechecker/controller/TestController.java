package com.project.codechecker.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class TestController {

    @GetMapping
    public String hello() {
        return "Hello from Swagger!";
    }

    @Operation(summary = "Echo input string",
            description = "Returns the same string that was received in the request",
            responses = {
                    @ApiResponse(description = "Successfully echoed the input string",
                            content = @Content(schema = @Schema(implementation = String.class)))
            })
    @PostMapping("/echo")
    public ResponseEntity<String> echo(@Parameter(description = "Input string to echo")
                                       @RequestBody String input) {
        return ResponseEntity.ok("Echo: " + input);
    }
}