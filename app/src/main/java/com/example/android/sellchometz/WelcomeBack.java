package com.example.android.sellchometz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.sellchometz.data.AllInfoContract;
import com.example.android.sellchometz.data.AllInfoContract.AllEntry;

public class WelcomeBack extends AppCompatActivity {

    private SharedPreferences mPrefs;
    private SharedPreferences.Editor mPrefEditor;

    TextView password;
    ImageButton fab;
    String pass;
   String next;
    String firstN;
    String lastN;
    String address;
    String city;
    String state;
    String phone;

    String atticS;
    int bob;
    int baseS;
    int bathS;
    int breakS;
    int briefS;
    int closetS;
    int crawlS;
    int drawerS;
    int freezerS;
    int garageS;
    int grillS;
    int kitCabS;
    int liquorS;
    int medS;
    int pantryS;
    int fridgeS;
    int shedS;
    int storageS;
    String otherS;
    int carBB;
    int investBB;
    int lockerBB;
    int officeBB;
    int neighborBB;
    int freezerBB;
    int otherBB;
    int zoneBB;
    int bakingingI;
    int bakingProI;
    int barley;
    int beer;
    int cereal;
    int condiments;
    int cosmetics;
    int crackers;
    int frozen;
    int grocery;
    int liqu;
    int meds;
    int mix;
    int noodle;
    int oats;
    int perfume;
    int pets;
    int pickle;
    int playd;
    int toilet;
    int vitamin;
    int wheatg;
    int utens;
    int apply;
    int baket;
    int toy;
    int book;
    int sefer;
    int et;
    String also;
    String valu;
    int home;
    int key;
    int combo;
    int full;
    int exclu;
    int just;
    String keyS;
    String comboS;
    String excluS;
    String justS;

