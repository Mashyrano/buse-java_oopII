import java.util.Scanner; 

public class Test{
	
	public static void main(String[] args){
		
		//printTabs();		
		// create Scanner object
		Scanner myScanner = new Scanner(System.in);
		
		printTabs();
		
		// prompt user and take input
		System.out.println("Enter the starting value of the table");
		int startVal = myScanner.nextInt();
		System.out.println("Enter the number of values to be displayed");
		int numDisplayed = myScanner.nextInt();
		System.out.println("Enter the increament between the values");
		int increament = myScanner.nextInt();
		
		selTabs(startVal, numDisplayed, increament);
	}
	
	static void printTabs(){
		int i;
		
		System.out.println("NUMBER" + '\t' + "SQUARE" + '\t' + "CUBE");
		
		for (i = 1; i <= 10; i++)
		{
			/* printed using formatted string */
			System.out.printf("%d\t%.0f\t%.0f\n", i, Math.pow(i, 2), Math.pow(i, 3));
		}
	}	
	
	static void selTabs(int startVal, int numDisplayed, int increament){
		
		int i;
		
		System.out.println("NUMBER" + '\t' + "SQUARE" + '\t' + "CUBE");
		
		for (i = startVal; i < startVal + numDisplayed * increament; i+=increament)
		{
			System.out.printf("%d\t%.0f\t%.0f\n", i, Math.pow(i, 2), Math.pow(i, 3));
		}
	}
	// use of function overloading since java does not support default arguments
	static void selTabs(int startVal, int numDisplayed){
		int i;
		
		System.out.println("NUMBER" + '\t' + "SQUARE" + '\t' + "CUBE");
		
		for (i = startVal; i < numDisplayed + startVal; i++)
		{
			System.out.printf("%d\t%.0f\t%.0f\n", i, Math.pow(i, 2), Math.pow(i, 3));
		}
	}
	
}