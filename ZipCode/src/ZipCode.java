public class ZipCode {
	int ZipCode;
	double Longitude, Latitude;
	String City, State;

	public ZipCode(int ZipCode, double Longitude, double Latitude, String City,
			String State) {
		this.ZipCode = ZipCode;
		this.Longitude = Longitude;
		this.Latitude = Latitude;
		this.City = City;
		this.State = State;
	}

	public int getZipCode() {
		return ZipCode;
	}

	public double getLongitude() {
		return Longitude;
	}

	public double getLatitude() {
		return Latitude;
	}

	public String getCity() {
		return City;
	}

	public String getState() {
		return State;
	}

	public String toString() {
		return "ZipCode: " + ZipCode + "\tCity: " + City;
	}

}
