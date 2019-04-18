package edu.wcupa.resources;

import edu.wcupa.core.Database;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

@Path("shorten")
@Produces(MediaType.TEXT_HTML)
public class FetcherResource {

    @GET
    @Path("go/{keyword}")
    public String getPersons(@PathParam("keyword") String keyword) {
        return "<script>window.location.href = \"" + Database.get(keyword) + "\";";
    }


}