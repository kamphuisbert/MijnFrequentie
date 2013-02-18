package nl.bertkamphuis.mijnfrequentie;

import android.content.Intent;
import android.os.Bundle;
//import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import nl.bertkamphuis.mijnfrequentie.R;
import org.apache.cordova.DroidGap;

public class MainActivity extends DroidGap {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.init();
        this.registerForContextMenu(this.appView);
        super.loadUrl("file:///android_asset/www/index.html");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
        case R.id.settings:
            this.startActivity(new Intent(android.provider.Settings.ACTION_SETTINGS));
            return true;
        case R.id.help:
            this.appView.sendJavascript("navigator.notification.alert('No help')");
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
    
}
