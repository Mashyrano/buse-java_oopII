import javax.swing.JOptionPane; 
/*
*an import that allows us to use the JOptionPane
*/
public class Test{
	public static void main(String[] args){
		
		String firstName = JOptionPane.showInputDialog("Enter name:");
		String lastName = JOptionPane.showInputDialog("Enter surname:");
		
		Student student1 = new Student(firstName, lastName);
		student1.printStudentDetails();
		
		String stringPay =  JOptionPane.showInputDialog("Enter payed fees:");
		Double initPay = Double.parseDouble(stringPay);
		
		student1.setFeesPaid(initPay);
		System.out.printf("\nAfter paying an initial $%.2f\n", initPay);
		student1.printStudentDetails();
		
		System.out.println("Enter details of second student");
		String firstName2 = JOptionPane.showInputDialog("Enter name:");
		String lastName2 = JOptionPane.showInputDialog("Enter surname:");
		Student student2 = new Student(firstName2, lastName2);
		student2.printStudentDetails();
	}
}

class Student{
	// data members
	private String LastName;
	private String FirstName;
	private static int numOfStudents = 0;
	private int regNumber;
	private final double feesAmount = 500;
	private double feesPaid;
	private double feesBalance;
	
	//constructor
	Student(String FirstName, String LastName){
		//initialize data members
		this.FirstName = FirstName;
		this.LastName = LastName;
		numOfStudents++;
		this.regNumber = numOfStudents;
		feesPaid = 0;
		calcFeesBalance();
	}
	
	//methods
	public double calcFeesBalance(){
		this.feesBalance = this.feesAmount - this.feesPaid;
		return (this.feesBalance);
	}
	
	public void printStudentDetails(){
		System.out.println("----------------------------------");
		System.out.println("Last Name:\t" + this.LastName);
		System.out.println("First Name:\t" + this.FirstName);
		System.out.println("reg Number:\t" + Integer.toString(this.regNumber));
		System.out.println("Fees Paid:\t" + "$" + Double.toString(this.feesPaid));
		System.out.println("Fees Balance:\t" + "$" + Double.toString(this.feesBalance));		
		System.out.println("----------------------------------");
	}	
	// setters
	public void setFirstName(String FirstName){
		this.FirstName = FirstName;
	}
	public void setLastName(String LastName){
		this.LastName = LastName;
	}
	public void setFeesPaid(double paid){
		// increament fees paid
		this.feesPaid += paid;
		calcFeesBalance(); // recalculate the balance
	}	
}






