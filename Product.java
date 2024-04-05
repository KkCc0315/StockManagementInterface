public abstract class Product {
	private String productName;
	private Double productPrice;
	private int quantityAvailable;
	private int productId;
	private boolean status = true;

	// Default constructor
	public Product() {

	}

	// Overloading
	public Product(int id, String name, int quantity, double price) {
		this.productId = id;
		this.productName = name;
		this.quantityAvailable = quantity;
		this.productPrice = price;
	}

	// Getter and Setter
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public int getQuantityAvailable() {
		return quantityAvailable;
	}

	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	// Instance method
	public double calculateValue() {
		double i;
		i = this.productPrice * this.quantityAvailable;
		return i;
	}

	public void addQuantity(int quantity) {
		if (this.status == true) {
			this.quantityAvailable = this.quantityAvailable + quantity;
		}
	}

	public void deductQuantity(int quantity) {
		this.quantityAvailable = this.quantityAvailable - quantity;
	}

	@Override
	public String toString() {
		if (this.isStatus() == true) {
			return "Item number          :" + this.productId + "\nProduct name         :" + this.productName
					+ "\nQuantity available:" + this.quantityAvailable + "\nPrice (RM)     :"
					+ String.format("%.2f", this.productPrice) + "\nInventory value (RM):"
					+ String.format("%.2f", this.calculateValue()) + "\nProduct status     : Active";
		} else {
			return "Item number          :" + this.productId + "\nProduct name         :" + this.productName
					+ "\nQuantity available:" + this.quantityAvailable + "\nPrice (RM)     :"
					+ String.format("%.2f", this.productPrice) + "\nInventory value (RM):"
					+ String.format("%.2f", this.calculateValue()) + "\nProduct status     : Discontinued";
		}
	}

}
