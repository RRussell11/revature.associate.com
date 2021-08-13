package com.revature.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controller.Controller;
import com.revature.controller.ExceptionController;
import com.revature.controller.ClientController;
import com.revature.controller.TestController;
//import com.revature.util.ConnectionUtility;
//import java.sql.Connection;
//import java.sql.SQLException;
import io.javalin.Javalin;

public class Application {

	private static Javalin app;
	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
	
	     
	
		app = Javalin.create();
		
		mapControllers(new TestController(), new ClientController(), new ExceptionController());
		
		app.start(7000); // start up our Javalin server on port 7000
	}
	
	public static void mapControllers(Controller... controllers) {
		for (Controller c : controllers) {
			c.mapEndpoints(Application.app);
		}
	}

}
