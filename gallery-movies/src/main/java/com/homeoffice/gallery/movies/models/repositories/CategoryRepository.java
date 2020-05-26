package com.homeoffice.gallery.movies.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homeoffice.gallery.movies.models.entities.Categorie;

public interface CategoryRepository extends JpaRepository<Categorie, Long>{

}
