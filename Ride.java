	/**
	 * The Ride class represents a ride that has duration,
	 * timeleft, name, virtualLine, holdingingQueue, and peopleOnRide
	 *
	 * @author Justin Chen
	 * 113097757
	 * justin.chen.1@stonybrook.edu
	 * HW assignment #4
	 * CSE-214
	 * R02 Daoqin Gao, Aiswariya Suresh 
	 */
import java.util.LinkedList;

public class Ride {
	
	private int duration; // duration of the ride
	private int timeLeft; // time left on the ride
	private String name; // name of the ride
	VirtualLine virtualLine = new VirtualLine(); // virtual line of the ride
	HoldingQueue holdingQueue = new HoldingQueue(); // holdingnQueue of the ride
	LinkedList<Person> peopleOnRide = new LinkedList<Person>(); // people on the ride
	
	private int numGoldRide = 0; //number of gold people on ride
	private int numSilverRide = 0; //number of silver people on ride
	private int numRegularRide = 0; // number of regular people on ride
	private int numBSOD = 0; // number of people that went on BSOD
	private int numKK = 0; // number of people that went on KK
	private int numToT = 0; // number of people that went on ToT
	private int numGF = 0; // number of people that went on GF
	
	private int capacity; // capacity of the people on the line
	
	/**
	 * The constructor used to initialize a ride
	 */
	public Ride() {
		duration = 0;
		timeLeft = 0;
		name = "";
	}
	
	/**
	 * Gets the number of people on BSOD
	 * 
	 * @return
	 * Return number of people on BSOD
	 */
	public int getNumBSOD() {
		return numBSOD;
	}
	
	/**
	 * Gets the number of people on KK
	 * 
	 * @return
	 * Return number of people on KK
	 */
	public int getNumKK() {
		return numKK;
	}
	
	/**
	 * Gets the number of people on ToT
	 * 
	 * @return
	 * Return number of people on ToT
	 */
	public int getNumToT() {
		return numToT;
	}
	
	/**
	 * Gets the number of people on GF
	 * 
	 * @return
	 * Return number of people on GF
	 */
	public int getNumGF() {
		return numGF;
	}
	
	/**
	 * Gets the number of gold people on ride
	 * 
	 * @return
	 * Return number of gold people on ride
	 */
	public int getNumGoldRide() {
		return numGoldRide;
	}
	
	/**
	 * Gets the number of silver people on ride
	 * 
	 * @return
	 * Return number of silver people on ride
	 */
	public int getNumSilverRide() {
		return numSilverRide;
	}
	
	/**
	 * Gets the number of regular people on ride
	 * 
	 * @return
	 * Return number of regular people on ride
	 */
	public int getNumRegularRide() {
		return numRegularRide;
	}
	
	/**
	 * This method gets the capacity
	 * 
	 * @return
	 * Returns the capacity
	 */
	public int getCapacity() {
		return capacity;
	}
	
	/**
	 * This method sets the capacity
	 * 
	 * @param c
	 * New capacity to be set to
	 */
	public void setCapacity(int c) {
		capacity = c;
	}
	
	/**
	 * This method gets the duration
	 * 
	 * @return
	 * Returns the duration
	 */
	public int getDuration() {
		return duration;
	}
	
	/**
	 * This method sets the duration
	 * 
	 * @param duration
	 * New duration to be set to
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	/**
	 * This method gets the time left
	 * 
	 * @return
	 * Returns the time left
	 */
	public int getTimeLeft() {
		return timeLeft;
	}
	
	/**
	 * This method sets the time left
	 * 
	 * @param timeLeft
	 * New time left to be set to
	 */
	public void setTimeLeft(int timeLeft) {
		this.timeLeft = timeLeft;
	}
	
	/**
	 * This method gets the name of the ride
	 * 
	 * @return
	 * Return the name of the ride
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This method sets the name of the ride
	 * 
	 * @param n
	 * New ride name to be set to
	 */
	public void setName(String n) {
		name = n;
	}
	
	/**
	 * This method gets the virtualLine
	 * 
	 * @return
	 * Returns the virtualLine
	 */
	public VirtualLine getVirtualLine() {
		return virtualLine;
	}
	
	/**
	 * This method sets the virtualLine
	 * 
	 * @param virtualLine
	 * New virtualLine to be set to
	 */
	public void setVirtualLine(VirtualLine virtualLine) {
		this.virtualLine = virtualLine;
	}
	
