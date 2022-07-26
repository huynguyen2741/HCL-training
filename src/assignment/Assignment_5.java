package assignment;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
//import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



interface getEmployee{
	Employee getEmployeeInfo(int id,String name,int age,String gender,String dept,int yearOfJoining,double salary);
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Employee{
//	the properties are id,name,age,gender,dept,yearofjoining,salary;
	int id;
	String name;
	int age;
	String gender;
	String dept;
	int yearOfJoining;
	double salary;

//	Based on the context, try to create hard coded data; Use only java 8 features

}


public class Assignment_5 {
	static LinkedList<Employee> list = new LinkedList<>();
	public static void main(String[] args) {

		list.add(new Employee(1,"Alen",21,"male","IT",2020,6000));
		list.add(new Employee(2,"Oson",32,"male","Maintenance",2008,3000));
		list.add(new Employee(3,"Hiko",27,"female","Maintenance",2010,7000));
		
//		countGender(list);
//		averageAge(list);
//		maxPay(list);
//		joinLater(list);
//		oldest(list);
//		countDept(list);
//		mainDept(list);
//		averageSalary(list);
//		differentAge(list);
		getNames(list);
	}
	
	
//	i) How many male and female employees are there in this organization?
	static void countGender(LinkedList<Employee> list) {
		int male= (int)list.stream()
				.filter(l -> l.getGender().equalsIgnoreCase("male")).count();
		int female = (int)list.stream()
				.filter(l -> l.getGender().equalsIgnoreCase("female")).count();
		
		System.out.print("Number of male: " + male + "\nNumber of female: " + female);
	}

	
//	ii) Find out Average age of male and female emps?
	static void averageAge(LinkedList<Employee> list) {
		Integer total_age = list.stream()
				.filter(e -> e.getGender().equalsIgnoreCase("male"))
				.mapToInt(e -> e.getAge())
				.sum(); 
		int total_male= (int)list.stream()
				.filter(l -> l.getGender().equalsIgnoreCase("male")).count();
		
		System.out.printf("Average age for male: %d\n",total_age/total_male );
		
		
		total_age = list.stream()
				.filter(e -> e.getGender().equalsIgnoreCase("female"))
				.mapToInt(e -> e.getAge())
				.sum(); 
		int total_female = (int)list.stream()
				.filter(l -> l.getGender().equalsIgnoreCase("female")).count();
		System.out.printf("Average age for female: %d",total_age/total_female );
		
	}
	
//	iii) Find the highest paid employee in this org?
	static void maxPay(LinkedList<Employee> list) {
		double max = list.stream()
				.mapToDouble(e -> e.getSalary())
				.max()
				.getAsDouble();
		System.out.printf("Max salary is: $%.2f", max);
					
	}
	
//	iv) List all the names of employee who has joined after 2015?
	static void joinLater(LinkedList<Employee> list) {
		System.out.println("Employess joined after 2015");
		list.stream()
		.filter(e -> e.getYearOfJoining() > 2015)
		.map(name -> name.getName())
		.forEach(System.out::println);
	}
	
//	v) Find out the senior most employee in this org?
	static void oldest(LinkedList<Employee> list) {
		int age = list.stream().mapToInt(e -> e.getAge()).max().getAsInt();
		System.out.print("Oldest age is: " + age);
	}
	
//	vi)Count the number of emps in each department?
	static void countDept(LinkedList<Employee> list) {
		Map<String, Long> s = list.stream().collect(groupingBy(Employee::getDept, counting()));
		System.out.print(s);
	}
	
//	vii)Find male and female employees are in Maintenance department?
	static void mainDept (LinkedList<Employee> list) {
		list.stream().filter(e -> e.getDept().equalsIgnoreCase("Maintenance")).forEach(System.out::println);
	}
	
//	viii) Find  the average slary of male and female employees?
	static void averageSalary (LinkedList<Employee> list) {
		double average = list.stream()
							.filter( e -> e.getGender().equalsIgnoreCase("male"))
							.collect(averagingDouble(Employee::getSalary));
		System.out.printf("Average salary for male: $%.2f\n", average);
		
		average = list.stream()
				.filter( e -> e.getGender().equalsIgnoreCase("female"))
				.collect(averagingDouble(Employee::getSalary));
		System.out.printf("Average salary for female: $%.2f", average);
	}
	
//	ix) Differentiat eht the employees who are younger or equal to 30 yrs 
//	    from those employees who older than 25 years
	static void differentAge(LinkedList<Employee> list) {
		System.out.print("Under or equals 25:\n");
		list.stream().filter(e -> e.getAge() <= 25).forEach(System.out::println);
		
		System.out.print("Above 30:\n");
		list.stream().filter(e -> e.getAge() > 30).forEach(System.out::println);
	}
	
//	x) List down the names of all employees in each department?
	static void getNames(LinkedList<Employee> list) {
		System.out.print(list.stream().collect(groupingBy(Employee::getDept)).toString());
	}
	
	
	
	
	
}
