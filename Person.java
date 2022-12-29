	/**
	 * The Person class represents a person with number, maxLines,
	 * status, and linked list of lines person is currently on
	 *
	 * @author Justin Chen
	 * 113097757
	 * justin.chen.1@stonybrook.edu
	 * HW assignment #4
	 * CSE-214
	 * R02 Daoqin Gao, Aiswariya Suresh 
	 */
import java.util.LinkedList;

enum Status {Available, Holding, OnRide}; //Enum fields

public class Person {
	
	private int number; //integer ID
	private int maxLines; // max number of lines person can be on
	LinkedList<Ride> lines =  new LinkedList<Ride>(); //list of rides the person is on
	private Status thisEnum; //enum
	
	/**
	 * Constructor used to make a person
	 * 
	 * @param number
	 * ID of the person
	 * @throws IllegalArgumentException
	 * Gives an error if the number is negative
	 */
	public Person(int number) throws IllegalArgumentException {
		if(number < 0) {
			throw new IllegalArgumentException("Inserted number is negative");
		}
		this.number = number;
	}	
	/**
	 * This method gets the number of the person
	 * 
	 * @return
	 * Returns the number of the person
	 */
	public int getNumber() {
		return number;
	}
	
	/**
	 * This method sets the ID number of the person to a new number
	 * 
	 * @param n
	 * New number being set to
	 */
	public void setNumber(int n) {
		number = n;
	}
	
	/**
	 * This method gets the max lines
	 * 
	 * @return
	 * Returns the max number of lines 
	 */
	public int getMaxLines() {
		return maxLines;
	}
	
	/**
	 * This method sets max lines
	 * 
	 * @param m
	 * New max number being set to
	 */
	public void setMaxLines(int m) {
		maxLines = m;
	}
	
	/**
	 * This method gets the person's lines
	 * 
	 * @return
	 * Return lines of the person
	 */
	public LinkedList<Ride> getLines() {
		return lines;
	}
	
	/**
	 * This method gets the current size of the person's ride line
	 * 
	 * @return
	 * Returns current size of the person's ride line
	 */
	public int getLineSize() {
		return lines.size();
	}
	
	/**
	 * This method adds a ride to a peson's line
	 * 
	 * @param r
	 * New ride being added to a person's line
	 */
	public void addLines(Ride r) {
		lines.addLast(r);
	}
	
	/**
	 * This method gets the status of the person
	 * 
	 * @return
	 * Returns the status of the person
	 */
	public Status getStatus() {
		return thisEnum;
	}
	/**
	 * This method set a new status for a person
	 * 
	 * @param e
	 * New status to be set to
	 */
	public void setStatus(Status e) {
		thisEnum = e;
	}
	
	/**
	 * This method removes the first line of the person's ride list
	 */
	public void removeRideOnPersonLine() {
		lines.removeFirst();
	}
	
	/**
	 * This method checks to see if the person is already on a line
	 * 
	 * @return
	 * Returns true if person is on a ride, false otherwise
	 */
	public boolean isThisPersonOnLine() {
		for(int i = 0; i < lines.size(); i++) {
			for(int j = 0; j < lines.get(i).getPeopleOnRide().size(); j++) {
				if(lines.get(i).getPeopleOnRide().get(j).getStatus() == Status.OnRide) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * This method adds a ride to a person's ride list
	 * 
	 * @param r
	 * New list being added to a person's ride list
	 */
	public void addRideOnPersonLine(Ride r) {
		if(lines.size() < maxLines) {
			lines.addLast(r);
		}
	}
}
