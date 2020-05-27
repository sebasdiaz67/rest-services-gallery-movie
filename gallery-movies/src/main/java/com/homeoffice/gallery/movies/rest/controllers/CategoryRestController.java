package com.homeoffice.gallery.movies.rest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homeoffice.gallery.movies.models.entities.Categorie;
import com.homeoffice.gallery.movies.rest.request.CategoryRequestDto;
import com.homeoffice.gallery.movies.rest.request.UtilClassDto;
import com.homeoffice.gallery.movies.services.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryRestController {

	@Autowired
	private CategoryService categoryService;

	private static final String MENSAJE = "mensaje";
	private static final String ERROR = "error";
	private static final String CATEGORY = "category";

	@GetMapping("/categories")
	public List<Categorie> findAllCategories() {
		return categoryService.findAll();
	}

	@GetMapping("/categories/page/{page}/size/{size}")
	public Page<Categorie> findAllCategories(@PathVariable Integer page, @PathVariable Integer size) {
		Pageable pageable = PageRequest.of(page, size);
		return categoryService.findAll(pageable);
	}

	@GetMapping("/categories/{id}")
	public ResponseEntity<?> findCategoryById(@PathVariable Long id) {
		Categorie category = null;
		Map<String, Object> response = new HashMap<>();
		try {
			category = categoryService.findById(id);
			if (category == null) {
				response.put(MENSAJE, "No existe la categoria para el ID enviado.");
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			}
		} catch (DataAccessException e) {
			response.put(MENSAJE, "Error al realizar la consulta.");
			response.put(ERROR, e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/categories")
	public ResponseEntity<?> createCategories(@Valid @RequestBody CategoryRequestDto categoryRequest) {
		Categorie categoryToSave = null;
		Map<String, Object> response = new HashMap<>();
		try {
			Categorie cate = UtilClassDto.createObjectCatgorie(categoryRequest);
			categoryToSave = categoryService.save(cate);
		} catch (DataAccessException e) {
			response.put(MENSAJE, "Error al crear la categoria.");
			response.put(ERROR, e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put(MENSAJE, "La categoria ha sido creado con éxito.");
		response.put(CATEGORY, categoryToSave);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PutMapping("/categories")
	public ResponseEntity<?> updateCategories(@Valid @RequestBody CategoryRequestDto categoryRequest) {
		Categorie categorieUpdated = null;
		Map<String, Object> response = new HashMap<>();
		if (categoryRequest.getId() == null) {
			response.put(MENSAJE, "El id no puede ser vacio.");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		} else {
			Categorie categoryBdd = categoryService.findById(categoryRequest.getId());
			if (categoryBdd == null) {
				response.put(MENSAJE, "No existe la categoria para el ID enviado.");
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			}
			try {
				UtilClassDto.updateObjectCategorie(categoryRequest, categoryBdd);
				categorieUpdated = categoryService.save(categoryBdd);
			} catch (DataAccessException e) {
				response.put(MENSAJE, "Error al actualizar la categoria.");
				response.put(ERROR, e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			response.put(MENSAJE, "La categoria ha sido actualizado con éxito.");
			response.put(CATEGORY, categorieUpdated);
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		}
	}

}
