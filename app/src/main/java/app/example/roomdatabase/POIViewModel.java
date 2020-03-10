package app.example.roomdatabase;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class POIViewModel extends AndroidViewModel {
    private static final String TAG = POIViewModel.class.getSimpleName();

    private final POIRepository repository;
    private final LiveData<List<POI>> allUsers;

    public POIViewModel(Application application) {
        super(application);
        repository = new POIRepository(application);
        allUsers = repository.getAllUsers();
    }

    public void insert(POI POI) {
        repository.insert(POI);
    }

    public void update(POI POI) {
        repository.update(POI);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteUser(int id) {
        repository.deleteUser(id);
    }

    public LiveData<List<POI>> getAllUsers() {
        return allUsers;
    }
}
