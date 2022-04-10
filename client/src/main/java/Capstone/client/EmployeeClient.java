package Capstone.client;

import io.micronaut.core.async.annotation.SingleResult;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import org.reactivestreams.Publisher;
import java.util.List;
@Client("/services/employee")
public interface EmployeeClient {

    @Get(consumes = MediaType.TEXT_PLAIN)
    @SingleResult
    Publisher<List<Object>> GetEmployee();
}
