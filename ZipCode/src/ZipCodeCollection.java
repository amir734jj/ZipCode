import java.util.ArrayList;
import java.util.Iterator;

public class ZipCodeCollection {
	ArrayList<ZipCode> array;
	int size;

	public ZipCodeCollection(ArrayList<ZipCode> array) {
		this.array = array;
	}

	public ZipCode getByZipCode(int ZipCode) {
		Iterator<ZipCode> it = array.iterator();
		ZipCode temp;
		while (it.hasNext()) {
			temp = it.next();
			if (temp.getZipCode() == ZipCode)
				return temp;
		}
		return null;
	}

	public void add(ZipCode item) {
		array.add(item);
	}

	public void getCollectionOfZipCodeByMiles(ZipCodeCollection Collection,
			ZipCode origin, int radius) {
		Iterator<ZipCode> it = array.iterator();
		ZipCode temp;
		while (it.hasNext()) {
			temp = it.next();
			if (FlatEarthDist.distance(origin.getLatitude(),
					origin.getLongitude(), temp.getLatitude(),
					temp.getLongitude()) <= radius)
				Collection.add(temp);
		}
	}

	public String toString() {
		String str = "";
		Iterator<ZipCode> it = array.iterator();
		while (it.hasNext())
			str += it.next() + "\n";
		return str;

	}
}
