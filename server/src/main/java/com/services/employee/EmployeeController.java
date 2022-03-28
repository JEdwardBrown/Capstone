package com.services.employee;


import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.netty.channel.EventLoopGroup;

import java.util.concurrent.ExecutorService;

@Controller("/services/employee")
public class EmployeeController {
    private final EmployeeServices employeeServices;
    private final EventLoopGroup eventLoopGroup;
    private final ExecutorService executorService;

    public EmployeeController(EmployeeServices employeeServices,
                              EventLoopGroup eventLoopGroup, ExecutorService executorService) {
        this.employeeServices = employeeServices;
        this.eventLoopGroup = eventLoopGroup;
        this.executorService = executorService;
    }

    @Post()
    public Single<HttpResponse<FeedbackTemplateResponseDTO>> save(@Body @Valid @NotNull FeedbackTemplateCreateDTO requestBody) {
        return Single.fromCallable(() -> feedbackTemplateServices.save(fromDTO(requestBody)))
                .observeOn(Schedulers.from(eventLoopGroup))
                .map(savedTemplate -> (HttpResponse<FeedbackTemplateResponseDTO>) HttpResponse
                        .created(fromEntity(savedTemplate))
                        .headers(headers -> headers.location(URI.create("/feedback_templates/" + savedTemplate.getId()))))
                .subscribeOn(Schedulers.from(executorService));
    }

}
