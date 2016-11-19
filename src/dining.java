// Use java threads to simulate the Dining Philosophers Problem; Credits given to Prof. Riley
// YOUR NAME HERE. */

class dining
{
    public static void main(String args[]) throws InterruptedException
    {
    	
    	Philospher[] phil = new Philospher[5];
    	
    	DiningMonitor monitor = new DiningMonitor(5);
    	
    	for(int i = 0; i < 5; i++){
    		phil[i] = new Philospher(i, monitor);
    		new Thread(phil[i]).start();
    	}
    	
    	
    }
};