public class Refrigerator extends Product {

	private String rDesign;
	private String rColor;
	private int rCapacity;

	// Constructor (int id, String name, int quantity, double price, String Design,
	// String Color, int capacity)
	public Refrigerator(int id, String name, int quantity, double price, String design, String color, int capacity) {
		super(id, name, quantity, price);
		this.rDesign = design;
		this.rColor = color;
		this.rCapacity = capacity;

	}

	// Getter and Setter
	public String getrDesign() {
		return rDesign;
	}

	public void setrDesign(String rDesign) {
		this.rDesign = rDesign;
	}

	public String getrColor() {
		return rColor;
	}

	public void setrColor(String rColor) {
		this.rColor = rColor;
	}

	public int getrCapacity() {
		return rCapacity;
	}

	public void setrCapacity(int rCapacity) {
		this.rCapacity = rCapacity;
	}

	// Calculate value of the stock of refrigerator
	public double calculateRvalue() {
		return (super.calculateValue());
	}

	@Override
	public String toString() {
		return "Item number         :" + super.getProductId() + "\nProduct name        :" + super.getProductName()
				+ "\nDoor design         :" + this.rDesign + "\nColor               :" + this.rColor
				+ "\nCapacity (in Litres):" + this.rCapacity + "\nQuantity available  :" + super.getQuantityAvailable()
				+ "\nPrice (RM)          :" + String.format("%.2f", super.getProductPrice()) + "\nInventory value (RM):"
				+ String.format("%.2f", this.calculateRvalue()) + "\nProduct status      :" + super.isStatus();
	}
}
