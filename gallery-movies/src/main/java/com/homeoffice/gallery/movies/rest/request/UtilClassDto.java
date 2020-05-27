package com.homeoffice.gallery.movies.rest.request;

import java.io.Serializable;
import java.util.Date;

import com.homeoffice.gallery.movies.models.entities.Categorie;

public class UtilClassDto implements Serializable {

	private static final long serialVersionUID = 1L;

	public static Categorie createObjectCatgorie(CategoryRequestDto categoryRequest) {
		Categorie categorie = new Categorie();
		categorie.setName(categoryRequest.getName());
		categorie.setDescription(categoryRequest.getDescription());
		categorie.setCreateDate(new Date());
		categorie.setCreateUser("admin");
		categorie.setStatus(Boolean.TRUE);
		return categorie;
	}

	public static void updateObjectCategorie(CategoryRequestDto categoryRequest, Categorie categoryBdd) {
		categoryBdd.setUpdateUser("admin");
		categoryBdd.setUpdateDate(new Date());
		if (categoryRequest.getStatus() != null && !categoryRequest.getStatus()) {
			categoryBdd.setStatus(Boolean.FALSE);
		} else {
			categoryBdd.setName(categoryRequest.getName());
			categoryBdd.setDescription(categoryRequest.getDescription());
		}
	}
}
