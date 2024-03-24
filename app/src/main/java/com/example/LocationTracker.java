import android.content.Context;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationService;

//Some help from Chat.GPT
//Todo finish functionality

public class LocationTracker() {


   private Context con;


   public LocationTracker(Context con){
       // Context to get location.
       this.con = con;
   }


   public void getLocation(LocationCallback callBack){
       if (this.con == null){
           return;
       }
       // Create new request.
       LocationRequest request = LocationRequest.create();
       // Get location from web and gps.
       request.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
       request.setInterval(1000);


  
       LocationServices.getFusedLocationProviderClient(context)
           .requestLocationUpdates(locationRequest, new LocationCallback() {
       @Override
       public void onLocationResult(LocationResult locationResult) {
           super.onLocationResult(locationResult);
           if (locationResult != null && locationResult.getLastLocation() != null) {
               callBack.onLocationResult(locationResult.getLastLocation());
           }
       }
   }, Looper.getMainLooper());
}
}


public interface LocationCallback {
   void onLocationResult(Location location);
}
