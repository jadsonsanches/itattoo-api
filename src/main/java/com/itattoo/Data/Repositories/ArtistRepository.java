package com.itattoo.Data.Repositories;

import com.itattoo.Domain.Models.Artist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
