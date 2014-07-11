import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<ZipCode> arrayOfZipCode;
	static ZipCodeCollection collection;

	public static void main(String[] args) {
		arrayOfZipCode = initialize();
		collection = new ZipCodeCollection(arrayOfZipCode);
		interactive();
	}

	public static void readText(ArrayList<String> array) {

		try {
			BufferedReader br = new BufferedReader(new FileReader(
					"./src/ZIP_CODES.txt"));
			String line = null;
			while ((line = br.readLine()) != null)
				array.add(line);
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void checkArray(ArrayList<String> array) {
		Iterator<String> it = array.iterator();
		String str;
		while (it.hasNext()) {
			str = it.next();
			if (str.contains(",,,"))
				it.remove();
		}
	}

	public static void processArray(ArrayList<String> array,
			ArrayList<ZipCode> arrayOfZipCode) {
		Iterator<String> it = array.iterator();
		String[] str;
		String temp;
		while (it.hasNext()) {
			temp = it.next();
			if (temp.isEmpty())
				break;
			str = temp.replaceAll("\"", "").split(",");
			arrayOfZipCode.add(new ZipCode(Integer.parseInt(str[0]), Double
					.parseDouble(str[1]), Double.parseDouble(str[2]), str[3],
					str[4]));
		}

	}

	public static ArrayList<ZipCode> initialize() {
		ArrayList<String> arrayOfString = new ArrayList<String>();
		ArrayList<ZipCode> arrayOfZipCode = new ArrayList<ZipCode>();
		readText(arrayOfString);
		checkArray(arrayOfString);
		processArray(arrayOfString, arrayOfZipCode);
		return arrayOfZipCode;
	}

	public static void interactive() {
		Scanner stdin = new Scanner(System.in);
		int i1, i2;
		System.out.print("Enter ZipCode: ");
		i1 = stdin.nextInt();
		System.out.print("Enter Radius in meter: ");
		i2 = stdin.nextInt();

		ZipCodeCollection temp = new ZipCodeCollection(new ArrayList<ZipCode>());

		collection.getCollectionOfZipCodeByMiles(temp,
				collection.getByZipCode(i1), i2);
		System.out.println("Result:\n" + temp.toString());
	}
}
