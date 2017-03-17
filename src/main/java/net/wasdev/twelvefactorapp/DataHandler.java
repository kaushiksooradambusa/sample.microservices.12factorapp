package net.wasdev.twelvefactorapp;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import net.wasdev.twelvefactorapp.storage.Storage;

@ApplicationScoped
public class DataHandler {

    @Inject
    Storage storage;

    private String defaultDatabaseName = "items";

    public String getDatabases() throws Exception {
        System.out.println("Getting all databases");
        String response = storage().getDatabases();
        return response;
    }
    
    public String createDatabase(String name) throws Exception {
        String response = storage().createDatabase(name);
        return response;
    }
    
    public String deleteDatabase(String name) throws Exception {
        String response = storage().deleteDatabase(name);
        return response;
    }

    public String getDatabaseFiles(String database) throws Exception {
        System.out.println("Getting files for database" + database);
        // An example of how to use java.util.logging
        Logger myLogger = Logger.getLogger("net.wasdev.12factorapp.JaxrsHttpReceiver.getDatabaseFiles");
        myLogger.log(Level.INFO, "Extra logging as an example");
        String response = storage().getDatabaseFiles(database);
        return response;
    }
    
    public String storeData(String data) throws NullPointerException, IOException, Exception {
        return storeData(data, defaultDatabaseName);
    }

    public String storeData(String data, String database) throws Exception {
        System.out.println("Storing data " + data);
        // Convert string to jsonObject
        InputStream is = new ByteArrayInputStream(data.getBytes());
        JsonReader reader = Json.createReader(is);
        JsonObject jsonData = reader.readObject();
        String response = storage().storeData(jsonData, database);
        return response;
    }
    
    private Storage storage() throws Exception {
//        if (storage == null) {
//            throw new Exception("Database cannot be accessed at this time.");
//        }
        return storage;
    }

}
