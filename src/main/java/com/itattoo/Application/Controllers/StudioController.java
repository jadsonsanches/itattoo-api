package com.itattoo.Application.Controllers;

import java.util.List;

import com.itattoo.Domain.Models.Studio;
import com.itattoo.Domain.Services.StudioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/studios")
public class StudioController {
    
    @Autowired
    private StudioService studioService;

    @GetMapping("")
    public ResponseEntity<List<Studio>> listAll() {
        return ResponseEntity.ok(studioService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Studio> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(studioService.getById(id));
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<Studio>> searchByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(studioService.searchByName(name));
    }

    @GetMapping("/search/page/{name}")
    public ResponseEntity<Page<Studio>> searchByNamePageable(@PathVariable("name") String name, @RequestParam("page") int page, @RequestParam("size") int size) {
        return ResponseEntity.ok(studioService.searchByNamePageable(name, page, size));
    }

}
