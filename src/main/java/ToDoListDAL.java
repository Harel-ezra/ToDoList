import com.mongodb.ConnectionString;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;

import com.mongodb.client.model.Projections;

import java.util.ArrayList;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class ToDoListDAL {
    public static ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");

    public static PojoCodecProvider provider = PojoCodecProvider.builder().register(User.class, ToDo.class).build();

//   מה זה תקרא
    public static CodecRegistry registry = fromRegistries(getDefaultCodecRegistry(), fromProviders(provider));

    public static MongoCollection<User> userCollection = MongoClients.create(connectionString)
            .getDatabase("Hafifa")
            .withCodecRegistry(registry)
            .getCollection("ToDoList", User.class);

//    בלי frommongo
    public static User getToDosByUserName(int userId) {
//        מה זה למה זה כאן
        User toDoListUser = new User();
        Document nameQuery = new Document("_id", userId);

        return userCollection.find(nameQuery).first();
    }

    public static String removeToDo(String toDo, int userId) {
        Document nameQuery = new Document("_id", userId);
        userCollection.updateOne(
                nameQuery,
                new Document("$pull", new Document("todos", new Document("name", toDo)))
        );
        return "ok";
    }

    public static String addToDo(String toDo, int userId) {
        Document nameQuery = new Document("_id", userId);
        userCollection.updateOne(
                nameQuery,
                new Document("$push", new Document("todos",
                        new Document("name", toDo).append("isDone", false))));
        return "ok";
    }

    public static String toDoIsDone(String toDo, int userId, boolean isDone) {
        Bson query = Filters.and(Filters.eq("_id", userId), Filters.elemMatch("todos", Filters.eq("name", toDo)));
        Bson update = Updates.set("todos.$.isDone",
                isDone);
        userCollection.updateOne(
                query,
                update
        );
        return "ok";
    }

    public static String editToDo(String toDo, String editedToDo, int userId) {
        Bson query = Filters.and(Filters.eq("_id", userId), Filters.elemMatch("todos", Filters.eq("name", toDo)));
        Bson update = Updates.set("todos.$.name", editedToDo);
        userCollection.updateOne(
                query,
                update
        );
        return "ok";
    }

    public static ArrayList<User> getAllUsersAtList() {
        Document filter = new Document();
        Bson projection = Projections.fields(Projections.include("_id", "name"));
        ArrayList<User> userList = userCollection.find(filter).projection(projection).into(new ArrayList<User>());
        return userList;
    }
}
