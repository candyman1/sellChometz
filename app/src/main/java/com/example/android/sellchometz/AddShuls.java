package com.example.android.sellchometz;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.sellchometz.data.CCHelper;
import com.example.android.sellchometz.data.CContract.CEntry;
import com.example.android.sellchometz.data.ShulInfoContract;

public class AddShuls extends AppCompatActivity {


    private EditText mPassword;

    private EditText mRabbisName;

    Button saveB;

    Button find;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_shuls);


        find=(Button)findViewById(R.id.findEmail);
        saveB=(Button)findViewById(R.id.saveB);
        mPassword = (EditText) findViewById(R.id.shul);
        mRabbisName = (EditText) findViewById(R.id.rabbi);

        saveB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertStuff();
            }});
                find.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent startIntent = new Intent(AddShuls.this,Display.class);

                        startActivity(startIntent);}
                    });

        }

    private void insertStuff() {

        String email =mPassword.getText().toString().trim();
        String rabbiName =mRabbisName.getText().toString().trim();
       if(!(email.equals("")||rabbiName.equals(""))){

        ContentValues values = new ContentValues();
        values.put(ShulInfoContract.ShulEntry.SHUL_MAIL, email);
        values.put(ShulInfoContract.ShulEntry.SHUL_RABBI, rabbiName);

        String selection=ShulInfoContract.ShulEntry.SHUL_MAIL+" =    ?";
        String[]selectionArgs={email};
        int count=getContentResolver().update(ShulInfoContract.ShulEntry.CONTENT_URI,values,selection,selectionArgs);


        if (count!=0){

            Toast.makeText(this, "updated",
                    Toast.LENGTH_SHORT).show();
        }else{

            // Insert a new pet into the provider, returning the content URI for the new pet.
            Uri newUri = getContentResolver().insert(ShulInfoContract.ShulEntry.CONTENT_URI, values);

            // Show a toast message depending on whether or not the insertion was successful
            if (newUri == null) {
                // If the new content URI is null, then there was an error with insertion.
                Toast.makeText(this, getString(R.string.editor_insert_info_failed),
                        Toast.LENGTH_SHORT).show();
            } else{
                // Otherwise, the insertion was successful and we can display a toast.


                Toast.makeText(this, getString(R.string.editor_insert_info_successful),
                        Toast.LENGTH_SHORT).show();
            }
        }}}
    private void insertShul() {

        String passString = mPassword.getText().toString().trim();
        String rabbiString = mRabbisName.getText().toString().trim();
        CCHelper mCCHelper = new CCHelper(this);
        SQLiteDatabase db = mCCHelper.getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put(CEntry.COLUMN_PASSWORD, passString);
        values.put(CEntry.COLUMN_RABBI, rabbiString);

    }
    private void deleteName(){
        String[]projection={
             ShulInfoContract.ShulEntry.SHUL_RABBI,
        ShulInfoContract.ShulEntry.SHUL_MAIL
        };
        Cursor cursor = getContentResolver().query(ShulInfoContract.ShulEntry.CONTENT_URI,projection,null,null,null);



        int rabbiColumnIndex=cursor.getColumnIndex(ShulInfoContract.ShulEntry.SHUL_RABBI);
        int mailColumnIndex = cursor.getColumnIndex(ShulInfoContract.ShulEntry.SHUL_MAIL);

        try{
            while(cursor.moveToNext()){
                String next=cursor.getString(rabbiColumnIndex);
                String firstN=cursor.getString(mailColumnIndex);
                String email =mPassword.getText().toString().trim();
                if(email.equals(firstN)){
                    int count=getContentResolver().delete(ShulInfoContract.ShulEntry.CONTENT_URI,null,null);

                    if (count!=0){
                        Toast.makeText(this, "deleted",
                                Toast.LENGTH_SHORT).show();


                    }
                    else{
                        Toast.makeText(this, "Not found",
                                Toast.LENGTH_SHORT).show();
                    }
                }

            }

        }finally {
            cursor.close();
        }
        String email =mPassword.getText().toString().trim();
        String rabbiName =mRabbisName.getText().toString().trim();
        int count=getContentResolver().delete(ShulInfoContract.ShulEntry.CONTENT_URI,null,null);

        if (count!=0){
            Toast.makeText(this, "deleted",
                    Toast.LENGTH_SHORT).show();


        }
        else{
            Toast.makeText(this, "Not found",
                    Toast.LENGTH_SHORT).show();
        }
    }

        @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Save" menu option
            case R.id.action_save:

                finish();
                return true;
        }
    return super.onOptionsItemSelected(item);}}