	/**
	 * This method gets the holding queue
	 * 
	 * @return
	 * Returns the holdingQueue
	 */
	public HoldingQueue getHoldingQueue() {
		return holdingQueue;
	}
	
	/**
	 * This method sets the holdingQueue
	 * 
	 * @param holdingQueue
	 * New holdingQueue to be set to
	 */
	public void setHoldingQueue(HoldingQueue holdingQueue) {
		this.holdingQueue = holdingQueue;
	}
	
	/**
	 * This method gets the people on the ride
	 * 
	 * @return
	 * Returns the people on the ride
	 */
	public LinkedList<Person> getPeopleOnRide() {
		return peopleOnRide;
	}
	
	/**
	 * This method sets the people on the ride
	 * 
	 * @param peopleOnRide
	 * New peopleOnRide to be set to
	 */
	public void setPeopleOnRide(LinkedList<Person> peopleOnRide) {
		this.peopleOnRide = peopleOnRide;
	}
	
	/**
	 * This method removes people from the virtual line, holding line, and peopleOnRide
	 * if it is applicable to do so
	 * 
	 * @param allRides
	 * LinkedList of rides that is used to get a random ride from it
	 */
	public void removeCustomer(LinkedList<Ride> allRides)  {
		
			Person [] onRideTemp = new Person[capacity];
			
			if(peopleOnRide.isEmpty() == false && holdingQueue.isEmpty() == false && virtualLine.isEmpty()== false) {
				
				int rideCounter = peopleOnRide.size();
				int holdCounter = holdingQueue.size();
				
				int whichBigger1 = rideCounter;
				if(rideCounter > holdCounter) {
					whichBigger1 = holdCounter;
				}
				if(rideCounter < holdCounter) {
					whichBigger1 = rideCounter;
				}
				
				for(int i = 0; i < rideCounter; i++) {
					onRideTemp[i] = new Person(peopleOnRide.get(0).getNumber());
					onRideTemp[i].setMaxLines(peopleOnRide.get(0).getMaxLines());
					onRideTemp[i].setStatus(Status.Available);
					peopleOnRide.get(0).removeRideOnPersonLine();
					Ride temp = RandomGenerator.selectRide(allRides);
					peopleOnRide.get(0).setStatus(Status.Available);
					temp.addPersonOnRideAfter(peopleOnRide.get(0));
					peopleOnRide.get(0).addRideOnPersonLine(temp);
					peopleOnRide.remove(0);
				}
				
				for(int i = 0; i < whichBigger1; i++) {
					peopleOnRide.addLast(holdingQueue.get(0));
					peopleOnRide.getLast().setStatus(Status.OnRide);
					holdingQueue.remove(0);
				}
				
				int whichBigger = virtualLine.size();
				if(holdingQueue.getMaxSize() > virtualLine.size()) {
					whichBigger = virtualLine.size();
				}
				else if(holdingQueue.getMaxSize() < virtualLine.size()) {
					whichBigger = holdingQueue.getMaxSize();
				}
				
				Person [] virtualTemp = new Person[whichBigger];
				
					for(int n = 0; n < whichBigger; n++) {
						if(getLargestStatus(virtualLine.get(n)) == Status.Available && holdingQueue.size() < holdingQueue.getMaxSize()) {
							virtualTemp[n] = new Person(virtualLine.get(0).getNumber());
							virtualTemp[n].setMaxLines(virtualLine.get(0).getMaxLines());
							virtualTemp[n].setStatus(Status.Holding);
							virtualLine.get(0).removeRideOnPersonLine();
							virtualLine.remove(n);
						}
					}
					
					for(int i = 0; i < whichBigger; i++) {
						holdingQueue.addLast(virtualLine.get(0));
						holdingQueue.getLast().setStatus(Status.Holding);
						virtualLine.remove(0);
					}
			}
			
			else if(peopleOnRide.isEmpty() == false && holdingQueue.isEmpty() == false && virtualLine.isEmpty() == true) {
				
				int rideCounter = peopleOnRide.size();
				int holdCounter = holdingQueue.size();
				
				int whichBigger1 = rideCounter;
				if(rideCounter > holdCounter) {
					whichBigger1 = holdCounter;
				}
				if(rideCounter < holdCounter) {
					whichBigger1 = rideCounter;
				}
				
				for(int i = 0; i < rideCounter; i++) {
					onRideTemp[i] = new Person(peopleOnRide.get(0).getNumber());
					onRideTemp[i].setMaxLines(peopleOnRide.get(0).getMaxLines());
					onRideTemp[i].setStatus(Status.Available);
					peopleOnRide.get(0).removeRideOnPersonLine();
					Ride temp = RandomGenerator.selectRide(allRides);
					peopleOnRide.get(0).setStatus(Status.Available);
					temp.addPersonOnRideAfter(peopleOnRide.get(0));
					peopleOnRide.get(0).addRideOnPersonLine(temp);
					if(peopleOnRide.get(0).getMaxLines() == 3) {
						numGoldRide++;
					}
					
					if(peopleOnRide.get(0).getMaxLines() == 2) {
						numSilverRide++;
					}
					
					if(peopleOnRide.get(0).getMaxLines() == 1) {
						numRegularRide++;
					}
					peopleOnRide.remove(0);
				}
				
				for(int i = 0; i < whichBigger1; i++) {
					peopleOnRide.addLast(holdingQueue.get(0));
					peopleOnRide.getLast().setStatus(Status.OnRide);
					holdingQueue.remove(0);
				}
			}
			
			else if(peopleOnRide.isEmpty() == false && holdingQueue.isEmpty() == true && virtualLine.isEmpty() == false) {
				
				int rideCounter = peopleOnRide.size();
				
				for(int i = 0; i < rideCounter; i++) {
					onRideTemp[i] = new Person(peopleOnRide.get(0).getNumber());
					onRideTemp[i].setMaxLines(peopleOnRide.get(0).getMaxLines());
					onRideTemp[i].setStatus(Status.Available);
					peopleOnRide.get(0).removeRideOnPersonLine();
					Ride temp = RandomGenerator.selectRide(allRides);
					peopleOnRide.get(0).setStatus(Status.Available);
					temp.addPersonOnRideAfter(peopleOnRide.get(0));
					peopleOnRide.get(0).addRideOnPersonLine(temp);
					peopleOnRide.remove(0);
				}
				
				int whichBigger = virtualLine.size();
				if(capacity > virtualLine.size()) {
					whichBigger = virtualLine.size();
				}
				else if(capacity < virtualLine.size()) {
					whichBigger = capacity;
				}
				
				Person [] virtualTemp = new Person[whichBigger];
				
					for(int n = 0; n < whichBigger; n++) {
						if(getLargestStatus(virtualLine.get(n)) == Status.Available) {
							int i = 0;
							virtualTemp[i] = new Person(virtualLine.get(n).getNumber());
							virtualTemp[i].setMaxLines(virtualLine.get(n).getMaxLines());
							virtualTemp[i].setStatus(Status.Available);
							this.addPersonOnRideAfter(virtualLine.get(0));
							virtualLine.get(n).removeRideOnPersonLine();
							virtualLine.get(n).addRideOnPersonLine(this);
							virtualLine.remove(n);
							i++;
						}
					}
					
					for(int i = 0; i < whichBigger; i++) {
						peopleOnRide.addLast(virtualTemp[i]);
					}

				
			}
			else if(peopleOnRide.isEmpty() == false && holdingQueue.isEmpty() == true && virtualLine.isEmpty() == true) {
				
				int rideCounter = peopleOnRide.size();
				for(int i = 0; i < rideCounter; i++) {
					onRideTemp[i] = new Person(peopleOnRide.get(0).getNumber());
					onRideTemp[i].setMaxLines(peopleOnRide.get(0).getMaxLines());
					onRideTemp[i].setStatus(Status.Available);
					peopleOnRide.get(0).removeRideOnPersonLine();
					Ride temp = RandomGenerator.selectRide(allRides);
					temp.addPersonOnRideAfter(peopleOnRide.get(0));
					peopleOnRide.get(0).addRideOnPersonLine(temp);
					peopleOnRide.remove(0);
				}
			}
			
			
			else if(peopleOnRide.isEmpty() == true && holdingQueue.isEmpty() == false && virtualLine.isEmpty() == false) {
				
				int whichBigger1 = capacity;
				if(holdingQueue.getMaxSize() > capacity) {
					whichBigger1 = capacity;
				}
				else if(holdingQueue.getMaxSize() < capacity) {
					whichBigger1 = holdingQueue.getMaxSize();
				}
				
				for(int i = 0; i < whichBigger1; i++) {
					peopleOnRide.addLast(holdingQueue.get(0));
					peopleOnRide.getLast().setStatus(Status.Available);
					holdingQueue.remove(0);
				}
				
				int whichBigger = holdingQueue.size();
				if(holdingQueue.getMaxSize() > virtualLine.size()) {
					whichBigger = virtualLine.size();
				}
				else if(holdingQueue.getMaxSize() < virtualLine.size()) {
					whichBigger = holdingQueue.getMaxSize();
				}
				
				Person [] virtualTemp = new Person[whichBigger];
				
					for(int n = 0; n < whichBigger; n++) {
						if(getLargestStatus(virtualLine.get(n)) == Status.Available && holdingQueue.size() < holdingQueue.getMaxSize()) {
							virtualTemp[n] = new Person(virtualLine.get(0).getNumber());
							virtualTemp[n].setMaxLines(virtualLine.get(0).getMaxLines());
							virtualTemp[n].setStatus(Status.Holding);
							virtualLine.get(0).removeRideOnPersonLine();
							virtualLine.remove(n);
						}
					}
					
					for(int i = 0; i < whichBigger; i++) {
						holdingQueue.addLast(virtualLine.get(0));
						holdingQueue.getLast().setStatus(Status.Holding);
					}
			}
			
			else if(peopleOnRide.isEmpty() == true && holdingQueue.isEmpty() == false && virtualLine.isEmpty( )== true) {
				
				int whichBigger = capacity;
				if(capacity > holdingQueue.size()) {
					whichBigger = holdingQueue.size();
				}
				else if(capacity < holdingQueue.size()){
					whichBigger = capacity;
				}
				
				for(int i = 0; i < whichBigger; i++) {
					peopleOnRide.addLast(holdingQueue.get(0));
					peopleOnRide.getLast().setStatus(Status.OnRide);
					holdingQueue.remove(0);
				}
			}

			else if(peopleOnRide.isEmpty() == true && holdingQueue.isEmpty() == true && virtualLine.isEmpty( ) == false) {
				
				int whichBigger = capacity;
				if(capacity > virtualLine.size()) {
					whichBigger = virtualLine.size();
				}
				else if(capacity < virtualLine.size()){
					whichBigger = capacity;
				}
				
				Person [] virtualTemp = new Person[whichBigger];
				
				for(int n = 0; n < whichBigger; n++) {
					if(getLargestStatus(virtualLine.get(n)) == Status.Available && holdingQueue.size() < holdingQueue.getMaxSize()) {
						virtualTemp[n] = new Person(virtualLine.get(0).getNumber());
						virtualTemp[n].setMaxLines(virtualLine.get(0).getMaxLines());
						virtualTemp[n].setStatus(Status.OnRide);
						virtualLine.get(0).removeRideOnPersonLine();
						virtualLine.remove(n);
					}
				}
				
				for(int i = 0; i < whichBigger; i++) {
					peopleOnRide.addLast(virtualLine.get(0));
					peopleOnRide.getLast().setStatus(Status.OnRide);
					virtualLine.remove(0);
				}
			}
			
			else if(peopleOnRide.isEmpty() == true && holdingQueue.isEmpty() == true && virtualLine.isEmpty() == true) {
				System.out.println("Everything is empty");
			}
			
		}
	
