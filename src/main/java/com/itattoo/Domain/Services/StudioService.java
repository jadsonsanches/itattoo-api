package com.itattoo.Domain.Services;

import java.util.List;

import com.itattoo.Data.Repositories.StudioRepository;
import com.itattoo.Domain.Models.Studio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class StudioService {
    
    @Autowired
    private StudioRepository studioRepository;

    public List<Studio> listAll() {
        return studioRepository.findAll();
    }

    public List<Studio> searchByName(String name) {
        return studioRepository.findAllByNameContaining(name);
    }

    public Page<Studio> searchByNamePageable(String name, int page, int size) {
        return studioRepository.findAllByNameContaining(name, PageRequest.of(page, size));
    }

    public Studio getById(Long id) {
        Studio studio = studioRepository.findById(id).orElseThrow(
                            () -> new IllegalArgumentException("The studio with this id doesn't exists.")
                        );

        return studio;
    }

}
