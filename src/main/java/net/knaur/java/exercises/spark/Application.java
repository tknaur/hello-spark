package net.knaur.java.exercises.spark;

import net.knaur.java.exercises.spark.model.UserAgentMessage;
import net.knaur.java.exercises.spark.transformer.JsonTransformer;
import spark.servlet.SparkApplication;
import static spark.Spark.*;

public class Application implements SparkApplication {
	@Override
	public void init() {
		get(("/"), (request, response) -> "Hello world!");
		
		get(("/agent"), (request, response) -> {
			String userAgent = request.userAgent();
			return userAgent;
		});
		
		get("/agent.json", "application/json", (request, response) -> {
			response.type("application/json");
			String userAgent = request.userAgent();
			return new UserAgentMessage(userAgent);
		}, new JsonTransformer());
		
	}
	
}
