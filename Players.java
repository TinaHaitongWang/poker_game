/*Name: Haitong Wang  
NetID: 28246763
Assignment No.: Project 2
Lab section: MW 2:00pm
"I did not collaborate with anyone on this
assignment."*/
// This is the class for the players 
import java.util.*;
public class Players {
	private List<Cards> deckcards = new ArrayList<Cards>(30);
	private List<Cards> handcards = new ArrayList<Cards>();
	private List<Cards> discardedcards = new ArrayList<Cards>();
	private List<Cards> playedcards = new ArrayList<Cards>();
	private int score = 30; 
	private int totalresource = 0; // cannot exceed 10, need a checking mechanism 
	private int unspentresource = 0; 
	private int spentresource = 0;
	Decks d = new Decks(1);
	private String name; 
	Random random = new Random();
	boolean playcardcontrol = true;
	
	public Players(String n){
		name = n;
	}
	// ************setters and getters*************** 
	public List<Cards> getDeckcards() {
		return deckcards;
	}

	public void setDeckcards(List<Cards> deckcards) {
		this.deckcards = deckcards;
	}
	public List<Cards> getHandcards() {
		return handcards;
	}
	public void setHandcards(List<Cards> handcards) {
		this.handcards = handcards;
	}
	public List<Cards> getDiscardedcards() {
		return discardedcards;
	}
	public void setDiscardedcards(List<Cards> discardedcards) {
		this.discardedcards = discardedcards;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getTotalresource() {
		return totalresource;
	}
	public void setTotalresource(int totalresource) {
		this.totalresource = totalresource;
	}
	public int getUnspentresource() {
		return unspentresource;
	}
	public void setUnspentresource(int unspentresource) {
		this.unspentresource = unspentresource;
	}
	public String getName() {
		return name;
	}
	public List<Cards> getPlayedcards() {
		return playedcards;
	}
	public void setPlayedcards(List<Cards> playedcards) {
		this.playedcards = playedcards;
	}
	public int getSpentresource() {
		return spentresource;
	}
	public void setSpentresource(int spentresource) {
		this.spentresource = spentresource;
	}
	
	// ********* display hand cards list ******************
	// this method just format the cards into appropriate order 
	public String displayHandcards(){
        String printName = "*";
        String printAttack = "*";
        String printHealth = "*";
        String printResource = "*";
        int count =0;
        StringBuilder stredge = new StringBuilder("**************************");
        StringBuilder strdivider =  new StringBuilder("----------------------");
		for(int i =0; i<handcards.size(); i++){
			if(i==handcards.size()-1){
				printName = printName+handcards.get(i).toStringName()+"* ";
				printAttack = printAttack+handcards.get(i).toStringAttack()+"* ";
				printHealth = printHealth+handcards.get(i).toStringTotalHealth()+"* ";
				printResource = printResource+handcards.get(i).toStringResource()+"* ";	
				if(i!= 0){// calculate the length of hand card resource point in order to display 

					if(handcards.get(i).toStringResource().length()>=handcards.get(i-1).toStringResource().length()){
						count =handcards.get(i).toStringResource().length();

					}
				}
				else if(i ==0){
					count =handcards.get(i).toStringResource().length();
				}
			}
			
			else{
			printName = printName+handcards.get(i).toStringName()+"*  *";
			printAttack = printAttack+handcards.get(i).toStringAttack()+"*  *";
			printHealth = printHealth+handcards.get(i).toStringTotalHealth()+"*  *";
			printResource = printResource+handcards.get(i).toStringResource()+"*  *";	
			if(i!= 0){// calculate the length of hand card resource point in order to display 

				if(handcards.get(i).toStringResource().length()>=handcards.get(i-1).toStringResource().length()){
					count =handcards.get(i).toStringResource().length();

				}
			}
			else if(i ==0){
				count =handcards.get(i).toStringResource().length();
			}
			}
		}
		stredge.setLength(count+2);
		strdivider.setLength(count+2);
        String edge = stredge.toString();
        String topedge = "";
        String divider = strdivider.toString();
        String topdivicer = "";
		for(int i =0; i<handcards.size(); i++){
			if(i != 0){
			topedge = topedge+"  "+ edge;
			topdivicer = topdivicer+"  "+ divider;
			}
			else{
				topedge = topedge+ edge;
				topdivicer = topdivicer+ divider;
			}
		}
		return "\n"+topedge+"\n"+printName+"\n"+topdivicer+"\n"+printAttack+"\n"+topdivicer+"\n"+ printHealth+"\n"+topdivicer+"\n"+printResource+"\n"+topedge;
	}
	
	// ********* draw card from deck *********************
	public void drawCardfromdeck(){
		int indexdrawcar = random.nextInt((deckcards.size()-1)+1)+1-1;
		handcards.add(deckcards.get(indexdrawcar));;
		score = score -1;
		deckcards.remove(indexdrawcar);
	}
	
	// *****************calculate the total resource after each draw ***************
	public int addResource(int totalresource){
		totalresource = totalresource+1;
		return totalresource;
	}
	
	// ***************player choose the card that they want to play***************
	public int playCards(String cardname){
		int index = 3000;
		for(int i=0;i<handcards.size();i++){
			if(cardname.equalsIgnoreCase(handcards.get(i).getName())){
				index =i;

			}
			
		}
		if(index == 3000){
			System.out.println("Can not find this card, please enter again!");
		}
		if(handcards.get(index).getResourceCost()<=totalresource){
			spentresource = handcards.get(index).getResourceCost();
			playedcards.add(handcards.get(index));
			handcards.remove(index);
			}
			else{
				System.out.println("Error: No enough resource point!");
				playcardcontrol = false;
			}
		return spentresource;
	}
	
	// *************** generate the deck of cards for this player ******************
    public void generateDecks(){
    	//Decks d = new Decks(1);
    	setDeckcards(d.drawDecks());
    }
    
    // ************** shuffle the deck of card for this player *********************
    public void shufflingDecks(){
    	setDeckcards(d.shuffling(getDeckcards()));
    }
    
    // ************** display score, resource points and number of hand cards *******************
    public String toString(){
    	return "****************************"
    			+"\n  Name:"+name+"               "+"\n  Score:"+score+"                "
                +"\n  Total Resource:"+totalresource+"        "
		          +"\n  Number of hand cards:"+handcards.size()+"  "+"\n****************************";
    }
}
