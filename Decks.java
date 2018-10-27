/*Name: Haitong Wang 
NetID: 28246763
Assignment No.: Project 2
Lab section: MW 2:00pm
"I did not collaborate with anyone on this
assignment."*/
// This is the Decks class, which use to arrange the cards for each player for each round 
import java.util.*;
public class Decks {
	Random random = new Random();
	private int numberCommon = 16; // number of common cards 
	private int numberUncommon = 8; // number of uncommon cards 
	private int numberRare = 6; // number of rare card 
	private int iteration;
	
	
	// *********************** constructor ****************************
	public Decks(int i){
		iteration = i;
	}
	// **************** setter and getter for iteration *******************
	public int getIteration() {
		return iteration;
	}
	public void setIteration(int i) {
		iteration = i;
	}

	
	// *************** create the decks ********************
	public List<Cards> drawDecks(){
		String[] namearray = new String[30];
		List<Cards> currentdeck = new ArrayList<Cards>();
		for(int j=0;j<numberCommon;j++){
			namearray[j] = toString("C", (j+1));
			Common commonlist = new Common(namearray[j]);
			commonlist.setValue();
			currentdeck.add(commonlist);
		}
		for(int k=0;k<numberUncommon;k++){
			namearray[(numberCommon-1+k)] = toString("U", (k+1));
			Uncommon uncommonlist = new Uncommon(namearray[(numberCommon-1+k)]);
			uncommonlist.setValue();
			currentdeck.add(uncommonlist);
		}
		for(int a=0;a<numberRare;a++){
			namearray[(numberCommon+numberUncommon-2+a)] = toString("R", (a+1));
			Rare rare = new Rare(namearray[(numberCommon+numberUncommon-2+a)]);
			rare.setValue();
			currentdeck.add(rare);
		}	
	return(currentdeck);
	}
	
	// *************** Generate the card name *******************
	public String toString(String t, int i){
		return t+i;
	}
	
	// ************** Shuffling method ********************* 
	public List<Cards> shuffling(List<Cards> currentdeck){
		Random random = new Random();
		for(int i =0; i<30;i++){
			int index = random.nextInt((30-1)+1)+1-1; 
			currentdeck.set(i, currentdeck.get(index));
		}
		setIteration(iteration +1);
		return currentdeck;
	}
	

}
