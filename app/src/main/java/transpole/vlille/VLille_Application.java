package transpole.vlille;

import android.app.Application;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DoubleConverter;
import com.thoughtworks.xstream.converters.basic.IntConverter;
import com.thoughtworks.xstream.converters.basic.StringConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class VLille_Application{

    public Markers markers;
    private static VLille_Application instance;

    private VLille_Application(){

        instance=this;
        Thread princ=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Instanciation de la classe XStream
                    XStream xstream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("_-", "_")));

                    // Redirection du fichier c:/temp/article.xml vers un flux
                    // d'entrée fichier
                    InputStream fis = new URL("http://www.vlille.fr/stations/xml-stations.aspx").openStream();

                    xstream.alias("markers", Markers.class);
                    xstream.alias("marker", Marker.class);

                    xstream.useAttributeFor(Marker.class, "name");
                    xstream.registerConverter(new StringConverter());

                    xstream.useAttributeFor(Marker.class, "lng");
                    xstream.useAttributeFor(Marker.class, "lat");
                    xstream.useAttributeFor(Markers.class, "center_lng");
                    xstream.useAttributeFor(Markers.class, "center_lat");
                    xstream.registerConverter(new DoubleConverter());

                    xstream.useAttributeFor(Marker.class, "id");
                    xstream.useAttributeFor(Markers.class, "zoom_level");
                    xstream.registerConverter(new IntConverter());

                    xstream.addImplicitCollection(Markers.class, "marker");

                    try {

                        Markers markers = (Markers) xstream.fromXML(fis);

                        ArrayList<Thread> listThread=new ArrayList<Thread>();

                        for(Marker marker: markers.getMarker()){
                            final Marker m=marker;
                            Thread t=new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    readInfo(m);
                                }
                            });
                            listThread.add(t);
                            t.start();
                        }

                        for(Thread t:listThread){
                            try {
                                t.join();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        instance.markers = markers;

                    } finally {
                        // On s'assure de fermer le flux quoi qu'il arrive
                        fis.close();
                    }

                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        });

        princ.start();
        try {
            princ.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    protected void readInfo(Marker marker) {
        try {
            XStream xstream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("_-", "_")));

            // Redirection du fichier c:/temp/article.xml vers un flux
            // d'entrée fichier
            InputStream fis = new URL("http://www.vlille.fr/stations/xml-station.aspx?borne=" + marker.getId()).openStream();


            xstream.alias("station", Marker.class);

            xstream.alias("adress", String.class);
            xstream.alias("status", int.class);
            xstream.alias("bikes", int.class);
            xstream.alias("attachs", int.class);
            xstream.alias("paiement", String.class);
            xstream.alias("lastupd", String.class);

            xstream.registerConverter(new StringConverter());
            xstream.registerConverter(new IntConverter());

            try {
                xstream.fromXML(fis, marker);
            } finally {
                // On s'assure de fermer le flux quoi qu'il arrive
                fis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Markers getMarkers(){

        if(VLille_Application.instance==null){
            new VLille_Application();
        }
        return VLille_Application.instance.markers;
    }
}
