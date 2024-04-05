import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class StockManagement extends Product {

	static boolean quitmenu = false;

	public static void main(String[] args) {
		int mChoice = 5;
		Scanner scanner = new Scanner(System.in);
		System.out.println("--------------------------------WELCOME-----------------------------------------");
		welcome();
		System.out.println("Press \"Enter\" to continue........");
		System.out.println("--------------------------------WELCOME-----------------------------------------");
		scanner.nextLine();

		System.out.println("-------------------------------USER INFO------------------------------------------");
		UserInfo userInfo = new UserInfo();
		userInfo.promptForName();
		String userID = userInfo.generateUserID();
		System.out.println("-------------------------------USER INFO------------------------------------------\n");

		ArrayList<Product> stock = new ArrayList<Product>(); // arraylist for product

		// check how much product user want to key in
		System.out.println("-------------------------------PRODUCT------------------------------------------");
		getMaxProduct(stock, scanner);
		System.out.println("-------------------------------PRODUCT------------------------------------------ \n");

		while (quitmenu == false) {
			System.out.println("-------------------------------MENU------------------------------------------");
			menu();
			System.out.println("-------------------------------MENU------------------------------------------");
			System.out.print("Please enter a menu option:");

			mChoice = scanner.nextInt();
			scanner.nextLine();

			executeMethods(mChoice, stock, scanner);

		}

		System.out.println("User Name: " + userInfo.getName() + "\n" + "User ID: " + userID);
		System.out.println("---------------------------------THANK YOU------------------------------------------");
		scanner.close();
	}

	// show welcome message
	private static void welcome() {
		System.out.println("Welcome to the OOP Assignment!");
		int number = 1;

		// Get current date and time
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = currentDateTime.format(formatter);

		// Display current date and time
		System.out.println("Current Date and Time: " + formattedDateTime);

		// Create an array of group member names
		String[] groupMembers = { "LEOW YU HONG", "LEE KANG WEI", "TAN WEI ZHI", "ONG YI HANG" };

		// Sort the array in alphabetical order
		Arrays.sort(groupMembers);

		// Display the names of group members in alphabetical order
		System.out.println("Group Members (in alphabetical order):");
		for (String member : groupMembers) {
			System.out.println(number + ". " + member);
			number++;
		}
	}

	private static void menu() {

		System.out.println("1. View products");
		System.out.println("2. Add stock");
		System.out.println("3. Deduct stock");
		System.out.println("4. Discontinue product");
		System.out.println("0. Exit");

	}

	private static void executeMethods(int menuChoice, ArrayList<Product> stock, Scanner scanner) {
		try {

			switch (menuChoice) {
			case 0:
				System.out.println(
						"---------------------------------THANK YOU------------------------------------------");
				System.out.println("Exiting menu...");
				System.out.println("Exit complete. Thanks for using!!!");
				quitmenu = true;

				break;
			case 1:
				System.out.println(
						"\n-------------------------------VIEW PRODUCT------------------------------------------");
				viewProducts(stock);
				System.out.println(
						"\n-------------------------------VIEW PRODUCT------------------------------------------");
				break;
			case 2:
				if (stock.isEmpty()) {
					System.out.println("Product list is empty! Unable to add any stock.");
					return;
				}
				System.out.println(
						"\n-------------------------------ADD QUANTITY------------------------------------------");
				addQuantity(stock, scanner);
				System.out.println(
						"\n-------------------------------ADD QUANTITY------------------------------------------");
				break;
			case 3:
				if (stock.isEmpty()) {
					System.out.println("Product list is empty! Unable to deduct any stock.");
					return;
				}
				System.out.println(
						"\n-------------------------------DEDUCT QUANTITY------------------------------------------");
				deductStock(stock, scanner);
				System.out.println(
						"\n-------------------------------DEDUCT QUANTITY------------------------------------------");
				break;
			case 4:
				if (stock.isEmpty()) {
					System.out.println("Product list is empty! Unable to discontinued any product.");
					return;
				}
				System.out.println(
						"\n-------------------------------DISCONTINUE PRODUCT--------------------------------------");
				discontinueProduct(stock, scanner);
				System.out.println(
						"\n-------------------------------DISCONTINUE PRODUCT--------------------------------------");
				break;
			default:
				System.out.println("Invalid choice, please try again.");
				break;
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid input, please enter a number.");
		}
	}

	// display contents of products
	private static void showContents(ArrayList<Product> stock) {
		System.out.println("|----Product list----|");
		System.out.println("ID   | Product Name");

		for (Product item : stock) {
			System.out.println(item.getProductId() + "       " + item.getProductName());
		}
	}

	// get number of maximum product function
	private static void getMaxProduct(ArrayList<Product> stock, Scanner scanner) {

		System.out.print("How many product you would like to add :");
		int mProduct = scanner.nextInt();
		scanner.nextLine();

		for (int i = 0; i < mProduct; i++) {
			addRefOrTV(stock, scanner);
		}

	}

	// Allow user to add ref or tv product
	private static void addRefOrTV(ArrayList<Product> stock, Scanner scanner) {
		System.out.println("Adding product...");
		System.out.println("1. Add refrigerator");
		System.out.println("2. Add TV");
		int choice = -1;
		while (choice < 1 || choice > 2) {
			System.out.print("Enter your choice (1 or 2): ");
			try {
				choice = Integer.parseInt(scanner.nextLine());
				if (choice < 1 || choice > 2) {
					System.out.println("Only number 1 or 2 allowed!");
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input, please enter a number.");
			}
		}
		switch (choice) {
		case 1:
			addRefrigerator(stock, scanner);
			break;
		case 2:
			addTV(stock, scanner);
			break;
		}
	}

	private static void addRefrigerator(ArrayList<Product> stock, Scanner scanner) {
		System.out.println("Adding refrigerator...");
		System.out.print("Enter the name: ");
		String name = scanner.nextLine();
		System.out.print("Enter the door design: ");
		String doorDesign = scanner.nextLine();
		System.out.print("Enter the color: ");
		String color = scanner.nextLine();
		System.out.print("Enter the capacity: ");
		int capacity = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter the quantity available in stock: ");
		int quantity = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter the price: ");
		double price = Double.parseDouble(scanner.nextLine());
		System.out.print("Enter the item number: ");
		int itemNumber = Integer.parseInt(scanner.nextLine());
		stock.add(new Refrigerator(itemNumber, name, quantity, price, doorDesign, color, capacity));
	}

	private static void addTV(ArrayList<Product> stock, Scanner scanner) {
		System.out.println("Adding TV...");
		System.out.print("Enter the name: ");
		String name = scanner.nextLine();
		System.out.print("Enter the screen type: ");
		String screenType = scanner.nextLine();
		System.out.print("Enter the resolution: ");
		String resolution = scanner.nextLine();
		System.out.print("Enter the display size: ");
		int displaySize = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter the quantity available in stock: ");
		int quantity = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter the price: ");
		double price = Double.parseDouble(scanner.nextLine());
		System.out.print("Enter the item number: ");
		int itemNumber = Integer.parseInt(scanner.nextLine());
		stock.add(new TV(itemNumber, name, quantity, price, screenType, resolution, displaySize));
	}

	private static void viewProducts(ArrayList<Product> stock) {
		System.out.println("Viewing products...\n");
		int count = 1;
		for (Product item : stock) {
			System.out.print(count + ".\n" + item.toString());
			System.out.println("\n");
			count++;
		}
		System.out.print("\n");
		count = 1;
	}

	private static void addQuantity(ArrayList<Product> stock, Scanner scanner) {
		int previousquantity;
		// System.out.println("Adding stock...");
		showContents(stock);

		// Prompt the user for the product ID
		int productId = -1;
		while (productId == -1) {
			try {
				System.out.print("Enter the product ID: ");
				productId = Integer.parseInt(scanner.nextLine());
				boolean found = false;

				// Search for the product in the array list
				for (Product p : stock) {
					if (p.getProductId() == productId) {
						found = true;
						Product product = p;

						if (product.isStatus() == true) { // check the status of product
							int quantityToAdd = -1;

							while (quantityToAdd < 0) {
								System.out.print("Enter the quantity to add: ");
								try {
									quantityToAdd = Integer.parseInt(scanner.nextLine());
									if (quantityToAdd < 0) {
										System.out.println("Invalid quantity, please enter a positive value.");
										quantityToAdd = -1; // reset the value to -1 to re-prompt user
									}
								} catch (NumberFormatException e) {
									System.out.println("Invalid input, please enter a number.");
									quantityToAdd = -1; // reset the value to -1 to re-prompt user
								}
							}

							previousquantity = product.getQuantityAvailable(); // store the previous quantity of product
							product.addQuantity(quantityToAdd);

							System.out.println("Stock quantity for " + product.getProductName() + " updated from "
									+ previousquantity + " to " + product.getQuantityAvailable() + ".");
						} else {
							System.out.println("Product is discontinued, cannot add anymore!");
						}

						break;
					}
				}

				if (!found) {
					System.out.println("Product not found.");
					productId = -1; // reset the value to -1 to re-prompt user
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input, please enter a number.");
			}
		}
	}

	private static void deductStock(ArrayList<Product> stock, Scanner scanner) {
		System.out.println("Deducting stock...");

		showContents(stock);

		// Prompt the user for the product ID
		System.out.print("Enter the product ID: ");
		int productId = Integer.parseInt(scanner.nextLine());

		// Search for the product in the array
		Product product = null;
		for (Product p : stock) {
			if (p.getProductId() == productId) {
				product = p;
				break;
			}
		}

		// If the product is found, prompt the user for the quantity to deduct
		if (product != null) {
			int quantityToDeduct = -1;
			while (quantityToDeduct < 0) {
				System.out.print("Enter the quantity to deduct: ");
				try {
					quantityToDeduct = Integer.parseInt(scanner.nextLine());
					if (quantityToDeduct < 0) {
						System.out.println("Invalid quantity, please enter a positive value.");
					}
				} catch (NumberFormatException e) {
					System.out.println("Invalid input, please enter a number.");
				}
			}

			// Check if there is enough quantity to deduct
			int currentQuantity = product.getQuantityAvailable();
			if (currentQuantity < quantityToDeduct) {
				System.out.println("Not enough stock available.");
			} else {
				int previousquantity = product.getQuantityAvailable(); // store previous quantity
				product.deductQuantity(quantityToDeduct);
				System.out.println("Stock quantity for " + product.getProductName() + " updated from "
						+ previousquantity + " to " + +product.getQuantityAvailable() + ".");
			}
		} else {
			System.out.println("Product not found.");
		}
	}

	public static void discontinueProduct(ArrayList<Product> stock, Scanner scanner) {
		// List out all the option for product
		showContents(stock);

		System.out.print("Enter product name that you want to discontinue: ");
		String name;
		int count = 0;
		name = scanner.nextLine();
		for (Product item : stock) {
			if (item.getProductName().equals(name)) {
				item.setStatus(false);
				System.out.println("Discontinue successfully");
				count++;
			}
		}
		if (count == 0) {
			System.out.println(name + " not found in product list");
		}
	}

}
