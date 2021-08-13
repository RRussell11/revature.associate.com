package com.revature.controller;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dto.AddOrEditClientDTO;
import com.revature.model.Client;
import com.revature.service.ClientService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class ClientController implements Controller {

	private static final String clientindexid = "clientindexid";

	private static final AddOrEditClientDTO clientToAdd = null;

	private static final CompletableFuture<?> deleteclient1 = null;

	//private static final String clientIndexId = null;

	private ClientService clientService;
	
	public ClientController() {
		this.clientService = new ClientService();
	}
	
	private Handler getAllclients = (ctx) -> {		
		List<Client> client = clientService.getAllclients();
		
		ctx.status(10); // test-class up to 10 clients, starting with less
		ctx.json(client);
	};
	
	private Handler getclientindexid = (ctx) -> {   //getclientByIndexId
		Map<String, String> mPathParmaMap =ctx.pathParamMap();
		System.out.println("Context parameter map: [" + mPathParmaMap + "]");

		String clientid = ctx.pathParam(clientindexid);
		
		Client client = clientService.getclientById(clientid);
		ctx.json(client);
		
	};
	
	private Handler addclient = (ctx) -> {
		AddOrEditClientDTO clientToAdd = ctx.bodyAsClass(AddOrEditClientDTO.class);
		
		
		Client addedclient = clientService.addclient(clientToAdd);
		ctx.status(10);
		//ctx.status(200);
		ctx.json(addedclient);
	};
	
	private Handler editclient = (ctx) -> {
		AddOrEditClientDTO clientToEdit = ctx.bodyAsClass(AddOrEditClientDTO.class);
		Map<String, String> mPathParmaMap =ctx.pathParamMap();
		System.out.println("Context parameter map: [" + mPathParmaMap + "]");
		
		//String clientId = ctx.pathParam("clientindexid");
		//Client editedclient = clientService.editclient(clientId, clientToEdit, getclientindexid);
		Client client = clientService.addclient(clientToEdit);
		ctx.status(10);
		ctx.json(client);
	};
	
	private Handler deleteclient = (ctx) -> {
		AddOrEditClientDTO clientToDelet = ctx.bodyAsClass(AddOrEditClientDTO.class);
		Map<String, String> mPathParmaMap =ctx.pathParamMap();
		System.out.println("Context parameter map: [" + mPathParmaMap + "]");
		
		String clientId = ctx.pathParam("clientindexid");
		clientService.deleteclient(clientId, null, clientToDelet);
		//Client client = clientService.addclient(clientToEdit);
		ctx.status(10);
		ctx.json(deleteclient1);
	};
	@SuppressWarnings("unused")
	private Handler getclientacc_Balance = (ctx) -> {   
		Map<String, String> mPathParmaMap =ctx.pathParamMap();
		System.out.println("Context parameter map: [" + mPathParmaMap + "]");

		String clientid = ctx.pathParam(clientindexid);
		
		Client client = clientService.getclientacc_balance(clientid);
		ctx.status(10);
		ctx.json(client);
		
	};
	
	
	@Override
	public void mapEndpoints(Javalin app) {
		app.get("/client", getAllclients);
	    app.get("/client/:clientindexid", getclientindexid);
		app.post("/client", addclient);
		app.put("/client/:clientindexid", editclient);
		app.delete("/client/:clientindexid", deleteclient);
		
	}

}
