package com.flp.fms.service;

import java.util.List;
import java.util.Map;

import com.flp.fms.domain.Actor;

public interface IActorService {

	Actor AddActor(Map actorDetails);

	Actor ModifyActor(Map actorDetails);

	boolean RemoveActor(int actorId);

	Actor SearchActor(int actorId);

	List<Actor> getAllActor();
}