	/**
	 * This method adds a person on ride after the initial add
	 * 
	 * @param p
	 * Person to be added
	 */
	public void addPersonOnRideAfter(Person p) {
		if(doesListContainDuplicate(virtualLine, p) == false) {
			virtualLine.enqueue(p);
		}
	}
	
	/**
	 * This method adds a person on a ride initially
	 * 
	 * @param p
	 * Person to be added
	 */
	public void addPersonOnRideInitially(Person p) {
		
		if(getLargestStatus(p) == Status.Available) {
			if(peopleOnRide.size() < capacity && doesListContainDuplicate(peopleOnRide, p) == false && isTheOrderCorrect(peopleOnRide, p) == true) {
				if(getLargestStatus(p) == Status.Available) {
					p.setStatus(Status.OnRide);
				}
				peopleOnRide.addLast(p);
			}
			else if(holdingQueue.size() < holdingQueue.getMaxSize() && doesListContainDuplicate(holdingQueue, p) == false && isTheOrderCorrect(holdingQueue, p) == true) {
				if(getLargestStatus(p) == Status.Available) {
					p.setStatus(Status.Holding);
				}
				holdingQueue.enqueue(p);
			}
		}
		else if(getLargestStatus(p) == Status.OnRide || getLargestStatus(p) == Status.Holding && isTheOrderCorrect(virtualLine, p) == true) {
			virtualLine.enqueue(p);
		}
	}
	
