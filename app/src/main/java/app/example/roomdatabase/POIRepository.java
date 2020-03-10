package app.example.roomdatabase;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

import androidx.lifecycle.LiveData;

class POIRepository {
    private static final String TAG = POIRepository.class.getSimpleName();

    private final POIDao POIDao;
    private final LiveData<List<POI>> allUsers;

    POIRepository(Application application) {
        POIRoomDatabase db = POIRoomDatabase.getDatabase(application);
        POIDao = db.userDao();
        allUsers = POIDao.getAllUsers();
    }

    public void insert(POI POI) {
        new AsyncTask<POI, Void, Long>() {
            @Override
            protected Long doInBackground(POI... POIS) {
                if (POIDao == null)
                    return -1L;
                return POIDao.insert(POIS[0]);
            }

            @Override
            protected void onPostExecute(Long aLong) {
                super.onPostExecute(aLong);
                Log.d(TAG, "insert : " + aLong);
            }
        }.execute(POI);
    }

    public void update(POI POI) {
        new AsyncTask<POI, Void, Integer>() {
            @Override
            protected Integer doInBackground(POI... POIS) {
                if (POIDao == null)
                    return -1;
                return POIDao.update(POIS[0]);
            }

            @Override
            protected void onPostExecute(Integer integer) {
                super.onPostExecute(integer);
                Log.d(TAG, "update : " + integer);
            }
        }.execute(POI);
    }

    public void deleteAll() {
        new AsyncTask<Void, Void, Integer>() {
            @Override
            protected Integer doInBackground(Void... voids) {
                if (POIDao == null)
                    return -1;
                return POIDao.deleteAll();
            }

            @Override
            protected void onPostExecute(Integer integer) {
                super.onPostExecute(integer);
                Log.d(TAG, "deleteAll : " + integer);
            }
        }.execute();
    }

    public void deleteUser(int id) {
        new AsyncTask<Integer, Void, Integer>() {
            @Override
            protected Integer doInBackground(Integer... integers) {
                if (POIDao == null)
                    return -1;
                return POIDao.deleteUser(integers[0]);
            }

            @Override
            protected void onPostExecute(Integer integer) {
                super.onPostExecute(integer);
                Log.d(TAG, "deleteUser : " + integer);
            }
        }.execute(id);
    }

    public LiveData<List<POI>> getAllUsers() {
        return allUsers;
    }
}
