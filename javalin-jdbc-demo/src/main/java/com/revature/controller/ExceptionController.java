package com.revature.controller;

import com.revature.dto.ExceptionMessageDTO;
import com.revature.exception.BadParameterException;
import com.revature.exception.DatabaseException;
import com.revature.exception.ClientNotFoundException;

import io.javalin.Javalin;
import io.javalin.http.ExceptionHandler;

public class ExceptionController implements Controller {

	private ExceptionHandler<DatabaseException> databaseExceptionHandler = (e, ctx) -> {
		ctx.status(500); // 500-Internal Server Error.
		
		// Here we encapsulate the exception message into a DTO that will be sent as JSON back to the user
		ExceptionMessageDTO messageDTO = new ExceptionMessageDTO();
		messageDTO.setMessage(e.getMessage());
		
		ctx.json(messageDTO);
	};
	
	private ExceptionHandler<ClientNotFoundException> clientNotFoundExceptionHandler = (e, ctx) -> {
		ctx.status(404); // 404-Not Found
		
		ExceptionMessageDTO messageDTO = new ExceptionMessageDTO();
		messageDTO.setMessage(e.getMessage());
		
		ctx.json(messageDTO);
	};
	
	private ExceptionHandler<BadParameterException> badParameterExceptionHandler = (e, ctx) -> {
		ctx.status(400);
		
		ExceptionMessageDTO messageDTO = new ExceptionMessageDTO();
		messageDTO.setMessage(e.getMessage());
		
		ctx.json(messageDTO);
	};
	
	@Override
	public void mapEndpoints(Javalin app) {
		app.exception(DatabaseException.class, databaseExceptionHandler);
		app.exception(ClientNotFoundException.class, clientNotFoundExceptionHandler);
		app.exception(BadParameterException.class, badParameterExceptionHandler);
	}

}
