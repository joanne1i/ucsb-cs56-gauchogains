package edu.ucsb.cs56.gauchogains;

import static spark.Spark.port;

import org.apache.log4j.Logger;


import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

import static spark.Spark.get;
import static spark.Spark.post;

/**
 * Simple example of using Mustache Templates
 *
 */

public class GauchoGainsMain{

	public static final String CLASSNAME="GauchoGainsMain";
	
	public static final Logger log = Logger.getLogger(CLASSNAME);

	public static void main(String[] args) {

        port(getHerokuAssignedPort());
		
	Map map = new HashMap();
        //map.put("userlogin","");
	//map.put("psw","");
	HashMap<String, String> users = new HashMap<>();
	//users.put("John Smith","ben123");
	//users.put("Muscle Bro","ben1234");
	//users.put("Nice Guy","ben123");
        get("/", (rq, rs) -> new ModelAndView(map, "login.mustache"), new MustacheTemplateEngine());
	post("/home", (rq, rs) -> {
    String a, b;
    a = rq.queryParams("userlogin");
    b = rq.queryParams("psw");
    System.out.println(a);
    System.out.println(b);
    if (a == "JohnSmith" && b == "admin")
		post("/home", (rq1, rs1) -> new ModelAndView(map, "test.mustache"), new MustacheTemplateEngine());
    else
    post("/home", (rq2, rs2) -> new ModelAndView(map, "logon.mustache"), new MustacheTemplateEngine());
    return String.join(" |String| ",a,b);
	});
	//}
	//else {
	//post("/home", (rq, rs) -> new ModelAndView(map, "logon.mustache"), new MustacheTemplateEngine());
	//}
	//post("/home", (rq, rs) -> new ModelAndView(users, "logon.mustache"), new MustacheTemplateEngine());
	//post("/home", (rq, rs) -> new ModelAndView(users, "home.mustache"), new MustacheTemplateEngine());
	//login.mustache action="/home"
	//There is no re-route to /logon	
	}
	
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

	
}
