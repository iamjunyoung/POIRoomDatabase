package app.example.roomdatabase;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
/*
        public static final String ID = "_id";
        public static final String POI_ID = "poi_id";
        public static final String FLOOR_ID = "floor_id";
        public static final String FLOOR_NAME_EN = "floor_name_en";
        public static final String FLOOR_NAME_KR = "floor_name_kr";

        public static final String FLOOR_ORDER = "floor_order";

        public static final String FLOOR_INDEX = "floor_index";

        public static final String ATTRIBUTE_EL_ID = "attribute_el_id";
        public static final String ATTRIBUTE_EL_VENDER = "attribute_el_vendor";
        public static final String ATTRIBUTE_EL_FLOOR_LIST = "attribute_el_floor_list";
        public static final String ATTRIBUTE_DESC = "attribute_desc";
        public static final String ATTRIBUTE_TEL = "attribute_tel";
        public static final String RADIUS = "radius";
        public static final String IS_RESTRICTED = "is_restricted";
        public static final String NAME_KR = "name_kr";
        public static final String POSITION_X = "position_x";
        public static final String POSITION_Y = "position_y";
        public static final String THETA = "theta";
        public static final String TYPE = "type";
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
@Entity(tableName = "user_table")
public class User {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "poiId")
    private String poiId;

    @ColumnInfo(name = "floorCode")
    private String floorCode;

    @ColumnInfo(name = "floorName")
    @Embedded
    @SerializedName("floorName")
    private FloorName floorName;

    @ColumnInfo(name = "floorIndex")
    private float floorIndex;

    @NonNull
    @ColumnInfo(name = "userName")
    private String userName;

    @NonNull
    @ColumnInfo(name = "age")
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getUserName() {
        return userName;
    }

    public void setUserName(@NonNull String userName) {
        this.userName = userName;
    }

    @NonNull
    public int getAge() {
        return age;
    }

    public void setAge(@NonNull int age) {
        this.age = age;
    }

    @NonNull
    @Override
    public String toString() {
        return String.format("%d. 이름 : %s, 나이 : %d", id, userName, age);
    }
}
