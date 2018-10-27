/*Name: Haitong Wang 
NetID: 28246763
Assignment No.: Project 2
Lab section: MW 2:00pm
"I did not collaborate with anyone on this
assignment."*/
// This class assign all cards properties  
import java.util.*;
public class AssignProperties {
	int attack;
	int totalHealth; 
	int resourceCost;
 
	int[]  cardproperties = new int[3];
	int upperrangetotalhealth; 
	int lowerrangetotalhealth;
	int upperrangeattack;
	int lowerrangeattack;
	int upperrangeresourcecost;
	int lowerrangeresourcecost;
	Random random = new Random();
	
	public AssignProperties(int urth, int lrth, int urrc, int lrrc, int th, int a, int rc ){
		upperrangetotalhealth = urth;
		lowerrangetotalhealth = lrth;
		upperrangeresourcecost = urrc;
		lowerrangeresourcecost = lrrc;
		attack = a;
		totalHealth = th; 
		resourceCost = rc;
		}
	
	// set total health of the card 
	public int assignTotalhealth(){
		totalHealth = random.nextInt((upperrangetotalhealth-lowerrangetotalhealth)+1)+lowerrangetotalhealth;
		return totalHealth;
		}
	// set attack value of the card 
	public int assignAttack(){
	    attack = upperrangetotalhealth-totalHealth;
	    return attack;
	    }
	// set resource cost of the card 
	public int assignResourceCost(){
	    resourceCost = random.nextInt((upperrangeresourcecost-lowerrangeresourcecost)+1)+lowerrangeresourcecost;
	    return resourceCost;
	    }
	// create an array to store these three based value in the order of 
	// index 0: total health, index 1: attack, index2: resource cost 
	// return the array to card properties 
	public int[] returnCardproperties(){
	    cardproperties[0] = assignTotalhealth();
	    cardproperties[1] = assignAttack();
	    cardproperties[2] = assignResourceCost();
	    return cardproperties;
	    }
	

}
