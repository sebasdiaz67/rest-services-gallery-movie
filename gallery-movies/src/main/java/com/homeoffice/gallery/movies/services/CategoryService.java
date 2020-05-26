package com.homeoffice.gallery.movies.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.homeoffice.gallery.movies.models.entities.Categorie;

public interface CategoryService {

	public List<Categorie> findAll();

	public Page<Categorie> findAll(Pageable pageable);

	public Categorie findById(Long id);

	public Categorie save(Categorie category);
}
