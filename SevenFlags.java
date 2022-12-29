	/**
	 * The SevenFlags class represents a simulation of 4 rides: BSOD, ToT, GF, and KK. 
	 *
	 * @author Justin Chen
	 * 113097757
	 * justin.chen.1@stonybrook.edu
	 * HW assignment #4
	 * CSE-214
	 * R02 Daoqin Gao, Aiswariya Suresh 
	 */
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class SevenFlags {

	public static void main(String[] args) {
		try {
			Ride BSOD = new Ride();
			BSOD.setName("BSOD");
			Ride ToT = new Ride();	
			ToT.setName("ToT");
			Ride GF = new Ride();		
			GF.setName("GF");
			Ride KK = new Ride();	
			KK.setName("KK");
			
			/**
			 * Adds all the rides to a LinkedList to be randomly selected from
			 */
			LinkedList<Ride> allRides = new LinkedList<Ride>();
			allRides.add(BSOD);
			allRides.add(ToT);
			allRides.add(GF);
			allRides.add(KK);
			
			Scanner input = new Scanner(System.in);
			
			int regularC, silverC, goldC, simLength = 0;
			int durationBdos, capacityBdos, holdqueBdos = 0;
			int durationKk, capacityKk, holdqueKk = 0;
			int durationToT, capacityToT, holdqueToT = 0;
			int durationGf, capacityGf, holdqueGf = 0;
			
			System.out.println("Please enter the number of regular customers: ");
			regularC = input.nextInt();

			System.out.println("Please enter the number of silver customers:  ");
			silverC = input.nextInt();

			System.out.println("Please enter the number of gold customers: ");
			goldC = input.nextInt();

			System.out.println("Please enter simulation length: ");
			simLength = input.nextInt();
			
			System.out.println("Please enter the duration of Blue Scream of Death (minutes): ");
			durationBdos = input.nextInt();
			
			System.out.println("Please enter the capacity of Blue Scream of Death: ");
			capacityBdos = input.nextInt();
			
			System.out.println("Please enter the holding queue size for Blue Scream of Death: ");
			holdqueBdos = input.nextInt();
			
			System.out.println("Please enter the duration of Kingda Knuth (minutes): ");
			durationKk = input.nextInt();
			
			System.out.println("Please enter the capacity of Kingda Knuth: ");
			capacityKk = input.nextInt();
			
			System.out.println("Please enter the holding queue size for Kingda Knuth: ");
			holdqueKk = input.nextInt();
			
			System.out.println("Please enter the duration of i386 Tower of Terror (minutes): ");
			durationToT = input.nextInt();
			
			System.out.println("Please enter the capacity of i386 Tower of Terror: ");
			capacityToT = input.nextInt();
			
			System.out.println("Please enter the holding queue size for i386 Tower of Terror: ");
			holdqueToT = input.nextInt();
			
			System.out.println("Please enter the duration of GeForce (minutes): ");
			durationGf = input.nextInt();
			
			System.out.println("Please enter the capacity of GeForce: ");
			capacityGf = input.nextInt();
			
			System.out.println("Please enter the holding queue size for GeForce: ");
			holdqueGf = input.nextInt();
			
			/**
			 * If any of the inputs are negative, then prints out a message,
			 * otherwise proceeds
			 */
			if(regularC < 0 || silverC < 0 || goldC < 0 || simLength < 0 || durationBdos < 0 || capacityBdos < 0 || holdqueBdos < 0 || durationKk < 0 || capacityKk < 0|| holdqueKk < 0 || durationToT < 0 ||capacityToT < 0 || holdqueToT < 0 || durationGf < 0 || capacityGf < 0|| holdqueGf < 0) {
				System.out.println("Negative numbers are not allowed. Try again");
			}
			else {
				
				// sets all the variables accordingly
				BSOD.setDuration(durationBdos);
				BSOD.setCapacity(capacityBdos);
				BSOD.getHoldingQueue().setMaxSize(holdqueBdos);
				KK.setDuration(durationKk);
				KK.setCapacity(capacityKk);
				KK.getHoldingQueue().setMaxSize(holdqueKk);
				ToT.setDuration(durationToT);
				ToT.setCapacity(capacityToT);
				ToT.getHoldingQueue().setMaxSize(holdqueToT);
				GF.setDuration(durationGf);
				GF.setCapacity(capacityGf);
				GF.getHoldingQueue().setMaxSize(holdqueGf);
				
				Person [] gold = new Person[goldC]; // array of gold members
				Person [] silver = new Person[silverC]; // array of silver members
				Person [] regular = new Person [regularC]; // array of regular members
				
				for(int i = 0; i < goldC; i++) {
					gold[i] = new Person(i+1);
					gold[i].setMaxLines(3);
					gold[i].setStatus(Status.Available);
				}
					
				for(int i = 0; i < silverC; i++) {
					silver[i] = new Person(i+1);
					silver[i].setMaxLines(2);
					silver[i].setStatus(Status.Available);
				}
				
				for(int i = 0; i < regularC; i++) {
					regular[i] = new Person(i+1);
					regular[i].setMaxLines(1);
					regular[i].setStatus(Status.Available);
				}
				
				for(int j = 0; j < 3; j++) {
					for(int i = 0; i < Math.max(Math.max(goldC, silverC), regularC); i++) {
						if(j < 3 && i < gold.length) {
							Ride temp = RandomGenerator.selectRide(allRides);
							if(gold.length > 0) {
								temp.addPersonOnRideInitially(gold[i]);
								gold[i].addRideOnPersonLine(temp);
							}
						}
						if(j < 2 && i < silver.length) {
							Ride temp = RandomGenerator.selectRide(allRides);
							if(silver.length > 0) {
								temp.addPersonOnRideInitially(silver[i]);
								silver[i].addRideOnPersonLine(temp);
							}
						}
						if(j < 1 && i < regular.length) {
							Ride temp = RandomGenerator.selectRide(allRides);
							if(regular.length > 0) {
								temp.addPersonOnRideInitially(regular[i]);
								regular[i].addRideOnPersonLine(temp);
							}
						}
					}
				}
				
				int actualTimer = 0;
				
				System.out.println("----------------------------------------------------------");
				System.out.println("At time: "+ actualTimer + "\n");
				System.out.println("Blue Scream of Death - Time remaining: " + durationBdos + " min");
				BSOD.printAllQueuesOnRide();
				System.out.println("Kingda Knuth - Time remaining: " + durationKk + " min");
				KK.printAllQueuesOnRide();
				System.out.println("i386 Tower of Terror - Time remaining: " + durationToT + " min");
				ToT.printAllQueuesOnRide();
				System.out.println("GeForce - Time remaining: " + durationGf + " min");
				GF.printAllQueuesOnRide();
				
				printCustomerLineForRegular(regular);
				printCustomerLineForSilver(silver);
				printCustomerLineForGold(gold);
				
				int timerForBSOD = 0;
				int timerForKk = 0;
				int timerForToT = 0;
				int timerForGf = 0;
				
				while(simLength > 0) {
					
					timerForBSOD++;
					timerForKk++;
					timerForToT++;
					timerForGf++;
					
					if(timerForBSOD == durationBdos) {
						BSOD.removeCustomer(allRides);
						simLength-=durationBdos;
						timerForBSOD = 0;
					}
					if(timerForKk == durationKk) {
						KK.removeCustomer(allRides);
						simLength-=durationKk;
						timerForKk = 0;
					}
					if(timerForToT == durationToT) {
						ToT.removeCustomer(allRides);
						simLength-=durationToT;
						timerForToT = 0;
					}
					if(timerForGf == durationGf) {
						GF.removeCustomer(allRides);
						simLength-=durationGf;
						timerForGf = 0;
					}
					
					actualTimer++;
					System.out.println("----------------------------------------------------------");
					System.out.println("At time: "+ actualTimer + "\n");
					System.out.println("Blue Scream of Death - Time remaining: " + (durationBdos-timerForBSOD) + " min");
					BSOD.printAllQueuesOnRide();
					System.out.println("Kingda Knuth - Time remaining: " + (durationKk-timerForKk) + " min");
					KK.printAllQueuesOnRide();
					System.out.println("i386 Tower of Terror - Time remaining: " + (durationToT-timerForToT) + " min");
					ToT.printAllQueuesOnRide();
					System.out.println("GeForce - Time remaining: " + (durationGf-timerForGf) + " min");
					GF.printAllQueuesOnRide();
					
					printCustomerLineForRegular(regular);
					printCustomerLineForSilver(silver);
					printCustomerLineForGold(gold);
					
				}
				
				int totalGold = BSOD.getNumGoldRide() + KK.getNumGoldRide() + ToT.getNumGoldRide() + GF.getNumGoldRide();
				int totalSilver = BSOD.getNumSilverRide() + KK.getNumSilverRide() + ToT.getNumSilverRide() + GF.getNumSilverRide();
				int totalRegular = BSOD.getNumRegularRide() + KK.getNumRegularRide() + ToT.getNumRegularRide() + GF.getNumRegularRide();
				
				int totalBSOD = BSOD.getNumBSOD() + KK.getNumBSOD() + ToT.getNumBSOD() + GF.getNumBSOD();
				int totalKK = BSOD.getNumKK() + KK.getNumKK() + ToT.getNumKK() + GF.getNumKK();
				int totalToT = BSOD.getNumToT() + KK.getNumToT() + ToT.getNumToT() + GF.getNumToT();
				int totalGF = BSOD.getNumGF() + KK.getNumGF() + ToT.getNumGF() + GF.getNumGF();
				
				
				System.out.println("On average, Gold customers have taken " + ((double)totalGold/goldC) + " rides");
				System.out.println("On average, Silver customers have taken " + (((double)totalSilver)/silverC) + " rides");
				System.out.println("On average, Regular customers have taken " + (((double)totalRegular)/regularC) + " rides" + "\n");
				
				System.out.println("BSOD has completed rides for " + totalBSOD + " people");
				System.out.println("KK has completed rides for " + totalKK + " people");
				System.out.println("ToT has completed rides for " + totalToT + " people");
				System.out.println("GF has completed rides for " + totalGF + " people");
			}
		}
		/**
		 * If there is an error one of these exceptions will be printed based on the error
		 * 
		 * InputMismatchException- prints a message if the input is incorrect
		 * 
		 * Catches any possible errors and returns a message about the error
		 */
		catch(InputMismatchException e) {
			System.out.println("There was an error try again");
		}
		catch (Exception x) {
			x.printStackTrace();
		}
		
	}
	
	/**
	 * This method gets the highest status from a person's ride list
	 * 
	 * @param p
	 * Person's line being check
	 * @return
	 * Return the highest status from a person's ride list
	 */
	public static Status getLargestStatus(Person p) {
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
	
	/**
	 * This method prints the rides and status for regular members
	 * 
	 * @param array
	 * Array being used to print out the ride(s) and status from a regular member
	 * @return
	 * Returns string representation of regular members
	 */
	public static String printCustomerLineForRegular(Person [] array) {
		System.out.println("Regular Customers: \n");
		System.out.println("Num  Line 1   Status");
		System.out.println("--------------------");
		for(int i = 0; i < array.length; i++) {
				System.out.printf("%-5s%-9s%-12s\n", i+1 + ". ", array[i].getLines().get(0).getName(), array[i].getStatus());
			}
		System.out.println("");
		return "";
	}
	
	/**
	 * This method prints the rides and status for silver members
	 * 
	 * @param array
	 * Array being used to print out the ride(s) and status from a silver member
	 * @return
	 * Returns string representation of silver members
	 */
	public static String printCustomerLineForSilver(Person [] array) {
		System.out.println("Silver Customers: \n");
		System.out.println("Num  Line 1   Line 2   Status");
		System.out.println("-----------------------------");
		for(int i = 0; i < array.length; i++) {
				System.out.printf("%-5s%-9s%-9s%-12s\n", i+1 + ". ", array[i].getLines().get(0).getName(), array[i].getLines().get(1).getName(), array[i].getStatus());
			}
		System.out.println("");
		return "";
	}
	
	/**
	 * This method prints the rides and status for gold members
	 * 
	 * @param array
	 * Array being used to print out the ride(s) and status from a gold member
	 * @return
	 * Returns string representation of gold members
	 */
	public static String printCustomerLineForGold(Person [] array) {
		System.out.println("Gold Customers: \n");
		System.out.println("Num  Line 1   Line 2   Line 3   Status");
		System.out.println("--------------------------------------");
		for(int i = 0; i <array.length; i++) {
				System.out.printf("%-5s%-9s%-9s%-9s%-12s\n", i+1 + ". ", array[i].getLines().get(0).getName(), array[i].getLines().get(1).getName(), array[i].getLines().get(2).getName(), array[i].getStatus());
			}
		System.out.println("");
		return "";
	}
	
	public boolean doYouWantToUsePersonalProbabilities() {
		Scanner input = new Scanner(System.in);
		int n = 0;
		System.out.println("Type 1 for personal probabilites, Type 2 for reuglar");
		n = input.nextInt();
		if(n == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
