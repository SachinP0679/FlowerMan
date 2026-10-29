import java.util.ArrayList;

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
	public static ArrayList<TripPoint> getTrip()
	{
		ArrayList<TripPoint> pirt = new ArrayList<TripPoint>();
		for(int i = 0;i<trip.size();i++)
		{
			pirt.add(i,trip.get(i));
		}
		return pirt;
	}
	public static void readFile(String filename)
	{
		
	}
}
