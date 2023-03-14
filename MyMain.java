package packTest;

import packWork.Buffer;
import packWork.Consumer;
//import packWork.Image;
import packWork.Producer;



public class MyMain {
	
	public static void main(String[] args) {
		/*
		//creez un obiect Image
		Image i = new Image();
		i.setMyNumber(1);
		i.display();
		i.myPicture(1);
		
		*/
		
	    Buffer buf = new Buffer();
		Producer p1 = new Producer(buf);
		Consumer c1 = new Consumer(buf);
			
		p1.start (); //citirea imaginii
		c1.start (); //prelucrarea imaginii
			
					
	}
	
		
}
