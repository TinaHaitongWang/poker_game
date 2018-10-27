

/*Name: Haitong Wang 
NetID: 28246763
Assignment No.: Project 2
Lab section: MW 2:00pm
"I did not collaborate with anyone on this
assignment."*/
// This is the parent class for the cards 

abstract class Cards {
	private String name;
	private String rarityLevel;
	private int attack;
	private int totalHealth; 
	private int currentHealth; 
	private int resourceCost; 
	boolean cardstatus = true;

	// *************Constructor*************
	public Cards(String n, String rl){
		name = n;
		rarityLevel = rl;
	}
	// ***********getter and setters for each card properties***************** 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRarityLevel() {
		return rarityLevel;
	}

	public void setRarityLevel(String rarityLevel) {
		this.rarityLevel = rarityLevel;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getTotalHealth() {
		return totalHealth;
	}

	public void setTotalHealth(int totalHealth) {
		this.totalHealth = totalHealth;
	}

	public int getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}

	public int getResourceCost() {
		return resourceCost;
	}

	public void setResourceCost(int resourceCost) {
		this.resourceCost = resourceCost;
	}
	
	
	public abstract int[] getproperties();//get the properties of cards from AssignProperties class 
	public abstract void setValue();// set the properties of cards to each card 

	// ********three rarity types*********
	static String Common;
	static String Uncommon;
	static String Rare;
	
	// *******card display **************
	// make individual card properties display and used for player class method displayHandcards 
	public String toStringName(){
		if(getName().length()>=3){
			return getName()+"    ";
		}
		else{
			return getName()+"     ";
		}
	}
	public String toStringAttack(){
		if(getAttack()>=10){
			return "A:"+getAttack()+"   ";
		}
		else{
			return "A:"+getAttack()+"    ";
		}
		}
	public String toStringTotalHealth(){
		if(getTotalHealth()>=10 ){
			return "H:"+getTotalHealth()+"   ";
		}
		else{
			return "H:"+getTotalHealth()+"    ";
		}
		}
	public String toStringResource(){
		if(getResourceCost()>=10){
			return "RC:"+getResourceCost()+"  ";
		}
		else{
			return "RC:"+getResourceCost()+"   ";
		}
		}

}