    String carST;
    String investST;
    String lockerST;
    String neighborST;
    String officeST;
    String freezerST;
    String otherST;
    String ending;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_back);

        mPrefs= PreferenceManager.getDefaultSharedPreferences(this);
        mPrefEditor=mPrefs.edit();


         password=(TextView)findViewById(R.id.with);
        pass=password.getText().toString().trim();





        fab=(ImageButton)findViewById(R.id.fab0);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
              displayDatabaseInfo();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    loadSet();}


    private void displayDatabaseInfo() {

       String[]projection={
                AllInfoContract.AllEntry.FIRST_NAME,
                AllInfoContract.AllEntry.LAST_NAME,
                AllInfoContract.AllEntry.ADDRESS,
                AllInfoContract.AllEntry.PASSWORD,
                AllEntry.CITY,
                AllEntry.STATE,
                AllEntry.PHONE,
                AllEntry.ATTIC,
                AllEntry.BASEMENT,
                AllEntry.BATHCAB,
                AllEntry.BREAKFRONT,
                AllEntry.BRIEFCASE,
                AllEntry.CLOSET,
               AllEntry.CRAWL,
               AllEntry.DRAWER,
               AllEntry.FREEZER,
               AllEntry.GARAGE,
               AllEntry.GRILL,
               AllEntry.KITCAB,
               AllEntry.LIQUORCAB,
               AllEntry.MEDCHEST,
               AllEntry.PANTRY,
               AllEntry.FRIDGE,
               AllEntry.SHED,
               AllEntry.STORAGE,
               AllEntry.OTHERPLACE,
               AllEntry.CARBOX,
               AllEntry.CAR,
               AllEntry.INVESTBOX,
               AllEntry.INVEST,
               AllEntry.LOCKERBOX,
               AllEntry.LOCKER,
               AllEntry.NEIGHBORBOX,
               AllEntry.NEIGHBOR,
               AllEntry.OFFICEBOX,
               AllEntry.OFFICE,
               AllEntry.FREEZEBOX,
               AllEntry.FREEZE,
               AllEntry.OTHERBOX,
               AllEntry.OTTER,
               AllEntry.ZONEBOX,
               AllEntry.BAKINGING,
               AllEntry.BAKINGPRO,
               AllEntry.BARLEY,
               AllEntry.BEER,
               AllEntry.CEREAL,
               AllEntry.CONDIMENTS,
               AllEntry.COSMETICS,
               AllEntry.CRACKERS,
               AllEntry.FROZEN,
               AllEntry.GROCERIES,
               AllEntry.LIQUOR,
               AllEntry.MEDICINE,
               AllEntry.MIXES,
               AllEntry.NOODLE,
               AllEntry.OATMEAL,
               AllEntry.PERFUME,
               AllEntry.PET,
               AllEntry.PICKLES,
               AllEntry.PLAYDOUGH,
               AllEntry.TOILETRIES,
               AllEntry.VITAMINS,
               AllEntry.WHEAT,
               AllEntry.UTENSILS,
               AllEntry.APPLIANCE,
               AllEntry.BAKINGT,
               AllEntry.TOYS,
               AllEntry.BOOKS,
               AllEntry.SEFORIM,
               AllEntry.ETC,
               AllEntry.OTHERPLACE,
               AllEntry.VALUE,
               AllEntry.STAY,
               AllEntry.KEY,
               AllEntry.KEYB,
               AllEntry.COMBB,
               AllEntry.COMB,
               AllEntry.FULLBED,
               AllEntry.EXCLUDEB,
               AllEntry.EXCLUDE,
               AllEntry.ONLYB,
               AllEntry.ONLY



        };
        Cursor cursor = getContentResolver().query(AllInfoContract.AllEntry.CONTENT_URI,null,null,null,null);


       pass=password.getText().toString().trim();
        if(!(pass.contains(".com"))){
            pass=pass+(".com");
        }

        int passColumnIndex = cursor.getColumnIndex(AllInfoContract.AllEntry.PASSWORD);
        int nameColumnIndex=cursor.getColumnIndex(AllInfoContract.AllEntry.FIRST_NAME);
        int nameLColumnIndex = cursor.getColumnIndex(AllInfoContract.AllEntry.LAST_NAME);
        int addressColumnIndex=cursor.getColumnIndex(AllInfoContract.AllEntry.ADDRESS);
        int cityColumnIndex = cursor.getColumnIndex(AllInfoContract.AllEntry.CITY);
        int stateColumnIndex=cursor.getColumnIndex(AllInfoContract.AllEntry.STATE);
        int phoneColumnIndex = cursor.getColumnIndex(AllInfoContract.AllEntry.PHONE);

        int atticColumnIndex=cursor.getColumnIndex(AllInfoContract.AllEntry.ATTIC);
        int baseIndex=cursor.getColumnIndex(AllEntry.BASEMENT);
        int bathIndex=cursor.getColumnIndex(AllEntry.BATHCAB);
        int breakIndex=cursor.getColumnIndex(AllEntry.BREAKFRONT);
        int briefIndex=cursor.getColumnIndex(AllEntry.BRIEFCASE);
        int closetIndex=cursor.getColumnIndex(AllEntry.CLOSET);
        int crawlIndex=cursor.getColumnIndex(AllEntry.CRAWL);
        int drawerIndex=cursor.getColumnIndex(AllEntry.DRAWER);
        int freezerIndex=cursor.getColumnIndex(AllEntry.FREEZER);
        int garageIndex=cursor.getColumnIndex(AllEntry.GARAGE);
        int grillIndex=cursor.getColumnIndex(AllEntry.GRILL);
        int kitCabIndex=cursor.getColumnIndex(AllEntry.KITCAB);
        int liquorIndex=cursor.getColumnIndex(AllEntry.LIQUORCAB);
        int medIndex=cursor.getColumnIndex(AllEntry.MEDCHEST);
        int pantryIndex=cursor.getColumnIndex(AllEntry.PANTRY);
        int fridgeIndex=cursor.getColumnIndex(AllEntry.FRIDGE);
        int shedIndex=cursor.getColumnIndex(AllEntry.SHED);
        int storageIndex=cursor.getColumnIndex(AllEntry.STORAGE);
        int otherIndex=cursor.getColumnIndex(AllEntry.OTHERPLACE);
        int carBXIndex=cursor.getColumnIndex(AllEntry.CARBOX);
        int investBXIndex=cursor.getColumnIndex(AllEntry.INVESTBOX);
        int lockerBXIndex=cursor.getColumnIndex(AllEntry.LOCKERBOX);
        int neighborBXIndex=cursor.getColumnIndex(AllEntry.NEIGHBORBOX);
        int officeBXIndex=cursor.getColumnIndex(AllEntry.OFFICEBOX);
        int freezeBXIndex=cursor.getColumnIndex(AllEntry.FREEZEBOX);
        int otherBXIndex=cursor.getColumnIndex(AllEntry.OTHERBOX);
        int zoneBXIndex=cursor.getColumnIndex(AllEntry.ZONEBOX);
        int carIndex=cursor.getColumnIndex(AllEntry.CAR);
        int investIndex=cursor.getColumnIndex(AllEntry.INVEST);
        int lockerIndex=cursor.getColumnIndex(AllEntry.LOCKER);
        int neighborIndex=cursor.getColumnIndex(AllEntry.NEIGHBOR);
        int officeIndex=cursor.getColumnIndex(AllEntry.OFFICE);
        int freezeIndex=cursor.getColumnIndex(AllEntry.FREEZE);
        int otterIndex=cursor.getColumnIndex(AllEntry.OTTER);
        int bakingingIndex=cursor.getColumnIndex(AllEntry.BAKINGING);
        int bakingproIndex=cursor.getColumnIndex(AllEntry.BAKINGPRO);
        int barleyIndex=cursor.getColumnIndex(AllEntry.BARLEY);
        int beerIndex=cursor.getColumnIndex(AllEntry.BEER);
        int cerealIndex=cursor.getColumnIndex(AllEntry.CEREAL);
        int condIndex=cursor.getColumnIndex(AllEntry.CONDIMENTS);
        int cosmeticIndex=cursor.getColumnIndex(AllEntry.COSMETICS);
        int crackerIndex=cursor.getColumnIndex(AllEntry.CRACKERS);
        int frozenIndex=cursor.getColumnIndex(AllEntry.FROZEN);
        int groceryIndex=cursor.getColumnIndex(AllEntry.GROCERIES);
        int liquorPIndex=cursor.getColumnIndex(AllEntry.LIQUOR);
        int medicineIndex=cursor.getColumnIndex(AllEntry.MEDICINE);
        int mixesIndex=cursor.getColumnIndex(AllEntry.MIXES);
        int noodleIndex=cursor.getColumnIndex(AllEntry.NOODLE);
        int oatmealIndex=cursor.getColumnIndex(AllEntry.OATMEAL);
        int perfumeIndex=cursor.getColumnIndex(AllEntry.PERFUME);
        int petIndex=cursor.getColumnIndex(AllEntry.PET);
        int pickleIndex=cursor.getColumnIndex(AllEntry.PICKLES);
        int playdoughIndex=cursor.getColumnIndex(AllEntry.PLAYDOUGH);
        int toileteriesIndex=cursor.getColumnIndex(AllEntry.TOILETRIES);
        int vitaminIndex=cursor.getColumnIndex(AllEntry.VITAMINS);
        int wheatIndex=cursor.getColumnIndex(AllEntry.WHEAT);
        int utensilIndex=cursor.getColumnIndex(AllEntry.UTENSILS);
        int applianceIndex=cursor.getColumnIndex(AllEntry.APPLIANCE);
        int bakingTIndex=cursor.getColumnIndex(AllEntry.BAKINGT);
        int toyIndex=cursor.getColumnIndex(AllEntry.TOYS);
        int bookIndex=cursor.getColumnIndex(AllEntry.BOOKS);
        int seforimIndex=cursor.getColumnIndex(AllEntry.SEFORIM);
        int etcIndex=cursor.getColumnIndex(AllEntry.ETC);
        int alsoIndex=cursor.getColumnIndex(AllEntry.ALSOINC);
        int valueIndex=cursor.getColumnIndex(AllEntry.VALUE);
        int stayIndex=cursor.getColumnIndex(AllEntry.STAY);
        int keybIndex=cursor.getColumnIndex(AllEntry.KEYB);
        int keyIndex=cursor.getColumnIndex(AllEntry.KEY);
        int combBIndex=cursor.getColumnIndex(AllEntry.COMBB);
        int combIndex=cursor.getColumnIndex(AllEntry.COMB);
        int fullIndex=cursor.getColumnIndex(AllEntry.FULLBED);
        int excludeBIndex=cursor.getColumnIndex(AllEntry.EXCLUDEB);
        int excludeIndex=cursor.getColumnIndex(AllEntry.EXCLUDE);
        int onlyBIndex=cursor.getColumnIndex(AllEntry.ONLYB);
        int onlyIndex=cursor.getColumnIndex(AllEntry.ONLY);






        try {
            while (cursor.moveToNext()) {


              next = cursor.getString(passColumnIndex);
                firstN = cursor.getString(nameColumnIndex);
                lastN=cursor.getString(nameLColumnIndex);
                address=cursor.getString(addressColumnIndex);
                city = cursor.getString(cityColumnIndex);
                state = cursor.getString(stateColumnIndex);
                phone=cursor.getString(phoneColumnIndex);

                atticS=cursor.getString(atticColumnIndex);
                baseS=cursor.getInt(baseIndex);
                breakS=cursor.getInt(breakIndex);
                bathS=cursor.getInt(bathIndex);
                briefS=cursor.getInt(briefIndex);
                closetS=cursor.getInt(closetIndex);
                crawlS=cursor.getInt(crawlIndex);
                drawerS=cursor.getInt(drawerIndex);
                freezerS=cursor.getInt(freezerIndex);
                garageS=cursor.getInt(garageIndex);
                grillS=cursor.getInt(grillIndex);
                kitCabS=cursor.getInt(kitCabIndex);
                liquorS=cursor.getInt(liquorIndex);
                medS=cursor.getInt(medIndex);
                pantryS=cursor.getInt(pantryIndex);
                fridgeS=cursor.getInt(fridgeIndex);
                shedS=cursor.getInt(shedIndex);
                storageS=cursor.getInt(storageIndex);
                otherS=cursor.getString(otherIndex);
                carBB=cursor.getInt(carBXIndex);
                officeBB=cursor.getInt(officeBXIndex);
                investBB=cursor.getInt(investBXIndex);
                lockerBB=cursor.getInt(lockerBXIndex);
                neighborBB=cursor.getInt(neighborBXIndex);
                freezerBB=cursor.getInt(freezeBXIndex);
                otherBB=cursor.getInt(otherBXIndex);
                zoneBB=cursor.getInt(zoneBXIndex);
                carST = cursor.getString(carIndex);
                investST = cursor.getString(investIndex);
                neighborST=cursor.getString(neighborIndex);
                lockerST=cursor.getString(lockerIndex);
                officeST = cursor.getString(officeIndex);
                freezerST = cursor.getString(freezeIndex);
                otherST=cursor.getString(otterIndex);
                bakingingI=cursor.getInt(bakingingIndex);
                bakingProI=cursor.getInt(bakingproIndex);
                barley=cursor.getInt(barleyIndex);
                beer=cursor.getInt(beerIndex);
                cereal=cursor.getInt(cerealIndex);
                condiments=cursor.getInt(condIndex);
                cosmetics=cursor.getInt(cosmeticIndex);
                crackers=cursor.getInt(crackerIndex);
                frozen=cursor.getInt(frozenIndex);
                grocery=cursor.getInt(groceryIndex);
                liqu=cursor.getInt(liquorPIndex);
                meds=cursor.getInt(medicineIndex);
                mix=cursor.getInt(mixesIndex);
                noodle=cursor.getInt(noodleIndex);
                oats=cursor.getInt(oatmealIndex);
                perfume=cursor.getInt(perfumeIndex);
                pets=cursor.getInt(petIndex);
                pickle=cursor.getInt(pickleIndex);
                playd=cursor.getInt(playdoughIndex);
                toilet=cursor.getInt(toileteriesIndex);
                vitamin=cursor.getInt(vitaminIndex);
                wheatg=cursor.getInt(wheatIndex);
                utens=cursor.getInt(utensilIndex);
                apply=cursor.getInt(applianceIndex);
                baket=cursor.getInt(bakingTIndex);
                toy=cursor.getInt(toyIndex);
                book=cursor.getInt(bookIndex);
                sefer=cursor.getInt(seforimIndex);
                et=cursor.getInt(etcIndex);
                also=cursor.getString(alsoIndex);
                valu=cursor.getString(valueIndex);
                home=cursor.getInt(stayIndex);
                key=cursor.getInt(keybIndex);
                combo=cursor.getInt(combBIndex);
                full=cursor.getInt(fullIndex);
                exclu=cursor.getInt(excludeBIndex);
                just=cursor.getInt(onlyBIndex);
                keyS=cursor.getString(keyIndex);
                comboS=cursor.getString(combIndex);
                excluS=cursor.getString(excludeIndex);
                justS=cursor.getString(onlyIndex);


                if(next.equals(pass)){

                    Toast.makeText(this, "Welcome Back " + firstN,
                            Toast.LENGTH_SHORT).show();

                    saveSet();
                    bob=1;

                    Intent startIntent = new Intent(WelcomeBack.this, Login.class);
                    startActivity(startIntent);

                }

            }if(!(bob==1)){Toast.makeText(this, "No Match" ,
                    Toast.LENGTH_SHORT).show();}
        }
        finally {
            cursor.close();

        }
    }
