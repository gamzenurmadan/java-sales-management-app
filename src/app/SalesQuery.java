package app;

/**   
*This class includes all the logical operations and the results
*/

import java.text.DecimalFormat;

public class SalesQuery {

    enum CustomerIdAndPurchaseCountTuple {
        CUSTOMER_ID,
        PURCHASE_COUNT
    }

    public static void queryMostProfitableProductAmongSuppliers(SalesManagement salesManagement) {

        double maxProfit = 0;
        Product mostProfitableProduct = null;
        Sales[][] salesArrayList = salesManagement.getSalesArray();

        for (int i = 0; i < salesArrayList.length; i++) {
            Sales[] salesArray = salesArrayList[i];
            for (int j = 0; j < salesArray.length; j++) {
                Sales sales = salesArray[j];
                Product product = sales.getProduct();

                double profit = calculateProfit(sales, product);
                if (profit > maxProfit) {
                    mostProfitableProduct = product;
                    maxProfit = profit;
                }
            }
        }
        printMostProfitableProduct(mostProfitableProduct, maxProfit);
    }

    public static void queryMostExpensiveProductAmongSuppliers(SalesManagement salesManagement) { // üç supplier ver,
                                                                                                  // azami değeri
        // olanı seç
        double maxPrice = 0;
        Product mostExpensiveProduct = null;
        Sales[][] salesArrayList = salesManagement.getSalesArray();

        for (int i = 0; i < salesArrayList.length; i++) {
            Sales[] salesArray = salesArrayList[i];
            for (int j = 0; j < salesArray.length; j++) {
                Sales sales = salesArray[j];
                Product product = sales.getProduct();
                double salesPrice = sales.getSalesPrice();

                if (salesPrice > maxPrice) {
                    mostExpensiveProduct = product;
                    maxPrice = salesPrice;
                }
            }
        }
        printMostExpensiveProduct(mostExpensiveProduct, maxPrice);
    }

    public static void queryCustomerWithMostProductPurchase(SalesManagement salesManagement, Customers customers) {
        Sales[][] salesArrayList = salesManagement.getSalesArray();
        Customer[] customerArray = customers.getCustomerArray();

        // TODO: Initialize customer purchase array
        String[][] customerAndPurchaseList = new String[customerArray.length][2];
        for (int i = 0; i < customerAndPurchaseList.length; i++) {
            String[] customerAndPurchaseArray = customerAndPurchaseList[i];

            customerAndPurchaseArray[CustomerIdAndPurchaseCountTuple.CUSTOMER_ID.ordinal()] = customerArray[i].getId(); // customerid
            customerAndPurchaseArray[CustomerIdAndPurchaseCountTuple.PURCHASE_COUNT.ordinal()] = "0"; // purchase count
        }

        // TODO: Fill customer purchase array
        for (int i = 0; i < salesArrayList.length; i++) {
            Sales[] salesArray = salesArrayList[i];
            for (int j = 0; j < salesArray.length; j++) {
                Sales sales = salesArray[j];
                for (int k = 0; k < customerAndPurchaseList.length; k++) {
                    if (sales.getCustomer().getId()
                            .equals(customerAndPurchaseList[k][CustomerIdAndPurchaseCountTuple.CUSTOMER_ID.ordinal()])) {
                        int purchaseCount = Integer.parseInt(
                                customerAndPurchaseList[k][CustomerIdAndPurchaseCountTuple.PURCHASE_COUNT.ordinal()]);
                        purchaseCount++;
                        customerAndPurchaseList[k][CustomerIdAndPurchaseCountTuple.PURCHASE_COUNT.ordinal()] = Integer
                                .toString(purchaseCount);
                    }
                }

            }
        }

        // TODO: Find customer with most purchase
        int maxPurchase = 0;
        Customer customerWithMostPurchases = null;
        for (int i = 0; i < customerAndPurchaseList.length; i++) {
            if (Integer.parseInt(
                    customerAndPurchaseList[i][CustomerIdAndPurchaseCountTuple.PURCHASE_COUNT.ordinal()]) > maxPurchase) {
                maxPurchase = Integer
                        .parseInt(customerAndPurchaseList[i][CustomerIdAndPurchaseCountTuple.PURCHASE_COUNT.ordinal()]);
                customerWithMostPurchases = customers
                        .getCustomerById(
                                customerAndPurchaseList[i][CustomerIdAndPurchaseCountTuple.CUSTOMER_ID.ordinal()]);
            }
        }
        System.out.println(
                "Customer with most purchases " + customerWithMostPurchases + " " + maxPurchase + " purchases");
    }

    public static void queryTotalProfitFromAllSales(SalesManagement salesManagement) {

        double totalProfit = 0;
        Sales[][] salesArrayList = salesManagement.getSalesArray();

        for (int i = 0; i < salesArrayList.length; i++) {
            Sales[] salesArray = salesArrayList[i];
            for (int j = 0; j < salesArray.length; j++) {
                Sales sales = salesArray[j];
                Product product = sales.getProduct();

                double profit = calculateProfit(sales, product);
                totalProfit += profit;
            }
        }
        printTotalProfit(totalProfit);
    }

    public static void queryLeastProfitableProductOfS1(SalesManagement salesManagement) {
        boolean isFirstProductRead = false;
        double leastProfit = 0;
        Product leastProfitableProduct = null;
        Sales[][] salesArrayList = salesManagement.getSalesArray();
        Sales[] salesArray = salesArrayList[0]; // s1

        for (int i = 0; i < salesArray.length; i++) {
            Sales sales = salesArray[i];
            Product product = sales.getProduct();

            double profit = calculateProfit(sales, product);
            if (!isFirstProductRead) { // assign first product as least profitable at the start
                leastProfitableProduct = product;
                leastProfit = profit;
                isFirstProductRead = true;
            }
            if (profit < leastProfit) {
                leastProfitableProduct = product;
                leastProfit = profit;
            }
        }

        printLeastProfitableProductOfS1(leastProfitableProduct, leastProfit);
    }

    private static void printMostProfitableProduct(Product mostProfitableProduct, double profit) {
        System.out.println("The most profitable product among the suppliers: " + mostProfitableProduct + " -> "
                + parseBigNumber(profit) + " TL profit");
    }

    private static void printMostExpensiveProduct(Product mostExpensiveProduct, double salesPrice) {
        System.out.println("The most expensive product among the suppliers: " + mostExpensiveProduct + " -> "
                + parseBigNumber(salesPrice) + " TL Sales Price");
    }

    private static void printLeastProfitableProductOfS1(Product leastProfitableProduct, double profit) {
        System.out.println("The least profitable product of S1: " + leastProfitableProduct + " -> "
                + parseBigNumber(profit) + " TL profit");
    }

    private static void printTotalProfit(double totalProfit) {
        System.out.println("Total profit made from all the sales: " + parseBigNumber(totalProfit) + " TL profit");
    }

    private static double calculateProfit(Sales sales, Product product) {
        double salesPrice = sales.getSalesPrice();
        int price = product.getPrice();
        double profit = salesPrice - price;
        return profit;
    }

    // used to get rid of scientific notation and fractions to match the sample output
    private static String parseBigNumber(double number) {
        DecimalFormat df = new DecimalFormat("#");
        df.setMaximumFractionDigits(8);
        return df.format(number);
    }
}
