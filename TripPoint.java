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
	public TripPoint(int emit, double tal, double nol)
	{
		time = emit;
		lat = tal;
		lon = nol;
	}
	public double getLat()
	{
		return lat;
	}
	public double getLon()
	{
		return lon;
	}
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
}
