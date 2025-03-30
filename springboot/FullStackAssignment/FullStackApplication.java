package com.assignment.fullstack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FullStackApplication {
    public static void main(String[] args) {
        SpringApplication.run(FullStackApplication.class, args);
    }
}

@Component
class AuthFilter implements jakarta.servlet.Filter {
    private static final ThreadLocal<String> authHeader = new ThreadLocal<>();

    public static String getAuthHeader() {
        return authHeader.get();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String headerValue = httpRequest.getHeader("PinggyAuthHeader");

        if (headerValue == null || headerValue.isEmpty()) {
            httpResponse.sendError(HttpStatus.UNAUTHORIZED.value(), "Unauthorized");
            return;
        }

        authHeader.set(headerValue);
        chain.doFilter(request, response);
    }
}

@RestController
@RequestMapping("/")
class PostController {
    private final List<PostDTO> posts = new ArrayList<>();

    @PostMapping("post")
    public ResponseEntity<String> createPost(@RequestBody PostRequestDTO request) {
        String authHeaderValue = AuthFilter.getAuthHeader();
        posts.add(new PostDTO(request.getTitle(), request.getBody(), authHeaderValue));
        return ResponseEntity.ok("Post saved successfully");
    }

    @GetMapping("list")
    public ResponseEntity<List<PostDTO>> getPosts() {
        return ResponseEntity.ok(posts);
    }
}

class PostRequestDTO {
    private String title;
    private String body;

    public String getTitle() { return title; }
    public String getBody() { return body; }
}

class PostDTO {
    private String title;
    private String body;
    private String authHeader;

    public PostDTO(String title, String body, String authHeader) {
        this.title = title;
        this.body = body;
        this.authHeader = authHeader;
    }

    public String getTitle() { return title; }
    public String getBody() { return body; }
    public String getAuthHeader() { return authHeader; }
} 