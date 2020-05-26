package com.homeoffice.gallery.movies.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homeoffice.gallery.movies.models.entities.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long>{

}
