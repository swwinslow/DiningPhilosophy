import java.util.Random;

public class Philospher implements Runnable  {
	
	private int index;

	private DiningMonitor monitor;
	
	public Philospher(int i, DiningMonitor mon){
		this.index = i;
		this.monitor = mon;
		
	}
	
	@Override
	public void run() {
		try{
			while(true){
				think();
				System.out.println("HERE IS THE INDEX" + this.index);
				monitor.pickUpChopsticks(this.index);
				eat();
				monitor.putDownChopstick(this.index);
			}
			
		} catch (InterruptedException e){
			
		}		
	}
	
	 Random ran = new Random();

	private void eat() throws InterruptedException {
		Thread.sleep(ran.nextInt(10));
	}

	private void think() throws InterruptedException {
		Thread.sleep(ran.nextInt(10));		
	}
	

}
