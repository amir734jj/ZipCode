import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PixelCanvas extends Canvas {
	private static final long serialVersionUID = 1L;
	static final int WIDTH = 1000;
	static final int HEIGHT = 496;

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		try {
			g.drawImage(ImageIO.read(new File("./src/phpEW1rnYPM.jpg")), 0, 0,
					this);
			g.dispose();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void drawPoint(Graphics g, int x1, int y1, int x2, int y2) {
		g.setColor(Color.RED);
		g.drawLine(x1, y1, x2, y2);
		g.dispose();
	}
}
