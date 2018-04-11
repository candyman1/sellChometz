package com.example.android.sellchometz;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.preference.PreferenceManager;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import android.print.PrintManager;
import android.print.pdf.PrintedPdfDocument;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.sellchometz.data.AllInfoContract;
import com.example.android.sellchometz.data.AllInfoContract.AllEntry;

import java.io.FileOutputStream;
import java.io.IOException;

import static com.example.android.sellchometz.R.id.exclude;

public class Price extends AppCompatActivity {


    private SharedPreferences mPrefs;
    private SharedPreferences.Editor mPrefEditor;
    private SharedPreferences qPrefs;
    private SharedPreferences.Editor qPrefEditor;
    EditText amount;
    CheckBox checkAll;
    CheckBox except;
    Button viewC;
    CheckBox mini;
    EditText minPlace;
    EditText not;
Context mContext;
   CheckBox stayHome;
    CheckBox key;
    EditText keyPlace;
    String cash;
    String miniPlace;
    String findKey;
CheckBox comb;
    String donot;
    EditText combin;
    String code;
    int count=0;
    int last;
    ImageView image17;
    ImageView image18;
    ImageView image19;
    ImageView image20;
String sub="";
    int lengthTwo=0;
    String subTwo="";
    int lengthThree=0;
    int second=0;
    int twoLen=0;
int huh=0;
    int threeLen=0;
int who=0;
int space1=0;
    int space2=0;
    int space3=0;
int specialLen2;
    int newSpace1=0;
    int newSpace2=0;
    String addPlace1="";
    String addPlace2="";
    int addLen1=0;
    int addLen2;
    String allOne="";
    String allTwo="";
    String allThree="";
    String allFour="";
    String allFive="";
    int numOne=0;
    int numTwo=0;
    int numThree=0;
    int numFour=0;
    int blankOne=0;
    int blankTwo=0;
    int blankThree=0;
    int blankFour=0;
    FrameLayout keyFrame;
    FrameLayout comboFrame;
    FrameLayout exFrame;
    FrameLayout miniFrame;
    Button my2;
    Button place2;
    Button more2;
    Button product2;
   TextView test;
    TextView bill;
    PopupWindow popUpWindow;
    LayoutInflater layoutinflater;
    LinearLayout linearLayout;
    boolean viter=true;
    int vary=0;
    int vary1=0;
    int vary2=0;
    int vary3=0;
    int vary4=0;
    int vary5=0;
    int vary6=0;
    int vary7=0;
    int vary8=0;
    int vary9=0;
    int vary10=0;
    int vary11=0;
    int vary12=0;
    int vary13=0;
    int vary14=0;
    int vary15=0;
    int vary16=0;
    int vary17=0;
    int vary18=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price);
mContext =this;
        test=(TextView)findViewById(R.id.hello);
        bill=(TextView)findViewById(R.id.bob);
        linearLayout=(LinearLayout)findViewById(R.id.activity_price);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutinflater=(LayoutInflater)getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                ViewGroup container=(ViewGroup)layoutinflater.inflate(R.layout.test,null);

                popUpWindow=new PopupWindow(container,400,400,true);
                popUpWindow.showAtLocation(linearLayout, Gravity.NO_GRAVITY,100,200);

                container.setOnTouchListener(new View.OnTouchListener(){
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                       popUpWindow.dismiss();
                        return true;
                    }
                });
            }
        });

        bill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutinflater=(LayoutInflater)getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                ViewGroup container=(ViewGroup)layoutinflater.inflate(R.layout.ques2,null);

                popUpWindow=new PopupWindow(container,400,400,true);
                popUpWindow.showAtLocation(linearLayout, Gravity.NO_GRAVITY,100,200);

                container.setOnTouchListener(new View.OnTouchListener(){
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popUpWindow.dismiss();
                        return true;
                    }
                });
            }
        });





        mPrefs= PreferenceManager.getDefaultSharedPreferences(this);
        mPrefEditor=mPrefs.edit();
        qPrefs= PreferenceManager.getDefaultSharedPreferences(this);
        qPrefEditor=qPrefs.edit();

        amount=(EditText)findViewById(R.id.value);
        checkAll=(CheckBox)findViewById(R.id.fullCheck) ;
        except=(CheckBox)findViewById(exclude);
        mini=(CheckBox)findViewById(R.id.minimal);
        minPlace=(EditText)findViewById(R.id.minPlaces);
        stayHome=(CheckBox) findViewById(R.id.home);
        key=(CheckBox) findViewById(R.id.keys);
        keyPlace=(EditText)findViewById(R.id.keyNumber);
        comb=(CheckBox)findViewById(R.id.combo);
        image17=(ImageView)findViewById(R.id.imageView17);
        image18=(ImageView)findViewById(R.id.imageView18);
        image19=(ImageView)findViewById(R.id.imageView19);
        image20=(ImageView)findViewById(R.id.imageView20);
        combin=(EditText)findViewById(R.id.combi);

        not=(EditText)findViewById(R.id.lazy);
        keyFrame=(FrameLayout)findViewById(R.id.cey);
        comboFrame=(FrameLayout)findViewById(R.id.comboFrame);
        exFrame=(FrameLayout)findViewById(R.id.excludeFrame);
        miniFrame=(FrameLayout)findViewById(R.id.miniFrame);
        my2=(Button)findViewById(R.id.myId2);
        place2=(Button)findViewById(R.id.plac2);
        more2=(Button)findViewById(R.id.more2);
        product2=(Button)findViewById(R.id.product2);

        my2.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                saveSettings();

                Intent startIntent = new Intent(Price.this,Login.class);

                startActivity(startIntent);
            }});
        place2.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                saveSettings();

                Intent startIntent = new Intent(Price.this,Places2.class);

                startActivity(startIntent);
            }});
        more2.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                saveSettings();

                Intent startIntent = new Intent(Price.this,More.class);

                startActivity(startIntent);
            }});
        product2.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                saveSettings();

                Intent startIntent = new Intent(Price.this,ChometzProducts.class);

                startActivity(startIntent);
            }});
        stayHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ( ((CheckBox)v).isChecked() ) {
                    key.setChecked(false);
                    comb.setChecked(false);
                    keyFrame.setVisibility(View.GONE);
                    comboFrame.setVisibility(View.GONE);
                }
            }
        });
        key.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ( ((CheckBox)v).isChecked() ) {
                    stayHome.setChecked(false);

                        keyFrame.setVisibility(View.VISIBLE);
                }
                else{ keyFrame.setVisibility(View.GONE);}
            }
        });

        comb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ( ((CheckBox)v).isChecked() ) {
                    stayHome.setChecked(false);
                    comboFrame.setVisibility(View.VISIBLE);
                }
                else{comboFrame.setVisibility(View.GONE);}
            }
        });
        checkAll.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if ( ((CheckBox)v).isChecked() ) {
                   mini.setChecked(false);
                    except.setChecked(false);

                    exFrame.setVisibility(View.GONE);
                    miniFrame.setVisibility(View.GONE);

                }

            }
        });
        except.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if ( ((CheckBox)v).isChecked() ) {
                    mini.setChecked(false);
                    checkAll.setChecked(false);
                    exFrame.setVisibility(View.VISIBLE);
                    miniFrame.setVisibility(View.GONE);

                }else{exFrame.setVisibility(View.GONE);}

            }
        });
        mini.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if ( ((CheckBox)v).isChecked() ) {
                    except.setChecked(false);
                    checkAll.setChecked(false);
                    exFrame.setVisibility(View.GONE);

                    miniFrame.setVisibility(View.VISIBLE);
                }
                else{ miniFrame.setVisibility(View.GONE);}
            }
        });

        keyPlace.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub

                //Show cross button after start typing.
                image17.setVisibility(View.VISIBLE);

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });
        image17.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                keyPlace.getText().clear();

            }
        });

        combin.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub

                //Show cross button after start typing.
                image18.setVisibility(View.VISIBLE);

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });
        image18.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                combin.getText().clear();

            }
        });
        not.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub

                //Show cross button after start typing.
                image19.setVisibility(View.VISIBLE);

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });
        image19.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                not.getText().clear();

            }
        });
        minPlace.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub

                //Show cross button after start typing.
                image20.setVisibility(View.VISIBLE);

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });
        image20.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                minPlace.getText().clear();

            }
        });
      // viewC=(Button)findViewById(R.id.next);
      // viewC.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
         //  @Override
          // public void onClick(View view) {
             //  saveSettings();
             // insertStuff();
                          //  Intent startIntent = new Intent(Price.this,Display.class);

            //   startActivity(startIntent);
      // }     });


    }


    @Override
    protected void onStart() {
        super.onStart();
        loadSettings();
        if(mini.isChecked()){
            miniFrame.setVisibility(View.VISIBLE);
        }else{miniFrame.setVisibility(View.GONE);}
        if(except.isChecked()){
            exFrame.setVisibility(View.VISIBLE);}
        else{exFrame.setVisibility(View.GONE);}
        if(key.isChecked()){
            keyFrame.setVisibility(View.VISIBLE);
        }else{keyFrame.setVisibility(View.GONE);}
        if(comb.isChecked()){
            comboFrame.setVisibility(View.VISIBLE);
        }else{comboFrame.setVisibility(View.GONE);}

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
       saveSettings();
    }

