package app;

/**   
*The main class that we load our data to memory and invoke the query methods.
*/

import utils.FileIO;

public class DropShippingApp {

	public static void main(String[] args) {
		Customers customers = new Customers(FileIO.getCustomerArrayFromCSVFile("data/Customers.csv"));
		
		Sales[][] sales = {
				FileIO.getSalesArrayFromCSVFile("data/S1_Sales.csv", customers,
						new Supplier(FileIO.getProductArrayFromCSVFile("data/S1_Products.csv"))),
				FileIO.getSalesArrayFromCSVFile("data/S2_Sales.csv", customers,
						new Supplier(FileIO.getProductArrayFromCSVFile("data/S2_Products.csv"))),
				FileIO.getSalesArrayFromCSVFile("data/S3_Sales.csv", customers,
						new Supplier(FileIO.getProductArrayFromCSVFile("data/S3_Products.csv")))
		};
		SalesManagement salesManagement = new SalesManagement(sales);

		SalesQuery.queryMostProfitableProductAmongSuppliers(salesManagement);
		SalesQuery.queryMostExpensiveProductAmongSuppliers(salesManagement);
		SalesQuery.queryCustomerWithMostProductPurchase(salesManagement, customers);
		SalesQuery.queryTotalProfitFromAllSales(salesManagement);
		SalesQuery.queryLeastProfitableProductOfS1(salesManagement);
	}
}
