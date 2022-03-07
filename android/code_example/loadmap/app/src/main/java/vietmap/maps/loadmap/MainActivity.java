package vietmap.maps.loadmap;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.location.LocationComponent;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.module.http.HttpRequestImpl;

public class MainActivity extends AppCompatActivity {
    private MapView mapView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Mapbox.getInstance(this);
        setContentView(R.layout.activity_main);
        mapView = findViewById(R.id.mapView);
        if(mapView!=null){
            mapView.onCreate(savedInstanceState);
            mapView.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(@NonNull MapboxMap mapboxMap) {


                    mapboxMap.setStyle(new Style.Builder()
                            .fromUri("https://maps.vietmap.vn/mt/dm/style.json?apikey={your-api-key}"));
                    mapboxMap.getUiSettings();


                }
            });
        }
        }
    @Override
    protected void onStart() {
        super.onStart();
        if(mapView!=null){
            mapView.onStart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(mapView!=null){
            mapView.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mapView!=null){
            mapView.onPause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mapView!=null){
            mapView.onDestroy();
        }
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        if(mapView!=null){
            mapView.onLowMemory();
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if(mapView!=null){
            mapView.onSaveInstanceState(outState);
        }
    }
}
