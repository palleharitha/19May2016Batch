package com.flp.fms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.flp.fms.domain.Actor;


public class ActorDaoImplForDB implements IActorDao{
	
	private EntityManager em;
	private EntityManagerFactory emf;
	public ActorDaoImplForDB() {
		this.emf = Persistence.createEntityManagerFactory("hello");
		this.em = emf.createEntityManager();
	}
	
	
	public Actor AddActor(Actor actor) {
		Actor actor1=findActorByName(actor.getFirstName(),actor.getLastName());
		if(actor1 == null)
		{
			em.getTransaction().begin();
			em.persist(actor);
			em.getTransaction().commit();
			return actor;
		}
		return actor1;
	}

	public Actor ModifyActor(Actor actor) {
		em.getTransaction().begin();
		em.persist(actor);
		em.getTransaction().commit();
		return actor;
	}

	public boolean RemoveActor(int actorId) {
		Actor actor=em.find(Actor.class, actorId);
		if(actor != null)
		{
			em.getTransaction().begin();
			em.remove(actor);
			em.getTransaction().commit();
			return true;
		}
		return false;
	}

	public Actor SearchActor(int actorId) {
		Actor actor=em.find(Actor.class, actorId);
		return actor;
	}

	public List<Actor> getAllActor() {
		TypedQuery<Actor> query = em.createQuery("Select a from Actor a",Actor.class);
		return query.getResultList();
	}
	
	public Actor findActorByName(String firstName,String lastName){
		TypedQuery<Actor> query = em.createQuery("Select a from Actor a where a.firstName=? and a.lastName=?",Actor.class);
		query.setParameter(1, firstName);
		query.setParameter(2, lastName);
	
		if(query.getResultList().size() > 0)
		{
			return query.getSingleResult();
		}
		return null;
	}
}
	
	
