/*Name: Haitong Wang  
NetID: 28246763
Assignment No.: Project 2
Lab section: MW 2:00pm
"I did not collaborate with anyone on this
assignment."*/
// This is the class for the battle method  
public class Battle { 
	int numberplayedcard;
	int totalDamage =0;
	Players one;
	Players two;
	boolean p =true;

	
	public Battle(Players one, Players two){
		this.one = one;// first one always attack 
		this.two = two; 
	}
	
	// *************** calculate the damage and apply damage to each card *******************
	public Players startBattle(){
		// ******** calculate the total damage for each play 
		for(int i =0; i<one.getPlayedcards().size();i++){
			totalDamage= totalDamage+one.getPlayedcards().get(i).getAttack();
			
		}
		numberplayedcard = two.getPlayedcards().size();
		// ********* call actual attacking method *********
		two = startattack(one, two, totalDamage,numberplayedcard);
		return two;
	}
	
	// Attack method: take damage from the cards and return a value indicate whether some cards have exhausted their health
	public Players startattack(Players one, Players two, int totaldamage1,int numberplayedcard2){
		// ********player one attack*********
		for(int i = 0; i<numberplayedcard2;i++){
			// check if player one's total damage reach zero or not 
			if(totalDamage<=0){
				break;
			}
			else{
				// player two absorbed damage from player one and update the player one's total damage 
				totalDamage = totalDamage-two.getPlayedcards().get(i).getCurrentHealth();
				if(totalDamage >= 0){
					two.getPlayedcards().get(i).setCurrentHealth(0);
					two.getPlayedcards().get(i).cardstatus = false;
					p = false;
					if(i == (numberplayedcard2-1)){
						two.setScore(two.getScore() -totalDamage); // score recording: reduce score points when there is not card in play 
					}
				}
				else if(totalDamage < 0){
					two.getPlayedcards().get(i).setCurrentHealth(Math.abs(totalDamage));
				}
			}
			
			if(!two.getPlayedcards().get(i).cardstatus){
				two.getDiscardedcards().add(two.getPlayedcards().get(i));
				System.out.println("Player "+two.getName()+" loses "+two.getPlayedcards().get(i).getName() +" card.");
				p = false;
				
			}
			
		}
		
		return two;
	}
	
	

}
