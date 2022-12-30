package app;
/**   
*This class creates an array that includes all the customers 
*Also a method that finds the customer by its id
*/

public class Customers {
    private Customer[] customerArray;

    public Customers(Customer[] customerArray) {
        this.customerArray = cloneCustomerArray(customerArray);
    }

    public Customers(Customers aCustomers) {
        this.customerArray = cloneCustomerArray(aCustomers.getCustomerArray());
    }

    public Customer getCustomerById(String id) {
        for (int i = 0; i < customerArray.length; i++) {
            if (customerArray[i].getId().equals(id)) {
                return customerArray[i];
            }
        }
        return null;
    }

    public Customer[] getCustomerArray() {
        Customer[] customerArrayToPopulate = cloneCustomerArray(this.customerArray);
        return customerArrayToPopulate;
    }

    public void setCustomerArray(Customer[] customerArray) {
        this.customerArray = cloneCustomerArray(customerArray);
    }

    public boolean equals(Customers aCustomers) {
        Customer[] customerArray1 = this.getCustomerArray();
        Customer[] customerArray2 = aCustomers.getCustomerArray();

        if (customerArray1.length != customerArray2.length)
            return false;

        for (int i = 0; i < customerArray1.length; i++) {
            if (!customerArray1[i].equals(customerArray2[i]))
                return false;
        }

        return true;
    }

    public String toString() {
        String toString = "Customer IDs of the customers in this array: ";
        Customer[] customerArray = this.getCustomerArray();
        for (int i = 0; i < customerArray.length; i++) {
            if (i == 0) {
                toString = toString + " " + customerArray[i].getId();
            }
            toString = toString + ", " + customerArray[i].getId();
        }

        return toString;
    }

    private Customer[] cloneCustomerArray(Customer[] customerArrayToCopy) {
        Customer[] customerArrayToPopulate = new Customer[customerArrayToCopy.length];
        for (int i = 0; i < customerArrayToCopy.length; i++) {
            customerArrayToPopulate[i] = new Customer(customerArrayToCopy[i]);
        }
        return customerArrayToPopulate;
    }
}
