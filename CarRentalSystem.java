package carRental;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class CarRentalSystem {
	private List<Car> cars;
	private List<Customer> customers;
	private List<Rental> rentals;
	
	public CarRentalSystem() {
		cars = new ArrayList<Car>();
		customers = new ArrayList<Customer>();
		rentals = new ArrayList<Rental>();
	}
	
	public void addCar(Car car) {
		cars.add(car);
	}
	
	public void addCustomer(Customer customer) {
		customers.add(customer);
	}
	
	public void rentCar(Car car, Customer customer, int days) {
		if(car.isAvailable()) {
			car.rent();
			rentals.add(new Rental(car, customer, days));
		}
		else {
			System.out.println("Car is not avilable for rent.");
		}
	}
	
	public void returnCar(Car car) {
		car.returnCar();
		Rental rentalToRemove = null;
		for (Rental rental: rentals) {
			if (rental.getCar() == car) {
				rentalToRemove = rental;
				break;
			} 
		}
		if (rentalToRemove != null) {
			rentals.remove(rentalToRemove);
		}
		else {
			System.out.println("Car was not returned,");
		}
	}
	
	public void menu() {
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			    System.out.println("    ~~~~~~~ Car Rental System ~~~~~~~");
			    System.out.println("      1. Rent a Car");
			    System.out.println("      2. Return a Car");
			    System.out.println("      3. Exit");
			    System.out.print("        Select your option : ");
			
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			if (choice == 1) {
				System.out.println("\n   <<<<< Rent a Car >>>>>\n");
				System.out.print("        Enter your name : ");
				String customerName = scanner.nextLine();
				
				System.out.println("\n        Available Cars \n");
				for (Car car : cars) {
					if (car.isAvailable()) {
						System.out.println("        "+car.getCarId()+" - "+car.getBrand()+" "+car.getModel());
				    }
				}
				
				System.out.print("\n        Enter car Id you want to rent : ");
				String carId =  scanner.nextLine();
				
				System.out.print("        Enter number of days for rental : ");
				int rentalDays = scanner.nextInt();
				scanner.nextLine();
				
				Customer newCustomer = new Customer("CUS" + (customers.size() + 1), customerName);
				addCustomer(newCustomer);
				
				Car selectedCar = null;
				for (Car car : cars) {
					if (car.getCarId().equals(carId) && car.isAvailable()) {
						selectedCar = car;
						break;
					}
				}
				
				if (selectedCar != null) {
					double totalPrice = selectedCar.calculatePrice(rentalDays);
					System.out.println("\n       == Rental Information ==\n");
					System.out.println("        Customer Id   : "+ newCustomer.getCustomerId());
					System.out.println("        Customer Name : "+ newCustomer.getname());
					System.out.println("        Car           : "+ selectedCar.getBrand()+" - "+selectedCar.getModel());
					System.out.println("        Rental Days   : "+ rentalDays);
					System.out.printf("        Total price    : $%.2f%n", totalPrice);
					
					System.out.print("\n        Confirm Rent (Yes / No) :");
					String confirm = scanner.nextLine();
					
					if (confirm.equalsIgnoreCase("Yes")) {
						rentCar(selectedCar, newCustomer, rentalDays);
						System.out.println("\n        Car rented successfully.\n");
					} else {
						System.out.println("\n        rented canceled.");
					}
				}
				else {
					System.out.println("\n      Invalid car selection or car not available for rent.");
				}
			}else if (choice == 2) {
				System.out.println("\n       <<<< Return a Car >>>>\n");
				System.out.print("        Enter the car Id you want to return : ");
				String carId = scanner.nextLine();
				
				Car carToReturn = null;
				for (Car car : cars) {
					if (car.getCarId().equals(carId) && !car.isAvailable()) {
						carToReturn = car;
						break;
					}
				}
				if (carToReturn != null) {
					Customer customer = null;
					for (Rental rental : rentals) {
						if (rental.getCar() == carToReturn) {
							customer = rental.getCustomer();
						    break;
						}
					}
				    if (customer != null) {
					    returnCar(carToReturn);
					    System.out.println("        Car return successfully by "+ customer.getname());
				    }else {
						System.out.println("        Car was not rented or rental information is missing.");
					}
				}else {
					System.out.println("        Invalid car Id or car is not rented.");
				}
			}else if (choice == 3) {
				break;
			}else {
				System.out.println("        Invalid option. Please enter a valid option.");
			}
		}
		System.out.println("\n        Thank you for using the Car Rental System!");
	}
}
