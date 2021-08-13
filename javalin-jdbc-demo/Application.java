package com.revature.app;


import java.util.logging.Logger;
import org.slf4j.LoggerFactory;
import com.revature.controller.ClientController;
import com.revature.controller.Controller;
import com.revature.controller.ExceptionController;
import com.revature.controller.TestController;

import io.javalin.Javalin;


   public class Application {

	private static Javalin app;
   //private static Logger logger =  (Logger) LoggerFactory.getLogger(Application.class);
	private static Logger logger = (Logger) LoggerFactory.getLogger(Application.class);
	@SuppressWarnings("unused")
	private static final Logger LOGGER2 = logger;

	public static void main(String[] args) {
		app = Javalin.create();

		mapControllers(new TestController(), new ClientController(), new ExceptionController());

		app.start(7000);   //start up our Javalin server on port 7000
	}

	public static void mapControllers(Controller... controllers) {
		for (Controller c : controllers) {
			c.mapEndpoints(Application.app);
		}
	}

	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*

	
		private static Javalin app;
		private static Logger logger = LoggerFactory.getLogger(Application.class);
		
		public static void main(String[] args) {
			app = Javalin.create();
			
			mapControllers(new TestController(), new ClientController(), new ExceptionController());
			
			app.start(7000); // start up our Javalin server on port 7000
		}
		
		private static void mapControllers(com.revature.controller.TestController testController,
				ClientController accountController, ExceptionController exceptionController) {
			// TODO Auto-generated method stub
			
		}

		public static void mapControllers(Controller... controllers) {
			for (Controller c : controllers) {
				c.mapEndpoints(Application.app);
			*/
		

	


	


