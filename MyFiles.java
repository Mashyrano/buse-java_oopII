import java.io.*;
import java.util.Scanner;
import java.util.NoSuchElementException;

class MyFiles{
	/*
	* main: entry for the program
	*/	
	public static void main(String[] args){
		//DisplayStudentDetails();
		//countStudents();
		//DisplayImportantDetails();
		//DisplayAverageAge();
		//calculateAverageMark();
		//createSummary();
		//addStudents();
		Scanner sc = new Scanner(System.in);
		// menu string
		String menu = "\n==============================\nMENU\n";
		menu = menu + "==============================\n";
		menu = menu + "0.Quit\n1.DisplayStudentDetails\n";
		menu = menu + "2.countStudents\n3.DisplayImportantDetails\n";
		menu = menu + "4.DisplayAverageAge\n5.calculateAverageMark\n";		   
		menu = menu + "6.createSummary\n7.addStudents\n\n$:";
					  
		while (true){
			System.out.print(menu);
			try{
				int option = sc.nextInt();

				switch(option){
					case 0:
						System.out.println("Logging Off");
						System.exit(0);
					case 1:
						DisplayStudentDetails();
						break;
					case 2:
						countStudents();
						break;
					case 3:
						DisplayImportantDetails();
						break;
					case 4:
						DisplayAverageAge();
						break;
					case 5:
						calculateAverageMark();
						break;
					case 6:
						createSummary();
						break;
					case 7:
						addStudents();
						break;
					default:
						System.out.println("Invalid option");
				}
			}
			catch(java.util.InputMismatchException e){
				System.out.println("Please enter a number next time\n");
				System.exit(0);
			}
		}
	}
	/*
	*Displays all details of each row
	*/
	public static void DisplayStudentDetails(){
		try{
			FileReader fr = new FileReader("StudentInfo.doc");
			Scanner sc = new Scanner(fr);
			while (sc.hasNextLine()){
				String student = sc.nextLine();
				System.out.println(student);
			}
			fr.close();//close file
		}
		catch(FileNotFoundException e){
			System.out.println("Oops: " + e);
		}
		catch(IOException e){
			System.out.println("Oops: " + e);
		}		
	}
	/*
	* counts all students and displays the total
	*/
	public static void countStudents(){
		try{
			FileReader fr = new FileReader("StudentInfo.doc");
			Scanner sc = new Scanner(fr);
			int count = 0;
			while (sc.hasNextLine()){
				sc.nextLine();
				count++;
			}
			System.out.println("$: Number of Students: " + count);
			fr.close();//close file
		}
		catch(FileNotFoundException e){
			System.out.println("Oops: " + e);
		}	
		catch(IOException e){
			System.out.println("Oops: " + e);
		}
	}
	/*
	* displays only the surname, initial , age and final mark
	*/
	public static void DisplayImportantDetails(){
		try{
			FileReader fr = new FileReader("StudentInfo.doc");
			Scanner sc = new Scanner(fr);
			while (sc.hasNextLine()){
				String student = sc.nextLine();
				Scanner sc2 = new Scanner(student);
				while (sc2.hasNext()){
					String surname = sc2.next();
					char initial = sc2.next().charAt(0);
					String schoolName = sc2.next();
					sc2.next();
					int age = sc2.nextInt();
					for (int i=0; i<3; i++){
						sc2.next();
					}
					double finalMark = sc2.nextDouble();
					System.out.printf("%s %s %s %d %.2f\n", surname, initial, schoolName, age, finalMark);
				}				
			}
			fr.close();//close file
		}
		catch(FileNotFoundException e){
			System.out.println("Oops: " + e);
		}
		catch(IOException e){
			System.out.println("Oops: " + e);
		}		
	}
	/*
	* calculatethe mean age and displays it
	*/
	public static void DisplayAverageAge(){
		try{ 
			FileReader fr = new FileReader("StudentInfo.doc");
			Scanner sc = new Scanner(fr);
			int age, i = 0, sum = 0;
			String s;
			while(sc.hasNext())
			{
				s = sc.nextLine();
				Scanner scan2 = new Scanner(s);
				/* skip columns up to age */
				for (int j=0; j < 4; j++){
					scan2.next();
				}
				age = scan2.nextInt();
				sum += age;
				i++;
			}
			int avg = sum/i;
			System.out.println("$: average age = " + avg);	
			fr.close();//close file
		}
		catch(FileNotFoundException e){
			System.out.println("Oops: " + e);
		}
		catch(IOException e){
			System.out.println("Oops: " + e);
		}
	}
	/*
	* calculates the average of the three marks
	*/
	public static void calculateAverageMark(){
		try{ 
			FileReader fr = new FileReader("StudentInfo.doc");
			Scanner sc = new Scanner(fr);
			double mark1, mark2, mark3, avg;
			while(sc.hasNext())
			{
				String s = sc.nextLine();
				Scanner scan2 = new Scanner(s);
				/* skip columns up to first mark */
				for (int j=0; j < 6; j++){
					scan2.next();
				}
				mark1 = scan2.nextDouble();
				mark2 = scan2.nextDouble();
				mark3 = scan2.nextDouble();
	
				avg = (mark1 + mark2 + mark3) / 3;
				System.out.printf("$: average mark = %.2f\n", avg);	
			}
			fr.close(); //close file
		}
		catch(FileNotFoundException e){
			System.out.println("Oops: " + e);
		}
		catch(IOException e){
			System.out.println("Oops: " + e);
		}
	}
	/*
	*calculates average mark and determines the grade
	*write to a new file some student details and the grade
	*/
	public static void createSummary(){
		// create directory
		File f = new File("StudentRecords");
		f.mkdir();
		//create file
		try{
			File f1 = new File("StudentRecords/StudentSummary.doc");
			// create a file writer
			FileWriter fw = new FileWriter(f1);
			// create a file reader
			FileReader fr = new FileReader("StudentInfo.doc");
			Scanner sc = new Scanner(fr);
			double mark1, mark2, mark3, avg;
			String grade;
			while(sc.hasNext())
			{
				String s = sc.nextLine();
				Scanner scan2 = new Scanner(s);
				// Extract Student details
				String surname = scan2.next();
				String name = scan2.next();
				String school = scan2.next();
				// skip to first mark
				for (int i=0; i < 3; i++)
				{
					scan2.next();
				}
				mark1 = scan2.nextDouble();
				mark2 = scan2.nextDouble();
				mark3 = scan2.nextDouble();
				//calculate average
				avg = (mark1 + mark2 + mark3) / 3;
				//determine grade
				if (avg < 25.0){
					grade = "BELOW AVERAGE";
				}
				else if (avg < 27.0){
					grade = "AVERAGE";
				}
				else{
					grade = "GOOD";
				}
				//write to file
				fw.write(surname + " " + name + " "  + school + " "  + String.format("%.2f", avg) + " "  + grade + "\n");	
			}		
			// clean up and close files
			fr.close();
			fw.flush();
			fw.close();
			System.out.println("\n$: Summary file created");
		}
		catch(FileNotFoundException e){
			System.out.println("Oops: " + e);
		}
		catch(IOException e){
			System.out.println("Oops: " + e);
		}
	}
	public static void addStudents(){
		Scanner sc = new Scanner(System.in);
		File f = new File("StudentInfo.doc");
		try{
			System.out.println("Enter student surname");
			String surname = sc.next();//
			System.out.println("Enter student name");
			String name = sc.next();//
			System.out.println("Enter school attended");
			String school = sc.next();//
			System.out.println("Enter Province");	
			String province = sc.next();//
			System.out.println("Enter age");	
			int age = sc.nextInt();//
			System.out.println("Enter gender");
			String gender = sc.next();//
			System.out.println("Enter first mark");
			double mark1 = sc.nextDouble();
			System.out.println("Enter second mark");
			double mark2 = sc.nextDouble();		
			System.out.println("Enter third mark");
			double mark3 = sc.nextDouble();
			// string doubles
			String mark1s = Double.toString(mark1);
			String mark2s = Double.toString((mark2));
			String mark3s = Double.toString((mark3));

			try{
				FileWriter fw = new FileWriter(f, true); // true for append
				fw.write(surname + " " + name + " "  + school + " ");
				fw.write(province + " " + age + " " + gender + " ");
				fw.write(String.format("%.2f", mark1) + " ");
				fw.write(String.format("%.2f", mark2) + " ");
				fw.write(String.format("%.2f", mark3) + "\n");
				fw.close();
				System.out.println("\n$: "+surname + " " + name.charAt(0) + " Added");
			}
			catch(IOException e){
				System.out.println("Oops: " + e);
			}
		}
		catch(java.util.InputMismatchException e){
			System.out.println("Error: Please enter the correct input data type\n");
		}
	}
}





















