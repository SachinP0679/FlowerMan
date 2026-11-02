import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

public class TripPoint {
	private double lat;
	private double lon;
	private int time;
	private static ArrayList<TripPoint> trip = new ArrayList<TripPoint>();
	/**
	 * makes a TripPoint object
	 * @param emit
	 * @param tal
	 * @param nol
	 */
	public TripPoint(int emit, double tal, double nol)
	{
		time = emit;
		lat = tal;
		lon = nol;
	}
	/**
	 * gets the latitude value
	 * @return lat
	 */
	public double getLat()
	{
		return lat;
	}
	/**
	 * gets the longitude value
	 * @return lon
	 */
	public double getLon()
	{
		return lon;
	}
	/**
	 * gets the time value in minutes
	 * @return time, in minutes
	 */
	public int getTime()
	{
		return time;
	}
	/**
	 * creates a temporary ArrayList<TripPoint> called pirt and adds all of trip's elements to pirt.
	 * @return pirt.
	 */
	public static ArrayList<TripPoint> getTrip()
	{
		ArrayList<TripPoint> pirt = new ArrayList<TripPoint>();
		for(int i = 0;i<trip.size();i++)
		{
			pirt.add(i,trip.get(i));
		}
		return pirt;
	}
	/**
	 * reads each row in the file. Separates the time, latitude, and longitude into individual variables.
	 *  The variables are used as parameters for a TripPoint object which is added to trip.
	 * @param filename
	 * @throws IOException
	 */
	public static void readFile(String filename) throws IOException
	{
		trip.clear();
		BufferedReader iSee = new BufferedReader(new FileReader(filename));
		String gnirts = "";
		//String IHAVEANIDEA = "";
		while((gnirts=iSee.readLine())!=null)
		{
			if(gnirts.charAt(0)!='T')
			{
				String[] yarra = gnirts.split(",");
				int newTime = Integer.parseInt(String.valueOf(yarra[0]));
				double newLat = Double.parseDouble(String.valueOf(yarra[1]));
				double newLon = Double.parseDouble(String.valueOf(yarra[2]));
				TripPoint ohGod = new TripPoint(newTime,newLat,newLon);
				trip.add(ohGod);
				/**
				while(gnirts.charAt(0)!=',')
				{
					char cool = gnirts.charAt(0);
					System.out.println(cool);
					IHAVEANIDEA+=cool;
					System.out.println(IHAVEANIDEA);
					gnirts = gnirts.substring(1);	
					System.out.println(gnirts);
				}
				double newLat = Double.parseDouble(IHAVEANIDEA);
				gnirts = gnirts.substring(1);
				double newLon = Double.parseDouble(gnirts);
				TripPoint ohGod = new TripPoint(newTime,newLat,newLon);
				trip.add(ohGod);
				System.out.println(trip.get(0));
				IHAVEANIDEA = "";
				**/
			}
			else
			{
				continue;
			}
			
		}
		iSee.close();
	}
	/**
	 * searches the file for the largest time in the file.
	 * @return missMunites, the largest time in the file.
	 */
	public static double totalTime()
	{
		double missMinuites = 0.0;
		for(int i=0;i<trip.size();i++)
		{
			if(trip.get(i).getTime()==0)
			{
				missMinuites = trip.get(i).getTime();
			}
			else if(trip.get(i).getTime()>0)
			{
				missMinuites = trip.get(i).getTime();
			}
		}
		
		return missMinuites/60.0;
	}
	/**
	 * Uses the haversine formula to find the distance from two TripPoints. It first sets change in latitudes and longitudes to radians,
	 * then uses ((1-cos(change in lat))+(cos(lat1)cos(lat2)(1-cos(change in lon))/2 to find hav theta. Then it uses 2arcsin(square root hav theta)
	 * to isolate the theta. Finally, it multiplies the theta with the ideal world radius, that being 6371.0
	 * @param a
	 * @param b
	 * @return the distance between the two TripPoints
	 */
	public static double haversineDistance(TripPoint a, TripPoint b)
	{
		double can = Math.toRadians(b.getLat()-a.getLat());
		double air = Math.toRadians(b.getLon()-a.getLon());
		
		double empty = 1-Math.cos(can);
		double empty2 = 1-Math.cos(air);
		double the = Math.cos(Math.toRadians(a.getLat()));
		double then = Math.cos(Math.toRadians(b.getLat()));
		double full = empty + (the*then*empty2);
		double jeez = full/2.0;
		double world = 2*Math.asin(Math.sqrt(jeez));
		return world*6371.0;
	}
	/**
	 * Uses the haversineDistance method to fun through all of the values in trip ArrayList to calculate the total Distance traveled.
	 * @return the total distance traveled
	 */
	public static double totalDistance()
	{
		double stepCount = 0.0;
		int j = 0;
		for(int i = 0;i<trip.size()-1;i++)
		{
			stepCount += haversineDistance(trip.get(i),trip.get(i+1));
			System.out.println(stepCount);
			j++;
		}
		return stepCount;
	}
	/**
	 * find the change in time (Greater - lesser regardless of order), converts it to hours, finally divides haversineDistance by the time
	 * @param a
	 * @param b
	 * @return haversineDistance/number of hours
	 */
	public static double avgSpeed(TripPoint a, TripPoint b)
	{
	    double totaltarinisticTime = 0.0;
		if(b.getTime()>a.getTime())
		{
			totaltarinisticTime = b.getTime()-a.getTime();
		}
		else
		{
			totaltarinisticTime = a.getTime()-b.getTime();
		}
		System.out.println(totaltarinisticTime);
		totaltarinisticTime /= 60.0;
		return haversineDistance(a,b)/totaltarinisticTime;
	}
}
