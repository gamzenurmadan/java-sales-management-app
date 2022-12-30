package app;

public class Supplier {
    private Product[] productArray;

    public Supplier(Product[] productArray) {
        this.productArray = cloneProductArray(productArray);
    }

    public Supplier(Supplier aSupplier) {
        this.productArray = cloneProductArray(aSupplier.getProductArray());
    }

    public Product getProductById(String id) {
        for (int i = 0; i < productArray.length; i++) {
            if (productArray[i].getId().equals(id)) {
                return productArray[i];
            }
        }
        return null;
    }

    public Product[] getProductArray() {
        Product[] productArrayToPopulate = cloneProductArray(this.productArray);
        return productArrayToPopulate;
    }

    public void setProductArray(Product[] productArray) {
        this.productArray = cloneProductArray(productArray);
    }

    public boolean equals(Supplier aSupplier) {
        Product[] productArray1 = aSupplier.getProductArray();
        Product[] productArray2 = this.getProductArray();
        if (productArray1.length != productArray2.length)
            return false;

        for (int i = 0; i < productArray1.length; i++) {
            if (!productArray1[i].equals(productArray2[i]))
                return false;
        }
        return true;

    }

    public String toString() {
        String toString = "Product IDs of the products for this supplier: ";
        Product[] productArray = this.getProductArray();
        for(int i = 0; i < productArray.length; i++) {
            if(i == 0) {
                toString = toString + " " + productArray[i].getId();
            }
            toString = toString + ", " + productArray[i].getId();
        }

        return toString;
    }

    private Product[] cloneProductArray(Product[] productArrayToCopy) {
        Product[] productArrayToPopulate = new Product[productArrayToCopy.length];
        for (int i = 0; i < productArrayToCopy.length; i++) {
            productArrayToPopulate[i] = new Product(productArrayToCopy[i]);
        }
        return productArrayToPopulate;
    }
}
