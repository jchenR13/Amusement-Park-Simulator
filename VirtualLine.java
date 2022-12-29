	/**
	 * The VirtualLine class represents a virtual queue
	 * for a specific ride at 7flags
	 *
	 * @author Justin Chen
	 * 113097757
	 * justin.chen.1@stonybrook.edu
	 * HW assignment #4
	 * CSE-214
	 * R02 Daoqin Gao, Aiswariya Suresh 
	 */
import java.util.LinkedList;

public class VirtualLine extends LinkedList<Person> {
	
	/**
	 * This method enqueues a person onto the virtual line
	 * 
	 * @param p
	 * New person being enqueued
	 */
	public void enqueue(Person p) {
		addLast(p);
	}
	
	/**
	 * This method dequeues a person from the virtual line
	 * 
	 * @return
	 * Returns the removed person
	 */
	public Person dequeue() {
		
		return (Person) removeFirst();
	}
	
	/**
	 * This method returns the peek of the person's virtual line
	 */
	public Person peek() {
		return (Person) getFirst();
	}
}
