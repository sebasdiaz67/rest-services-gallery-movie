package com.homeoffice.gallery.movies.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.homeoffice.gallery.movies.models.entities.Genre;
import com.homeoffice.gallery.movies.models.repositories.GenreRepository;
import com.homeoffice.gallery.movies.services.GenreService;

@Service
@Transactional
public class GenreServiceImpl implements GenreService {

	@Autowired
	private GenreRepository genreRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Genre> findAll() {
		return genreRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Genre> findAll(Pageable pageable) {
		return genreRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Genre findById(Long id) {
		return genreRepository.findById(id).orElse(null);
	}

	@Override
	public Genre save(Genre genre) {
		return genreRepository.save(genre);
	}

}
