package com.micronaut;

import com.micronaut.domain.StoreInventory;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.annotation.Status;
import io.micronaut.http.HttpStatus;
import javax.validation.constraints.NotBlank;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.micronaut.data.exceptions.DataAccessException;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@ExecuteOn(TaskExecutors.IO)
@Controller("/inventory")
public class InventoryController {

    protected final InventoryRepository inventoryRepository;

    public InventoryController(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Get("/{id}")
    public Optional<StoreInventory> show(Long id) {
        return inventoryRepository
                .findById(id);
    }

    @Put
    public HttpResponse update(@Body @Valid InventoryUpdateCommand command) {
        inventoryRepository.update(command.getId(), command.getName());
        return HttpResponse
                .noContent()
                .header(HttpHeaders.LOCATION, location(command.getId()).getPath());
    }

    @Get("/list")
    public List<StoreInventory> list(@Valid Pageable pageable) {
        return inventoryRepository.findAll(pageable).getContent();
    }

    @Post
    public HttpResponse<StoreInventory> save(@Body("name") @NotBlank String name) {
        StoreInventory inventory = inventoryRepository.save(name);

        return HttpResponse
                .created(inventory)
                .headers(headers -> headers.location(location(inventory.getId())));
    }

    @Post("/ex")
    public HttpResponse<StoreInventory> saveExceptions(@Body @NotBlank String name) {
        try {
            StoreInventory inventory = inventoryRepository.saveWithException(name);
            return HttpResponse
                    .created(inventory)
                    .headers(headers -> headers.location(location(inventory.getId())));
        } catch(DataAccessException e) {
            return HttpResponse.noContent();
        }
    }

    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    public void delete(Long id) {
        inventoryRepository.deleteById(id);
    }

    protected URI location(Long id) {
        return URI.create("/inventorys/" + id);
    }

    protected URI location(StoreInventory inventory) {
        return location(inventory.getId());
    }
}