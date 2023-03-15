package packWork;

import java.awt.image.BufferedImage;


public class EdgeDetection 
{   
	  public static BufferedImage sobel(BufferedImage edX, BufferedImage edY){
	    	
		    //imaginea noua pe care vom aplica algoritmul sobel(edgedetection)
	    	BufferedImage sobel = new BufferedImage(edX.getWidth(), edX.getHeight(), BufferedImage.TYPE_INT_RGB);
	    	
	    	//parcurg imaginea
	    	 for(int i = 0; i < sobel.getWidth() ; i++){
	  		   for(int j= 0; j < sobel.getHeight(); j++){
	  			   //determin magnitudinea celor doua valori gradient pentru fiecare pixel
	  			   int pix= Math.abs(edX.getRGB(i, j)&0xff) + Math.abs(edY.getRGB(i, j)&0xff);
	  			  //pentru fiecare pixel din matrice se extrag valoarile din BufferedImage
	  			   sobel.setRGB(i,j, 0xff000000|(pix<<16)|(pix<<8)|pix);
			   } 
	  	   	}
	    	return sobel; 
	    }
	  
	  

	    public BufferedImage detect(BufferedImage img, int[] kernel)
	    {   
	    	//noua imagine pentru edge detection
	    	 BufferedImage rezultat = new BufferedImage(img.getWidth() -1, img.getHeight() -1, BufferedImage.TYPE_INT_RGB);  
	         
	    	 //parcurg imaginea
	         for (int i=0; i<img.getWidth(); i++) {
	            for (int j=0; j<img.getHeight(); j++) {
	                //transform pixelii in hexa
	            	int [] pixeli = { img.getRGB(i-1, j-1)&0xff,img.getRGB(i, j-1)&0xff,img.getRGB(i+1, j-1)&0xff,
	                                  img.getRGB(i-1, j)&0xff,img.getRGB(i, j)&0xff,img.getRGB(i+1, j)&0xff,img.getRGB(i-1, j+1)&0xff,
	                                  img.getRGB(i, j+1)&0xff,img.getRGB(i+1, j+1)&0xff};
	                 
	            	//fac convolutia dintre kernel si pixeli si scriu in rezultat
	            	int value = convolutie (kernel, pixeli);
	                rezultat.setRGB(i,j, 0xff000000|(value<<16)|(value<<8)|value);
	            }
	           }
	       return rezultat;
	    }
	   
	    
	   
	    private static int convolutie (int [] kernel, int [] pixel){
	        int rezultat = 0; 
            //inmultesc fiecare bit al pixelului cu kernelul corespunzator si fac suma 
	        for (int i = 0; i < pixel.length; i++){
	            rezultat += kernel[i] * pixel[i];
	        }
	        ///rezultatul pozitiv e impartit la 9
	        return (int)(Math.abs(rezultat) / 9);
	  
	    }
	    
	    
	  //aplicare gray scale ca fiind media aritmetica a R,G,B pentru fiecare pixel in parte
    public BufferedImage grayscale(BufferedImage img)
    {
       //parcurg imaginea pt a realiza grayscale
         
    	for (int i=0; i<img.getWidth(); i++) {
            for (int j=0; j<img.getHeight(); j++){
           	       
            	    //preiau pixel cu pixel
            	    int pixel = img.getRGB(i,j);

            	    //canalul alpha, ce reprezinta gradul de transparenta a unei culori
           	        int a = (pixel>>24)&0xff;
           	        //red, green, blue(au 8 biti) ii convertiti in hexa
           	        int r = (pixel>>16)&0xff;
           	        int g = (pixel>>8)&0xff;
           	        int b = pixel&0xff;

           	        //calculam media dintre RGB
           	        int media = (r+g+b)/3;

           	        //seteaza valoarea pixelului
           	        pixel = (a<<24) | (media<<16) | (media<<8) | media;
           	        img.setRGB(i, j, pixel);
            }
         }
       return img;
    }
}