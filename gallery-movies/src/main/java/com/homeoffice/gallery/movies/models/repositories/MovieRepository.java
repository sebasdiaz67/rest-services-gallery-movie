package com.homeoffice.gallery.movies.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homeoffice.gallery.movies.models.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
