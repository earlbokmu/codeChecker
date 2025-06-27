package com.project.codechecker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hwi")
public class HwiController {

    @PostMapping
    public ResponseEntity<String> postHwi(@RequestBody HwiRequest request) {
        // 요청 데이터 출력
        System.out.println("받은 이름: " + request.getName());

        // 응답 반환
        return ResponseEntity.ok("안녕하세요, " + request.getName() + "님!");
    }

}
