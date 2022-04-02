package com.services.employee;


import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.netty.channel.EventLoopGroup;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.UUID;
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

    /*
        Creates a new Employee and puts it in the database
    */
    @Post()
    public Single<HttpResponse<EmployeeResponseDTO>> save(@Body @Valid @NotNull EmployeeCreateDTO requestBody) {
        return Single.fromCallable(() -> employeeServices.save(fromDTO(requestBody)))
                .observeOn(Schedulers.from(eventLoopGroup))
                .map(savedEmployee -> (HttpResponse<EmployeeResponseDTO>) HttpResponse
                        .created(fromEntity(savedEmployee))
                        .headers(headers -> headers.location(URI.create("/employee/" + savedEmployee.GetId()))))
                .subscribeOn(Schedulers.from(executorService));
    }


    /*
    @Post()
    public Single<HttpResponse<FeedbackTemplateResponseDTO>> save(@Body @Valid @NotNull FeedbackTemplateCreateDTO requestBody) {
        return Single.fromCallable(() -> feedbackTemplateServices.save(fromDTO(requestBody)))
                .observeOn(Schedulers.from(eventLoopGroup))
                .map(savedTemplate -> (HttpResponse<FeedbackTemplateResponseDTO>) HttpResponse
                        .created(fromEntity(savedTemplate))
                        .headers(headers -> headers.location(URI.create("/feedback_templates/" + savedTemplate.getId()))))
                .subscribeOn(Schedulers.from(executorService));
    }
     */

    /*
        Updates an already existing Employee in the Database
    */

    @Put()
    public Single<HttpResponse<EmployeeResponseDTO>> update(@Body @Valid @NotNull EmployeeUpdateDTO requestBody) {
        return Single.fromCallable(() -> employeeServices.update(fromDTO(requestBody)))
                .observeOn(Schedulers.from(eventLoopGroup))
                .map(savedEmployee -> (HttpResponse<EmployeeResponseDTO>) HttpResponse
                        .ok()
                        .headers(headers -> headers.location(URI.create("/employee/" + savedEmployee.GetId())))
                        .body(fromEntity(savedEmployee)))
                .subscribeOn(Schedulers.from(executorService));
    }

    /*
        Deletes an Employee
    */
    @Delete("/{id}")
    public Single<? extends HttpResponse<?>> delete(@NotNull UUID id) {
        return Single.fromCallable(() -> employeeServices.delete(id))
                .observeOn(Schedulers.from(eventLoopGroup))
                .map(success -> (HttpResponse<?>) HttpResponse.ok())
                .subscribeOn(Schedulers.from(executorService));
    }

    /*
        Gets an Employee from the database
    */
    @Get("/{id}")
    public Single<HttpResponse<EmployeeResponseDTO>> getById(UUID id) {
        return Single.fromCallable(() -> employeeServices.getById(id))
                .observeOn(Schedulers.from(eventLoopGroup))
                .map(employee -> (HttpResponse<EmployeeResponseDTO>) HttpResponse.ok(fromEntity(employee)))
                .subscribeOn(Schedulers.from(executorService));
    }

    /*
        Convert from createDTO to employee
    */
    private Employee fromDTO(EmployeeCreateDTO dto) {
        return new Employee(dto.GetId(), dto.GetName(), dto.GetStartDate(), dto.GetWorkLoc(), dto.GetRole());
    }

    /*
        Convert from UpdateDTO to employee
    */
    private Employee fromDTO(EmployeeUpdateDTO dto) {

        return new Employee(dto.GetId());
    }

    /*
        Convert from Employee to ResponseDTO
    */
    private EmployeeResponseDTO fromEntity(Employee employee) {
        EmployeeResponseDTO dto = new EmployeeResponseDTO();
        dto.SetId(employee.GetId());
        dto.SetName(employee.GetName());
        dto.SetRole(employee.GetRole());
        dto.SetStartDate(employee.GetStartDate());
        dto.SetLoc(employee.GetEmployeeLoc());
        return dto;
    }
}
