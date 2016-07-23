package com.flp.fms.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.flp.fms.dao.ActorDaoImplForDB;
import com.flp.fms.dao.FilmDaoImplForDB;
import com.flp.fms.dao.IActorDao;
import com.flp.fms.dao.IFilmDao;
import com.flp.fms.domain.Actor;
import com.flp.fms.domain.Category;
import com.flp.fms.domain.Film;
import com.flp.fms.domain.Language;
import com.flp.fms.view.UserInteraction;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class FilmServiceImpl implements IFilmService
{
	IFilmDao filmDao;
	
	public FilmServiceImpl() 
	{
		filmDao=new FilmDaoImplForDB();
	}
	
	public void AddFilm(Map filmDetails) throws ParseException
	{
		Film film=new Film();
		film.setTitle((String) filmDetails.get("title"));
		film.setDescription((String) filmDetails.get("description"));
		film.setReleaseYear((Date) filmDetails.get("releaseDate"));
		film.setRentalDuration( (Short) filmDetails.get("rentalDuration"));
		film.setRentalRate((BigDecimal) filmDetails.get("rentalRate"));
		film.setLength((Short) filmDetails.get("length"));
		film.setReplacementCost((BigDecimal) filmDetails.get("replacementCost"));
		film.setRating((String) filmDetails.get("rating"));
		film.setSpecialFeatures((String) filmDetails.get("specialFeatures"));
		
		Language lang=filmDao.findLanguageByName((String) filmDetails.get("languageName"));
		if(lang == null)
		{
			lang=new Language((String) filmDetails.get("languageName"));
		}
		film.setLanguage(lang);
		
		Category catg=filmDao.findCategoryByName((String) filmDetails.get("categoryName"));
		if(catg == null)
		{
			catg=new Category((String) filmDetails.get("categoryName"));
		}
		film.setCategory(catg);
		
		for(int i=0; i < ((List) filmDetails.get("actors")).size(); i++)
		{
			Actor actor=new Actor();
			actor.setFirstName((String) ((Map) ((List) filmDetails.get("actors")).get(i)).get("firstName"));
			actor.setLastName((String) ((Map) ((List) filmDetails.get("actors")).get(i)).get("lastName"));
			
			film.getActors().add(actor);
		}
		filmDao.AddFilm(film);
	}
	
	public void ModifyFilm()
	{
		
		
	}

	public boolean RemoveFilm(short filmId)
	{
		return filmDao.RemoveFilm(filmId);
	}

	/*public Film SearchFilm(short filmId) 
	{
		return filmDao.SearchFilm(filmId);
	}*/
	
	public List<Film> SearchFilm(int ch,Map searchParameters) 
	{
		switch(ch)
		{
			case 1:return filmDao.findFilmByName( (String) searchParameters.get(ch));
			
			case 2:return filmDao.findFilmByActor((Integer) searchParameters.get(ch));
			
			case 3:return filmDao.findFilmByRating( (String) searchParameters.get(ch));
		}
		return null;
	}

	public List<Film> getAllFilm() 
	{
		return filmDao.getAllFilm();
	}
}