	/**
	 * This method gets the highest status of a person's ride list
	 * 
	 * @param p
	 * Checks this peron's ride list
	 * @return
	 * Returns the highest status of a person's ride list
	 */
	public Status getLargestStatus(Person p) {
		if(p.getLines().isEmpty() == true){
			return Status.Available;
		}
		else {
			for(int i = 0; i < p.getLineSize(); i++) {
				for(int j = 0; j < p.getLines().get(i).getPeopleOnRide().size(); i++) {
					if(p.getLines().get(i).getPeopleOnRide().get(j).getStatus() == Status.OnRide) {
						return Status.OnRide;
					}
					if(p.getLines().get(i).getPeopleOnRide().get(j).getStatus() == Status.Holding) {
						return Status.Holding;
					}
				}
			}
			return Status.Available;
		}
		
	}
	
	/**
	 * This person checks if the order is in the following priority(Gold, silver, regular)
	 * 
	 * @param list
	 * Ride that is being tranversed
	 * @param p
	 * Person to be checked
	 * @return
	 * Returns true if the order is correct, else otherwise
	 */
	public boolean isTheOrderCorrect(LinkedList<Person> list, Person p) {
		if(list.isEmpty()) {
			return true;
		}
		else if(list.getLast().getMaxLines() == 3 && p.getMaxLines() <= 3) {
			return true;
		}
		else if(list.getLast().getMaxLines() == 2 && p.getMaxLines() <= 2) {
			return true;
		}
		else if(list.getLast().getMaxLines() == 1 && p.getMaxLines() <= 1) {
			return true;
		}
		return false;
	}
	
