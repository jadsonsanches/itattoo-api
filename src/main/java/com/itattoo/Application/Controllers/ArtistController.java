package com.itattoo.Application.Controllers;

import java.util.List;

import com.itattoo.Domain.Models.Artist;
import com.itattoo.Domain.Services.ArtistService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artists")
public class ArtistController {
    
    @Autowired
    private ArtistService artistService;

    @GetMapping("")
    public ResponseEntity<List<Artist>> listAll() {
        return ResponseEntity.ok(artistService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artist> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(artistService.getById(id));
    }

}
