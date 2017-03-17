package net.wasdev.twelvefactorapp.storage.cloudant;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.Document;
import com.cloudant.client.api.model.Response;

import net.wasdev.twelvefactorapp.bluemix.ServiceName;
import net.wasdev.twelvefactorapp.storage.Storage;

@ApplicationScoped
public class Cloudant implements Storage {
	
    @Inject
    @ServiceName(name="")
    CloudantClient client;

    @Override
    public String getDatabases() {
        return client.getAllDbs().toString();
    }

    @Override
    public String getDatabaseFiles(String databaseName) {
        Database db = client.database(databaseName, true);
        List<String> documentList;
        try {
            documentList = db.getAllDocsRequestBuilder().build().getResponse().getDocIds();
        } catch (IOException e) {
            return "";
        }
        return documentList.toString();
    }

    @Override
    public String storeData(Object data, String database) {
        Database db = client.database(database, true);
        Response response = db.save(data);
        return response.getId();
    }

    @Override
    public String createDatabase(String name) {
        client.createDB(name);
        return "Done";
    }

    @Override
    public String deleteDatabase(String name) {
        client.deleteDB(name);
        return "Done";
    }

}
