package packWork;

import java.awt.image.BufferedImage;

public class Buffer{
	
	private BufferedImage img;
	private boolean available = false;
	
	public synchronized BufferedImage get() {
		while (!available) {
			
			try {
				wait();
				//Asteapta producatorul sa trimita informatie
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		available = false;
		notifyAll();
		
		BufferedImage img2=img;
		
		return img2;
	}
	
	public synchronized void put( BufferedImage image) {
		while (available) {
			
			try {
				wait();
				//Asteapta Consumatorul sa preia info
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		this.img = image;
		available = true;
		notifyAll();
	}
}