	/**
	 * This method checks if a ride has more than 1 occurrence of person
	 * 
	 * @param list
	 * Ride that is being traversed
	 * @param p
	 * Person that is being checked for duplicate
	 * @return
	 * Returns true if there is a duplicate, false otherwise
	 */
	public boolean doesListContainDuplicate(LinkedList<Person> list, Person p) {
		if(list.size() == 0) {
			return false;
		}
		else {
			for(int i = 0; i < list.size(); i++) {
				if(p.getMaxLines() == list.get(i).getMaxLines() && p.getNumber() == list.get(i).getNumber()) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * This method neatly prints out a ride's virtualLine, holdingQueueu, and peopleOnRide
	 * 
	 * @return
	 * Returns a string representation of a ride
	 */
	public String printAllQueuesOnRide() {
		
		System.out.print("On Ride: ");
		if(peopleOnRide.size() == 0) {
			System.out.print("[ EMPTY ]" + "\n");
		}
		else {
			printRide(peopleOnRide);
			System.out.print("\n");
		}
		System.out.print("Holding Queue: ");
		if(holdingQueue.size() == 0) {
			System.out.print("[ EMPTY ]"+ "\n");
		}
		else {
			printRide(holdingQueue);
			System.out.print("\n");
		}
		System.out.print("Virtual Queue: ");
		if(virtualLine.size() == 0) {
			System.out.print("[ EMPTY ]"+ "\n");
		}
		else {
			printRide(virtualLine);
			System.out.print("\n");
		}
		System.out.println("----------------");
		return "";
	}
	
	/**
	 * This method prints one of the following lines from the ride: personOnRide, holingingQueue, or virtualLine
	 * 
	 * @param r
	 * Ride that is being used to print a single line from
	 * @return
	 * Returns a string representation of one of the lines of ride
	 */
	public static String printRide(LinkedList<Person> r) {
		for(int i = 0; i < r.size(); i++) {
			Person temp = r.get(i);
			if(temp.getMaxLines() == 3) {
				if(i == r.size()-1) {
					System.out.print("Gold " + temp.getNumber());
				}
				else {
					System.out.print("Gold " + temp.getNumber() + ", ");
				}
			}
			else if(temp.getMaxLines() == 2) {
				if(i == r.size()-1) {
					System.out.print("Silver " + temp.getNumber());
				}
				else {
					System.out.print("Silver " + temp.getNumber() + ", ");
				}
			}
			else {
				if(i == r.size()-1) {
					System.out.print("Regular " + temp.getNumber());
				}
				else {
					System.out.print("Regular " + temp.getNumber() + ", ");
				}
			}
		}
		return "";
	}
	
}