private void saveSet(){
    mPrefEditor.putString("email",pass);
    mPrefEditor.putString("address",address);
    mPrefEditor.putString("name1",firstN);
    mPrefEditor.putString("name2",lastN);
    mPrefEditor.putString("city",city);
    mPrefEditor.putString("state",state);
    mPrefEditor.putString("phone",phone);

    mPrefEditor.putString("other",otherS);
    mPrefEditor.putString("carList",carST);
    mPrefEditor.putString("investList",investST);
    mPrefEditor.putString("lockerList",lockerST);
    mPrefEditor.putString("neighborList",neighborST);
    mPrefEditor.putString("coolerList",freezerST);
    mPrefEditor.putString("officeList",officeST);
    mPrefEditor.putString("longList",otherST);
    mPrefEditor.putString("info",also);
    mPrefEditor.putString("total",valu);
    mPrefEditor.putString("lookKey",keyS);
    mPrefEditor.putString("code",comboS);
    mPrefEditor.putString("least",justS);
    mPrefEditor.putString("lazy",excluS);
    if(exclu==1){
        mPrefEditor.putBoolean("checkEx_checked",true);
    }else{
        mPrefEditor.putBoolean("checkEx_checked",false);
    }
    if(just==1){
        mPrefEditor.putBoolean("checkMin_checked",true);
    }else{
        mPrefEditor.putBoolean("checkMin_checked",false);
    }
    if(combo==1){
        mPrefEditor.putBoolean("comb_checked",true);
    }else{
        mPrefEditor.putBoolean("comb_checked",false);
    }
    if(full==1){
        mPrefEditor.putBoolean("checkAll_checked",true);
    }else{
        mPrefEditor.putBoolean("checkAll_checked",false);
    }
    if(home==1){
        mPrefEditor.putBoolean("checkHome_checked",true);
    }else{
        mPrefEditor.putBoolean("checkHome_checked",false);
    }
    if(key==1){
        mPrefEditor.putBoolean("checkKey_checked",true);
    }else{
        mPrefEditor.putBoolean("checkKey_checked",false);
    }
    if(sefer==1){
        mPrefEditor.putBoolean("checkSeforim_checked",true);
    }else{
        mPrefEditor.putBoolean("checkSeforim_checked",false);
    }
    if(et==1){
        mPrefEditor.putBoolean("checkEtc_checked",true);
    }else{
        mPrefEditor.putBoolean("checkEtc_checked",false);
    }
    if(toy==1){
        mPrefEditor.putBoolean("checkToy_checked",true);
    }else{
        mPrefEditor.putBoolean("checkToy_checked",false);
    }
    if(book==1){
        mPrefEditor.putBoolean("checkBook_checked",true);
    }else{
        mPrefEditor.putBoolean("checkBook_checked",false);
    }
    if(apply==1){
        mPrefEditor.putBoolean("checkAppliance_checked",true);
    }else{
        mPrefEditor.putBoolean("checkAppliance_checked",false);
    }
    if(baket==1){
        mPrefEditor.putBoolean("checkBaking_checked",true);
    }else{
        mPrefEditor.putBoolean("checkBaking_checked",false);
    }
    if(wheatg==1){
        mPrefEditor.putBoolean("checkWheat_checked",true);
    }else{
        mPrefEditor.putBoolean("checkWheat_checked",false);
    }
    if(utens==1){
        mPrefEditor.putBoolean("checkUtensil_checked",true);
    }else{
        mPrefEditor.putBoolean("checkUtensil_checked",false);
    }
    if(toilet==1){
        mPrefEditor.putBoolean("checkToil_checked",true);
    }else{
        mPrefEditor.putBoolean("checkToil_checked",false);
    }
    if(vitamin==1){
        mPrefEditor.putBoolean("checkVita_checked",true);
    }else{
        mPrefEditor.putBoolean("checkVita_checked",false);
    }
    if(pickle==1){
        mPrefEditor.putBoolean("checkPickle_checked",true);
    }else{
        mPrefEditor.putBoolean("checkPickle_checked",false);
    }
    if(playd==1){
        mPrefEditor.putBoolean("checkPlay_checked",true);
    }else{
        mPrefEditor.putBoolean("checkPlay_checked",false);
    }
    if(perfume==1){
        mPrefEditor.putBoolean("checkPerfume_checked",true);
    }else{
        mPrefEditor.putBoolean("checkPerfume_checked",false);
    }
    if(pets==1){
        mPrefEditor.putBoolean("checkPet_checked",true);
    }else{
        mPrefEditor.putBoolean("checkPet_checked",false);
    }
    if(noodle==1){
        mPrefEditor.putBoolean("checkNoodle_checked",true);
    }else{
        mPrefEditor.putBoolean("checkNoodle_checked",false);
    }
    if(oats==1){
        mPrefEditor.putBoolean("checkOat_checked",true);
    }else{
        mPrefEditor.putBoolean("checkOat_checked",false);
    }
    if(meds==1){
        mPrefEditor.putBoolean("checkMed_checked",true);
    }else{
        mPrefEditor.putBoolean("checkMed_checked",false);
    }
    if(mix==1){
        mPrefEditor.putBoolean("checkMix_checked",true);
    }else{
        mPrefEditor.putBoolean("checkMix_checked",false);
    }
    if(grocery==1){
        mPrefEditor.putBoolean("checkGroc_checked",true);
    }else{
        mPrefEditor.putBoolean("checkGroc_checked",false);
    }
    if(liqu==1){
        mPrefEditor.putBoolean("checkLiq_checked",true);
    }else{
        mPrefEditor.putBoolean("checkLiq_checked",false);
    }
    if(crackers==1){
        mPrefEditor.putBoolean("checkCracker_checked",true);
    }else{
        mPrefEditor.putBoolean("checkCracker_checked",false);
    }
    if(frozen==1){
        mPrefEditor.putBoolean("checkFroz_checked",true);
    }else{
        mPrefEditor.putBoolean("checkFroz_checked",false);
    }
    if(condiments==1){
        mPrefEditor.putBoolean("checkCond_checked",true);
    }else{
        mPrefEditor.putBoolean("checkCond_checked",false);
    }
    if(cosmetics==1){
        mPrefEditor.putBoolean("checkCos_checked",true);
    }else{
        mPrefEditor.putBoolean("checkCos_checked",false);
    }
    if(beer==1){
        mPrefEditor.putBoolean("checkBeer_checked",true);
    }else{
        mPrefEditor.putBoolean("checkBeer_checked",false);
    }
    if(cereal==1){
        mPrefEditor.putBoolean("checkCerea_checked",true);
    }else{
        mPrefEditor.putBoolean("checkCerea_checked",false);
    }
    if(barley==1){
        mPrefEditor.putBoolean("checkBarl_checked",true);
    }else{
        mPrefEditor.putBoolean("checkBarl_checked",false);
    }
    if(bakingProI==1){
        mPrefEditor.putBoolean("checkBake_checked",true);
    }else{
        mPrefEditor.putBoolean("checkBake_checked",false);
    }
    if(carBB==1){
        mPrefEditor.putBoolean("car_checked",true);
    }else{
        mPrefEditor.putBoolean("car_checked",false);
    }
    if(investBB==1){
        mPrefEditor.putBoolean("investment_checked",true);
    }else{
        mPrefEditor.putBoolean("investment_checked",false);
    }
    if(lockerBB==1){
        mPrefEditor.putBoolean("locker_checked",true);
    }else{
        mPrefEditor.putBoolean("locker_checked",false);
    }
    if(neighborBB==1){
        mPrefEditor.putBoolean("neighbor_checked",true);
    }else{
        mPrefEditor.putBoolean("neighbor_checked",false);
    }
    if(officeBB==1){
        mPrefEditor.putBoolean("office_checked",true);
    }else{
        mPrefEditor.putBoolean("office_checked",false);
    }
    if(freezerBB==1){
        mPrefEditor.putBoolean("cooler_checked",true);
    }else{
        mPrefEditor.putBoolean("cooler_checked",false);
    }
    if(otherBB==1){
        mPrefEditor.putBoolean("other_checked",true);
    }else{
        mPrefEditor.putBoolean("other_checked",false);
    }
    if(zoneBB==1){
        mPrefEditor.putBoolean("checkZone_checked",true);
    }else{
        mPrefEditor.putBoolean("checkZone_checked",false);
    }
   if(atticS.equals("yes")){
       mPrefEditor.putBoolean("att_checked",true);
   }else{
       mPrefEditor.putBoolean("att_checked",false);
   }
    if(baseS==1){
        mPrefEditor.putBoolean("base_checked",true);
    }else{
        mPrefEditor.putBoolean("base_checked",false);
    }
    if(breakS==1){
        mPrefEditor.putBoolean("break_checked",true);
    }else{
        mPrefEditor.putBoolean("break_checked",false);
    }
    if(bathS==1){
        mPrefEditor.putBoolean("bath_checked",true);
    }else{
        mPrefEditor.putBoolean("bath_checked",false);
    }
    if(briefS==1){
        mPrefEditor.putBoolean("brief_checked",true);
    }else{
        mPrefEditor.putBoolean("brief_checked",false);
    }
    if(closetS==1){
        mPrefEditor.putBoolean("closet_checked",true);
    }else{
        mPrefEditor.putBoolean("closet_checked",false);
    }
    if(crawlS==1){
        mPrefEditor.putBoolean("crawl_checked",true);
    }else{
        mPrefEditor.putBoolean("crawl_checked",false);
    }
    if(drawerS==1){
        mPrefEditor.putBoolean("drawer_checked",true);
    }else{
        mPrefEditor.putBoolean("drawer_checked",false);
    }
    if(freezerS==1){
        mPrefEditor.putBoolean("freezer_checked",true);
    }else{
        mPrefEditor.putBoolean("freezer_checked",false);
    }
    if(garageS==1){
        mPrefEditor.putBoolean("garage_checked",true);
    }else{
        mPrefEditor.putBoolean("garage_checked",false);
    }
    if(grillS==1){
        mPrefEditor.putBoolean("grill_checked",true);
    }else{
        mPrefEditor.putBoolean("grill_checked",false);
    }
    if(kitCabS==1){
        mPrefEditor.putBoolean("kitCab_checked",true);
    }else{
        mPrefEditor.putBoolean("kitCab_checked",false);
    }
    if(liquorS==1){
        mPrefEditor.putBoolean("liquor_checked",true);
    }else{
        mPrefEditor.putBoolean("liquor_checked",false);
    }
    if(medS==1){
        mPrefEditor.putBoolean("medChest_checked",true);
    }else{
        mPrefEditor.putBoolean("medChest_checked",false);
    }
    if(pantryS==1){
        mPrefEditor.putBoolean("pantry_checked",true);
    }else{
        mPrefEditor.putBoolean("pantry_checked",false);
    }
    if(fridgeS==1){
        mPrefEditor.putBoolean("fridge_checked",true);
    }else{
        mPrefEditor.putBoolean("fridge_checked",false);
    }
    if(shedS==1){
        mPrefEditor.putBoolean("shed_checked",true);
    }else{
        mPrefEditor.putBoolean("shed_checked",false);
    }
    if(storageS==1){
        mPrefEditor.putBoolean("storage_checked",true);
    }else{
        mPrefEditor.putBoolean("storage_checked",false);
    }




    mPrefEditor.apply();
}
    private void loadSet() {
        password.setText( mPrefs.getString("pasword", ""));}
}
