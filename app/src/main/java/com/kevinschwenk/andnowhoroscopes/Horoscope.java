package com.kevinschwenk.andnowhoroscopes;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


/**
 * Created by Kevin on 1/25/2017.
 */

public class Horoscope {

    private String text;
    private Context myContext;

    /**
     * Horoscope constructor
     * On creation, chooses a random horoscope to generate a new text message
     * @param context Context passed in from MainActivity
     */
    public Horoscope(Context context){
        super();
        myContext = context;
        int num = (int)(Math.random()*11)+1;
        switch(num) {
            case 1: horoscope1();
                break;
            case 2: horoscope2();
                break;
            case 3: horoscope3();
                break;
            case 4: horoscope4();
                break;
            case 5: horoscope5();
                break;
            case 6: horoscope6();
                break;
            case 7: horoscope7();
                break;
            case 8: horoscope8();
                break;
            case 9: horoscope9();
                break;
            case 10: horoscope10();
                break;
            case 11: horoscope11();
                break;
        }
    }

    /**
     * Getter method for text
     * Returns text without updating horoscope message
     * @return Text
     */
    public String getText() {
        return text;
    }

    /**
     * Reads file from assets folder
     * @param filePath File location, must be a txt file
     * @return ArrayList of strings used in parsing sentences. Each element is randomly selected from a line
     * @throws IOException
     */
    private ArrayList<String> getHoroscopeFile(String filePath) throws IOException{
        ArrayList<String[]> lst = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(myContext.getAssets().open(filePath)));

            String mLine;
            while ((mLine = reader.readLine()) != null) {
                lst.add(mLine.split("\\|"));
            }

            for (String[] set:lst) {
                int num = (int)(Math.random()*set.length);
                words.add(set[num]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return words;
    }

    /**
     * The following functions are individual creation methods to generate horoscopes.
     * More will be updated
     * I might find a better way to do this in the future
     */
    private void horoscope1() {
        text = "";
        try {
            ArrayList<String> words = getHoroscopeFile("horoscope1.txt");
            text = "You " + words.get(0) + " " + words.get(1) + ", but " + words.get(2) + " you are " + words.get(3) + ".";
        } catch (IOException e) {
            text = "error 1";
        }
    }
    private void horoscope2() {
        text = "";
        try {
            ArrayList<String> words = getHoroscopeFile("horoscope2.txt");
            text = "You should " + words.get(0) + " " + words.get(1) + " " + words.get(2) +  ".";
        } catch (IOException e) {
            text = "error 2";
        }
    }
    private void horoscope3() {
        text = "";
        try {
            ArrayList<String> words = getHoroscopeFile("horoscope3.txt");
            text = "There are " + words.get(0) + ". So many " + words.get(0) + ".";
        } catch (IOException e) {
            text = "error 3";
        }
    }
    private void horoscope4() {
        text = "";
        try {
            ArrayList<String> words = getHoroscopeFile("horoscope4.txt");
            text = words.get(0) + ", " + words.get(1) + " " + words.get(2) + ".";
        } catch (IOException e) {
            text = "error 4";
        }
    }
    private void horoscope5() {
        text = "";
        try {
            ArrayList<String> words = getHoroscopeFile("horoscope5.txt");
            text = "Your day will be filled with " + words.get(0) + ", " + words.get(1) + ", and " + words.get(2) +  ".";
        } catch (IOException e) {
            text = "error 5";
        }
    }
    private void horoscope6() {
        text = "";
        try {
            ArrayList<String> words = getHoroscopeFile("horoscope6.txt");
            text = words.get(0) + " " + words.get(1) + " " + words.get(2) + " " + words.get(3) + ".";
        } catch (IOException e) {
            text = "error 6";
        }
    }
    private void horoscope7() {
        text = "";
        try {
            ArrayList<String> words = getHoroscopeFile("horoscope7.txt");
            text = "Your day looks " + words.get(0) + " " + words.get(1) + ". " + words.get(2) + " " + words.get(3) + " " + words.get(4) + " today.";
        } catch (IOException e) {
            text = "error 7";
        }
    }
    private void horoscope8() {
        text = "";
        try {
            ArrayList<String> words = getHoroscopeFile("horoscope8.txt");
            text = "Today, you will " + words.get(0) + " " + words.get(1) + ". After this happens, " + words.get(2) + ".";
        } catch (IOException e) {
            text = "error 8";
        }
    }
    private void horoscope9() {
        text = "";
        try {
            ArrayList<String> words = getHoroscopeFile("horoscope9.txt");
            text = words.get(0) + " " + words.get(1) + ", " + words.get(2) + ". " + words.get(3) + " " + words.get(4) + ".";
        } catch (IOException e) {
            text = "error 9";
        }
    }
    private void horoscope10() {
        text = "";
        try {
            ArrayList<String> words = getHoroscopeFile("horoscope10.txt");
            text = words.get(0) + " " + words.get(1) + " season " + (int)(Math.random()*50+50) + "? " + words.get(2) + ".";
        } catch (IOException e) {
            text = "error 10";
        }
    }
    private void horoscope11() {
        text = "";
        try {
            ArrayList<String> words = getHoroscopeFile("horoscope11.txt");
            text = words.get(0) + " " + (int)(Math.random()*50+50) + " " + words.get(1)+ " " + words.get(2)+ " " + words.get(3) + ".";
        } catch (IOException e) {
            text = "error 11";
        }
    }
}
