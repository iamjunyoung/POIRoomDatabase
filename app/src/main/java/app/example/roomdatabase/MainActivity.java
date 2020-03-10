package app.example.roomdatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity {

    private POIViewModel POIViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        POIViewModel = ViewModelProviders.of(this).get(POIViewModel.class);
        POIViewModel.getAllUsers().observe(this, new Observer<List<POI>>() {
            @Override
            public void onChanged(List<POI> POIS) {
                ListView listView = findViewById(R.id.listView);
                ListAdapter adapter = listView.getAdapter();
                if (adapter instanceof ArrayAdapter) {
                    ArrayAdapter<POI> arrayAdapter = (ArrayAdapter<POI>) adapter;
                    arrayAdapter.clear();
                    if (POIS != null)
                        arrayAdapter.addAll(POIS);

                    arrayAdapter.notifyDataSetChanged();
                } else {
                    adapter = new ArrayAdapter<>(listView.getContext(), android.R.layout.simple_list_item_1, android.R.id.text1, POIS);
                    listView.setAdapter(adapter);
                }
            }
        });


        // Event
        ListView listView = findViewById(R.id.listView);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getItemAtPosition(position);
                if (item instanceof POI) {
                    POIViewModel.deleteUser(((POI) item).getId());
                    return true;
                }
                return false;
            }
        });

        findViewById(R.id.actionAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText id = findViewById(R.id.id);
                if (id.getText().toString().trim().length() == 0) return;

                EditText fCode = findViewById(R.id.floorCode);
                if (fCode.getText().toString().trim().length() == 0) return;

                EditText fNameEn = findViewById(R.id.floorNameEn);
                if (fNameEn.getText().toString().trim().length() == 0) return;

                EditText fNameKr = findViewById(R.id.floorNameKr);
                if (fNameKr.getText().toString().trim().length() == 0) return;

                EditText fIndex = findViewById(R.id.floorIndex);
                if (fIndex.getText().toString().trim().length() == 0) return;

                EditText x = findViewById(R.id.positionX);
                if (x.getText().toString().trim().length() == 0) return;

                EditText y = findViewById(R.id.positionY);
                if (y.getText().toString().trim().length() == 0) return;

                EditText nameKr = findViewById(R.id.nameKr);
                if (nameKr.getText().toString().trim().length() == 0) return;

                EditText elId = findViewById(R.id.attElID);
                if (elId.getText().toString().trim().length() == 0) return;

                EditText elVendor = findViewById(R.id.attElVendor);
                if (elVendor.getText().toString().trim().length() == 0) return;

                EditText elFloorList = findViewById(R.id.attElFloorList);
                if (elFloorList.getText().toString().trim().length() == 0) return;

                EditText desc = findViewById(R.id.attDesc);
                if (desc.getText().toString().trim().length() == 0) return;

                EditText tel = findViewById(R.id.attTel);
                if (tel.getText().toString().trim().length() == 0) return;

                EditText radius = findViewById(R.id.radius);
                if (radius.getText().toString().trim().length() == 0) return;

                EditText type = findViewById(R.id.type);
                if (type.getText().toString().trim().length() == 0) return;

                EditText restricted = findViewById(R.id.restricted);
                if (restricted.getText().toString().trim().length() == 0) return;

                EditText theta = findViewById(R.id.theta);
                if (theta.getText().toString().trim().length() == 0) return;

                EditText isHome = findViewById(R.id.isHome);
                if (isHome.getText().toString().trim().length() == 0) return;

                EditText isCharger = findViewById(R.id.isCharger);
                if (isCharger.getText().toString().trim().length() == 0) return;

                EditText isInPOIList = findViewById(R.id.isInPOIList);
                if (isInPOIList.getText().toString().trim().length() == 0) return;

                //boolean은 checkbox같은거로 체크하게 하는게 좋을듯
                try {
                    String poiID = id.getText().toString().trim();
                    String floorCode = fCode.getText().toString().trim();
                    String floorNameEn = fNameEn.getText().toString().trim();
                    String floorNameKr = fNameKr.getText().toString().trim();
                    float floorIndex = Float.valueOf(fIndex.getText().toString().trim()); // float
                    float pos_x = Float.valueOf(x.getText().toString().trim()); // float
                    float pos_y = Float.valueOf(y.getText().toString().trim()); // float
                    String poiNameKr = nameKr.getText().toString().trim();
                    String elID = elId.getText().toString().trim();
                    String elV = elVendor.getText().toString().trim();
                    String elF = elFloorList.getText().toString().trim();
                    String description = desc.getText().toString().trim();
                    String telephone = tel.getText().toString().trim();
                    int rad = Integer.valueOf(radius.getText().toString().trim()); // int
                    int t = Integer.valueOf(type.getText().toString().trim());     // int
                    int r = Integer.valueOf(restricted.getText().toString().trim()); // int
                    int th = Integer.valueOf(theta.getText().toString().trim());     // int
                    boolean home = Boolean.valueOf(isHome.getText().toString().trim());  // boolean
                    boolean charger = Boolean.valueOf(isCharger.getText().toString().trim()); // boolean
                    boolean isPOIList = Boolean.valueOf(isInPOIList.getText().toString().trim()); //boolean

                    POI poi = new POI();
                    poi.setPoiId(poiID);
                    poi.setFloorCode(floorCode);

                    FloorName floorName = new FloorName();
                    floorName.setEn(floorNameEn);
                    floorName.setKr(floorNameKr);
                    poi.setFloorName(floorName);

                    poi.setFloorIndex(floorIndex);

                    Position position = new Position();
                    position.setX(pos_x);
                    position.setY(pos_y);
                    poi.setPosition(position);

                    Name name = new Name();
                    name.setKr(poiNameKr);

                    Attribute attribute = new Attribute();
                    attribute.setEl_id(elID);
                    attribute.setEl_vendor(elV);
                    attribute.setEl_floor_list(elF);
                    attribute.setDesc(description);
                    attribute.setTel(telephone);
                    poi.setAttribute(attribute);

                    poi.setRadius(r);
                    poi.setType(t);
                    poi.setRestricted(r);
                    poi.setTheta(th);

                    poi.setHome(home);
                    poi.setCharger(charger);
                    poi.setInPOIList(isPOIList);

                    POIViewModel.insert(poi);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
