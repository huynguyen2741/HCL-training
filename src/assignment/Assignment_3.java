package assignment;

// Washing Machine class
abstract class Washing_Machine {
	public abstract void switchOn();
	public int acceptClothes(int noOfClothes) {
		return noOfClothes;
	}
	public abstract void acceptDetergent();
	public abstract void switchOff();
	
}

//Student class
class Student {
	public boolean average(int mark1,int mark2, int mark3) {
		
		double average = ( mark1 + mark2 + mark3)/3;
		boolean pass = average > 50 ? true: false;
		return pass;
	}
	
	public String input(String name) {return name;}
}

//Bank class
class Bank {
	public double deposit(double amount, double balance) {
//		placeholder for total.
		double total = 0;
		if (amount < 0 || balance < 0) {
			System.out.println("Error in input");
//			signify error
			total = -1;
		}
		else {
			total = amount + balance;
		}
		return total;
	}
	
	public double withdraw (double amount, double balance) {
		if (balance >= amount) {
			return balance -= amount; 
		}
		return 0;
	}
}

//Question 4 - Vehicle and Truck
//Pdf file for question 5 in same folder
class Vehicle{
	int vehicleNo;
	String model;
	String manufacturer;
	String color = "Gray";
}

class Truck extends Vehicle{
	int loadingCap = 100;
	public void changeAttributes() {
		this.color = "White";
		this.loadingCap = 200;
		System.out.print("Color: " + this.color + "\nLoading cap: " + this.loadingCap);
	}
}


//testing for question 4
public abstract class Assignment_3 {
	public static void main (String[] args) {
		Truck t = new Truck();
		t.changeAttributes();
	}	
}












