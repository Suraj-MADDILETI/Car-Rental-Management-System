package carRental;

public class Customer {
	private String customerId, name;
	
	public Customer(String customerId, String name ) {
		this.customerId = customerId;
		this.name = name;
	}
	
	public String getCustomerId() {
		return customerId;
	}

	public String getname() {
		return name;
	}

}
