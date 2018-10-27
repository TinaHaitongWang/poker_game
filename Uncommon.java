/*Name: Haitong Wang 
NetID: 28246763
Assignment No.: Project 2
Lab section: MW 2:00pm
"I did not collaborate with anyone on this
assignment."*/
// This is the Uncommon card subclass for the cards 
// import java.util.*;
public class Uncommon extends Cards{
	public Uncommon(String n) {
		super(n, Uncommon);
	}
	// create an array to store these three based value that randomly generated in the order of 
	// index 0: total health, index 1: attack, index2: resource cost 
	public int[] getproperties(){
		AssignProperties uncommoncard = new AssignProperties(12, 1, 5, 2,this.getTotalHealth(),this.getAttack(),this.getResourceCost());
		return uncommoncard.returnCardproperties();
		}
	public void setValue(){
		int[] arrayvalue = getproperties();
		this.setAttack(arrayvalue[1]);
		this.setTotalHealth(arrayvalue[0]);
		this.setCurrentHealth(getTotalHealth());
		this.setResourceCost(arrayvalue[2]);
	}


}
