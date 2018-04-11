package com.example.android.sellchometz;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.sellchometz.data.AllInfoContract;
import com.example.android.sellchometz.data.AllInfoContract.AllEntry;

import static com.example.android.sellchometz.R.layout.activity_login;



public class Login extends AppCompatActivity {

   private Button go;
    private Button load;
    private ImageButton next;

    private SharedPreferences mPrefs;
    private SharedPreferences.Editor mPrefEditor;
public String word;
    TextView pass;
    TextView first;
    TextView last;
    TextView city;
    TextView state;
    TextView add;
    TextView phone;
    TextView date;
    String homeAdd;
    String ePass;
    String nameFirst;
    String nameLast;
    String theCity;
    String theState;
    String thePhone;
    String theDate;
    String dataBase;
    String passW;
    int jim=0;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_login);


        mPrefs= PreferenceManager.getDefaultSharedPreferences(this);
        mPrefEditor=mPrefs.edit();

        final Bundle bundle=getIntent().getExtras();


        first=(TextView) findViewById(R.id.first_name);


        last=(TextView) findViewById(R.id.last_name);


        add=(TextView) findViewById(R.id.address);


        pass=(TextView)findViewById(R.id.email);
        pass.setText(mPrefs.getString("email",""));

        city=(TextView)findViewById(R.id.city);
        city.setText(mPrefs.getString("city",""));

        state=(TextView)findViewById(R.id.state);
        state.setText(mPrefs.getString("state",""));

        phone=(TextView)findViewById(R.id.phone);
        phone.setText(mPrefs.getString("phone",""));

        date=(TextView)findViewById(R.id.date);
        date.setText(mPrefs.getString("date",""));




        next=(ImageButton)findViewById(R.id.fab);

 passW=pass.getText().toString().trim();
       if(!(passW.equals(""))){
displayDatabaseInfo();
        }

        next.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View view){

                if(jim==0) {

                    saveSettings();
                    Intent startIntent = new Intent(Login.this, Places2.class);

                    startActivity(startIntent);
                }    }
        });




            }

    @Override
    protected void onStart() {
        super.onStart();
        loadSettings();


    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        saveSettings();
    }

    private void displayDatabaseInfo() {

        String[]projection={
                AllInfoContract.AllEntry._ID,
                AllInfoContract.AllEntry.FIRST_NAME,
                AllInfoContract.AllEntry.LAST_NAME,
                AllInfoContract.AllEntry.ADDRESS,
                AllInfoContract.AllEntry.PASSWORD

        };
        Cursor cursor = getContentResolver().query(AllInfoContract.AllEntry.CONTENT_URI,projection,null,null,null);



        int nameColumnIndex=cursor.getColumnIndex(AllInfoContract.AllEntry.FIRST_NAME);
        int passColumnIndex = cursor.getColumnIndex(AllInfoContract.AllEntry.PASSWORD);
        int lastNameColumn=cursor.getColumnIndex(AllInfoContract.AllEntry.LAST_NAME);
        try{
            while(cursor.moveToNext()){
                String next=cursor.getString(passColumnIndex);
                String firstN=cursor.getString(nameColumnIndex);
                String lastN=cursor.getString(lastNameColumn);
                if(next.equals(passW)) {
                   first.setText(firstN);
                    last.setText(lastN);
                }
            }

        }finally {
            cursor.close();
        }

    }




    private void loadSettings(){
        first.setText(mPrefs.getString("name1",""));
        last.setText(mPrefs.getString("name2",""));
        add.setText(mPrefs.getString("address",""));
        pass.setText(mPrefs.getString("email",""));
        city.setText(mPrefs.getString("city",""));
        state.setText(mPrefs.getString("state",""));
        phone.setText(mPrefs.getString("phone",""));
        date.setText(mPrefs.getString("date",""));


    }



    private void saveSettings(){
        nameFirst= first.getText().toString().trim();
    mPrefEditor.putString("name1",nameFirst);
        nameLast=last.getText().toString().trim();
    mPrefEditor.putString("name2",nameLast);
        homeAdd=add.getText().toString().trim();
    mPrefEditor.putString("address",homeAdd);
        ePass=pass.getText().toString().trim();
        if(!(ePass.contains(".com"))&&(!(ePass.equals("")))){
            ePass=ePass+(".com");
        }

        mPrefEditor.putString("email",ePass);
        theCity=city.getText().toString().trim();
        mPrefEditor.putString("city",theCity);
        theState=state.getText().toString().trim();
        mPrefEditor.putString("state",theState);
        thePhone=phone.getText().toString().trim();
        mPrefEditor.putString("phone",thePhone);
        theDate=date.getText().toString().trim();
        mPrefEditor.putString("date",theDate);

    mPrefEditor.apply();
}

    private void insertStuff() {


        EditText first = (EditText) findViewById(R.id.first_name);
        EditText last = (EditText) findViewById(R.id.last_name);
        EditText add = (EditText) findViewById(R.id.address);
        EditText pass=(EditText)findViewById(R.id.email);

        String nameFirst = first.getText().toString().trim();
        String nameLast = last.getText().toString().trim();
        String homeAdd = add.getText().toString().trim();
        String mail=pass.getText().toString().trim();
        String cityS=city.getText().toString().trim();
        String stateS=state.getText().toString().trim();
        String phoneS=phone.getText().toString().trim();
        String dateS=date.getText().toString().trim();

        // Create a ContentValues object where column names are the keys,
        // and pet attributes from the editor are the values.
        ContentValues values = new ContentValues();
        values.put(AllInfoContract.AllEntry.FIRST_NAME, nameFirst);
        values.put(AllInfoContract.AllEntry.LAST_NAME, nameLast);
        values.put(AllInfoContract.AllEntry.ADDRESS, homeAdd);
        values.put(AllInfoContract.AllEntry.PASSWORD,mail);
        values.put(AllEntry.CITY,cityS);
        values.put(AllEntry.STATE,stateS);
        values.put(AllEntry.PHONE,phoneS);
        values.put(AllEntry.DATE,dateS);

        // Insert a new pet into the provider, returning the content URI for the new pet.
      Uri newUri = getContentResolver().insert(AllInfoContract.AllEntry.CONTENT_URI, values);

        // Show a toast message depending on whether or not the insertion was successful
        if (newUri == null) {
            // If the new content URI is null, then there was an error with insertion.
            Toast.makeText(this, getString(R.string.editor_insert_info_failed),
                    Toast.LENGTH_SHORT).show();
        } else {
            // Otherwise, the insertion was successful and we can display a toast.
            Toast.makeText(this, getString(R.string.editor_insert_info_successful),
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void loadSet() {
       pass.setText( mPrefs.getString("pasword", ""));


    }
    public void test(){
        String nameFirst = first.getText().toString().trim();
        String nameLast = last.getText().toString().trim();
        String homeAdd = add.getText().toString().trim();
        String mail=pass.getText().toString().trim();
        String cityS=city.getText().toString().trim();
        String stateS=state.getText().toString().trim();
        String phoneS=phone.getText().toString().trim();
        String dateS=date.getText().toString().trim();
        String n = ".*[0-9].*";
        String a = ".*[a-zA-Z].*";
        if(nameFirst.equals("")||nameLast.equals("")||homeAdd.equals("")||mail.equals("")||cityS.equals("")||stateS.equals("")
                ||phoneS.equals("")||dateS.equals("")){
            Toast.makeText(this,"All fields required.",
                    Toast.LENGTH_SHORT).show();
            jim=1;
        }


        else if(!(homeAdd.matches(n))||(!(homeAdd.matches(a)))){
            Toast.makeText(this,"Invalid address",
                    Toast.LENGTH_SHORT).show();
            jim=1;}


        else{jim=0;}
    }

    }






