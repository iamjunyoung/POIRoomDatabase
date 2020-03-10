package app.example.roomdatabase;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

class FloorName implements Serializable {
    @SerializedName("en") public String en;
    @SerializedName("kr") public String kr;
}
