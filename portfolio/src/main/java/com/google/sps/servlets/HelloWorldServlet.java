package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import com.google.gson.Gson;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    
    ArrayList<String> mylist = new ArrayList<String>(); 
    mylist.add("Comments:");
    mylist.add("I like to read");
    mylist.add("I am learning how to play the piano");
    mylist.add("My dream city is NYC");

    Gson gson = new Gson();
    String json_string = gson.toJson(mylist);
    
    // Send the JSON as the response
    response.setContentType("application/json;");
    response.getWriter().println(json_string);

}

    
}
