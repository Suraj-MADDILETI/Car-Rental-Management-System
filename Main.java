package carRental;

public class Main {

	public static void main(String[] args) {
		CarRentalSystem rentalSystem = new CarRentalSystem();
		
		Car car1 = new Car("C001", "Audi", "A4", 99);
		Car car2 = new Car("C002", "Jaguar", "F-Pace", 79);
		Car car3 = new Car("C003", "Aston Martin", "DB11", 119);
		Car car4 = new Car("C004", "Porsche", "911 GT3", 149);
		Car car5 = new Car("C005", "Ferrari", "Purosangue SUV V12", 199);
		
		rentalSystem.addCar(car1);
		rentalSystem.addCar(car2);
		rentalSystem.addCar(car3);
		rentalSystem.addCar(car4);
		rentalSystem.addCar(car5);
		
		rentalSystem.menu();

	}

}
