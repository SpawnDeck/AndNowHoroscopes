package com.kevinschwenk.andnowhoroscopes;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    private String textKey = "com.kevinschwenk.andnowhoroscopes.text";
    private String signKey = "com.kevinschwenk.andnowhoroscopes.sign";
    private String starKey = "com.kevinschwenk.andnowhoroscopes.star";
    private String notifyKey = "com.kevinschwenk.andnowhoroscopes.notify";
    private String text;
    private String starSign;
    private int starItem = 0;


    /**
     * On creation of app instance, run this method
     * @param savedInstanceState Bundle passed in
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView horoscopeText = (TextView) findViewById(R.id.horoscope);

        SharedPreferences prefs = this.getSharedPreferences(textKey, Context.MODE_PRIVATE);
        this.getSharedPreferences(signKey, Context.MODE_PRIVATE);
        this.getSharedPreferences(starKey, Context.MODE_PRIVATE);
        this.getSharedPreferences(notifyKey, Context.MODE_PRIVATE);
        if(prefs.getString(textKey, null)==null) {
            prefs.edit().putString(textKey, new Horoscope(this).getText()).apply();
            text = prefs.getString(textKey, "create error 1");
        }
        else {
            text = prefs.getString(textKey, "create error 2");
        }

        horoscopeText.setText(text);
    }

    /**
     * On creation of options menu, run this method
     * @param menu Options menu
     * @return Boolean if successful
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * On creation of context menu, run this method
     * @param menu Context menu
     * @param v View to use
     * @param menuInfo Menu info
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.sign_menu, menu);
        MenuItem itemAries = menu.findItem(R.id.id_aries);
        MenuItem itemTaurus = menu.findItem(R.id.id_taurus);
        MenuItem itemGemini = menu.findItem(R.id.id_gemini);
        MenuItem itemCancer = menu.findItem(R.id.id_cancer);
        MenuItem itemLeo = menu.findItem(R.id.id_leo);
        MenuItem itemVirgo = menu.findItem(R.id.id_virgo);
        MenuItem itemLibra = menu.findItem(R.id.id_libra);
        MenuItem itemScorpio = menu.findItem(R.id.id_scorpio);
        MenuItem itemSagittarius = menu.findItem(R.id.id_sagittarius);
        MenuItem itemCapricorn = menu.findItem(R.id.id_capricorn);
        MenuItem itemAquarius = menu.findItem(R.id.id_aquarius);
        MenuItem itemPisces = menu.findItem(R.id.id_pisces);
        SharedPreferences star = getSharedPreferences(starKey, 0);
        starItem = star.getInt(starKey, 0);
        switch(starItem) {
            case 1:
                itemAries.setChecked(true);
                break;
            case 2:
                itemTaurus.setChecked(true);
                break;
            case 3:
                itemGemini.setChecked(true);
                break;
            case 4:
                itemCancer.setChecked(true);
                break;
            case 5:
                itemLeo.setChecked(true);
                break;
            case 6:
                itemVirgo.setChecked(true);
                break;
            case 7:
                itemLibra.setChecked(true);
                break;
            case 8:
                itemScorpio.setChecked(true);
                break;
            case 9:
                itemSagittarius.setChecked(true);
                break;
            case 10:
                itemCapricorn.setChecked(true);
                break;
            case 11:
                itemAquarius.setChecked(true);
                break;
            case 12:
                itemPisces.setChecked(true);
                break;
        }
    }

    /**
     * Execute on new item selected in options menu
     * @param item Item selected
     * @return If item was selected
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_share:
                shareHoroscope();
                return true;
            case R.id.change_sign:
                selectSign(findViewById(android.R.id.content));
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Execute on new item selected in context menu
     * @param item Item selected
     * @return If item was selected
     */
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        SharedPreferences sign = getSharedPreferences(signKey, 0);
        SharedPreferences star = getSharedPreferences(starKey, 0);
        switch(item.getItemId()) {
            case R.id.id_aries:
                starSign = "Aries";
                sign.edit().putString(signKey, starSign).apply();
                item.setChecked(true);
                starItem = 1;
                star.edit().putInt(starKey, starItem).apply();
                return true;
            case R.id.id_taurus:
                starSign = "Taurus";
                sign.edit().putString(signKey, starSign).apply();
                item.setChecked(true);
                starItem = 2;
                star.edit().putInt(starKey, starItem).apply();
                return true;
            case R.id.id_gemini:
                starSign = "Gemini";
                sign.edit().putString(signKey, starSign).apply();
                item.setChecked(true);
                starItem = 3;
                star.edit().putInt(starKey, starItem).apply();
                return true;
            case R.id.id_cancer:
                starSign = "Cancer";
                sign.edit().putString(signKey, starSign).apply();
                item.setChecked(true);
                starItem = 4;
                star.edit().putInt(starKey, starItem).apply();
                return true;
            case R.id.id_leo:
                starSign = "Leo";
                sign.edit().putString(signKey, starSign).apply();
                item.setChecked(true);
                starItem = 5;
                star.edit().putInt(starKey, starItem).apply();
                return true;
            case R.id.id_virgo:
                starSign = "Virgo";
                sign.edit().putString(signKey, starSign).apply();
                item.setChecked(true);
                starItem = 6;
                star.edit().putInt(starKey, starItem).apply();
                return true;
            case R.id.id_libra:
                starSign = "Libra";
                sign.edit().putString(signKey, starSign).apply();
                item.setChecked(true);
                starItem = 7;
                star.edit().putInt(starKey, starItem).apply();
                return true;
            case R.id.id_scorpio:
                starSign = "Scorpio";
                sign.edit().putString(signKey, starSign).apply();
                item.setChecked(true);
                starItem = 8;
                star.edit().putInt(starKey, starItem).apply();
                return true;
            case R.id.id_sagittarius:
                starSign = "Sagittarius";
                sign.edit().putString(signKey, starSign).apply();
                item.setChecked(true);
                starItem = 9;
                star.edit().putInt(starKey, starItem).apply();
                return true;
            case R.id.id_capricorn:
                starSign = "Capricorn";
                sign.edit().putString(signKey, starSign).apply();
                item.setChecked(true);
                starItem = 10;
                star.edit().putInt(starKey, starItem).apply();
                return true;
            case R.id.id_aquarius:
                starSign = "Aquarius";
                sign.edit().putString(signKey, starSign).apply();
                item.setChecked(true);
                starItem = 11;
                star.edit().putInt(starKey, starItem).apply();
                return true;
            case R.id.id_pisces:
                starSign = "Pisces";
                sign.edit().putString(signKey, starSign).apply();
                item.setChecked(true);
                starItem = 12;
                star.edit().putInt(starKey, starItem).apply();
                return true;
        }

        return super.onContextItemSelected(item);
    }

    /**
     * Selection of zodiac sign
     * @param view View passed in to allow for selection inside of app
     */
    public void selectSign(View view) {
        registerForContextMenu(view);
        openContextMenu(view);
    }

    /**
     * Share functionality, so that you can share your antics with friends
     */
    public void shareHoroscope(){
        SharedPreferences prefs = getSharedPreferences(textKey, 0);
        String text = prefs.getString(textKey, "share error");
        Intent mShareIntent = new Intent(Intent.ACTION_SEND);
        mShareIntent.setType("text/plain");
        mShareIntent.putExtra(Intent.EXTRA_TEXT, "My daily horoscope: " + text);
        startActivity(Intent.createChooser(mShareIntent,"Share using"));
    }

    /**
     * Update the displayed horoscope and return the new text
     * Functions as both an updater and a getter method for notifications
     * @return Updated text of horoscope
     */
    public String updateHoroscope() {

        final TextView horoscopeText = (TextView) findViewById(R.id.horoscope);

        text = new Horoscope(this).getText();

        SharedPreferences sign = getSharedPreferences(signKey, 0);
        if(sign.getString(signKey, null)!=null) {
            starSign = sign.getString(signKey, null);
            char c[] = text.toCharArray();
            c[0] = Character.toLowerCase(c[0]);
            text = new String(c);
            text = starSign + ", " + text;
        }

        SharedPreferences prefs = getSharedPreferences(textKey, 0);
        prefs.edit().putString(textKey, text).apply();

        horoscopeText.setText(text);

        return text;
    }

    /**
     * Command to create a new horoscope from the button in the app
     * If no notification has been set yet, schedule a repeating notification
     * If a notification already is scheduled, simply update the displayed horoscope
     * @param v View passed in, required to use this method in activity_main
     */
    public void pushHoroscope(View v) {
        SharedPreferences notify = getSharedPreferences(notifyKey, 0);
        if (notify.getBoolean(notifyKey, true)) {
            notify.edit().putBoolean(notifyKey, false).apply();

            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.set(Calendar.HOUR_OF_DAY, 9);

            AlarmReceiver alarmReceiver = null;
            alarmReceiver = new AlarmReceiver();
            alarmReceiver.setMainActivityHandler(this);
            registerReceiver(alarmReceiver, AlarmReceiver.INTENT_FILTER);

            Intent intentAlarm = new Intent("alarm");

            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, PendingIntent.getBroadcast(this, 1, intentAlarm, PendingIntent.FLAG_UPDATE_CURRENT));

            //Temporary tester to let the user know a repeating alarm has been set
            final TextView horoscopeText = (TextView) findViewById(R.id.horoscope);
            horoscopeText.setText("Hi there! By updating this horoscope, you've set up a repeating alarm! If you see this message, please tell Kevin. If you see it more than once, please tell Kevin again. Press the button again to remove this message (hopefully) permanently!");
        }
        else {
            updateHoroscope();
        }

    }
}

