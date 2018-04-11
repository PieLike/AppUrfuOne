package com.example.pielikes.appurfuone;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.provider.UserDictionary;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IllegalFormatException;

import static android.content.ContentValues.TAG;
import static android.provider.CalendarContract.AUTHORITY;
import static android.provider.CalendarContract.CONTENT_URI;

public class CProvider extends ContentProvider {

    static final String PROVIDER_NAME = "com.example.pielikes.appurfuone.CProvider";
    static final String URL = "content://" + PROVIDER_NAME + "/cpcontacts";
    static final Uri CONTENT_URL = Uri.parse(URL);
    static final String id = "id";
    static final String name = "name";
    static final int uriCode = 1;
    private static HashMap<String, String> values;
    static final UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME, "cpcontacts", uriCode);
    }

    private SQLiteDatabase sqlDB;
    static final String DATABASE_NAME = "myContacts";
    static final String TABLE_NAME = "names";
    static final int DATABASE_VERSION = 1;
    static final String CREATE_DB_TABLE = "CREATE TABLE " + TABLE_NAME +
            " (id INTEGER PRIMARY KEY AUTOINCREMENT, " + " name TEXT NOT NULL);";



    @Override
    public synchronized Cursor query(Uri uri, String[] projection, String selection,
                                     String[] selectionArgs, String sortOrder){
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(TABLE_NAME);
        switch (uriMatcher.match(uri)){
            case uriCode:
                queryBuilder.setProjectionMap(values);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        Cursor cursor = queryBuilder.query(sqlDB, projection, selection, selectionArgs,
                null, null, sortOrder);
        cursor.setNotificationUri(getContext().getContentResolver(),uri);
        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)){
            case uriCode:
                return "vnd.adroid.cursor.dir/cpcontacts";
            default:
                throw new IllegalArgumentException("Unsupported URI " + uri);
        }
    }

    @Override
    public synchronized int update(Uri uri, ContentValues values, String selection,
                                   String[] selectionArgs){
        int rowsUpdated = 0;
        switch (uriMatcher.match(uri)){
            case uriCode:
                rowsUpdated = sqlDB.update(TABLE_NAME, values, selection, selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return  rowsUpdated;
    }
    @Override
    public synchronized Uri insert(Uri uri, ContentValues values){

        long rowID = sqlDB.insert(TABLE_NAME, null, values);

        if(rowID > 0){
            Uri _uri = ContentUris.withAppendedId(CONTENT_URI, rowID);
            getContext().getContentResolver().notifyChange(_uri, null);
            return _uri;
        } else {
            Toast.makeText(getContext(), "Row Insert Failed",
                    Toast.LENGTH_SHORT).show();
            return null;
        }
    }

    @Override
    public synchronized int delete(Uri uri, String selection, String[] selectionArgs){
        int rowsDeleted = 0;
        switch (uriMatcher.match(uri)){
            case uriCode:
                rowsDeleted = sqlDB.delete(TABLE_NAME, selection,selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return  rowsDeleted;

    }

    public boolean onCreate(){
        DatabaseHelper dbHelper = new DatabaseHelper(getContext());
        sqlDB = dbHelper.getWritableDatabase();

        if(sqlDB != null){
            return true;
        }
    //    Log.i(TAG,"onCreate ContentProvider");
        return false;
    }

    private static class DatabaseHelper extends SQLiteOpenHelper{

        DatabaseHelper(Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqlDB) {
            sqlDB.execSQL(CREATE_DB_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqlDB, int oldVersion, int newVersion) {
            sqlDB.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(sqlDB);
        }
    }

/*    public int insertModule(Module module){

        Uri MODULES_URI = Uri.parse(CONTENT_PATH + AUTHORITY + MODULES_PATH);
        ContentResolver cr = context.getContextResolver();

        ContentValues values = getContextValuesFromModule(module);
        Uri result = cr.insert(MODULES_URI, values);

        return Integer.parseInt(result.getLastPathSegment());
    }

    private static ContentValues getContextValuesFromModule(Module module){

        ContentValues values = new ContentValues();

        values.put(DBHelper.MODULE.VERSION.toString(),module.getVersion());
        values.put(DBHelper.MODULE.TYPE.toString(),module.getType());
        values.put(DBHelper.MODULE.NAME.toString(),module.getName());
        values.put(DBHelper.MODULE.ADDRESS.toString(),module.getAddress());

        return values;
    }

    public List<Module> getModules(){
        List<Module> modules = new ArrayList<>();
        Uri MODULES_URI = Uri.parse(CONTENT_PATH + AUTHORITY + MODULES_PATH);
        ContentResolver cr = context.getContextResolver();
        Cursor cursor = null;
        try {
            cursor = cr.query(MODULES_URI, null, null, null, null);
            if (cursor != null)
                while (cursor.moveToNext())
                    modules.add(getModuleFromCursor(cursor));
        } catch (Exception ex) {
        } finally {
            if (cursor != null){
                cursor.close();
            }
        }
        return modules;
    }

    public void updateModule(Module module){
        ContentResolver cr = context.getContextResolver();
        ContentValues values = getContextValuesFromModule(module);

        cr.update(CProvider.MODULES_URI, values, DBHelper.MODULE.ID + "=?",
                new String[]{String.valueOf(module.getId())});
    }

    public void deleteModule(Module originalModule){
        ContentResolver cr = context.getContextResolver();

        cr.delete(CProvider.MODULES_URI, DBHelper,MODULE.ADDRESS + "=?",
                new String[]{String.valueOf(module.getAddress())});
    }

    Uri mNewUri;
    ContentValues mNewValues = new ContentValues();

    mNewValues.put(UserDictionary.Words.APP_ID, "example.user");
    mNewValues.put(UserDictionary.Words.LOCALE, "en_US");
    mNewValues.put(UserDictionary.Words.WORD, "insert");
    mNewValues.put(UserDictionary.Words.FREQUENCY, "100");

    mNewUri = getContentResolver().insert(UserDictionary.Word.CONTENT_URI,mNewValues);

*/

}
