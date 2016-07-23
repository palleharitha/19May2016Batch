package com.flp.fms.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.flp.fms.domain.Actor;
import com.flp.fms.domain.Category;
import com.flp.fms.domain.Film;
import com.flp.fms.domain.Language;
import com.flp.fms.service.ActorServiceImpl;
import com.flp.fms.service.FilmServiceImpl;
import com.flp.fms.service.IActorService;
import com.flp.fms.service.IFilmService;

public class UserInteraction
{
	IFilmService filmService;
	IActorService actorService;
	Scanner sc=new Scanner(System.in);

	public UserInteraction()
	{
		//filmService=new FilmServiceImpl();
		//actorService=new ActorServiceImpl();
	}
	

	public void AddFilm() throws ParseException
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		Map<String, Object> filmDetails=new HashMap<String, Object>();
		
		System.out.println("Enter title");
		filmDetails.put("title",sc.next());
		
		System.out.println("Enter description");
		filmDetails.put("description",sc.next());
		
		System.out.println("Enter release date");
		filmDetails.put("releaseDate",dateFormat.parse(sc.next()));
		
		System.out.println("Enter rental duration");
		filmDetails.put("rentalDuration",sc.nextShort());
		
		System.out.println("Enter rental rate");
		filmDetails.put("rentalRate",sc.nextBigDecimal());
		
		System.out.println("Enter length of the movie");
		filmDetails.put("length",sc.nextInt());
		
		System.out.println("Enter replacement cost");
		filmDetails.put("replacementCost",sc.nextBigDecimal());
		
		System.out.println("Enter rating");
		filmDetails.put("rating",sc.next());
		
		System.out.println("Enter special features");
		filmDetails.put("specialFeatures",sc.next());
				
		
		System.out.println("Enetr the language Name");
		filmDetails.put("languageName",sc.next());

		System.out.println("Enetr the category Name");
		filmDetails.put("categoryName",sc.next());
	
		System.out.println("Enetr the Number of actors");
		int numberOfActors=sc.nextInt();
		
		List actors=new ArrayList();
		for(int i=1;i <= numberOfActors;i++)
		{
			Map<String, String> actorDetails=new HashMap<String, String>();
			System.out.println("Enter the actor first name");
			actorDetails.put("firstName",sc.next());
			System.out.println("Enter the actor last name");
			actorDetails.put("lastName",sc.next());
			actors.add(actorDetails);
		}
		
		filmDetails.put("actors",actors);
		//filmService.AddFilm(filmDetails);
	}
	
	public void ModifyFilm()
	{
		
	}
	
	public void RemoveFilm()
	{
		System.out.println("Enter the film id to remove");
		short filmId=sc.nextShort();
		if(filmService.RemoveFilm(filmId))
		{
			System.out.println("film Successfully removed");
		}
		else
		{
			System.out.println("film Not Found");
		}
	}
	
	public void SearchFilm()
	{
		/*System.out.println("Enter the film id to search");
		short filmId=sc.nextShort();
		Film film=filmService.SearchFilm(filmId);
		if(film !=null)
		{
			System.out.println("Found "+film);
		}
		else
		{
			System.out.println("Not Found");
		}*/
		Map<Integer, Object> searchParameters=new HashMap<Integer, Object>();
		System.out.println("Search Menu");
		System.out.println("-------------------------------------------------");
		System.out.println("1.By film Title"+"\n"+"2.By Actor"+"\n"+"3.By Rating"+"\n");
		System.out.println("enter the choice of search");
		int ch=sc.nextInt();
		
		switch(ch)
		{
			case 1:System.out.println("enter the film title");
					searchParameters.put(ch, sc.next());
					System.out.println("Film Details are"+filmService.SearchFilm(ch,searchParameters));
					break;
			case 2:System.out.println("enter the Actor Id");
					searchParameters.put(ch, sc.nextInt());
					System.out.println("Film Details are"+filmService.SearchFilm(ch,searchParameters));
					break;
			case 3:System.out.println("enter the rating");
					searchParameters.put(ch, sc.next());
					System.out.println("Film Details are"+filmService.SearchFilm(ch,searchParameters));
					break;
			default:System.out.println("Invalid Search choice");
					break;
		}
		
		//filmService.SearchFilm(film_id)
	}
	
	public void getAllFilm()
	{
		List<Film> films=filmService.getAllFilm();
		System.out.println("All films details are "+films);
	}
	
	public Actor AddActor()
	{
		Actor actor=new Actor();
		Map<String, String> actorDetails=new HashMap<String, String>();
		System.out.println("Enter the actor first name");
		actorDetails.put("firstName",sc.next());
		System.out.println("Enter the actor last name");
		actorDetails.put("lastName",sc.next());
		return actorService.AddActor(actorDetails);
	}
	
	public void ModifyActor()
	{
		Map<Object, Object> actorDetails=new HashMap<Object, Object>();
		System.out.println("Enter the actor id to modify");
		actorDetails.put("actorId",sc.nextInt());
		System.out.println("Enter the actor modified first name");
		actorDetails.put("firstName",sc.next());
		System.out.println("Enter the actor modified last name");
		actorDetails.put("lastName",sc.next());
		System.out.println("Actor modified successfully ,details are"+actorService.ModifyActor(actorDetails));	
	}
	
	public void RemoveActor()
	{
		System.out.println("Enter the actor id to remove");
		int actorId=sc.nextInt();
		if(actorService.RemoveActor(actorId))
		{
			System.out.println("Actor Successfully removed");
		}
		else
		{
			System.out.println("Actor Not Found");
		}
	}
	
	public void SearchActor()
	{
		System.out.println("Enter the actor id to search");
		int actorId=sc.nextInt();
		Actor actor=actorService.SearchActor(actorId);
		if(actor !=null)
		{
			System.out.println("Found "+actor);
		}
		else
		{
			System.out.println("Not Found");
		}
	}
	
	public void getAllActor()
	{
		List<Actor> actors= actorService.getAllActor();
		System.out.println("All actors details are "+actors);
	}


}
