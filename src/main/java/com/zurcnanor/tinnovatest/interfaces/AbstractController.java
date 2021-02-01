package com.zurcnanor.tinnovatest.interfaces;

import com.zurcnanor.tinnovatest.vehicle.dto.SearchSpecification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/**
 * Abstract class with basic requests (GET, POST, PUT, DELETE) of an API
 *
 * @param <TEntity>
 * @param <SId>
 * @param <URequest>
 * @param <VResponse>
 */
public class AbstractController<TEntity extends MyEntity<SId>, SId, URequest extends Request, VResponse extends Response> {
    
    protected IService<TEntity, SId> service;
    
    private IMapper<URequest, TEntity> requestMapper;

    private IMapper<TEntity, VResponse> responseMapper;

    public AbstractController(IService<TEntity, SId> service,
                              IMapper<URequest, TEntity> requestMapper,
                              IMapper<TEntity, VResponse> responseMapper) {
        this.service = service;
        this.requestMapper = requestMapper;
        this.responseMapper = responseMapper;
    }

    @GetMapping
    public ResponseEntity<List<VResponse>> getAll(SearchSpecification specification) {
        return ResponseEntity.ok()
                .body(responseMapper.map(service.getAll(specification)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VResponse> getOne(@PathVariable("id") SId id) {
        return ResponseEntity.ok()
                .body(responseMapper.map(service.getById(id)));
    }

    @PostMapping
    public ResponseEntity<VResponse> create(@RequestBody @Valid URequest request) {
        TEntity created = service.create(requestMapper.map(request));

        return ResponseEntity.created(getLocation(created.getId()))
                .body(responseMapper.map(created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VResponse> edit(@PathVariable("id") SId id,
                                          @RequestBody @Valid URequest request) {
        TEntity entity = requestMapper.map(request);
        entity.setId(id);
        service.edit(entity);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<VResponse> update(@PathVariable("id") SId id,
                                            @RequestBody URequest request) {
        TEntity entity = requestMapper.map(request);
        entity.setId(id);
        service.update(entity);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VResponse> delete(@PathVariable("id") SId id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private URI getLocation(SId id) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .build()
                .expand(id)
                .toUri();
    }
    
}
