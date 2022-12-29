	/**
	 * The RandomGenerator class randomly generates a ride from
	 * a list of rides with equal probability
	 *
	 * @author Justin Chen
	 * 113097757
	 * justin.chen.1@stonybrook.edu
	 * HW assignment #4
	 * CSE-214
	 * R02 Daoqin Gao, Aiswariya Suresh 
	 */
import java.util.LinkedList;

public class RandomGenerator {
	
	/**
	 * This method randomly selects a ride
	 * 
	 * @param rides
	 * LinkedList of rides
	 * @return
	 * Returns a random ride with equal probability
	 */
	public static Ride selectRide(LinkedList<Ride> rides) {
		
		int random = (int)(Math.random()*(rides.size()));
		return rides.get(random);
	}
}
