package ca.ualberta.cs.comput301.currentlocation;

import java.util.Date;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.TextView;

public class CurrentLocationActivity extends Activity {
	private static final String GPS_MOCK_PROVIDER = "mockLocationProvider";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		// Obtain LocationManager service and set up location update request.
		LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		lm.requestLocationUpdates(GPS_MOCK_PROVIDER, 1000, 0, locationListener);
	}

	
	// Retrieve location updates through LocationListener interface
	private final LocationListener locationListener = new LocationListener(){
		@Override
		public void onLocationChanged(Location location)
		{
			TextView tv = (TextView)findViewById(R.id.myLocationText);
			if(location != null)
			{
				double lat = location.getLatitude();
				double lng = location.getLongitude();
				Date date = new Date(location.getTime());
				tv.setText("Your location is:"
						+ "\nLatitude: " + lat
						+ "\nLongitude: " + lng
						+ "\nat: " + date.toString());
				
			}
			else
			{
				tv.setText("No location information");
			}
		}
		@Override
		public void onProviderEnabled(String string){
			
		}
		
		@Override
		public void onProviderDisabled(String string){
			
		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras)
		{

			// TODO Auto-generated method stub
			
		}
	}	;

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
