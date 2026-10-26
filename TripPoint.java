public class TripPoint {
	private double lat;
	private double lon;
	private int time;
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
}
