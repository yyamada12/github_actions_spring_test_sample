package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testHelloEndpoint() {
        String url = "http://localhost:" + port + "/api/hello";
        String response = restTemplate.getForObject(url, String.class);
        assertThat(response).isEqualTo("Hello World!");
    }

    @Test
    public void testHelloEndpointFail() {
        String url = "http://localhost:" + port + "/api/hello";
        String response = restTemplate.getForObject(url, String.class);
        assertThat(response).isEqualTo("Hello World");
    }
}
