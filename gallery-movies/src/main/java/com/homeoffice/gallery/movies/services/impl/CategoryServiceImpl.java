package com.homeoffice.gallery.movies.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.homeoffice.gallery.movies.models.entities.Categorie;
import com.homeoffice.gallery.movies.models.repositories.CategoryRepository;
import com.homeoffice.gallery.movies.services.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository genreRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Categorie> findAll() {
		return genreRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Categorie> findAll(Pageable pageable) {
		return genreRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Categorie findById(Long id) {
		return genreRepository.findById(id).orElse(null);
	}

	@Override
	public Categorie save(Categorie category) {
		return genreRepository.save(category);
	}

}
