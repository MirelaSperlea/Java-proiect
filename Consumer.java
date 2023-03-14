package packWork;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Consumer extends EdgeDetection implements Runnable 
{   
	private Buffer buffer = new Buffer();
  
	Thread t;
	
	//valorile stantard pentru axa x si y
	static int [] x = {1,0,-1,2,0,-2,1,0,-1};
    static int [] y = {1,2,1,0,0,0,-1,-2,-1};
   
	//dimensiuniile imaginii mari
	int heightPicture=501;
	int widthPicture=501;
	int heightCurso=0;
	
	
	public Consumer(Buffer b) {
		
		t = new Thread(this);
	}
	
	public void start() {
		t.start();
	}
	
	//bloc initializare
	{
	 System.out.println("S-a initializat Consumer!");
	}
	
	public void run() {
		
		BufferedImage img = null;
	    //BufferedImage pic = null;
		BufferedImage picture = null;
		
	
		try{
			
		//imaginea pe care o voi reconstrui
	    picture = new BufferedImage(widthPicture, heightPicture, BufferedImage.TYPE_INT_RGB);
	    Graphics2D g = picture.createGraphics();
	
	    //adaug pic din Producer de 4 ori pt a reconstrui imaginea	
	    for(byte i=0;i<4;i++)
		{  
	    	//preiau 1/4 din imagine
	    	img = buffer.get();
	    	System.out.println("Consumer a primit " + 25 * (i+1) + "% din imagine");
		    
	    	 g.drawImage(img, 0, heightCurso, null);
		     heightCurso +=img.getHeight();	
		   
		}
	    
	    Image.image(img);
	    Thread.sleep(1000);
		}
	    
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
	    //creez un obiect de tip EdgeDetect
		EdgeDetection Detection = new EdgeDetection();
		
        System.out.println("Transform imaginea in grayscale" );
        BufferedImage imgGrey = Detection.grayscale(picture);
       
        System.out.println("Edge detection X" );
        BufferedImage edgesX = Detection.detect(imgGrey,x);
        System.out.println("Edge detection Y" );
        BufferedImage edgesY = Detection.detect(imgGrey,y);
        
        
        System.out.println("Imaginea edge detection" );
        BufferedImage Sobel = EdgeDetection.sobel(edgesX,edgesY);
        
		
        try{
             //scriem imaginile
        	
             //imaginea grayscale
        	 ImageIO.write(imgGrey, "jpg", new File("C:\\Users\\mirel\\OneDrive\\Desktop\\Lab_AWJ\\Proiect\\grayscale.jpg"));
        	 //imaginea edgedetection pe axa x
        	 ImageIO.write(edgesX, "jpg", new File("C:\\Users\\mirel\\OneDrive\\Desktop\\Lab_AWJ\\Proiect\\edgesX.jpg"));
        	 //imaginea edgedetection pe axa y
        	 ImageIO.write(edgesY, "jpg", new File("C:\\Users\\mirel\\OneDrive\\Desktop\\Lab_AWJ\\Proiect\\edgesY.jpg"));
        	 //imaginea finala edgedection
        	 ImageIO.write(Sobel, "jpg", new File("C:\\Users\\mirel\\OneDrive\\Desktop\\Lab_AWJ\\Proiect\\edgedection.jpg"));
         
        }
        
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
	    
	    
			
	}

	
}