package com.services.employee;


import io.micronaut.http.annotation.Controller;

@Controller("/services/employee")
public class EmployeeController {
    private final EmployeeServices employeeServices;

    public FeedbackTemplateController(employeeServices feedbackTemplateServices,
                                      EventLoopGroup eventLoopGroup, ExecutorService executorService) {
        this.employeeServices = feedbackTemplateServices;
        this.eventLoopGroup = eventLoopGroup;
        this.executorService = executorService;
    }
}
