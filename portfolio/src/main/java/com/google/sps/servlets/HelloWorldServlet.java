package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Map;
import java.util.List;
import com.google.gson.Gson;



/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

    private static final Map < String, List < String >> commentMap = Map.of(
        "comments", List.of(
        "I am 20 years old",
        "Orange is my favourite colour",
        "I do not know how to swim",
        "I recently learned how to drive"
    )
    );

    private static final String json_string = new Gson().toJson(commentMap);


  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    
    // Send the JSON as the response
    response.setContentType("application/json;");
    response.getWriter().println(json_string);

}

    
}
