package com.itattoo.Domain.Services;

import java.util.List;

import com.itattoo.Data.Repositories.ArtistRepository;
import com.itattoo.Domain.Models.Artist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {
    
    @Autowired
    private ArtistRepository artistRepository;

    public List<Artist> listAll() {
        return artistRepository.findAll();
    }

    public Artist getById(Long id) {
        Artist artist = artistRepository.findById(id).orElseThrow(
                            () -> new IllegalArgumentException("The artist with this id doesn't exists.")
                        );

        return artist;
    }

}
