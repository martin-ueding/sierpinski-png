import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.Graphics2D;

public class Sierpinski {
	
	public static void main(String[] args) {
		
		int stufe;
		int lastStufe = 9;
		int neuBreite;
		
		double[] punkteX = {0,0.5,0};
		double[] punkteY = {0,0.5,0.5};
		
		int fak = (int)(1/ 0.5);
		
		int i, j;
		
		int runde;
		
		boolean[][] aktuell, neu;
		
		aktuell = new boolean[1][1];
		aktuell[0][0] = true;
		
		for (stufe = 0; stufe < lastStufe; stufe++) {	// Solange wir noch tiefer sollen:
			System.out.println("Stufe " + (stufe +1));
			
			neuBreite = (int) Math.pow(2, stufe) * fak;	// Neue Größe ist hier doppelt so groß
			
			neu = new boolean[neuBreite][neuBreite];	// Ein neues Feld
			
			for (runde = 0; runde < 3; runde++) {
				for (i = 0; i < aktuell.length; i++) {
					for (j = 0; j < aktuell[0].length; j++) {
						/* Kopiere das alte Bild in das neue hinein, dabei wird es verkleinert */
						neu[(int) (i+punkteX[runde]*neuBreite)][(int) (j+punkteY[runde]*neuBreite)] = aktuell[i][j]; 
					}
				}
			}
			aktuell = neu;	
		}
		
		
		final int res = 50;
		final int space = 1;
		
		BufferedImage img = new BufferedImage(1024, 768, BufferedImage.TYPE_INT_RGB);
		
			try {	
			Graphics2D g = img.createGraphics();
				
			for (int x = 0; x < aktuell.length; x++) {
				for (int y = 0; y < aktuell[0].length; y++) {
					if (aktuell[x][y]) {
						g.fillRect(x*(res+space), y*(res+space), res, res);
					}
				}
			}			
			javax.imageio.ImageIO.write(img, "png", new FileOutputStream("Sierpinski.png"));	// Speichere das Bild
		}
		catch (IOException e) {}
	}
}
