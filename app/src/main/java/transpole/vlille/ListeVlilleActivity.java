package transpole.vlille;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import java.util.ArrayList;


public class ListeVlilleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_vlille);
        update(VLille_Application.getMarkers());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.liste_vlille, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void update(Markers markers) {
        ArrayList<Marker> liste_vlille=markers.getMarker();
        GridView gridview = (GridView) findViewById(R.id.liste_vlille);
        gridview.setAdapter(new MarkerAdapter(this.getApplicationContext(),(Vlille)this.getParent(),R.layout.liste_vlille_layout,liste_vlille));
    }
}
