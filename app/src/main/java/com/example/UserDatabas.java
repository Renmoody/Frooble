

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.Room;
import android.content.Context;

//Simple database setup
public class UserDatabase {


   private List<User> userList;


}


@Dao
public interface UserDao {
   @Insert
   void insert(User user);


   @Query("SELECT * FROM users")
   List<User> getAllUsers();
}


@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
   public abstract UserDao userDao();
}


public class UserDatabaseManager {


   private static AppDatabase appDatabase;


   public static AppDatabase getAppDatabase(Context context) {
       if (appDatabase == null) {
           appDatabase = Room.databaseBuilder(context.getApplicationContext(),
                   AppDatabase.class, "user-database").build();
       }
       return appDatabase;
   }
}


