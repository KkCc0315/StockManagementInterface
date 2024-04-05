public class TV extends Product {

	private String tScreenType;
	private String tResolution;
	private int tDisplaySize;

	// Constructor
	public TV(int id, String name, int quantity, double price, String type, String resolution, int size) {
		super(id, name, quantity, price);
		this.tScreenType = type;
		this.tResolution = resolution;
		this.tDisplaySize = size;
	}

	public String gettScreenType() {
		return tScreenType;
	}

	public void settScreenType(String tScreenType) {
		this.tScreenType = tScreenType;
	}

	public String gettResolution() {
		return tResolution;
	}

	public void settResolution(String tResolution) {
		this.tResolution = tResolution;
	}

	public int gettDisplaySize() {
		return tDisplaySize;
	}

	public void settDisplaySize(int tDisplaySize) {
		this.tDisplaySize = tDisplaySize;
	}

	public double calculateRvalue() {
		return (super.calculateValue());
	}

	@Override
	public String toString() {
		if (super.isStatus() == true) {
			return "Item number         :" + super.getProductId() + "\nProduct name        :" + super.getProductName()
					+ "\nScreen type         :" + this.tScreenType + "\nResolution          :" + this.tResolution
					+ "\nDisplay size        :" + this.tDisplaySize + "\nQuantity available  :"
					+ super.getQuantityAvailable() + "\nPrice (RM)          :"
					+ String.format("%.2f", super.getProductPrice()) + "\nInventory value (RM):"
					+ String.format("%.2f", this.calculateRvalue()) + "\nProduct status      :Active";
		} else {
			return "Item number         :" + super.getProductId() + "\nProduct name        :" + super.getProductName()
					+ "\nScreen type         :" + this.tScreenType + "\nResolution          :" + this.tResolution
					+ "\nDisplay size        :" + this.tDisplaySize + "\nQuantity available  :"
					+ super.getQuantityAvailable() + "\nPrice (RM)          :"
					+ String.format("%.2f", super.getProductPrice()) + "\nInventory value (RM):"
					+ String.format("%.2f", this.calculateRvalue()) + "\nProduct status      :Discontinued";
		}
	}
}
