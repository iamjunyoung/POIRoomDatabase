package app.example.roomdatabase;

import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
/*
        public static final String ID = "_id";
        public static final String POI_ID = "poi_id";
        public static final String FLOOR_ID = "floor_id";
        public static final String FLOOR_NAME_EN = "floor_name_en";
        public static final String FLOOR_NAME_KR = "floor_name_kr";

        public static final String FLOOR_ORDER = "floor_order";

        public static final String FLOOR_INDEX = "floor_index";

        public static final String POSITION_X = "position_x";
        public static final String POSITION_Y = "position_y";

        public static final String NAME_KR = "name_kr";

        public static final String ATTRIBUTE_EL_ID = "attribute_el_id";
        public static final String ATTRIBUTE_EL_VENDER = "attribute_el_vendor";
        public static final String ATTRIBUTE_EL_FLOOR_LIST = "attribute_el_floor_list";
        public static final String ATTRIBUTE_DESC = "attribute_desc";
        public static final String ATTRIBUTE_TEL = "attribute_tel";

        public static final String RADIUS = "radius";
        public static final String TYPE = "type";
        public static final String IS_RESTRICTED = "is_restricted";
        public static final String THETA = "theta";

        public static final String IS_HOME = "is_home";
        public static final String IS_CHARGER = "is_charger";
        public static final String IS_IN_POILIST = "is_in_poi_list";
 */
/*
    private String poiId;

    private String floorId;
    private FloorName floorName;
    private int                 floorOrder;
    private int                 floorIndex;
    private Attribute attributes;
    private int                 radius;
    private int                 isRestricted;
    private Name                name;
    private Position pos;
    private int                 theta;
    private int                 type;
    private boolean             isHome;
    private boolean             isDock;
 */
@Entity(tableName = "poi_table")
public class POI {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @SerializedName("id") private int id;

    @ColumnInfo(name = "poiId")
    @SerializedName("poiId") private String poiId;

    @ColumnInfo(name = "floorCode")
    @SerializedName("floorCode") private String floorCode;

    @Embedded
    @SerializedName("floorName") private FloorName floorName;

    @ColumnInfo(name = "floorIndex")
    @SerializedName("floorIndex") private float floorIndex;

    @Embedded
    @SerializedName("position") private Position position;

    @Embedded
    @SerializedName("name") private Name name;

    @Embedded
    @SerializedName("attribute") private Attribute attribute;

    @ColumnInfo(name = "radius")
    @SerializedName("radius") private int radius;

    @ColumnInfo(name = "type")
    @SerializedName("type") private int type;

    @ColumnInfo(name = "restricted")
    @SerializedName("restricted") private int restricted;

    @ColumnInfo(name = "theta")
    @SerializedName("theta") private int theta;

    @ColumnInfo(name = "isHome")
    @SerializedName("isHome") private boolean isHome;

    @ColumnInfo(name = "isCharger")
    @SerializedName("isCharger") private boolean isCharger;

    @ColumnInfo(name = "isInPOIList")
    @SerializedName("isInPOIList") private boolean isInPOIList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPoiId() {
        return poiId;
    }

    public void setPoiId(String poiId) {
        this.poiId = poiId;
    }

    public String getFloorCode() {
        return floorCode;
    }

    public void setFloorCode(String floorCode) {
        this.floorCode = floorCode;
    }

    public FloorName getFloorName() {
        return floorName;
    }

    public void setFloorName(FloorName floorName) {
        this.floorName = floorName;
    }

    public float getFloorIndex() {
        return floorIndex;
    }

    public void setFloorIndex(float floorIndex) {
        this.floorIndex = floorIndex;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getRestricted() {
        return restricted;
    }

    public void setRestricted(int restricted) {
        this.restricted = restricted;
    }

    public int getTheta() {
        return theta;
    }

    public void setTheta(int theta) {
        this.theta = theta;
    }

    public boolean isHome() {
        return isHome;
    }

    public void setHome(boolean home) {
        isHome = home;
    }

    public boolean isCharger() {
        return isCharger;
    }

    public void setCharger(boolean charger) {
        isCharger = charger;
    }

    public boolean isInPOIList() {
        return isInPOIList;
    }

    public void setInPOIList(boolean inPOIList) {
        isInPOIList = inPOIList;
    }

    @NonNull
    @Override
    public String toString() {
        return String.format("%d. x : %f, y : %f, floorIndex : %f", id, position.x, position.y, floorIndex);
    }
}
