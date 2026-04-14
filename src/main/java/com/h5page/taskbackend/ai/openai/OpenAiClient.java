package com.h5page.taskbackend.ai.openai;

import com.h5page.taskbackend.ai.openai.dto.OpenAiChatRequest;
import com.h5page.taskbackend.ai.openai.dto.OpenAiChatResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

import java.time.Duration;

/**
 * Minimal OpenAI API client for chat completion.
 */
@Component
public class OpenAiClient {
    private final RestClient restClient;
    private final String model;

    public OpenAiClient(
            @Value("${openai.base-url}") String baseUrl,
            @Value("${openai.api-key}") String apiKey,
            @Value("${openai.model}") String model,
            @Value("${openai.timeout-seconds}") long timeoutSeconds
    ) {
        this.model = model;
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setReadTimeout(Duration.ofSeconds(timeoutSeconds));
        this.restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .requestFactory(requestFactory)
                .build();
    }

    public OpenAiChatResponse chat(OpenAiChatRequest request) {
        request.setModel(model);
        HttpEntity<OpenAiChatRequest> entity = new HttpEntity<>(request);
        return restClient.post()
                .uri("/chat/completions")
                .body(entity.getBody())
                .retrieve()
                .body(OpenAiChatResponse.class);
    }
}
