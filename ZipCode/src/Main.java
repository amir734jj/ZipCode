import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		ArrayList<String> arrayOfString = new ArrayList<String>();
		readText(arrayOfString);
		checkArray(arrayOfString);
		ArrayList<ZipCode> arrayOfZipCode = new ArrayList<ZipCode>();
		processArray(arrayOfString, arrayOfZipCode);
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
}
