package net.wasdev.twelvefactorapp.storage;

public interface Storage {
	
    public String getDatabases();
    
    public String createDatabase(String name);
    
    public String getDatabaseFiles(String databaseName);
    
    public String storeData(Object data, String database);
    
    public String deleteDatabase(String name);

}
