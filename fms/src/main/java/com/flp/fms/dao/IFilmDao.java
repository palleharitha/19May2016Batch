package com.flp.fms.dao;

import java.text.ParseException;
import java.util.List;

import com.flp.fms.domain.Actor;
import com.flp.fms.domain.Category;
import com.flp.fms.domain.Film;
import com.flp.fms.domain.Language;

public interface IFilmDao
{
	void AddFilm(Film film);
	void ModifyFilm();
	boolean RemoveFilm(short film_id);
	Film SearchFilm(short film_id);
	List<Film> getAllFilm();
	Language findLanguageByName(String language_name);
	Category findCategoryByName(String category_name);
	boolean findActorByName(String first_name,String last_name);
	List<Film> findFilmByName(String filmName);
	List<Film> findFilmByActor(int actorId);
	List<Film> findFilmByRating(String rating);
}