private void saveSettings(){

    cash=amount.getText().toString().trim();
    mPrefEditor.putString("total",cash);
    mPrefEditor.putBoolean("checkAll_checked",
            checkAll.isChecked());
    mPrefEditor.putBoolean("checkEx_checked",
            except.isChecked());
    mPrefEditor.putBoolean("checkMin_checked",
           mini.isChecked());
    miniPlace=minPlace.getText().toString().trim();
    mPrefEditor.putString("least",miniPlace);
    mPrefEditor.putBoolean("checkHome_checked",
            stayHome.isChecked());
    mPrefEditor.putBoolean("checkKey_checked",
            key.isChecked());
    findKey=keyPlace.getText().toString().trim();
    mPrefEditor.putString("lookKey",findKey);
    donot=not.getText().toString().trim();
    mPrefEditor.putString("lazy",donot);
    mPrefEditor.putBoolean("comb_checked",comb.isChecked());
    code=combin.getText().toString().trim();
    mPrefEditor.putString("code",code);

    mPrefEditor.apply();
}
private void loadSettings(){

    amount.setText(mPrefs.getString("total",""));
    checkAll.setChecked(mPrefs.getBoolean("checkAll_checked",false));
    except.setChecked(mPrefs.getBoolean("checkEx_checked",false));
    mini.setChecked(mPrefs.getBoolean("checkMin_checked",false));
    minPlace.setText(mPrefs.getString("least",""));
    stayHome.setChecked(mPrefs.getBoolean("checkHome_checked",false));
    key.setChecked(mPrefs.getBoolean("checkKey_checked",false));
    keyPlace.setText(mPrefs.getString("lookKey",""));
    not.setText(mPrefs.getString("lazy",""));
    comb.setChecked(mPrefs.getBoolean("comb_checked",false));
    combin.setText(mPrefs.getString("code",""));


}

    private void insertStuff() {



        String nameFirst =(mPrefs.getString("name1",""));
        String nameLast = (mPrefs.getString("name2",""));
        String homeAdd = (mPrefs.getString("address",""));
        String mail=(mPrefs.getString("email",""));
        String cityS=(mPrefs.getString("city",""));
        String stateS=(mPrefs.getString("state",""));
        String phoneS=(mPrefs.getString("phone",""));

        String other=(mPrefs.getString("other",""));
        String carSS=(mPrefs.getString("carList", ""));
        String investSS=(mPrefs.getString("investList", ""));
        String lockerSS=(mPrefs.getString("lockerList", ""));
        String neighborSS=(mPrefs.getString("neighborList", ""));
        String freezerSS=(mPrefs.getString("coolerList", ""));
        String officeSS=(mPrefs.getString("officeList", ""));
        String otherSS=(mPrefs.getString("longList", ""));
        String moreProd=(mPrefs.getString("info",""));
        String money=(mPrefs.getString("total",""));

        String findKey=(mPrefs.getString("lookKey",""));
        String findComb=(mPrefs.getString("code",""));


        String lessCheck=(mPrefs.getString("lazy",""));
        String leastCheck=(mPrefs.getString("least",""));

        String atticS=(mPrefs.getString("atticS",""));
        int basementS;
        int bathS;
        int breakfrontS;
        int briefS;
        int closetS;
        int crawlS;
        int drawerS;
        int freezerS;
        int garageS;
        int grillS;
        int kitCabS;
        int liqS;
        int medChestS;
        int pantryS;
        int fridgeS;
        int shedS;
        int storageS;
        int carBoxS;
        int investBoxS;
        int lockerBoxS;
        int neighborBoxS;
        int officeBoxS;
        int freezerBoxS;
        int otherBoxS;
        int zoneS;
        int bakedPS;
        int bakeIS;
        int barleyS;
        int beerS;
        int cerealS;
        int condS;
        int cosS;
        int crackerS;
        int frozenS;
        int groceryS;
        int liquorS;
        int medS;
        int mixS;
        int noodleS;
        int oatS;
        int perfumeS;
        int petS;
        int pickleS;
        int playdS;
        int toilS;
        int vitaS;
        int wheatS;
        int utenS;
        int applyS;
        int baketS;
        int toyS;
        int bookS;
        int seferS;
        int etcS;

        int homeS;
        int keyS;
        int comboS;
        int fullS;
        int excludeS;
        int miniS;
        Boolean storageC=(mPrefs.getBoolean("storage_checked",false));
        Boolean shedC=(mPrefs.getBoolean("shed_checked",false));
        Boolean fridgeC=(mPrefs.getBoolean("fridge_checked",false));
        Boolean pantryC=(mPrefs.getBoolean("pantry_checked",false));
        Boolean medChestC=(mPrefs.getBoolean("medChest_checked",false));
        Boolean liqC=(mPrefs.getBoolean("liquor_checked",false));
        Boolean kitCabC=(mPrefs.getBoolean("kitCab_checked",false));
        Boolean grillC=(mPrefs.getBoolean("grill_checked",false));
        Boolean garageC=(mPrefs.getBoolean("garage_checked",false));
        Boolean freezerC=(mPrefs.getBoolean("freezer_checked",false));
        Boolean drawerC=(mPrefs.getBoolean("drawer_checked",false));
        Boolean crawlC=(mPrefs.getBoolean("crawl_checked",false));
        Boolean closetC=(mPrefs.getBoolean("closet_checked",false));
        Boolean briefC=(mPrefs.getBoolean("brief_checked",false));
        Boolean bathC=(mPrefs.getBoolean("bath_checked",false));
        Boolean base=(mPrefs.getBoolean("base_checked",false));
        Boolean breakf=(mPrefs.getBoolean("break_checked",false));
        Boolean carB=(mPrefs.getBoolean("car_checked",false));
        Boolean investB=(mPrefs.getBoolean("investment_checked",false));
        Boolean lockerB=(mPrefs.getBoolean("locker_checked",false));
        Boolean neighborB=(mPrefs.getBoolean("neighbor_checked",false));
        Boolean officeB=(mPrefs.getBoolean("office_checked",false));
        Boolean freezeB=(mPrefs.getBoolean("cooler_checked",false));
        Boolean otherB=(mPrefs.getBoolean("other_checked",false));
        Boolean zoneB=(mPrefs.getBoolean("checkZone_checked",false));
        Boolean bakingPB=(mPrefs.getBoolean("checkBake_checked",false));
        Boolean bakingIB=(mPrefs.getBoolean("checkIng_checked",false));
        Boolean barleyB=(mPrefs.getBoolean("checkBarl_checked",false));
        Boolean beerB=(mPrefs.getBoolean("checkBeer_checked",false));
        Boolean cerealB=(mPrefs.getBoolean("checkCerea_checked",false));
        Boolean condB=(mPrefs.getBoolean("checkCon_checked",false));
        Boolean cosB=(mPrefs.getBoolean("checkCos_checked",false));
        Boolean crackerB=(mPrefs.getBoolean("checkCracker_checked",false));
        Boolean frozenB=(mPrefs.getBoolean("checkFroz_checked",false));
        Boolean groceryB=(mPrefs.getBoolean("checkGroc_checked",false));
        Boolean liquoB=(mPrefs.getBoolean("checkLiq_checked",false));
        Boolean medicinB=(mPrefs.getBoolean("checkMed_checked",false));
        Boolean mixB=(mPrefs.getBoolean("checkMix_checked",false));
        Boolean noodleB=(mPrefs.getBoolean("checkNoodle_checked",false));
        Boolean oatB=(mPrefs.getBoolean("checkOat_checked",false));
        Boolean perfumeB=(mPrefs.getBoolean("checkPerfume_checked",false));
        Boolean petB=(mPrefs.getBoolean("checkPet_checked",false));
        Boolean pickleB=(mPrefs.getBoolean("checkPickle_checked",false));
        Boolean playdB=(mPrefs.getBoolean("checkPlay_checked",false));
        Boolean toilB=(mPrefs.getBoolean("checkToil_checked",false));
        Boolean vitaB=(mPrefs.getBoolean("checkVita_checked",false));
        Boolean wheatB=(mPrefs.getBoolean("checkWheat_checked",false));
        Boolean utenB=(mPrefs.getBoolean("checkUtensil_checked",false));
        Boolean applyB=(mPrefs.getBoolean("checkAppliance_checked",false));
        Boolean baketB=(mPrefs.getBoolean("checkBaking_checked",false));
        Boolean toyB=(mPrefs.getBoolean("checkToy_checked",false));
        Boolean bookB=(mPrefs.getBoolean("checkBook_checked",false));
        Boolean seferB=(mPrefs.getBoolean("checkSeforim_checked",false));
        Boolean etcB=(mPrefs.getBoolean("checkEtc_checked",false));

        Boolean homeB=(mPrefs.getBoolean("checkHome_checked",false));
        Boolean keyB=(mPrefs.getBoolean("checkKey_checked",false));
        Boolean comboB=(mPrefs.getBoolean("comb_checked",false));
        Boolean excludeB=(mPrefs.getBoolean("checkEx_checked",false));
        Boolean fullB=(mPrefs.getBoolean("checkAll_checked",false));

        Boolean miniB=(mPrefs.getBoolean("checkMin_checked",false));
        if(homeB){
            homeS=1;
        }else{
            homeS=2;
        }
        if(keyB){
            keyS=1;
        }else{
            keyS=2;
        }
        if(comboB){
            comboS=1;
        }else{
            comboS=2;
        }if(excludeB){
            excludeS=1;
        }else{
            excludeS=2;
        }if(miniB){
            miniS=1;
        }else{
            miniS=2;
        }
        if(fullB){
            fullS=1;
        }else{
            fullS=2;
        }
        if(bakingPB){
            bakedPS=1;
        }else{
            bakedPS=2;
        }
        if(bakingIB){
            bakeIS=1;
        }else{
            bakeIS=2;
        }
        if(barleyB){
            barleyS=1;
        }else{
            barleyS=2;
        }
        if(beerB){
            beerS=1;
        }else{
            beerS=2;
        }
        if(cerealB){
            cerealS=1;
        }else{
            cerealS=2;
        }
        if(condB){
            condS=1;
        }else{
            condS=2;
        }
        if(cosB){
            cosS=1;
        }else{
            cosS=2;
        }
        if(crackerB){
            crackerS=1;
        }else{
            crackerS=2;
        }
        if(frozenB){
            frozenS=1;
        }else{
            frozenS=2;
        }
        if(groceryB){
            groceryS=1;
        }else{
            groceryS=2;
        }
        if(liquoB){
            liquorS=1;
        }else{
            liquorS=2;
        }
        if(medicinB){
            medS=1;
        }else{
            medS=2;
        }
        if(mixB){
            mixS=1;
        }else{
            mixS=2;
        }
        if(noodleB){
            noodleS=1;
        }else{
            noodleS=2;
        }
        if(oatB){
            oatS=1;
        }else{
            oatS=2;
        }
        if(perfumeB){
            perfumeS=1;
        }else{
            perfumeS=2;
        }
        if(petB){
            petS=1;
        }else{
            petS=2;
        }
        if(pickleB){
            pickleS=1;
        }else{
            pickleS=2;
        }
        if(playdB){
            playdS=1;
        }else{
            playdS=2;
        }
        if(toilB){
            toilS=1;
        }else{
            toilS=2;
        }
        if(vitaB){
            vitaS=1;
        }else{
            vitaS=2;
        }
        if(wheatB){
            wheatS=1;
        }else{
            wheatS=2;
        }
        if(utenB){
            utenS=1;
        }else{
            utenS=2;
        }
        if(applyB){
            applyS=1;
        }else{
            applyS=2;
        }
        if (baketB){
            baketS=1;
        }else{
            baketS=2;
        }
        if(toyB){
            toyS=1;
        }else{
            toyS=2;
        }
        if(bookB){
            bookS=1;
        }else{
            bookS=2;
        }
        if(seferB){
            seferS=1;
        }else{
            seferS=2;
        }
        if(etcB){
            etcS=1;
        }else{
            etcS=2;
        }




        if(zoneB){
            zoneS=1;
        }else{
            zoneS=2;
        }
        if(otherB){
            otherBoxS=1;
        }else{
            otherBoxS=2;
        }
        if(freezeB){
            freezerBoxS=1;
        }else{
            freezerBoxS=2;
        }
        if(officeB){
            officeBoxS=1;
        }else{
            officeBoxS=2;
        }
        if(neighborB){
            neighborBoxS=1;
        }else{
            neighborBoxS=2;
        }
        if(lockerB){
            lockerBoxS=1;
        }else{
            lockerBoxS=2;
        }
        if(investB){
            investBoxS=1;
        }else{
            investBoxS=2;
        }
        if (carB){
           carBoxS=1;
        }else{
            carBoxS=2;
        }

        if(storageC==true){
            storageS=1;
        }else{
            storageS=2;
        }
        if(shedC==true){
            shedS=1;
        }else{
            shedS=2;
        }
        if(fridgeC==true){
            fridgeS=1;
        }else{
            fridgeS=2;
        }
        if(pantryC==true){
            pantryS=1;
        }else{
            pantryS=2;
        }
        if(medChestC==true){
            medChestS=1;
        }else{
            medChestS=2;
        }
        if (liqC==true){
            liqS=1;
        }else{
            liqS=2;
        }
        if(kitCabC==true){
            kitCabS=1;
        }else{
            kitCabS=2;
        }
        if(grillC==true){
            grillS=1;
        }else{
            grillS=2;
        }
        if(garageC==true){
            garageS=1;
        }else{
            garageS=2;
        }
        if(freezerC==true){
            freezerS=1;
        }else{
            freezerS=2;
        }
        if(drawerC==true){
            drawerS=1;
        }else{
            drawerS=2;
        }
        if(crawlC==true){
            crawlS=1;
        }else{
            crawlS=2;
        }
        if(closetC==true){
            closetS=1;
        }else{
            closetS=2;
        }
        if(briefC==true){
            briefS=1;
        }else{
            briefS=2;
        }
        if(bathC==true){
            bathS=1;
        }else{
            bathS=2;
        }
        if(base==true){
            basementS=1;
        }else{
            basementS=2;
        }
        Boolean joe=(mPrefs.getBoolean("att_checked", false));
        if(joe==true){
            atticS="yes";
        }else{
            atticS="no";
        }
        if(breakf==true){
            breakfrontS=1;
        }else{
            breakfrontS=2;
        }

        // Create a ContentValues object where column names are the keys,
        // and pet attributes from the editor are the values.
        ContentValues values = new ContentValues();
        values.put(AllInfoContract.AllEntry.FIRST_NAME, nameFirst);
        values.put(AllInfoContract.AllEntry.LAST_NAME, nameLast);
        values.put(AllInfoContract.AllEntry.ADDRESS, homeAdd);
        values.put(AllEntry.PASSWORD,mail);
        values.put(AllEntry.CITY,cityS);
        values.put(AllEntry.STATE,stateS);
        values.put(AllEntry.PHONE,phoneS);
        values.put(AllEntry.ATTIC,atticS);
        values.put(AllEntry.BASEMENT,basementS);
        values.put(AllEntry.BATHCAB,bathS);
        values.put(AllEntry.BREAKFRONT,breakfrontS);
        values.put(AllEntry.BRIEFCASE,briefS);
        values.put(AllEntry.CLOSET,closetS);
        values.put(AllEntry.CRAWL,crawlS);
        values.put(AllEntry.DRAWER,drawerS);
        values.put(AllEntry.FREEZER,freezerS);
        values.put(AllEntry.GARAGE,garageS);
        values.put(AllEntry.GRILL,grillS);
        values.put(AllEntry.KITCAB,kitCabS);
        values.put(AllEntry.LIQUORCAB,liqS);
        values.put(AllEntry.MEDCHEST,medChestS);
        values.put(AllEntry.PANTRY,pantryS);
        values.put(AllEntry.FRIDGE,fridgeS);
        values.put(AllEntry.SHED,shedS);
        values.put(AllEntry.STORAGE,storageS);
        values.put(AllEntry.OTHERPLACE,other);
        values.put(AllEntry.CARBOX,carBoxS);
        values.put(AllEntry.INVESTBOX,investBoxS);
        values.put(AllEntry.LOCKERBOX,lockerBoxS);
        values.put(AllEntry.NEIGHBORBOX,neighborBoxS);
        values.put(AllEntry.OFFICEBOX,officeBoxS);
        values.put(AllEntry.FREEZEBOX,freezerBoxS);
        values.put(AllEntry.OTHERBOX,otherBoxS);
        values.put(AllEntry.ZONEBOX,zoneS);
        values.put(AllEntry.CAR,carSS);
        values.put(AllEntry.INVEST,investSS);
        values.put(AllEntry.LOCKER,lockerSS);
        values.put(AllEntry.NEIGHBOR,neighborSS);
        values.put(AllEntry.OFFICE,officeSS);
        values.put(AllEntry.FREEZE,freezerSS);
        values.put(AllEntry.OTTER,otherSS);
        values.put(AllEntry.BAKINGING,bakeIS);
        values.put(AllEntry.BAKINGPRO,bakedPS);
        values.put(AllEntry.BARLEY,barleyS);
        values.put(AllEntry.BEER,beerS);
        values.put(AllEntry.CEREAL,cerealS);
        values.put(AllEntry.CONDIMENTS,condS);
        values.put(AllEntry.COSMETICS,cosS);
        values.put(AllEntry.CRACKERS,crackerS);
        values.put(AllEntry.FROZEN,frozenS);
        values.put(AllEntry.GROCERIES,groceryS);
        values.put(AllEntry.LIQUOR,liquorS);
        values.put(AllEntry.MEDICINE,medS);
        values.put(AllEntry.MIXES,mixS);
        values.put(AllEntry.NOODLE,noodleS);
        values.put(AllEntry.OATMEAL,oatS);
        values.put(AllEntry.PERFUME,perfumeS);
        values.put(AllEntry.PET,petS);
        values.put(AllEntry.PICKLES,pickleS);
        values.put(AllEntry.PLAYDOUGH,playdS);
        values.put(AllEntry.TOILETRIES,toilS);
        values.put(AllEntry.VITAMINS,vitaS);
        values.put(AllEntry.WHEAT,wheatS);
        values.put(AllEntry.UTENSILS,utenS);
        values.put(AllEntry.APPLIANCE,applyS);
        values.put(AllEntry.BAKINGT,baketS);
        values.put(AllEntry.TOYS,toyS);
        values.put(AllEntry.BOOKS,bookS);
        values.put(AllEntry.ETC,etcS);
        values.put(AllEntry.ALSOINC,moreProd);
        values.put(AllEntry.SEFORIM,seferS);
        values.put(AllEntry.VALUE,money);
        values.put(AllEntry.STAY,homeS);
        values.put(AllEntry.KEYB,keyS);
        values.put(AllEntry.KEY,findKey);
        values.put(AllEntry.COMBB,comboS);
        values.put(AllEntry.COMB,findComb);
        values.put(AllEntry.FULLBED,fullS);
        values.put(AllEntry.EXCLUDEB,excludeS);
        values.put(AllEntry.EXCLUDE,lessCheck);
        values.put(AllEntry.ONLYB,miniS);
        values.put(AllEntry.ONLY,leastCheck);



        String selection=AllEntry.PASSWORD+" =  ?";
        String[]selectionArgs={mail};
         count=getContentResolver().update(AllEntry.CONTENT_URI,values,selection,selectionArgs);


        if (count!=0){
            Toast.makeText(this, "found",
                    Toast.LENGTH_SHORT).show();
        }else{

        // Insert a new pet into the provider, returning the content URI for the new pet.
        Uri newUri = getContentResolver().insert(AllInfoContract.AllEntry.CONTENT_URI, values);

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
    }}
    private void deleteSettings(){
        mPrefs.edit().clear().apply();
    }


    public class MyPrintDocumentAdapter extends PrintDocumentAdapter {
        Context context;
        private int pageHeight;
        private int pageWidth;
        public PdfDocument myPdfDocument;
        public int totalpages = 1;

        public MyPrintDocumentAdapter(Context context) {
            this.context = context;
        }

        @Override
        public void onLayout(PrintAttributes oldAttributes,
                             PrintAttributes newAttributes,
                             CancellationSignal cancellationSignal,
                             LayoutResultCallback callback,
                             Bundle metadata) {

            myPdfDocument = new PrintedPdfDocument(context, newAttributes);

            pageHeight =
                    newAttributes.getMediaSize().getHeightMils() / 1000 * 72;
            pageWidth =
                    newAttributes.getMediaSize().getWidthMils() / 1000 * 72;

            if (cancellationSignal.isCanceled()) {
                callback.onLayoutCancelled();
                return;
            }

            if (totalpages > 0) {
                PrintDocumentInfo.Builder builder = new PrintDocumentInfo
                        .Builder("print_output.pdf")
                        .setContentType(PrintDocumentInfo.CONTENT_TYPE_DOCUMENT)
                        .setPageCount(totalpages);

                PrintDocumentInfo info = builder.build();
                callback.onLayoutFinished(info, true);

            } else {
                callback.onLayoutFailed("Page count is zero.");
            }
        }
        @Override
        public void onFinish(){
            deleteSettings();
            Intent startIntent = new Intent(Price.this, MainActivity.class);
            startActivity(startIntent);
        }

        @Override
        public void onWrite(final PageRange[] pageRanges,
                            final ParcelFileDescriptor destination,
                            final CancellationSignal cancellationSignal,
                            final WriteResultCallback callback) {

            for (int i = 0; i < totalpages; i++) {
                if (pageInRange(pageRanges, i)) {
                    PdfDocument.PageInfo newPage = new PdfDocument.PageInfo.Builder(pageWidth,
                            pageHeight, i).create();

                    PdfDocument.Page page =
                            myPdfDocument.startPage(newPage);


                    if (cancellationSignal.isCanceled()) {
                        callback.onWriteCancelled();
                        myPdfDocument.close();
                        myPdfDocument = null;
                        return;
                    }
                    drawPage(page, i);
                    myPdfDocument.finishPage(page);

                }
            }

            try {
                myPdfDocument.writeTo(new FileOutputStream(
                        destination.getFileDescriptor()));

            } catch (IOException e) {
                callback.onWriteFailed(e.toString());
                return;
            } finally {
                myPdfDocument.close();
                myPdfDocument = null;

            }

            callback.onWriteFinished(pageRanges);

        }



        {

        }
    }


    private boolean pageInRange(PageRange[] pageRanges, int page) {
        for (int i = 0; i < pageRanges.length; i++) {
            if ((page >= pageRanges[i].getStart()) &&
                    (page <= pageRanges[i].getEnd()))
                return true;
        }
        return false;

    }

    private void drawPage(PdfDocument.Page page,
                          int pagenumber) {
        Canvas canvas = page.getCanvas();

        pagenumber++; // Make sure page numbers start at 1

        int titleBaseLine = 55;
        int leftMargin = 225;

        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(24);

        canvas.drawText(
                "שטר          "+"Authorization"+"          הרשאה",
                leftMargin-125,
                titleBaseLine,
                paint);

        paint.setTextSize(14);
        canvas.drawText("DELEGATION OF POWER OF ATTORNEY FOR SALE OF CHOMETZ ", leftMargin - 125, titleBaseLine + 35, paint);

        paint.setTextSize(14);
        canvas.drawText("AND SUBSEQUENT BILL OF SALE ", leftMargin - 25, titleBaseLine + 50, paint);
        SharedPreferences prefs = getSharedPreferences("shulemail", MODE_PRIVATE);

        String rav=prefs.getString("rabbiid","");
        paint.setTextSize(12);
        canvas.drawText("I hereby fully empower and authorize "+rav+", or anyone else he may ", leftMargin - 200, titleBaseLine + 70, paint);
        paint.setTextSize(12);
        canvas.drawText("designate as a subsitute in his stead, to sell and transfer before the coming Pesach all legal title ", leftMargin - 200, titleBaseLine + 80, paint);
        paint.setTextSize(12);
        canvas.drawText("to my \"Chometz\".Chometz is understood, but not limited, to mean any leavened product made of ", leftMargin - 200, titleBaseLine + 90, paint);
        paint.setTextSize(12);
        canvas.drawText("wheat, barley, spelt,oats, or rye, or any mixture or derivative thereof, as well as any item having", leftMargin - 200, titleBaseLine + 100, paint);
        paint.setTextSize(12);
        canvas.drawText("become questionable as to its content as defined in accordance with Jewish Law and tradition.", leftMargin - 200, titleBaseLine + 110, paint);
        paint.setTextSize(12);
        canvas.drawText("Chometz in my possesion may consist of among other things: ", leftMargin - 200, titleBaseLine + 130, paint);
        paint.setTextSize(12);
        String baked = "";
        String bakeP = "";
        String barley = "";
        String beer = "";
        String cereal = "";
        String cond = "";
        String cosmetics = "";
        String crackers = "";
        String frozen = "";
        String groceries = "";
        String liquor = "";
        String medicine = "";
        String mix = "";
        String noodle = "";
        String oatmeal = "";
        String perfume = "";
        String pet = "";
        String pickle = "";
        String playdoe = "";
        String toilet = "";
        String vitamin = "";
        String wheat = "";
        String utensil = "";
        String appliance = "";
        String bakingTool = "";
        String toys = "";
        String books = "";
        String seforim = "";
        String etc = "";
        String otherProduct = "";
        boolean bakedI = (mPrefs.getBoolean("checkIng_checked", false));
        boolean bakedP = (mPrefs.getBoolean("checkBake_checked", false));
        boolean barleyB = (mPrefs.getBoolean("checkBarl_checked", false));
        boolean beerB = (mPrefs.getBoolean("checkBeer_checked", false));
        boolean cerealB = (mPrefs.getBoolean("checkCerea_checked", false));
        boolean condB = (mPrefs.getBoolean("checkCond_checked", false));
        boolean cosB = (mPrefs.getBoolean("checkCos_checked", false));
        boolean crackB = (mPrefs.getBoolean("checkCracker_checked", false));
        boolean frozenB = (mPrefs.getBoolean("checkFroz_checked", false));
        boolean groceryB = (mPrefs.getBoolean("checkGroc_checked", false));
        boolean liquorB = (mPrefs.getBoolean("checkLiq_checked", false));
        boolean medB = (mPrefs.getBoolean("checkMed_checked", false));
        boolean mixB = (mPrefs.getBoolean("checkMix_checked", false));
        boolean noodleB = (mPrefs.getBoolean("checkNoodle_checked", false));
        boolean oatB = (mPrefs.getBoolean("checkOat_checked", false));
        boolean perfumeB = (mPrefs.getBoolean("checkPerfume_checked", false));
        boolean petB = (mPrefs.getBoolean("checkPet_checked", false));
        boolean pickleB = (mPrefs.getBoolean("checkPickle_checked", false));
        boolean playB = (mPrefs.getBoolean("checkPlay_checked", false));
        boolean toiletB = (mPrefs.getBoolean("checkToil_checked", false));
        boolean vitaminB = (mPrefs.getBoolean("checkVita_checked", false));
        boolean wheatB = (mPrefs.getBoolean("checkWheat_checked", false));
        boolean utensilB = (mPrefs.getBoolean("checkUtensil_checked", false));
        boolean applianceB = (mPrefs.getBoolean("checkAppliance_checked", false));
        boolean bakingToolB = (mPrefs.getBoolean("checkBaking_checked", false));
        boolean toysB = (mPrefs.getBoolean("checkToy_checked", false));
        boolean booksB = (mPrefs.getBoolean("checkBook_checked", false));
        boolean seforimB = (mPrefs.getBoolean("checkSeforim_checked", false));
        boolean etcB = (mPrefs.getBoolean("checkEtc_checked", false));
        if (bakedI) {
            baked = "baking ingredients, ";
        }
        if (bakedP) {
            bakeP = "baked products, ";
        }
        if (barleyB) {
            barley = "barley, ";
        }
        if (beerB) {
            beer = "beer, ";
        }
        if (cerealB) {
            cereal = "cereal, ";
        }
        if (condB) {
            cond = "condiments, ";
        }
        if (cosB) {
            cosmetics = "cosmetics, ";
        }
        if (crackB) {
            crackers = "crackers, ";
        }
        if (frozenB) {
            frozen = "frozen items, ";
        }
        if (groceryB) {
            groceries = "groceries, ";
        }
        if (liquorB) {
            liquor = "liquor, ";
        }
        if (medB) {
            medicine = "medicines, ";
        }
        if (mixB) {
            mix = "mixes, ";
        }
        if (noodleB) {
            noodle = "noodle products, ";
        }
        if (oatB) {
            oatmeal = "oatmeal, ";
        }
        if (perfumeB) {
            perfume = "perfumes, ";
        }
        if (petB) {
            pet = "pet food, ";
        }
        if (pickleB) {
            pickle = "pickles, ";
        }
        if (playB) {
            playdoe = "playdough, ";
        }
        if (toiletB) {
            toilet = "toiletries, ";
        }
        if (vitaminB) {
            vitamin = "vitamins, ";
        }
        if (wheatB) {
            wheat = "wheat germ, ";
        }
        if (utensilB) {
            utensil = "utensils, ";
        }
        if (applianceB) {
            appliance = "appliances, ";
        }
        if (bakingToolB) {
            bakingTool = "baking tools, ";
        }
        if (toysB) {
            toys = "toys, ";
        }
        if (booksB) {
            books = "books, ";
        }
        if (seforimB) {
            seforim = "seforim, ";
        }
        if (etcB) {
            etc = "etc.  ";
        }


        String products = baked + bakeP + barley + beer + cereal + cond + cosmetics + crackers + frozen + groceries + liquor + medicine
                + mix + noodle + oatmeal + perfume + pet + pickle + playdoe + toilet + vitamin + wheat;
        String firstLine="";
        if(!(products.equals(""))){
        firstLine = products.substring(0, products.length() - 2);}
        int len = products.length();
        if (len > 93) {
            firstLine = products.substring(0, 93);
            last = firstLine.lastIndexOf(" ");
            vary=10;
            vary1=10;
            firstLine = firstLine.substring(0, last);

            sub = products.substring(last, products.length() - 2);
            lengthTwo = sub.length();
        }
        if (lengthTwo > 93) {
            sub = products.substring(last + 1, last + 93);
            second = sub.lastIndexOf(" ");
            sub = sub.substring(0, second);
            vary1 = 20;
            int bob = sub.length();
            subTwo = products.substring(bob + last + 2, products.length() - 2);
        }


        canvas.drawText(firstLine, leftMargin - 200, titleBaseLine + 140, paint);
        canvas.drawText(sub, leftMargin - 200, titleBaseLine + 140+vary, paint);
        canvas.drawText(subTwo, leftMargin - 200, titleBaseLine + 140+vary1, paint);
        String affixed = utensil + appliance + bakingTool + toys + books + seforim + etc;

        if (!(affixed.equals(""))) {
            affixed = affixed.substring(0, affixed.length() - 2);
            canvas.drawText("Chometz affixed to: " + affixed, leftMargin - 200, titleBaseLine + 150+vary1, paint);

        }
        String otherP = (mPrefs.getString("info", ""));

        String echad = otherP;
        String shainy = "";
        int moreStuff = otherP.length();
        if(!(moreStuff==0)){
            vary2=10;
            vary3=10;
        }
        if (moreStuff > 93) {
            echad = otherP.substring(0, 93);
            vary3=20;
            int sof = echad.lastIndexOf(" ");
            echad = echad.substring(0, sof);
            shainy = otherP.substring(sof, otherP.length() - 2);
        }
        if (!(otherP.equals(""))) {
            vary16=10;
            canvas.drawText("In addition to the above, I wish to specify the following other item(s): ", leftMargin - 200, titleBaseLine + 150+vary1+vary16, paint);
            canvas.drawText(echad, leftMargin - 200, titleBaseLine + 150+vary1+vary2+vary16, paint);
            canvas.drawText(shainy, leftMargin - 200, titleBaseLine + 150+vary1+vary3+vary16, paint);
        }
        vary4=vary1+vary3+vary16;
        canvas.drawText("The above items may be found primarily in: (items at home address ,for other location see below)", leftMargin - 200, titleBaseLine + 160+vary4, paint);
        String attic = "";
        String basement = "";
        String bathCab = "";
        String breakf = "";
        String briefcase = "";
        String closet = "";
        String crawl = "";
        String desk = "";
        String freeze = "";
        String garage = "";
        String grill = "";
        String kitCab = "";
        String liqCab = "";
        String medChest = "";
        String pantry = "";
        String fridge = "";
        String shed = "";
        String storage = "";

        String otherPlace="";

            otherPlace = (mPrefs.getString("other", ""));


        boolean atticB = (mPrefs.getBoolean("att_checked", false));
        boolean basementB = (mPrefs.getBoolean("base_checked", false));
        boolean bathCabB = (mPrefs.getBoolean("bath_checked", false));
        boolean breakfrontB = (mPrefs.getBoolean("break_checked", false));
        boolean briefcasesB = (mPrefs.getBoolean("brief_checked", false));
        boolean closetB = (mPrefs.getBoolean("closet_checked", false));
        boolean crawlB = (mPrefs.getBoolean("crawl_checked", false));
        boolean drawerB = (mPrefs.getBoolean("drawer_checked", false));
        boolean freezerB = (mPrefs.getBoolean("freezer_checked", false));
        boolean garageB = (mPrefs.getBoolean("garage_checked", false));
        boolean grillB = (mPrefs.getBoolean("grill_checked", false));
        boolean kitCabB = (mPrefs.getBoolean("kitCab_checked", false));
        boolean liquorCabB = (mPrefs.getBoolean("liquor_checked", false));
        boolean medChestB = (mPrefs.getBoolean("medChest_checked", false));
        boolean pantryB = (mPrefs.getBoolean("pantry_checked", false));
        boolean fridgeB = (mPrefs.getBoolean("fridge_checked", false));
        boolean shedB = (mPrefs.getBoolean("shed_checked", false));
        boolean storageB = (mPrefs.getBoolean("storage_checked", false));
        if (atticB) {
            attic = "attic, ";
        }
        if (basementB) {
            basement = "basement, ";
        }
        if (bathCabB) {
            bathCab = "bathroom  cabinet, ";
        }
        if (breakfrontB) {
            breakf = "breakfront, ";
        }
        if (briefcasesB) {
            briefcase = "briefcases, ";
        }
        if (closetB) {
            closet = "closet, ";
        }
        if (crawlB) {
            crawl = "crawlspace,  ";
        }
        if (drawerB) {
            desk = "desk drawers, ";
        }
        if (freezerB) {
            freeze = "freezer, ";
        }
        if (garageB) {
            garage = "garage, ";
        }
        if (grillB) {
            grill = "grill, ";
        }
        if (kitCabB) {
            kitCab = "kitchen  cabinets, ";
        }
        if (liquorCabB) {
            liqCab = "liquor  cabinet, ";
        }
        if (medChestB) {
            medChest = "medicine  chest, ";
        }
        if (pantryB) {
            pantry = "pantry, ";
        }
        if (fridgeB) {
            fridge = "refrigerator, ";
        }
        if (shedB) {
            shed = "shed, ";
        }
        if (storageB) {
            storage = "storage  area  ";
        }
        String places = attic + basement + bathCab + breakf + briefcase + closet + crawl + desk + freeze + garage + grill + kitCab + liqCab +
                medChest + pantry + fridge + shed + storage;
        String one="";
        if (!(places.equals("")))
        {
            one = places.substring(0, places.length() - 2);
        }

        String two = "";
        String three = "";
        String four = "";
        int placeLen = places.length();
        if (placeLen > 93) {
            vary5=10;
            vary6=10;
            one = places.substring(0, 93);
            huh = one.lastIndexOf(" ");
            one = one.substring(0, huh);
            two = places.substring(huh + 1, places.length() - 2);
            twoLen = two.length();
        }
        if (twoLen > 93) {
            vary6=20;
            two = two.substring(0, 93);
            who = two.lastIndexOf(" ");
            two = two.substring(0, who);
            three = places.substring(who + huh + 2, places.length() - 2);
            threeLen = three.length();
        }
        addLen1 = otherPlace.length();

            addPlace1 = otherPlace;
        if(addLen1>0){
            vary7=10;
            vary8=10;
        }else{
            vary7=0;
            vary8=0;
        }
      if (addLen1 > 55) {
            addPlace1 = otherPlace.substring(0, 55);
            newSpace1 = addPlace1.lastIndexOf(" ");
            addPlace1 = addPlace1.substring(0, newSpace1);
            addPlace2 = otherPlace.substring(newSpace1 + 1, otherPlace.length()-1);
            vary7=10;
            vary8=20;
        }


        canvas.drawText(one, leftMargin - 200, titleBaseLine + 170+vary4, paint);
        canvas.drawText(two, leftMargin - 200, titleBaseLine + 170+vary4+vary5, paint);
        canvas.drawText(three, leftMargin - 200, titleBaseLine + 170+vary4+vary6, paint);
        if (!(addPlace1.equals(""))) {
            canvas.drawText("They can also be found in: " + addPlace1, leftMargin - 200, titleBaseLine + 170 + vary4 + vary6 + vary7, paint);
            canvas.drawText(addPlace2, leftMargin - 200, titleBaseLine + 170 + vary4 + vary6 + vary8, paint);
        }

        vary9=vary4+vary6+vary8;
        boolean excep = (mPrefs.getBoolean("checkEx_checked", false));
        String jack = not.getText().toString();


        String one1 = jack;
        String two1 = "";
        String three1 = "";
        String four1 = "";
        int jackLen = jack.length();
        if (jackLen > 42) {
            one1 = jack.substring(0, 42);
            vary10=10;
            vary11=10;
            vary12=10;
            space1 = one1.lastIndexOf(" ");
            one1 = one1.substring(0, space1);
            two1 = jack.substring(space1 + 1, jack.length() - 1);
            specialLen2 = two1.length();
        }
        if (specialLen2 > 93) {
            two1 = two1.substring(0, 93);
            vary11=20;
            vary12=20;
            space2 = two1.lastIndexOf(" ");
            two1 = two1.substring(0, space2);
            three1 = jack.substring(space1 + space2 + 2, jack.length() - 1);
            lengthThree = three1.length();
        }
        if (lengthThree > 93) {
            vary12=30;
            three1 = three1.substring(0, 93);
            space3 = three1.lastIndexOf(" ");
            three1 = three1.substring(0, space3);
            four1 = jack.substring(space1 + space2 + space3 + 3, jack.length() - 1);
        }
        boolean small=(mPrefs.getBoolean("checkMin_checked",false));
        if (excep) {
            vary17=10;
            vary18=10;
            canvas.drawText("",leftMargin-200,titleBaseLine+180+vary9,paint);
            canvas.drawText("Special Rental - I would like to exclude from the bedikah: " + one1, leftMargin - 200, titleBaseLine + 180+vary9+vary17, paint);
            canvas.drawText(two1, leftMargin - 200, titleBaseLine + 180+vary9+vary10+vary17, paint);
            canvas.drawText(three1, leftMargin - 200, titleBaseLine + 180+vary9+vary11+vary17, paint);
            canvas.drawText(four1, leftMargin - 200, titleBaseLine + 180+vary9+vary12+vary17, paint);
            canvas.drawText("", leftMargin - 200, titleBaseLine + 180+vary9+vary12+vary17+vary18, paint);
        }
        String just=minPlace.getText().toString();
        int justLen=just.length();
        String just1=just;
        String just2="";
        String just3="";
        if(justLen>42){
            just1=just.substring(0,42);
            int blank=just1.lastIndexOf(" ");
            just1=just1.substring(0,blank);
            just2=just.substring(blank+1,just.length()-1);
            vary11=10;
            vary12=10;
        }
        int just2Len=just2.length();
        if(just2Len>93){
            just2=just2.substring(0,93);
            int blank2=just2.lastIndexOf(" ");
            just2=just2.substring(0,blank2);
            just3=just.substring(blank2+1,just.length()-1);
            vary11=10;
            vary12=20;
        }
        if(small){
            vary17=10;
            vary18=10;
            canvas.drawText("Special Rental - I would like to only check these places: " + just1, leftMargin - 200, titleBaseLine + 180+vary9+vary17, paint);
            canvas.drawText(just2, leftMargin - 200, titleBaseLine + 180+vary9+vary11+vary17, paint);
            canvas.drawText(just3, leftMargin - 200, titleBaseLine + 180+vary9+vary12+vary17, paint);
            canvas.drawText("", leftMargin - 200, titleBaseLine + 180+vary9+vary12+vary17+vary18, paint);
        }
        String day=(mPrefs.getString("date",""));
        String year=day.substring(day.length()-4,day.length());
        switch(year){
            case"2017":
                year="April 10th to April 18th 2017 ";
                break;
            case"2018":
            case"2029":
            case"2037":
            case"2067":
            case"2075":
                year="March 30th to April 7th ";
                break;
            case"2019":
            case"2038":
            case"2084":
                year="April 19th to April 27th ";
                break;
            case"2020":
            case"2039":
            case"2058":
                year="April 8th to April 16th ";
                break;
            case"2021":
            case"2051":
            case"2097":
                year="March 27th to April 4th ";
                break;
            case"2022":
            case"2041":
            case"2079":
                year="April 15th to April 23rd ";
                break;
            case"2023":
            case"2069":
            case"2088":
                year="April 5th to April 13th ";
                break;
            case"2024":
            case"2054":
                year="April 22nd to April 30th ";
                break;
            case"2025":
            case"2055":
                year="April 12th to April 20th ";
                break;
            case"2026":
            case"2045":
                year="April 1st to April 9th ";
                break;
            case"2027":
            case"2073":
            case"2092":
                year="April 21st to April 29th ";
                break;
            case"2028":
            case"2047":
            case"2093":
                year="April 10th to April 18th ";
                break;
            case"2030":
            case"2076":
                year="April 17th to April 25th ";
                break;
            case"2031":
            case"2077":
                year="April 7th to April 15th ";
                break;
            case"2032":
            case"2070":
                year="March 26th to April 3rd ";
                break;
            case"2033":
            case"2052":
            case"2063":
            case"2071":
            case"2082":
                year="April 13th to April 21st ";
                break;
            case"2034":
            case"2080":
                year="April 3rd to April 11th ";
                break;
            case"2035":
            case"2081":
                year="April 23rd to May 1st ";
                break;
            case"2036":
            case"2044":
            case"2074":
                year="April 11th to April 19th ";
                break;
            case "2040":
            case"2048":
            case"2059":
            case"2078":
                year="March 28th to April 5th ";
                break;
            case"2042":
            case"2061":
            case"2099":
                year ="April 4th to April 12th ";
                break;
            case"2043":
            case"2062":
                year="April 24th to April 2nd ";
                break;
            case"2046":
            case"2065":
                year="April 20th to April 28th ";
                break;
            case"2049":
            case"2068":
            case"2087":
            case"2098":
                year="April 16th to April April 24th ";
                break;
            case"2050":
            case"2096":
                year="April 6th to April 14th ";
                break;
            case"2053":
            case"2072":
            case"2083":
            case"2091":
                year="April 2nd to April 10th ";
                break;
            case"2056":
            case"2064":
            case"2094":
                year="March 31st to April 8th ";
                break;
            case"2057":
            case"2095":
                year="April 18th to April 26th ";
                break;
            case"2060":
            case"2090":
                year="April 14th to April 22nd ";
                break;
            case"2066":
            case"2085":
                year="April 9th to April 17th ";
                break;
            case"2086":
                year="March 29th to March 8th ";
                break;
            case"2089":
                year="March 25th to April 2rd ";
                break;


        }

        vary13=vary9+vary12+vary17+vary18;
        canvas.drawText("In addition, he may also sell all Chometz and/or mixtures containing Chometz that are ", leftMargin - 200, titleBaseLine + 190+vary13, paint);
        canvas.drawText("knowingly or unknowingly in my possession, or to which I have legal ownership or responsibility", leftMargin - 200, titleBaseLine + 200+vary13, paint);
        canvas.drawText("in whole or in part; or shares, stock, or business interests in corporations which own or deal in", leftMargin - 200, titleBaseLine + 210+vary13, paint);
        canvas.drawText("Chometz (including all transit goods which might be delivered to me during the period of ", leftMargin - 200, titleBaseLine + 220+vary13, paint);
        canvas.drawText(year+"inclusive)to a non-Jew of his choice.", leftMargin - 200, titleBaseLine + 230+vary13, paint);
        canvas.drawText("I also authorize "+rav+" or his designate, to rent or sell as he deems fit,", leftMargin - 200, titleBaseLine + 250+vary13, paint);
        canvas.drawText("and for the appropriate duration, the places where the above mentioned items are located. ", leftMargin - 200, titleBaseLine + 260+vary13, paint);
        String keyAdd = (mPrefs.getString("lookKey", ""));
        String combination=(mPrefs.getString("code",""));
        boolean stayPut=(mPrefs.getBoolean("checkHome_checked",false));
        if(stayPut){
            canvas.drawText("I will be home for Pesach.", leftMargin - 200, titleBaseLine + 270+vary13, paint);
        }
        if((!(keyAdd.equals(""))&&key.isChecked())){
            vary14=10;
            canvas.drawText("Keys/combination to these locations can be found at:", leftMargin - 200, titleBaseLine + 260+vary13+vary14, paint);
            canvas.drawText(keyAdd, leftMargin - 200, titleBaseLine + 270+vary13+vary14, paint);
        }
        vary15=vary13+vary14;
        if((!(combination.equals(""))&&(comb.isChecked()))){
            canvas.drawText("The combination to these locations is: "+combination, leftMargin - 200, titleBaseLine + 270+vary13, paint);
        }
        canvas.drawText("The buyer shall have, through the aid and cooperation of the Rabbi, free access to the Chometz", leftMargin - 200, titleBaseLine + 290+vary15, paint);
        canvas.drawText("and/or mixtures containing Chometz aquired by him.", leftMargin - 200, titleBaseLine + 300+vary15, paint);
        String money=(mPrefs.getString("total",""));
        canvas.drawText("The above-mentioned goods have an approximate value of $"+money, leftMargin - 200, titleBaseLine + 320+vary15, paint);
        canvas.drawText("Exact assessment of quantity and value of goods mentioned above, will take place after Pesach.", leftMargin - 200, titleBaseLine + 330+vary15, paint);
        canvas.drawText("The buyer's deposit is to be paid to "+rav+" or his designate. This", leftMargin - 200, titleBaseLine + 340+vary15, paint);
        canvas.drawText("authorization is made binding by my signature below which, when given with the bill of sale,", leftMargin - 200, titleBaseLine + 350+vary15, paint);
        canvas.drawText("shall be considered as if I had actually signed the bill of sale.", leftMargin - 200, titleBaseLine + 360+vary15, paint);
        canvas.drawText("The authorization is further legalized by what is known as Kinyan Suddar (Taking Hold of a ", leftMargin - 200, titleBaseLine + 370+vary15, paint);
        canvas.drawText("Garment)and is also intended to conform to the criteria of secular law by the use of any", leftMargin - 200, titleBaseLine +380+vary15, paint);
        canvas.drawText("appropriate legal instrument available to achieve this objective.", leftMargin - 200, titleBaseLine + 390+vary15, paint);
        boolean tzone=(mPrefs.getBoolean("checkZone_checked",false));


        if(tzone){
            canvas.drawText("I would like to do the earliest Mechira.", leftMargin - 200, titleBaseLine + 400+vary15, paint);
        }

        else if(excep||small){
            canvas.drawText("I would like an early Mechira - before the Bedika.", leftMargin - 200, titleBaseLine + 400+vary15, paint);
        }
        else{
            canvas.drawText("I would like a regular Mechira.", leftMargin - 200, titleBaseLine + 400+vary15, paint);
        }

        canvas.drawText("Signed by me on "+day+"  (Signature)____________________________________________________", leftMargin - 200, titleBaseLine + 420+vary15, paint);
        String nameFirst =(mPrefs.getString("name1",""));
        String nameLast = (mPrefs.getString("name2",""));
        String phoneS=(mPrefs.getString("phone",""));
        canvas.drawText("Name: "+nameFirst+" "+nameLast+"   Phone: "+phoneS, leftMargin - 200, titleBaseLine +430+vary15, paint);
        String homeAdd = (mPrefs.getString("address",""));
        String cityS=(mPrefs.getString("city",""));
        String stateS=(mPrefs.getString("state",""));
        canvas.drawText("Address: "+homeAdd+" "+cityS+", "+stateS, leftMargin - 200, titleBaseLine +440+vary15, paint);
        canvas.drawText("------------------------------------------------------------------------------------------------------------------------------------------------------------", leftMargin - 200, titleBaseLine + 450+vary15, paint);
        canvas.drawText("(FOR RABBI'S USE ONLY:) I, "+rav+" grant rights to Rabbi_____________________________", leftMargin - 200, titleBaseLine + 460+vary15, paint);
        canvas.drawText("to deal on my behalf to effect the sale of the above-mentioned goods and the rental or sale", leftMargin - 200, titleBaseLine + 470+vary15, paint);
        canvas.drawText("of the locations. ", leftMargin - 200, titleBaseLine +480+vary15, paint);
        canvas.drawText("Signed______________________________________________________________", leftMargin - 200, titleBaseLine + 490+vary15, paint);
        String addition="";

        String jim=(mPrefs.getString("longList", ""));
        boolean othchec=(mPrefs.getBoolean("other_checked",false));
        if(!(jim.equals(""))&&othchec){
         addition=addition+jim+" ";}
        String carS=(mPrefs.getString("carList", ""));
        String car="";
        boolean carchec=(mPrefs.getBoolean("car_checked",false));
        if(!(carS.equals(""))&&carchec){
         car="A vehicle at: "+carS+".   ";}
        String investS=(mPrefs.getString("investList", ""));
        String invest="";
        boolean investchec=(mPrefs.getBoolean("investment_checked",false));
        if(!(investS.equals(""))&&investchec){
        invest="Investment property at: "+investS+".   ";}
        String lockerS=(mPrefs.getString("lockerList", ""));
        String loc="";
        boolean lockchec=(mPrefs.getBoolean("locker_checked",false));
        if(!(lockerS.equals(""))&&lockchec){
        loc="Locker at:"+ lockerS+".   ";}
        String neighborS=(mPrefs.getString("neighborList", ""));
        String neighbor="";
        boolean neighchec=(mPrefs.getBoolean("neighbor_checked",false));
        if(!(neighborS.equals(""))&&neighchec){
        neighbor="Another home: "+neighborS+".   ";}
        String fridgeSS=(mPrefs.getString("coolerList", ""));
        String fridgeS="";
        boolean coolchec=(mPrefs.getBoolean("cooler_checked",false));
        if(!(fridgeSS.equals(""))&&coolchec){
        fridgeS="Refrigerator/freezer at: "+fridgeSS+".   ";}
        String officeS=(mPrefs.getString("officeList", ""));
        String office="";
        boolean officechec=(mPrefs.getBoolean("office_checked",false));
        if(!(officeS.equals(""))&&officechec){
        office="Office/business at: "+officeS+".  ";}
        String allOther="";
        allOther=addition+car+invest+loc+neighbor+fridgeS+office;

        allOne=allOther;
        numOne=allOther.length();
        if(numOne>93){
           allOne=allOne.substring(0,63);
           blankOne=allOne.lastIndexOf(" ");
            allOne=allOne.substring(0,blankOne);
            allTwo=allOther.substring(blankOne+1,allOther.length()-1);
            numTwo=allTwo.length();
    }
        if(numTwo>93){
            allTwo=allTwo.substring(0,93);
            blankTwo=allTwo.lastIndexOf(" ");
            allTwo=allTwo.substring(0,blankTwo);
            allThree=allOther.substring(blankOne+blankTwo+2,allOther.length()-1);
            numThree=allThree.length();
        }
        if(numThree>93){
            allThree=allThree.substring(0,93);
            blankThree=allThree.lastIndexOf(" ");
            allThree=allThree.substring(0,blankThree);
            allFour=allOther.substring(blankOne+blankTwo+blankThree+3,allOther.length()-1);
            numFour=allFour.length();
        }
        if(numFour>93){
            allFour=allFour.substring(0,93);
            blankFour=allFour.lastIndexOf(" ");
            allFour=allFour.substring(0,blankFour);
            allFive=allOther.substring(blankOne+blankTwo+blankThree+blankFour+4,allOther.length()-1);
        }

        if(!(allOther.equals(""))){
            canvas.drawText("-----------------------------------------------------------------------------------------------------------------------------------------------------------", leftMargin - 200, titleBaseLine + 500+vary15, paint);
            canvas.drawText("I would also like to include: "+allOne, leftMargin - 200, titleBaseLine +510+vary15, paint);
            canvas.drawText(allTwo, leftMargin - 200, titleBaseLine +520+vary15, paint);
            canvas.drawText(allThree, leftMargin - 200, titleBaseLine +530+vary15, paint);
            canvas.drawText(allFour, leftMargin - 200, titleBaseLine +540+vary15, paint);
            canvas.drawText(allFive, leftMargin - 200, titleBaseLine+550+vary15, paint);
        }
    }

    public void printDocument(View view) {
        test();
        if(viter) {
            saveSettings();
            insertStuff();

            PrintManager printManager = (PrintManager) this
                    .getSystemService(Context.PRINT_SERVICE);

            String jobName = this.getString(R.string.app_name) +
                    " Document";

            printManager.print(jobName, new MyPrintDocumentAdapter(this),
                    null);
        }
    }

    protected void sendEmail() {
        Log.i("Send email", "");

        String[] TO = {"wearetherosenbergs@gmail.com"};

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");


        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);

        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(Price.this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
    public void test(){
        if(amount.getText().toString().equals("")||key.isChecked()&&keyPlace.getText().toString().equals("")
                ||comb.isChecked()&&combin.getText().toString().equals("")||except.isChecked()&&not.getText().toString().equals("")
                ||mini.isChecked()&&minPlace.getText().toString().equals("")){
            Toast.makeText(this,
                    "Incomplete", Toast.LENGTH_SHORT).show();
            viter=false;
        }

       else if(!stayHome.isChecked()&&!key.isChecked()&&!comb.isChecked()){
            Toast.makeText(this,
                    "Missing location for keys/combination", Toast.LENGTH_SHORT).show();
            viter=false;
        }
        else if(!mini.isChecked()&&!except.isChecked()&&!checkAll.isChecked()){
            Toast.makeText(this,
                    "Choose type of bedika", Toast.LENGTH_SHORT).show();
            viter=false;
        }else{viter=true;}

    }
}



