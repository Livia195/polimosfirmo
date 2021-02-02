package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutSourcedEmployee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of employees: ");
		Integer n = sc.nextInt();
		List <Employee> list = new ArrayList<>();
		
		for(int i=1; i<=n ; i++) {
			System.out.println("Employee #"+ i + "data: ");
			System.out.print("Outsourced (y/n)"); 
			char ots =  sc.next().charAt(0); 
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Hours: ");
			int hour = sc.nextInt();
			System.out.print("Value per hour: ");
			Double value = sc.nextDouble();
			
			
			if (ots== 'y') {
			
				System.out.print("Additional charge: ");
				Double ac = sc.nextDouble();
				Employee employee = new OutSourcedEmployee(name, hour, value, ac);
				list.add(employee);
				
			}
			
			else {
				Employee employee = new Employee(name, hour, value);
				list.add(employee);
				
				}
			
		}
			
	System.out.println("-----------------------------------------------------");
		System.out.println("PAYMENTS: ");
		
			for (Employee emp : list) {
				System.out.println(emp.getName() + " - $ " + String.format("%.2f", emp.payment()));
			}
		
sc.close();
	}

}
