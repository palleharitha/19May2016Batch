package com.flp.fms.service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.flp.fms.domain.Actor;
import com.flp.fms.domain.Film;


public interface IFilmService 
{
	void AddFilm(Map filmDetails) throws ParseException;
	void ModifyFilm();
	boolean RemoveFilm(short film_id);
	List<Film> SearchFilm(int ch,Map searchParameters);
	List<Film> getAllFilm();
}
