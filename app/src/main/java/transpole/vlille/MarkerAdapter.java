package transpole.vlille;

import java.util.ArrayList;
import java.util.Collections;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MarkerAdapter extends BaseAdapter {

    // declaring our ArrayList of items
    private ArrayList<Marker> objects;
    private Context mContext;
    private Vlille vlille;

    /* here we must override the constructor for ArrayAdapter
    * the only variable we care about now is ArrayList<Item> objects,
    * because it is the list of objects we want to display.
    */
    public MarkerAdapter(Context context, Vlille vlille,int textViewResourceId, ArrayList<Marker> objects) {
        mContext = context;
        this.objects=objects;
        this.vlille=vlille;

    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    /*
         * we are overriding the getView method here - this is what defines how each
         * list item will look.
         */
    public View getView(int position, View convertView, ViewGroup parent){

        // assign the view we are converting to a local variable
        View v = convertView;

        // first check to see if the view is null. if so, we have to inflate it.
        // to inflate it basically means to render, or show, the view.
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.liste_vlille_layout, null);
        }

		/*
		 * Recall that the variable position is sent in as an argument to this method.
		 * The variable simply refers to the position of the current object in the list. (The ArrayAdapter
		 * iterates through the list we sent it)
		 *
		 * Therefore, i refers to the current Item object.
		 */
        final Marker m = objects.get(position);

        if (m != null) {

            // This is how you obtain a reference to the TextViews.
            // These TextViews are created in the XML files we defined.

            TextView nomStation = (TextView) v.findViewById(R.id.nomStation);
            TextView velo = (TextView) v.findViewById(R.id.veloLibre);
            TextView place = (TextView) v.findViewById(R.id.placeLibre);

            ImageView iv=(ImageView) v.findViewById(R.id.marker);
            ImageView cb=(ImageView) v.findViewById(R.id.cb);


            if(iv!=null) {
                iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Markers markers=VLille_Application.getMarkers();
                        markers.setCenter_lat(m.getLat());
                        markers.setCenter_lng(m.getLng());
                        markers.setZoom_level(18);
                        vlille.switchTab(1);
                    }
                });
            }
            if(cb!=null && !m.getPaiement().equals("AVEC_TPE")){

                cb.setVisibility(View.INVISIBLE);
            }


            // check to see if each individual textview is null.
            // if not, assign some text!
           if(nomStation!=null){
               nomStation.setText(m.getName());
               if(m.getStatus()==1){
                   nomStation.setTextColor(Color.RED);
               }
               else{
                   nomStation.setTextColor(Color.GREEN);
               }
           }
           if(velo!=null){
               velo.setText(Integer.toString(m.getBikes()));
           }
           if(place!=null){
               place.setText(Integer.toString(m.getAttachs()));
           }

        }

        // the view must be returned to our activity
        return v;

    }

}
