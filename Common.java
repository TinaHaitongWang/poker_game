/*Name: Haitong Wang 
NetID: 28246763
Assignment No.: Project 2
Lab section: MW 2:00pm
"I did not collaborate with anyone on this
assignment."*/
// This is the Common card subclass for the cards 
//import java.util.*;
public class Common extends Cards {
	
	// ********Constructor********
	public Common(String n) {
		super(n, Common);
	}
	// ****************assign properties to the common class card********************
	// create an array to store these three based value that randomly generated in the order of 
	// index 0: total health, index 1: attack, index2: resource cost 
	public int[] getproperties(){
	AssignProperties commoncard = new AssignProperties(8, 1, 3, 1,this.getTotalHealth(),this.getAttack(),this.getResourceCost());
	return commoncard.returnCardproperties();
	}
	// ***************set the card properties to the card***************
	public void setValue(){
		int[] arrayvalue = getproperties();
		this.setAttack(arrayvalue[1]);
		this.setTotalHealth(arrayvalue[0]);
		this.setCurrentHealth(getTotalHealth());
		this.setResourceCost(arrayvalue[2]);
	}


}
