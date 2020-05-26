package com.homeoffice.gallery.movies.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.homeoffice.gallery.movies.models.entities.Genre;

public interface GenreService {

	public List<Genre> findAll();

	public Page<Genre> findAll(Pageable pageable);

	public Genre findById(Long id);

	public Genre save(Genre genre);
}
