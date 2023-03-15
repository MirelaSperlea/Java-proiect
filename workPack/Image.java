package packWork;

import java.awt.image.BufferedImage;

public class Image extends DisplayClass implements GenericImage {
   
	//encapsulation
	
	//private data
	private int mynumber;
	int image;
	
	//constructor
	public void  myPicture(int startnumber){
		setMyNumber(startnumber);
		System.out.println("This is the image "+ startnumber);
	}
	//getter method for number
	public int getMyNumber() {
		return mynumber;
	}
   //setter method for number
	public void setMyNumber(int mynumber) {
		this.mynumber = mynumber;
	}
	
   //polymorphism
	
	public void display(){
		
		System.out.println("Image is display..");
		
	}
	
	@Override
	public void displayImage() {
		System.out.println("This is the image");
	}

	

	int width;
	int height;
	int imageType;
	
    //constructor
	Image(int width, int height, int imageType){
		this.width = width;
		this.height = height;
		this.imageType = imageType;
	}

	public Image() {
		
	}
	
	public void setImageType(int imageType) {
		this.imageType = imageType;
	}

	public void descriereImagine(){
		System.out.println("Imaginea are dimensiuni mici");
	}

	
	//varargs
	
	public static void image(BufferedImage...image){
		 for(int i=0;i<image.length;i++){
		 System.out.println("The image "+ i +" is ready!");
		
		 } 
	}

	//setter and getters
	public void setWidth(int width) {
		this.width = width;
	}


	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public int getHeight(){
		return height;
	}
	
	@Override
	public int getWidth(){
		return width;
	}

	@Override
	public int getImageType() {
		return imageType;
	}
}
