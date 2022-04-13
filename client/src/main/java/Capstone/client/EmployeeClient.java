package Capstone.client;

import io.micronaut.core.async.annotation.SingleResult;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import org.reactivestreams.Publisher;
import java.util.List;

@Client("http://localhost:8080/services/employee")
public interface EmployeeClient {
    @Get("/{id}")
    Publisher<ServerRelease> GetSingleEmployee(String name);
}
