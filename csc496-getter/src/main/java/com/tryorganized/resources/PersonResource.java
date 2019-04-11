package com.tryorganized.resources;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

@Path("person")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    @GET
    @Path("/getPeople")
    public List<String> getPersons() {
        return Arrays.asList("A", "B", "C");
    }

    @GET
    @Path("tester")
    public String myresponse(){
        return  "Hello";
    }


}