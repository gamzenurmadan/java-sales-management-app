package app;

/**   
*Customer object class with its constructor and getter methods.
*The method that checks the equality of customers and toString method can be found here. 
*/

public class Customer {

	private String id;
	private String name;
	private String email;
	private String country;
	private String address;

	public Customer(String id, String name, String email, String country, String address) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.country = country;
		this.address = address;
	}

	public Customer(Customer aCustomer) {
		this.id = aCustomer.getId();
		this.name = aCustomer.getName();
		this.email = aCustomer.getEmail();
		this.country = aCustomer.getCountry();
		this.address = aCustomer.getAddress();
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getCountry() {
		return country;
	}

	public String getAddress()

	{
		return address;
	}

	public boolean equals(Customer aCustomer) {
		if (this.address.equals(aCustomer.getAddress())
				&& this.country.equals(aCustomer.getCountry())
				&& this.email.equals(aCustomer.getEmail())
				&& this.id.equals(aCustomer.getId())
				&& this.name.equals(aCustomer.getName()))
			return true;
		return false;
	}

	public String toString() {
		String toString = "ID: " + this.id
				+ " name: " + this.name
				+ " E-mail: " + this.email
				+ " Country: " + this.country
				+ " Address: " + this.address;
		return toString;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
