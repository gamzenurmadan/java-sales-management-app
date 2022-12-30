package app;

/**   
*This class creates an array that includes all suppliers 
*and associates customers and the products.
*/

public class SalesManagement {
    private Sales[][] salesArray;

    public SalesManagement(Sales[][] salesArray) {
        this.salesArray = salesArray;
    }

    public Sales[][] getSalesArray() {
        return salesArray;
    }

    public void setSalesArray(Sales[][] salesArray) {
        this.salesArray = salesArray;
    }
    
    public boolean equals(SalesManagement aSalesManagement) {
        Sales[][] salesArrayList1 = aSalesManagement.getSalesArray();
        Sales[][] salesArrayList2 = this.getSalesArray();

        if (salesArrayList1.length != salesArrayList2.length)
            return false;

        for (int i = 0; i < salesArrayList1.length; i++) {
            Sales[] salesArray1 = salesArrayList1[i];
            Sales[] salesArray2 = salesArrayList2[i];

            if (salesArray1.length != salesArray2.length)
                return false;

            for (int j = 0; j < salesArray1.length; j++) {
                Sales sales1 = salesArray1[j];
                Sales sales2 = salesArray2[j];
                if (!sales1.equals(sales2))
                    return false;
            }
        }
        return true;
    }
}
