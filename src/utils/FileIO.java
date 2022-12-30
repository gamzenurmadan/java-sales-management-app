package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import app.Customer;
import app.Customers;
import app.Product;
import app.Sales;
import app.Supplier;

public class FileIO {

	public static Sales[] getSalesArrayFromCSVFile(String filePath, Customers customers, Supplier supplier) {
		String strLine = "";

		try {
			int lineCount = getLineCount(filePath);

			if (lineCount <= 0)
				return new Sales[0];

			BufferedReader br2 = new BufferedReader(new FileReader(filePath));
			br2.readLine(); // skip first row

			Sales[] salesArray = new Sales[lineCount - 1];
			for (int i = 0; i < lineCount - 1; i++) {
				if ((strLine = br2.readLine()) == null)
					continue;

				String[] tokenArray = getTokenArray(strLine);
				Product product = supplier.getProductById(tokenArray[2]);
				double salesPrice = calculateSalesPrice(product);

				salesArray[i] = new Sales(
						tokenArray[0],
						customers.getCustomerById(tokenArray[1]),
						product,
						tokenArray[3],
						salesPrice);
			}
			br2.close();

			return salesArray;

		} catch (IOException e) {
			System.err.println(e.getMessage());
			return new Sales[0];
		}
	}

	public static Customer[] getCustomerArrayFromCSVFile(String filePath) {
		String strLine = "";

		try {
			int lineCount = getLineCount(filePath);

			if (lineCount <= 0)
				return new Customer[0];

			BufferedReader br2 = new BufferedReader(new FileReader(filePath));
			br2.readLine(); // skip first row

			Customer[] customerArray = new Customer[lineCount - 1];
			for (int i = 0; i < lineCount - 1; i++) {
				if ((strLine = br2.readLine()) == null)
					continue;

				String[] tokenArray = getTokenArray(strLine);
				customerArray[i] = new Customer(tokenArray[0], tokenArray[1], tokenArray[2], tokenArray[3],
						tokenArray[4]);
			}
			br2.close();

			return customerArray;

		} catch (IOException e) {
			System.err.println(e.getMessage());
			return new Customer[0];
		}
	}

	public static Product[] getProductArrayFromCSVFile(String filePath) {
		String strLine = "";

		try {
			int lineCount = getLineCount(filePath);

			if (lineCount <= 0)
				return new Product[0];

			BufferedReader br2 = new BufferedReader(new FileReader(filePath));
			br2.readLine(); // skip first row

			Product[] productArray = new Product[lineCount - 1];
			for (int i = 0; i < lineCount - 1; i++) {
				if ((strLine = br2.readLine()) == null)
					continue;

				String[] tokenArray = getTokenArray(strLine);
				productArray[i] = new Product(tokenArray[0], tokenArray[1], Double.parseDouble(tokenArray[2]),
						Integer.parseInt(tokenArray[3]), Integer.parseInt(tokenArray[4]));
			}
			br2.close();

			return productArray;

		} catch (IOException e) {
			System.err.println(e.getMessage());
			return new Product[0];
		}
	}

	private static int getLineCount(String filePath) throws FileNotFoundException, IOException {
		int lineCount = 0;
		BufferedReader br = new BufferedReader(new FileReader(filePath));

		while (br.readLine() != null) {
			lineCount++;
		}
		br.close();

		return lineCount;
	}

	private static String[] getTokenArray(String strLine) {

		StringTokenizer st = new StringTokenizer(strLine, ",");
		int tokenSize = st.countTokens();
		String[] tokenArray = new String[tokenSize];
		for (int j = 0; j < tokenSize; j++) {
			tokenArray[j] = st.nextToken();
		}
		return tokenArray;
	}

	private static double calculateSalesPrice(Product product) { // TODO: check again if it is duplicate
		return product.getPrice() + (((product.getRate() / 5.0) * 100) * product.getNumberOfReview());
	}

}
