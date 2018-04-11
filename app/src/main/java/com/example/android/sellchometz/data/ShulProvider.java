package com.example.android.sellchometz.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

/**
 * Created by Tatty on 9/12/2017.
 */

public class ShulProvider extends ContentProvider {
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    public static final int BREAD=100;
    public static final int BREAD_ID=101;
    public static final int BREAD_PASS=102;
    // Static initializer. This is run the first time anything is called from this class.
    static {
        // The calls to addURI() go here, for all of the content URI patterns that the provider
        // should recognize. All paths added to the UriMatcher have a corresponding code to return
        // when a match is found.
        sUriMatcher.addURI(ShulInfoContract.CONTENT_AUTHORITY, ShulInfoContract.SHUL_PATH, BREAD);
        sUriMatcher.addURI(ShulInfoContract.CONTENT_AUTHORITY, ShulInfoContract.SHUL_PATH + "/#", BREAD_ID);
        sUriMatcher.addURI(ShulInfoContract.CONTENT_AUTHORITY, ShulInfoContract.SHUL_PATH + "/*", BREAD_PASS);
    }
    /** Tag for the log messages */
    public static final String LOG_TAG = ShulProvider.class.getSimpleName();

    private ShulHelper sAllHelper;
    @Override
    public boolean onCreate() {
        sAllHelper=new ShulHelper(getContext());
        return true;
    }
    /**
     * Perform the query for the given URI. Use the given projection, selection, selection arguments, and sort order.
     */
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
                        String sortOrder) {
        // Get readable database
        SQLiteDatabase database = sAllHelper.getReadableDatabase();

        // This cursor will hold the result of the query
        Cursor cursor;

        // Figure out if the URI matcher can match the URI to a specific code
        int match = sUriMatcher.match(uri);
        switch (match) {
            case BREAD:



                cursor=database.query(ShulInfoContract.ShulEntry.SHUL_TABLE,projection,selection,selectionArgs,
                        null,null,sortOrder);
                break;
            case BREAD_ID:
                // For the PET_ID code, extract out the ID from the URI.
                // For an example URI such as "content://com.example.android.pets/pets/3",
                // the selection will be "_id=?" and the selection argument will be a
                // String array containing the actual ID of 3 in this case.
                //
                // For every "?" in the selection, we need to have an element in the selection
                // arguments that will fill in the "?". Since we have 1 question mark in the
                // selection, we have 1 String in the selection arguments' String array.
                selection = ShulInfoContract.ShulEntry.SHUL_MAIL+ "   =?";
                selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };

                // This will perform a query on the pets table where the _id equals 3 to return a
                // Cursor containing that row of the table.
                cursor = database.query(ShulInfoContract.ShulEntry.SHUL_TABLE, projection, selection, selectionArgs,
                        null, null, sortOrder);
                break;
            case BREAD_PASS:
                selection = ShulInfoContract.ShulEntry.SHUL_MAIL;
                selectionArgs=new String[]{ ShulInfoContract.ShulEntry.SHUL_MAIL};
                cursor = database.query(ShulInfoContract.ShulEntry.SHUL_TABLE, projection, selection, selectionArgs,
                        null, null, sortOrder);
                break;

            default:
                throw new IllegalArgumentException("Cannot query unknown URI " + uri);
        }
        return cursor;
    }
    /**
     * Insert new data into the provider with the given ContentValues.
     */
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        final int match = sUriMatcher.match(uri);
        switch (match) {
            case BREAD:
                return insertInfo(uri, contentValues);
            default:
                throw new IllegalArgumentException("Insertion is not supported for " + uri);
        }
    }

    /**
     * Insert a pet into the database with the given content values. Return the new content URI
     * for that specific row in the database.
     */
    public Uri insertInfo(Uri uri, ContentValues values) {

        SQLiteDatabase database = sAllHelper.getWritableDatabase();

        // Insert the new pet with the given values
        long id = database.insert(ShulInfoContract.ShulEntry.SHUL_TABLE, null, values);


        // If the ID is -1, then the insertion failed. Log an error and return null.
        if (id == -1) {
            Log.e(LOG_TAG, "Failed to insert row for " + uri);
            return null;}
        // Once we know the ID of the new row in the table,
        // return the new URI with the ID appended to the end of it
        return ContentUris.withAppendedId(uri, id);
    }
    /**
     * Updates the data at the given selection and selection arguments, with the new ContentValues.
     */
    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        SQLiteDatabase database = sAllHelper.getWritableDatabase();


        return database.update(ShulInfoContract.ShulEntry.SHUL_TABLE, values, selection,selectionArgs);



    }

    /**
     * Delete the data at the given selection and selection arguments.
     */
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    /**
     * Returns the MIME type of data for the content URI.
     */
    @Override
    public String getType(Uri uri) {
        return null;
    }
}


