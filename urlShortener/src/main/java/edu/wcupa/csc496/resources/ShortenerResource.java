package edu.wcupa.csc496.resources;

import edu.wcupa.csc496.core.Database;
import edu.wcupa.csc496.data.LinkToShorten;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

@Path("shorten")
@Produces(MediaType.APPLICATION_JSON)
public class ShortenerResource {

    @GET
    @Path("/go/{keyword}")
    public String getPersons(@PathParam("keyword") String keyword) {
        System.out.println(Database.db);
        System.out.println(Database.db.get(keyword));
        return Database.db.get(keyword);
    }

    @GET
    @Path("")
    public LinkToShorten shortenLink(@QueryParam("url") String url, @QueryParam("keyword") String keyword){
        return  shorten(url, keyword);
    }

    private String getShortenedLink(String keyword) throws Exception {
        return  getIp()+ ":82/shorten/go/" + keyword;
    }

    public static String getIp() throws Exception {
        URL whatismyip = new URL("http://checkip.amazonaws.com");
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(
                    whatismyip.openStream()));
            String ip = in.readLine();
            return ip;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private LinkToShorten shorten(String url, String keyword) {
        String shortenedLink = "";
        try {
           shortenedLink = getShortenedLink(keyword);
        } catch (Exception e) {
            return LinkToShorten.builder().build();
        }
        LinkToShorten linkToShorten = LinkToShorten.builder()
                .withOriginalLink(url)
                .withKeyword(keyword)
                .withShortLink(shortenedLink)
                .build();
        boolean didInsert = Database.insertShortenLink(linkToShorten);
        if (!didInsert) {
            System.err.println("Failed to insert into DB!");
        }
        return linkToShorten;
    }


}