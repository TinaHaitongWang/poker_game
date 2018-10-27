/*Name: Haitong Wang 
NetID: 28246763
Assignment No.: Project 2
Lab section: MW 2:00pm
"I did not collaborate with anyone on this
assignment."*/
// This is the Rare card subclass for the cards 

public class Rare extends Cards {
	public Rare(String n) {
		super(n, Rare);
	}
	// create an array to store these three based value that randomly generated in the order of 
	// index 0: total health, index 1: attack, index2: resource cost 
	public int[] getproperties(){
		AssignProperties rarecard = new AssignProperties(16, 1, 7, 4,this.getTotalHealth(),this.getAttack(),this.getResourceCost());
		return rarecard.returnCardproperties();
		}
	
	public void setValue(){
		int[] arrayvalue = getproperties();
		this.setAttack(arrayvalue[1]);
		this.setTotalHealth(arrayvalue[0]);
		this.setCurrentHealth(getTotalHealth());
		this.setResourceCost(arrayvalue[2]);
	}

}
