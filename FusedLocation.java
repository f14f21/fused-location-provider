
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    FusedLocation fusedLocation;
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==FusedLocation.CALLBACK_REQUEST_PERMISSION){

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fusedLocation=new FusedLocation(this, new FusedLocation.Callback() {
            @Override
            public void onLocationResult(Location location) {
                Toast.makeText(MainActivity.this, "Location : "+ location.getLatitude() ,Toast.LENGTH_SHORT).show();
            }
        });
        //fusedLocation.showSettingsAlert();
        fusedLocation.getCurrentLocation(3);
    }
}
