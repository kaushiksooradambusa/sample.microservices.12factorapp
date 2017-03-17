package net.wasdev.twelvefactorapp;

import java.io.IOException;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class JaxrsHttpReceiver {
	
    @Inject
    DataHandler dataHandler;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResponse() throws NullPointerException, IOException {
        try {
            String dbFiles = dataHandler.getDatabases();
            return Response.ok(dbFiles).build();
        } catch (Exception e) {
            //JsonObject exception = Json.createObjectBuilder().add("Exception", e.getMessage()).build();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @Path("/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDatabaseResponse(@PathParam("name") String name) {
        try {
            String database = dataHandler.getDatabaseFiles(name);
            return Response.ok(database).build();
        } catch (Exception e) {
            //JsonObject exception = Json.createObjectBuilder().add("Exception", e.getMessage()).build();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }

    }



    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response postResponse(String data) throws NullPointerException, IOException {
        try {
            String contents = dataHandler.storeData(data);
            return Response.ok(contents).build();
        } catch (Exception e) {
            //JsonObject exception = Json.createObjectBuilder().add("Exception", e.getMessage()).build();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @Path("/{name}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response postDataResponse(String data, @PathParam("name") String name) {
        try {
            String contents = dataHandler.storeData(data, name);
            return Response.ok(contents).build();
        } catch (Exception e) {
            //JsonObject exception = Json.createObjectBuilder().add("Exception", e.getMessage()).build();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }



    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response putResponse(String databaseName) throws NullPointerException, IOException {
        System.out.println("Creating database called " + databaseName);
        String response;
        try {
            response = dataHandler.createDatabase(databaseName);
            return Response.ok("Created database " + response).build();
        } catch (Exception e) {
            //JsonObject exception = Json.createObjectBuilder().add("Exception", e.getMessage()).build();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @Path("/{name}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteResponse(@PathParam("name") String name) {
        System.out.println("Deleting database called " + name);
        String response;
        try {
            response = dataHandler.deleteDatabase(name);
            return Response.ok("Deleted database " + response).build();
        } catch (Exception e) {
            //JsonObject exception = Json.createObjectBuilder().add("Exception", e.getMessage()).build();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }

    }

}
