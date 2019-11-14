package java_Rockets;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Rockets_main {
	Scanner sc = new Scanner(System.in);
	boolean executeRockets_main = true;
	ArrayList<Rocket> myRockets = new ArrayList<Rocket>();
	
	public void showRockets() {
		
	}
	
	
	public void main() {
		
		System.out.println("Soy el main de rockets");
		
		
		Rocket my1stRocket = new Rocket("32WESSDS", 3);//Utiliza el constructor Propeller() que los inicializa en currentPower = 0
		my1stRocket.setMaxPropPower(new int[] { 10,30,80 });		
		System.out.println(my1stRocket.getCodeName()+" "+my1stRocket.getAllMaxPropPower());
		myRockets.add(my1stRocket);		
		
		Rocket my2ndRocket = new Rocket("LDSFJA32", 6);
		my2ndRocket.setMaxPropPower(new int[] { 30,40,50,50,30,10 });		
		System.out.println(my2ndRocket.getCodeName()+" "+my2ndRocket.getAllMaxPropPower());
		myRockets.add(my2ndRocket);	
		
		
		
		
		do {
			int userChoice;
			System.out.println("What do you need?: \n\t 1-SHOW ROCKETS WITH ITS MAXPOWER \n\t 2-CHANGE POWER \\n\\t 3-EXIT APP");
			userChoice = sc.nextInt();
			
			switch (userChoice) {
			case 1:
				//this.showRockets();//For myRockets (Arraylist of Rockets)
				System.out.println(my1stRocket.getCodeName()+" "+my1stRocket.getAllMaxPropPower());
				System.out.println(my2ndRocket.getCodeName()+" "+my2ndRocket.getAllMaxPropPower());
				
				break;

			case 2:
				//changePower();
				
				
				//ExecutorService executor = Executors.newFixedThreadPool(10);
				//ThreadPoolExecutor executor = new Thread
				
				
				
				break;

			case 3:
				this.executeRockets_main = false;
				break;

			default:
				break;
			}
			
			
		}while(this.executeRockets_main);
		
		////AFTER EXIT DE USER INTARFACE APP, COMES PREVIUS APP WITH CORRECT THREAD IMPLEMENTATION.
		//Change the .start() from the Propeller itself to the rocket. Was a wrong aproach to thread management.
		//That is the correct way because the rocket is the one who ask for changing the power of each Propeller
		//Was in one PUBLIC VOID METHOD (setCurrentPower()) of the "thread object"
		//Move to Rocket set_target_power() who do the .start on each propeller of the Arraylist
		
		//NEXT STEP. Create a threadpool with n threadpools, where n is the number of propeller.
		//When new power is asked, create the threadpool, prepare and execute()
		System.out.println("Como Rockets_main te digo adios \n");
		
		
		
		
		
		
		
		
		System.out.println("y ahora... Yapa:");
		
		
		
		String prevRocket1PropState = my1stRocket.getAllCurrentPower();
		String prevRocket2PropState = my2ndRocket.getAllMaxPropPower();
			
		
		///TO DO. CREATE USER INTERACTION
		my1stRocket.setAllTargetPropPower(new int[] { 5, 10, 20});
		my2ndRocket.setAllTargetPropPower(new int[] { 5, 0, 10, 5, 0, 10});
		
		
				
		do {
					
			String currentRocket1PropState = my1stRocket.getAllCurrentPower();
			String currentRocket2PropState = my2ndRocket.getAllCurrentPower();
			boolean changeInAccel = false;
			
			if (!currentRocket1PropState.contentEquals(prevRocket1PropState)) {
				//System.out.print(" rocket1 :" + currentRocket1PropState);
				prevRocket1PropState = currentRocket1PropState;
				changeInAccel = true;
			}
			if (!currentRocket2PropState.contentEquals(prevRocket2PropState)) {
				//System.out.print("rocket2 :" + currentRocket2PropState);
				prevRocket2PropState = currentRocket2PropState;
				changeInAccel = true;				
			}
			
			
			if(changeInAccel) {
				System.out.print("Propeller State on each Rocket:");
				System.out.print(" \t Rocket1 :" + currentRocket1PropState);
				System.out.print(" \t Rocket2 :" + currentRocket2PropState);
				System.out.println();
			}
			
			
		}while(true);
		
		
		
	}


}
