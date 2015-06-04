package com.dreammist.dota2heropicker;

import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.database.sqlite.*;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase heroesDB = openOrCreateDatabase("HeroesDB",MODE_PRIVATE,null);
        heroesDB.execSQL("CREATE TABLE IF NOT EXISTS HeroesTable(hero_name TEXT, class TEXT, role TEXT, attack_type TEXT, has_stun INTEGER, has_disable INTEGER);");

        //                                          hero_name           class   role       attack_type has_stun    has_disable
        heroesDB.execSQL("INSERT INTO HeroesTable VALUES('Bloodseeker',      'agi', 'ganker',   'melee',    0,          1);");
        heroesDB.execSQL("INSERT INTO HeroesTable VALUES('Crystal Maiden',   'int', 'support',  'ranged',   0,          1);");
        heroesDB.execSQL("INSERT INTO HeroesTable VALUES('Skywrath Mage',    'int', 'support',  'ranged',   0,          1);");
        heroesDB.execSQL("INSERT INTO HeroesTable VALUES('Storm Spirit',     'int', 'support',  'ranged',   0,          1);");
        heroesDB.execSQL("INSERT INTO HeroesTable VALUES('Sven',             'str', 'support',  'ranged',   0,          1);");

        Cursor resultSet = heroesDB.rawQuery("SELECT * FROM HeroesTable", null);
        resultSet.moveToFirst();
        String heroName = resultSet.getString(0);
        String classType = resultSet.getString(2);

        System.out.println("Hero Name: " + heroName);
        System.out.println("Class Type: " + classType);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
