package app.example.roomdatabase;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface POIDao {
    @Insert
    long insert(POI poi);

    @Update
    int update(POI poi);

    @Query("DELETE FROM poi_table")
    int deleteAll();

    @Query("DELETE FROM poi_table WHERE id = :id")
    int deleteUser(int id);

    @Query("SELECT * from poi_table ORDER BY id ASC")
    LiveData<List<POI>> getAllUsers();

}
