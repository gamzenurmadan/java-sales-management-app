package app;

/**   
*Product object class with its constructor and getter methods.
*The method that checks the equality of product objects and toString method can be found here. 
*/

public class Product {
	private String id;
	private String title;
	private double rate;
	private int numberOfReview;
	private int price;

	public Product(String id, String title, double rate, int numberOfReview, int price) {
		this.id = id;
		this.title = title;
		this.rate = rate;
		this.numberOfReview = numberOfReview;
		this.price = price;
	}

	public Product(Product aProduct) {
		this.id = aProduct.getId();
		this.title = aProduct.getTitle();
		this.rate = aProduct.getRate();
		this.numberOfReview = aProduct.getNumberOfReview();
		this.price = aProduct.getPrice();
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public double getRate() {
		return rate;
	}

	public int getNumberOfReview() {
		return numberOfReview;
	}

	public int getPrice() {
		return price;
	}

	public String toString() {
		String toString = "ID: " + this.getId()
				+ " Title: " + this.getTitle()
				+ " Rate: " + this.getRate()
				+ " Number of reviews: " + this.getNumberOfReview()
				+ " Price: " + this.getPrice();
		return toString;
	}

	public boolean equals(Product aProduct) {
		if (this.id.equals(aProduct.getId())
				&& this.numberOfReview == aProduct.getNumberOfReview()
				&& this.price == aProduct.getPrice()
				&& this.rate == aProduct.getRate()
				&& this.title.equals(aProduct.getTitle()))
			return true;
		return false;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public void setNumberOfReview(int numberOfReview) {
		this.numberOfReview = numberOfReview;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
