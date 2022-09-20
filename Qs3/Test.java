// a class for testing
public class Test{
	public static void main(String[] args){
		Grad student1 = new Grad("Ali Joseph", "B212167B");
		UnderGrad student2 = new UnderGrad("Ellen Sango", "B225421B");
		
		student1.setGrade(75.3);
		student2.setGrade(72.0);
		
		System.out.print("Under Graduate\n" + student2.getName() + " : ");
		System.out.print(student2.getID() + "\n Grade:" + student2.getGrade());
		System.out.println("\nPassed: " + student2.isPassed(student2.getGrade()));
		
		System.out.println("----------------------------");
		
		System.out.print("Graduate\n" + student1.getName() + " : ");
		System.out.print(student1.getID() + "\n Grade:" + student1.getGrade());
		System.out.println("\nPassed: " + student1.isPassed(student1.getGrade()));
	}	

}

abstract class Student{
	//data members
	protected String name;
	protected String address;
	protected int age;
	protected String ID;
	protected double grade;
	
	// methods
	public abstract boolean isPassed(double grade);
	// getters
	public String getID(){
		return (this.ID);
	}
	public String getName(){
		return (this.name);
	}
	public double getGrade(){
		return (this.grade);
	}
	// setters
	public void setGrade(double grade){
		this.grade = grade;
	}
}

class UnderGrad extends Student{
	//constructor
	UnderGrad(String name, String ID){
		this.name = name;
		this.ID = ID;
	}
	// override isPassed
	public boolean isPassed(double grade){
		if (grade > 70.0){
			return (true);
		}
		return (false);
	}
}

class Grad extends Student{
	//constructor
	Grad(String name, String ID){
		this.name = name;
		this.ID = ID;
	}	
	// override isPassed
	public boolean isPassed(double grade){
		if (grade > 80.0){
			return (true);
		}
		return (false);
	}
}