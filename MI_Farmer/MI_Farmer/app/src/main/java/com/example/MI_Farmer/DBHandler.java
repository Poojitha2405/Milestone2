package com.example.MI_Farmer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "cropsdb";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "mycart";

    private static final String USER_TABLE_NAME = "users";

    // below variable is for our id column.
    private static final String ID_COL = "id";

    // below variable is for our hotel name column
    private static final String CROP_COL = "crop";

    private static final String AMOUNT_COL = "amount";

    // below variable id for our meal column.
    private static final String PRICE_COL = "price";

    // below variable for our rating column.
    private static final String SUBTOTAL_COL = "subtotal";

    private static final String IMAGE_RESOURCE_COL = "image_resource";

    private static final String USER_NAME_COL = "name";

    private static final String EMAIL_COL = "email";

    // below variable id for our meal column.
    private static final String PHONE_COL = "phone";

    // below variable for our rating column.
    private static final String PASSWORD_COL = "password";

    private static final String DATE_COL = "date";


    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + CROP_COL + " TEXT,"
                + PRICE_COL + " TEXT,"
                + SUBTOTAL_COL + " TEXT,"
                + AMOUNT_COL + " TEXT,"
                + IMAGE_RESOURCE_COL + " TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);


        query = "CREATE TABLE " + USER_TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + USER_NAME_COL + " TEXT,"
                + EMAIL_COL + " TEXT,"
                + PHONE_COL + " TEXT,"
                + PASSWORD_COL + " TEXT,"
                + DATE_COL + " TEXT)";

        db.execSQL(query);
    }

    // this method is useD to add new MEAL to our sqlite database.
    public void addNewCourse(String cropName, String price, String subtotal, String amount, String imgResource ) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(CROP_COL, cropName);
        values.put(PRICE_COL, price);
        values.put(SUBTOTAL_COL, subtotal);
        values.put(AMOUNT_COL, amount);
        values.put(IMAGE_RESOURCE_COL, imgResource);


        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    public void addNewUser(String userName, String email, String phone, String password, String date ) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(USER_NAME_COL, userName);
        values.put(EMAIL_COL, email);
        values.put(PHONE_COL, phone);
        values.put(PASSWORD_COL, password);
        values.put(DATE_COL, date);


        // after adding all values we are passing
        // content values to our table.
        db.insert(USER_TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    // we have created a new method for reading all the courses.
    public ArrayList<CropModal> readCrops() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorMeals = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.
        ArrayList<CropModal> cropModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorMeals.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                cropModalArrayList.add(new CropModal(cursorMeals.getString(0),cursorMeals.getString(1),
                        cursorMeals.getString(2),
                        cursorMeals.getString(3),
                cursorMeals.getString(4),
                cursorMeals.getString(5)));
            } while (cursorMeals.moveToNext());
            // moving our cursor to next.
        }

        // at last closing our cursor
        // and returning our array list.
        cursorMeals.close();
        return cropModalArrayList;
    }


    public ArrayList<UserModal> readUsers() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorMeals = db.rawQuery("SELECT * FROM " + USER_TABLE_NAME, null);

        // on below line we are creating a new array list.
        ArrayList<UserModal> userModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorMeals.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                userModalArrayList.add(new UserModal(cursorMeals.getString(0),
                        cursorMeals.getString(1),
                        cursorMeals.getString(2),
                        cursorMeals.getString(3),
                        cursorMeals.getString(4),
                        cursorMeals.getString(5)));
            } while (cursorMeals.moveToNext());
            // moving our cursor to next.
        }

        // at last closing our cursor
        // and returning our array list.
        cursorMeals.close();
        return userModalArrayList;
    }



    public int deleteCrop(String cropName) {

        SQLiteDatabase db = this.getWritableDatabase();

        String whereClause = ID_COL + " = ?";
        String[] whereArgs = new String[]{String.valueOf(cropName)};

//for multiple condition, join them with AND
//String whereClause = KEY_NAME1 + " = ? AND " + KEY_NAME2 + " = ?";
//String[] whereArgs = new String[]{String.valueOf(KEY_VALUE1), String.valueOf(KEY_VALUE2)};

        int numRowsDeleted = db.delete(TABLE_NAME, whereClause, whereArgs);
        db.close();

        return numRowsDeleted;
    }

    public void deleteAll() {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, null, null);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

