import org.json.simple.JSONObject;

public class Santa {
	private static final int DEFAULT_WEIGHT_SANTA = 250; 
	private static final int WEIGHT_PRESENT_PACKAGE = 20; 

	// INVENTORY
	// value represents the weight that the item takes up
	private int gingerbreadMen = 0; 
	private int carrots = 0;
	private int hotCocoa = 0; 
	private int santaHat = 0; 
	private int santaCoat = 0; 
	private int candyCanes = 0; 
	private int sleighParts = 0; 
	
	private Sleigh sleigh; 
	private int presentsDelivered = 0;
	private int timesCaught = 0; 
	
	public Santa() {
	}
	
	public void successfulDelivery() {
		this.presentsDelivered++; 
		sleigh.notify(this); 
	}
	
	public int getWeight() {
		return DEFAULT_WEIGHT_SANTA + gingerbreadMen + carrots + hotCocoa + 
				santaHat + santaCoat + candyCanes + sleighParts - 
				(presentsDelivered * WEIGHT_PRESENT_PACKAGE); 
	}
	
	// use negative integers to remove items
	// assumed that item/quantity combination does not exceed sleigh capacity 
	public void updateInventory(String item, int quantity, JSONObject script) {
		if (script.containsKey(item)) {
			int weight = Store.cost(item, script) * quantity; 			
			if (item.equals(Game.CARROT)) {
				this.carrots += weight; 
			}
			else if (item.equals(Game.GINGERBREAD_MEN)) {
				this.gingerbreadMen += weight; 
			}
			else if (item.equals(Game.HOT_COCOA)) {
				this.hotCocoa += weight; 
			}
			else if (item.equals(Game.SANTA_HAT)) {
				this.santaHat += weight; 
			}
			else if (item.equals(Game.SANTA_COAT)) {
				this.santaCoat += weight; 
			}
			else if (item.equals(Game.CANDY_CANES)) {
				this.candyCanes += weight; 
			}
			else if (item.equals(Game.SLEIGH_PARTS)) {
				this.sleighParts += weight; 
			}
			// update sleigh weight
			sleigh.notify(this); 
		}	
		else {
			System.out.println("Invalid Item"); 
		}
}
	
	public int getGingerbreadMen() {
		return gingerbreadMen;
	}

	public int getCarrots() {
		return this.carrots;
	}

	public int getCandyCanes() {
		return candyCanes;
	}

	public int getSleighParts() {
		return sleighParts;
	}

	public int getHotCocoa() {
		return hotCocoa;
	}

	public int getSantaHat() {
		return santaHat;
	}

	public int getSantaCoat() {
		return santaCoat;
	}
	
	public int getPresentsDelivered() {
		return presentsDelivered; 
	}
	
	public int getTimesCaught() {
		return timesCaught; 
	}
	
	public void setSleigh(Sleigh sleigh) {
		this.sleigh = sleigh; 
	}
}
