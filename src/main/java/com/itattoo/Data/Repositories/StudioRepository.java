package com.itattoo.Data.Repositories;

import java.util.List;

import com.itattoo.Domain.Models.Studio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudioRepository extends JpaRepository<Studio, Long> {

    List<Studio> findAllByArtists_Id(Long artistId);

    List<Studio> findAllByNameContaining(String name);

    Page<Studio> findAllByNameContaining(String name, Pageable pageable);

}
