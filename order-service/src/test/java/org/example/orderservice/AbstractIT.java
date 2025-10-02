package org.example.orderservice;


import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.RestAssured;
import java.math.BigDecimal;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;


import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.testcontainers.utility.TestcontainersConfiguration;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@Import(TestcontainersConfiguration.class)
public abstract class AbstractIT {
//    static final String CLIENT_ID = "bookstore-webapp";
//    static final String CLIENT_SECRET = "P1sibsIrELBhmvK18BOzw1bUl96DcP2z";
//    static final String USERNAME = "siva";
//    static final String PASSWORD = "siva1234";
//
//    @Autowired
//    OAuth2ResourceServerProperties oAuth2ResourceServerProperties;



    @LocalServerPort
    int port;


    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    protected static void mockGetProductByCode(String code, String name, BigDecimal price) {
        stubFor(WireMock.get(urlMatching("/api/products/" + code))
                .willReturn(aResponse()
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withStatus(200)
                        .withBody(
                                """
                    {
                        "code": "%s",
                        "name": "%s",
                        "price": %f
                    }
                """
                                        .formatted(code, name, price.doubleValue()))));
    }

//    protected String getToken() {
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//
//        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
//        map.put(OAuth2Constants.GRANT_TYPE, singletonList(OAuth2Constants.PASSWORD));
//        map.put(OAuth2Constants.CLIENT_ID, singletonList(CLIENT_ID));
//        map.put(OAuth2Constants.CLIENT_SECRET, singletonList(CLIENT_SECRET));
//        map.put(OAuth2Constants.USERNAME, singletonList(USERNAME));
//        map.put(OAuth2Constants.PASSWORD, singletonList(PASSWORD));
//
//        String authServerUrl =
//                oAuth2ResourceServerProperties.getJwt().getIssuerUri() + "/protocol/openid-connect/token";
//
//        var request = new HttpEntity<>(map, httpHeaders);
//        KeyCloakToken token = restTemplate.postForObject(authServerUrl, request, KeyCloakToken.class);
//
//        assert token != null;
//        return token.accessToken();
//    }

//    record KeyCloakToken(@JsonProperty("access_token") String accessToken) {}
}