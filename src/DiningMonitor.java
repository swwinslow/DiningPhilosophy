
public class DiningMonitor {
	//DEFINE STATES OF A PHILOSPHER
	private enum State {THINKING, HUNGRY, EATING };
	
	//ARRAY OF THE PHILOSPHERS
	private State[] philospherState;
	
	public DiningMonitor(int numberPhil){
		philospherState = new State[numberPhil];
		for(int i = 0; i < numberPhil; i++){
			philospherState[i] = State.THINKING;
			System.out.println("Philospher #" + i + " is THINKING");

		}
	}
	
	public synchronized void pickUpChopsticks(int id) throws InterruptedException{
		philospherState[id] = State.HUNGRY;
		System.out.println("Philospher #" + id + " is HUNGRY");
		while(someNeighborIsEating(id)){
			wait();
		}
		philospherState[id] = State.EATING;
		System.out.println("Philospher #" + id + " is EATING");

	}
	
	public boolean someNeighborIsEating(int id){
		if (philospherState[(id + 1)  % 5]  == State.EATING){
			return true;
		}
		if (philospherState[(id + 4)  % 5]  == State.EATING){
			return true;
		}
		return false;
	}
	
	public synchronized void putDownChopstick(int id){
		philospherState[id] = State.THINKING;
		System.out.println("Philospher #" + id + " is THINKING");

		notifyAll();
	}
	
}
