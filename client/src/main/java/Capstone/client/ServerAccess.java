package Capstone.client;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import jakarta.inject.Singleton;
import reactor.core.publisher.Mono;

import java.util.List;

@Singleton
public class ServerAccess {
    private final HttpClient httpClient;

    public ServerAccess(@Client("http://localhost:8080/services/employee") HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    Mono<List<ServerRelease>> fetchReleases() {
        HttpRequest<?> req = HttpRequest.GET("/{id}");
        return Mono.from(httpClient.retrieve(req, Argument.listOf(ServerRelease.class)));
    }
}
