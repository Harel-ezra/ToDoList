import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class ToDoListDAL {
    private static int _id = 0;
    public static ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");
    public static PojoCodecProvider provider = PojoCodecProvider.builder().register(User.class).build();
    public static CodecRegistry registry = fromRegistries(getDefaultCodecRegistry(), fromProviders(provider));

    public static User getMissionsFromMongoByUserName(String userName) {
        User toDoListUser = new User();
        Document nameQuery = new Document("name", userName);

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase HafifaDB = mongoClient.getDatabase("Hafifa").withCodecRegistry(registry);
            MongoCollection<User> userCollection = HafifaDB.getCollection("ToDoListMissions", User.class);
            User user = userCollection.find(nameQuery).first();
            toDoListUser = user;
            if (user == null) {
                user = new User(_id++, new ArrayList<String>() ,userName);
                userCollection.insertOne(user);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return toDoListUser;
    }

    public static String removeToDo(String userName, String toDo) {
        Document nameQuery = new Document("name", userName);
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase HafifaDB = mongoClient.getDatabase("Hafifa").withCodecRegistry(registry);
            MongoCollection<User> userCollection = HafifaDB.getCollection("ToDoListMissions", User.class);
             userCollection.updateOne(
                    nameQuery,
                    new Document("$pull", new Document("missions", toDo))
            );
        } catch (Exception e) {
            return e.toString();
        }
        return "ok";
    }

    public static String addToDo(String userName, String toDo) {
        Document nameQuery = new Document("name", userName);
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase HafifaDB = mongoClient.getDatabase("Hafifa").withCodecRegistry(registry);
            MongoCollection<User> userCollection = HafifaDB.getCollection("ToDoListMissions", User.class);
            userCollection.updateOne(
                    nameQuery,
                    new Document("$push", new Document("missions", toDo))
            );
        } catch (Exception e) {
            return e.toString();
        }
        return "ok";
    }
    public static String editToDo(String userName, String toDo,String editedToDo) {
        Bson query= Filters.and(
                Filters.eq("name", userName),
                Filters.eq("missions",toDo)
        );
        Bson update = Updates.set("missions.$", editedToDo);

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase HafifaDB = mongoClient.getDatabase("Hafifa").withCodecRegistry(registry);
            MongoCollection<User> userCollection = HafifaDB.getCollection("ToDoListMissions", User.class);
            userCollection.updateOne(
                    query,
                    update
            );
        } catch (Exception e) {
            return e.toString();
        }
        return "ok";
    }
}
