package com.flp.fms.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.flp.fms.domain.Actor;
import com.flp.fms.domain.Category;
import com.flp.fms.domain.Film;
import com.flp.fms.domain.Language;

public class FilmDaoImplForDB implements IFilmDao
{
	private EntityManager em;
	private EntityManagerFactory emf;
	public FilmDaoImplForDB() {
		this.emf = Persistence.createEntityManagerFactory("hello");
		this.em = emf.createEntityManager();
	}

	public void AddFilm(Film film) 
	{
		Set<Actor> actors= film.getActors();
		for(Actor actor:actors)
		{
			if(findActorByName(actor.getFirstName(),actor.getLastName()))
			{
				film.getActors().remove(actor);
			}
		}
		em.getTransaction().begin();
		em.persist(film);
		em.getTransaction().commit();
	}

	public void ModifyFilm() {
		// TODO Auto-generated method stub
		
	}

	public boolean RemoveFilm(short filmId) {
		Film film=findFilm(filmId);
		
		if(film != null)
		{
			em.getTransaction().begin();
			em.remove(film);
			em.getTransaction().commit();
			return true;
		}
		return false;
	}

	public Film SearchFilm(short filmId) {
		Film film=findFilm(filmId);
		return film;
	}

	public List<Film> getAllFilm() {
		TypedQuery<Film> query = em.createQuery("Select f from Film f",Film.class);
		return query.getResultList();
		
	}
	
	public Film findFilm(short filmId) {
		return em.find(Film.class, filmId);
	}
	
	public Language findLanguageByName(String languageName){
		TypedQuery<Language> query = em.createQuery("Select l from Language l where l.languageName=? ",Language.class);
		query.setParameter(1, languageName);
		
		if(query.getResultList().size() > 0)
		{
			return query.getSingleResult();
		}
		return null;
	}
	
	public Category findCategoryByName(String categoryName){
		TypedQuery<Category> query = em.createQuery("Select c from Category c where c.categoryName=?",Category.class);
		query.setParameter(1, categoryName);
		
		if(query.getResultList().size() > 0)
		{
			return query.getSingleResult();
		}
		return null;
	}
	
	public boolean findActorByName(String firstName,String lastName){
		TypedQuery<Actor> query = em.createQuery("Select a from Actor a where a.firstName=? and a.lastName=?",Actor.class);
		query.setParameter(1, firstName);
		query.setParameter(2, lastName);
	
		if(query.getResultList().size() > 0)
		{
			return true;	
		}
		return false;
	}
	
	public List<Film> findFilmByName(String filmName){
		TypedQuery<Film> query = em.createQuery("Select f from Film f where f.title=?",Film.class);
		query.setParameter(1, filmName);
		
		if(query.getResultList().size() > 0)
		{
			return query.getResultList();
		}
		return null;
	}
	
	public List<Film> findFilmByActor(int actorId){
		TypedQuery<Film> query = em.createQuery("Select f from Film f where f.filmId=?)",Film.class);
		query.setParameter(1, actorId);
		
		if(query.getResultList().size() > 0)
		{
			return query.getResultList();
		}
		return null;
	}
	
	public List<Film> findFilmByRating(String rating){
		TypedQuery<Film> query = em.createQuery("Select f from Film f where f.rating=?",Film.class);
		query.setParameter(1, rating);
		
		if(query.getResultList().size() > 0)
		{
			return query.getResultList();
		}
		return null;
	}
}
