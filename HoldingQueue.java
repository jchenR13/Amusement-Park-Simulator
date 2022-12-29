	/**
	 * The HoldingQueue class represents the holding queue
	 * for a specific ride at 7flags
	 *
	 * @author Justin Chen
	 * 113097757
	 * justin.chen.1@stonybrook.edu
	 * HW assignment #4
	 * CSE-214
	 * R02 Daoqin Gao, Aiswariya Suresh 
	 */
public class HoldingQueue extends VirtualLine {
	
	private int maxSize; // max size of the holdingQueue
	
	/**
	 * Separate enqueue method for the HoldingQueue class 
	 * that adds a person to the holding queue
	 */
	@Override
	public void enqueue(Person p) {
		if(size()-1 == maxSize) {
			System.out.println("Cannot add person to the line. The line is full");
		}
		else {
			addLast(p);
		}
	}
	
	/**
	 * This method gets the max size of the holdingQueue
	 * 
	 * @return
	 * Returns max size of the queue
	 */
	public int getMaxSize() {
		return maxSize;
	}
	
	/**
	 * This method sets the max size of the holdingQueue
	 * 
	 * @param n
	 * New max size to be set to
	 */
	public void setMaxSize(int n) {
		maxSize = n;
	}
}
