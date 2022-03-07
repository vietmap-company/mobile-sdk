package vietmap.maps.addMarker;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import android.os.Bundle;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
//import com.mapbox.mapboxsdk.plugins.annotation.SymbolManager;
//import com.mapbox.mapboxsdk.plugins.annotation.SymbolOptions;
import com.mapbox.mapboxsdk.plugins.annotation.OnSymbolClickListener;
import com.mapbox.mapboxsdk.plugins.annotation.Symbol;
import com.mapbox.mapboxsdk.plugins.annotation.SymbolManager;
import com.mapbox.mapboxsdk.plugins.annotation.SymbolOptions;
import com.mapbox.mapboxsdk.utils.BitmapUtils;
import com.mapbox.mapboxsdk.geometry.LatLng;





public class MainActivity extends AppCompatActivity {
    private MapView mapView = null;
    private final SymbolManager symbolManager=null;
    private static String markerName  = "marker_demo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Mapbox.getInstance(this);
        setContentView(R.layout.activity_main);
        // initialize the map view
        mapView = findViewById(R.id.mapView);

        if(mapView!=null){

            mapView.onCreate(savedInstanceState);

            mapView.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(@NonNull MapboxMap mapboxMap) {


                    mapboxMap.setCameraPosition(new  CameraPosition.Builder()
                            .target(new LatLng(10.758828246395028, 106.6757719352329))
                            .zoom(11.0)
                            .build());
                    String tileUrl="https://maps.vietmap.vn/mt/tm/style.json?apikey={you-key}";


                    mapboxMap.setStyle(new Style.Builder().fromUri(tileUrl), new Style.OnStyleLoaded() {
                        @Override
                        public void onStyleLoaded(@NonNull Style style) {
                            addConfigMarker(style);
                            // Create a SymbolManager.
                            SymbolManager symbolManager = new SymbolManager(mapView, mapboxMap, style);


                            // Set non-data-driven properties.
                            symbolManager.setIconAllowOverlap(true);
                            symbolManager.setIconIgnorePlacement(true);

                            // Create a symbol at the specified location.
                            SymbolOptions symbolOptions = new SymbolOptions()

                                    .withLatLng(new LatLng(10.758828246395028, 106.6757719352329))
                                    .withIconImage(markerName)
                                    .withIconSize(0.24f);

                            // Use the manager to draw the annotations.

                           Symbol symbol= symbolManager.create(symbolOptions);
                           // trigger click on marker
                           symbolManager.addClickListener(new OnSymbolClickListener() {
                                @Override
                                public boolean onAnnotationClick(Symbol symbol) {
                                    Log.println(Log.DEBUG,"debug","onAnnotationClick: with id "+symbol.getId());
                                    return false;
                                }
                            });

                           // you want update location then you only call
                           // symbolManager.update(symbol);


                        }
                    });
                }
            });
        }
    }
    void  addConfigMarker(Style style ){
        style.addImage(markerName,
                BitmapUtils.getBitmapFromDrawable(ContextCompat.getDrawable(this,R.drawable.ic_marker)),
                true);
    }
}