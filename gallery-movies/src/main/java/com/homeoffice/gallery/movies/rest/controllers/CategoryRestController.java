package com.homeoffice.gallery.movies.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homeoffice.gallery.movies.models.entities.Categorie;
import com.homeoffice.gallery.movies.services.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryRestController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/categories")
	public List<Categorie> findAllCategories() {
		return categoryService.findAll();
	}

	@GetMapping("/categories/page/{page}/size/{size}")
	public Page<Categorie> findAllCategories(@PathVariable Integer page, @PathVariable Integer size) {
		Pageable pageable = PageRequest.of(page, size);
		return categoryService.findAll(pageable);
	}
}
