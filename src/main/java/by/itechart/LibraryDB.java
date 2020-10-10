package by.itechart;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

import java.sql.*;
import java.util.List;

public class LibraryDB {

    public void dataWork() throws ClassNotFoundException, SQLException {

        MongoClient mongo = new MongoClient("localhost", 27017);
        MongoCredential credential = MongoCredential.createCredential("alex", "myDB", "password".toCharArray());
        MongoDatabase database = mongo.getDatabase("myDB");
        database.createCollection("library");
    }

    public void writeToData(List<Book> list) {
        for (Book book : list) {
            String s = "{ id:" + book.getId() + "author:" + book.getAuthor() + "name:" + book.getName() + "}";
            DBObject dbObject = (DBObject) JSON.parse(s);

        }
    }

}
