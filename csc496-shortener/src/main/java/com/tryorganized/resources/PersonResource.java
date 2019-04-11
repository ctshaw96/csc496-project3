package com.tryorganized.resources;

import com.tryorganized.core.Database;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("shorten")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    private static String DOMAIN = "http://localhost:80/shorten/go/";

    @GET
    @Path("/go/{keyword}")
    public String getPersons(@PathParam("keyword") String keyword) {
        System.out.println(Database.db);
        System.out.println(Database.db.get(keyword));
        return Database.db.get(keyword);
    }

    @GET
    @Path("")
    public String myresponse(@QueryParam("url") String url, @QueryParam("keyword") String keyword){
        return shorten(url, keyword);
    }

    private String shorten(String url, String keyword) {
        Database.db.put(keyword, url);
        System.out.println(Database.db);
        System.out.println(Database.db.get(keyword));
        return DOMAIN + keyword;
    }


}