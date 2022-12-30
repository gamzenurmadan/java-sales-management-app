package app;

/**
 * Sales object class with its constructor and getter methods.
 * The method that checks the equality of sales objects can be found here.
 */

public class Sales { // üç tane yaratıp sales management içine koymak lazım
    private String id;
    private Customer customer;
    private Product product;
    private String salesDate;
    private double salesPrice;

    public Sales(String id, Customer customer, Product product, String salesDate, double salesPrice) {
        this.id = id;
        this.customer = new Customer(customer);
        this.product = new Product(product);
        this.salesDate = salesDate;
        this.salesPrice = salesPrice;
    }

    public Sales(Sales aSales) {
        this.id = aSales.getId();
        this.customer = aSales.getCustomer();
        this.product = aSales.getProduct();
        this.salesDate = aSales.getSalesDate();
        this.salesPrice = aSales.getSalesPrice();
    }

    public Customer getCustomer() {
        return new Customer(this.customer);
    }

    public String getId() {
        return id;
    }

    public Product getProduct() {
        return new Product(this.product);
    }

    public String getSalesDate() {
        return salesDate;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public boolean equals(Sales aSales) {
        if (this.id.equals(aSales.getId())
                && this.salesDate.equals(aSales.getSalesDate())
                && this.salesPrice == aSales.getSalesPrice()
                && this.product.equals(aSales.getProduct())
                && this.customer.equals(aSales.getCustomer()))
            return true;
        return false;
    }

    public String toString() {
        String toString = "ID: " + this.getId() + " Customer ID: " + this.getCustomer().getId() + " Product ID: "
                + this.getProduct().getId() + " Sales Date: " + this.getSalesDate() + " Sales Price: "
                + this.getSalesPrice();
        return toString;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCustomer(Customer customer) {
        this.customer = new Customer(customer);
    }

    public void setProduct(Product product) {
        this.product = new Product(product);
    }

    public void setSalesDate(String salesDate) {
        this.salesDate = salesDate;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }
}
