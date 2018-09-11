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
	get("/home", (rq, rs) -> {
    String a, b;
    a = rq.queryParams("userlogin");
    b = rq.queryParams("psw");
    System.out.println(a);
    System.out.println(b);
    if (a.equals("JohnSmith") && b.equals("admin"))
		return  new ModelAndView(map, "test.mustache");
    else
    return new ModelAndView(map, "logon.mustache");	}, new MustacheTemplateEngine());
	}
	
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
	
}
