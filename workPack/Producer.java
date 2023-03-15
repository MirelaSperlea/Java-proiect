package packWork;


import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Producer implements Runnable
{
	
	private Buffer bufImage = new Buffer();
	Thread t;
	
	public Producer(Buffer bufImage) {
		t = new Thread(this);
	}
	
	public void start() {
		t.start();
	}
	
	public void run() 
	{ 
		BufferedImage pic = null;
		BufferedImage img = null;
		
		
		
		try{
			//un nou fisier
			File file = new File("poza.jpg");
			//citirea pozei
			img=ImageIO.read(file);
	
		    //dmensiunile pozei
		    int imgWidth = img.getWidth();
	        int imgHeight = img.getHeight(); 
	    
		   //se transmite de 4 ori la Consumer
		   for(byte i=0;i<4;i++){  
			   
			 pic=img.getSubimage((imgWidth / 4) * i, 0, imgWidth / 4, imgHeight);
	         bufImage.put(pic);
	         System.out.println("Producer a trimis " + 25 * (i+1) + "% din imagine");
	        	
		   }
		  Thread.sleep(1000);
	  }
		
		catch (FileNotFoundException e)
		{
			// Tratam un tip de exceptie
			System.out.println("Fisierul nu a fost gasit!");
			System.out.println("Exceptie : " + e.getMessage());
		}
		
		catch(IOException e){
			// Tratam alt tip de exceptie
			System.out.println("Eroare la citirea din fisier!");
			e.printStackTrace();
		}
		
		catch (InterruptedException e) {
			e.printStackTrace();
		}
  }
	
	
}
	
	