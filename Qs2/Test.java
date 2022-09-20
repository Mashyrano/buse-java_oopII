// Test library to test Book Object
public class Test{
	
	public static void main(String[] args){
		// test the constructors
		Book b1 = new Book();
		Book b2 = new Book("Animal Farm");
		Book b3 = new Book("Atomic Habits", "James Clear");
		
		b1.display();
		b2.display();
		b3.display();
		// testing the getters and setters
		System.out.print("Before setting new b2 name is "+b2.getAuthor());
		b2.setAuthor("George Orwell");
		System.out.print("\nAfter setting new b2 name is "+b2.getAuthor());
		// testing the equals method
		if (b2.equals(b3)){
			System.out.println("\nThey are equal");
		}
		else{
			System.out.println("\nThey are not equal");
		}
		b1.setTitle("Animal Farm");
		b1.setAuthor("George Orwell");
		if (b2.equals(b1)){
			System.out.println("They are equal");
		}
		else{
			System.out.println("They are not equal");
		}
		// testing get initials
		Book b4 = new Book("Time up", "John Berry Barnes");
		String initials1 = b3.getInitials();
		String initials2 = b4.getInitials();
		
		System.out.println(b3.getAuthor() + " equals " + initials1);
		System.out.println(b4.getAuthor() + " equals " + initials2);
	}
	
}

class Book{
	// member variables
	public String title;
	public String author;
	public int id;
	public static int numOfObjects = 1;
		
	// constructors
	Book(){
		this.title = "unknown";
		this.author = "unknown";
		this.id = 0;
	}	
	Book(String title){
		this.title = title;
		this.author = "unknown";
		this.id = numOfObjects;
		numOfObjects++;
	}	
	Book(String title, String author){
		this.title = title;
		this.author = author;
		this.id = numOfObjects;
		numOfObjects++;
	}
	// getters	
	public String getTitle(){
		return (this.title);
	}
	public String getAuthor(){
		return (this.author);
	}
	public int getId(){
		return (this.id);
	}	
	// setters
	public void setAuthor(String author){
		this.author = author;
	}
	public void setTitle(String title){
		this.title = title;
	}	
	// equals method
	public boolean equals(Book b){
		if (this.author.compareTo(b.author) != 0){
			return (false);
		}
		if (this.title.compareTo(b.title) != 0){
			return (false);
		}
		return (true);
	}
	/* getInitials
	 * 
	 * Returns a string containing the first letters of authors names
	 */
	public String getInitials(){
		int i = 0;
		char space = ' ';
		
		String initials = "";
		if (this.author.compareTo("unknown") == 0){
			return ("No name");
		}
		initials += this.author.charAt(i);
		for (i = 0; i < this.author.length(); i++){
			if (this.author.charAt(i) == space){
				initials += '.';
				initials += this.author.charAt(i+1);
			}
		}
		return (initials);
	}
	// display method for testing purposes
	public void display(){
		String strId = Integer.toString(this.id);
		System.out.println("Author:\t" + this.author);
		System.out.println("Book title:\t" + this.title);
		System.out.println("Book Id:\t" + this.id);
		System.out.println("----------------------");
	}
}






