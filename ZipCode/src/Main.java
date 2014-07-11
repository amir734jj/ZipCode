import java.io.*;
import java.util.*;

import javax.swing.JFrame;

public class Main {
	static ArrayList<ZipCode> arrayOfZipCode;
	static PixelCanvas convas;

	public static void main(String[] args) {
		initialize(arrayOfZipCode);
		createGUI(convas);
		convas.drawPoint(convas.getGraphics(), 100, 150, 200, 250);
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

	public static void initialize(ArrayList<ZipCode> array) {
		ArrayList<String> arrayOfString = new ArrayList<String>();
		readText(arrayOfString);
		checkArray(arrayOfString);
		ArrayList<ZipCode> arrayOfZipCode = new ArrayList<ZipCode>();
		processArray(arrayOfString, arrayOfZipCode);
		array = arrayOfZipCode;
	}

	public static void createGUI(PixelCanvas convas) {
		PixelCanvas p = new PixelCanvas();
		JFrame frame = new JFrame();
		frame.setSize(PixelCanvas.WIDTH, PixelCanvas.HEIGHT);
		frame.add(p);
		frame.setVisible(true);
		convas = p;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
