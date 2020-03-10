package app.example.roomdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {POI.class}, version = 1)
public abstract class POIRoomDatabase extends RoomDatabase {
    public abstract POIDao userDao();

    private static volatile POIRoomDatabase INSTANCE;

    static POIRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (POIRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), POIRoomDatabase.class, "user_database").build();
                }
            }
        }
        return INSTANCE;
    }
}
