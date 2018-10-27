/*Name: Haitong Wang   
NetID: 28246763
Assignment No.: Project 2
Lab section: MW 2:00pm
"I did not collaborate with anyone on this
assignment."*/
// This is the main method of this project 
import java.util.*;
public class MainMethod {
	//************** print out user information ********************
	// this method will print out information to prompt the user view their player informations 
	public static void viewInformation(int roundnumber){
		
		if(roundnumber ==1){
		System.out.print("Now, your deck of cards is drawn and 4 of them are automatically drawn to your hand"
				+ "\ncards. As a remainder you can view your score, total resource points, and number of hand cards "
				+ "\nat begining of each round. Enter 'infor' to view score and resources points!");
		}
		else{
			System.out.println("As a remainder you can view your score, total resource points, and number of hand cards "
					+ "\nat begining of each round. Enter Enter 'infor' to view score and resources points!");
		}
	}
	
	public static void main(String[] args){
		// ********* variables and fields need to be declared before start the game ***********
		Scanner scan = new Scanner(System.in);
		
		// ******************************* introduce the game rule ******************************* 
		System.out.println("Welcome to the Collective Card Game! Here are the rules to this game: "
				+ "\nYou will battle with another player by playing cards against each other. "
				+ "\n**********************************************************************************************************************"
				+ "\n1) At begining of game, each player will be given a deck of 30 randomly generated cards "
				+ "\n   in the ratio 16 common cards, 8 uncommon cards and 6 rare cards. Cards are assigned "
				+ "\n   to different rarity level based on its attack/health and resource cost values."
				+ "\n2) Each player starts with 4 hand cards that are automatically drawn from the deck of cards."
				+ "\n3) Eaxh player starts with a score of 30 and 0 resource points."
				+ "\n4) At begining of each round, each player get to draw a random card from their deck to put"
				+ "\n   into their hand cards. And for each draw, a resource point will be added to their total"
				+ "\n   resource point. "
				+ "\n5) For each round, each player will take turn and choose to play any combination of cards from his/her hand cards "
				+ "\n   such that the resource cost of the cards does not exceed the player's avaliable resource points."
				+ "\n   After both players have made their choices, battle will begin. And at the end of battle, any cards with"
				+ "\n   a health of 0 will be added to the player's discard card pile. The losser of this round will be report and point"
				+ "\n   will be deducted from their score if all cards in play have not health point to take opponent's attack."
				+ "\n   ****NOTE: Before play any cards, player can view their hand cards and discard cards."
				+ "\n   ****NOTE: Once both player played their cards, battle will begin automaticatlly."
				+ "\n6) Reshuffing the deck of cards happends when there is no cards in the hand or the deck has exhausted the supply of "
				+ "\n   cards. If both players exhaust their supply of cards before the end of the game, the cards are shuffled back into"
				+ "\n   the deck and both players immediately draw 4 cards. "
				+ "\n7) At the begining of a new round each player get to choose to continue the game or quit. "
				+ "\n8) Any spent resource points are refunded to both players."
				+ "\n9) The first player to reach a score of 0 losses the game and if both player reach a score of 0 in the same round,"
				+ "\n   the game is a draw."
				+ "\n10) During each round, player can revisit the above rules of this game."
				+ "\n11) Last but not least HOW TO READ YOUR CARD: Name of the card is on the first line. Depends on rarity level, C stands"
				+ "\n    for common cards, U stands for uncommon cards, and R stands for rare cards. A is the attack values of the card. H is"
				+ "\n    the health of the card, and RC is the recource points that costed to play the card."
				+ "\n**********************************************************************************************************************");
		
		//********************** Start the game ********************************
		boolean gamecontrol3 = true;// control for the program 
		while(gamecontrol3){ // begin of the program 
		
		//********************** Start the new game ********************************
		System.out.println("Are you ready to play? Enter 'Start' to begin the game!");
		// check if the user want to play the game 
		boolean gamecontrol1 = true; // control the game 
		while(gamecontrol1){ // new game control 
			
		// prompt the player to enter to start the game 	
		while(true){
			String input1 = scan.next();
			if(input1.equals("Start")){
				break;
			}
			else{ 
				System.out.println("Error, Please enter again!");
				continue;
			}
			}
		
		//********************* Players information ****************************
		// two player enter their name and based on the order to play the card 
		System.out.print("Please enter the name for Player 1: ");
		String input2 = scan.next();
		Players p1 = new Players(input2);
		System.out.print("Please enter the name for Player 2: ");
		String input3 = scan.next();
		Players p2 = new Players(input3);
		
		// at the start of a new game, assign player scores, resource points, deck of cards 
		p1.generateDecks();
		p2.generateDecks();
		p1.setScore(30);
		p2.setScore(30);
		p1.setTotalresource(0);
		p2.setTotalresource(0);
		
		// draw 4 cards from the deck automatically at beginning each new game 
		for(int i = 0; i<4;i++){
		p1.drawCardfromdeck();
		p2.drawCardfromdeck();
		}
		List<Players> p = new ArrayList<Players>();// make a array list for two player 
		p.add(p1); 
		p.add(p2);
		
		//********************** begin of a round ******************************
		int indexround =1; // count the round of the game 
		boolean gamecontrol2 = true; // control the round
		while(gamecontrol2){// control to end the round 
		
		// for any round other than the first round, refund all spent resource points 
		if(indexround!=1){
				p.get(0).setTotalresource(p.get(0).getUnspentresource()+p.get(0).getSpentresource());
				p.get(1).setTotalresource(p.get(1).getUnspentresource()+p.get(1).getSpentresource());
		}
		
		// player can view the information at the beginning of each round 	
		for(int i=0; i<2;i++){
		System.out.println("\n***************************************************************************************************************************"
				+ "\nPlayer "+p.get(i).getName()+":");
		viewInformation(indexround);
		String input4 = scan.next(); 
		if(input4.equalsIgnoreCase("infor")){
			System.out.println(p.get(i).toString());
		}	
		}
		
		// round control, prompt the begin the round
		while(true){
		System.out.println("Enter 'Begin' to start this round");
		String input7 = scan.next(); 
		if(input7.equalsIgnoreCase("Begin")){
			break;
		}
		}
		System.out.println("\n*********************************************************Round" +indexround+"********************************************************");
		                      
		
		
		// draw a random card from players' deck and add an additional total resource point 
		for(int i =0;i<2;i++){
		System.out.println("Player "+p.get(i).getName()+": a card is drawn from you deck!");
		p.get(i).drawCardfromdeck();
		if(p.get(i).getTotalresource()<10){
		p.get(i).setTotalresource(p.get(i).getTotalresource()+1);
		}
		
		// check if the resource point is over 10 points 
		if(p.get(i).getTotalresource()>10){
			p.get(i).setTotalresource(10);// maximum of resource points is 10!!! take out extra points 
			}
		}
		
		// *******************Player get to choose to play any combinations of cards************
		int[] playerDiaplay = new int[2];
		playerDiaplay[0] = 1; playerDiaplay[1] = 2;
		for(int i = 0; i<playerDiaplay.length;i++){
		System.out.print("\n*****************************************************Player "+p.get(i).getName()+"*******************************************************");
		System.out.print("\nNow you are ready to play! Here are your handcards");
		System.out.println(p.get(i).displayHandcards());
		System.out.print("\nPlease pick any combination of hand cards to play by entering the name of card:");
		while(true){
			System.out.print("\nPlease enter the name for card, ex: 'C1'/'U1'/'R1', 'Done' to end entering cards or 'TotalResource' to view your "
					+ "resource point");
			String input6 = scan.next();
			int indexloop =0;
			if(input6.equalsIgnoreCase("Done")){
				if(indexloop ==0){
				p.get(i).setUnspentresource(p.get(i).getTotalresource());
				}
				break;
			}
			else if(input6.equalsIgnoreCase("TotalResource")){
				System.out.println("You have "+p.get(i).getTotalresource()+" resource points");
			}
			else{
				int resourcepoint = p.get(i).playCards(input6);
				p.get(i).setTotalresource(p.get(i).getTotalresource()-resourcepoint);
				p.get(i).setSpentresource(resourcepoint);
				p.get(i).setUnspentresource(p.get(i).getTotalresource());
			}
			indexloop ++;
		}
		
		}
		
		//****************** Battle ********************
		System.out.println("\n*****************************************************BATTLE BEGIN*****************************************************");
		Battle b1 = new Battle(p.get(0), p.get(1));//player two update after attack 
		p.set(1,b1.startBattle());
		Battle b2 = new Battle(p.get(1), p.get(0));
		p.set(0,b2.startBattle());
		// add cards with health of 0 to player's discard pile
		for(int i =0; i<p.get(0).getPlayedcards().size();i++){
		if(!p.get(0).getPlayedcards().get(i).cardstatus){
			p.get(0).getPlayedcards().remove(i);
	
		}
		else{
			System.out.println("Player "+p.get(0).getName()+": You are doing great!");
		}
		}
		for(int i =0; i<p.get(1).getPlayedcards().size();i++){
			if(!p.get(1).getPlayedcards().get(i).cardstatus){
				p.get(1).getPlayedcards().remove(i);
			}
			else{
				System.out.println("Player "+p.get(1).getName()+": You are doing great!");
			}
			}
		System.out.println("*****************************************************BATTLE END*****************************************************\n");
		//************ check if need to re-shuffle the deck ***********
		if(p.get(0).getDeckcards().isEmpty() &p.get(1).getDeckcards().isEmpty()){
			p.get(1).shufflingDecks();
			p.get(0).shufflingDecks();
		}
		else if (p.get(1).getDeckcards().isEmpty()){
			p.get(1).shufflingDecks();
		}
		else if (p.get(0).getDeckcards().isEmpty()){
			p.get(0).shufflingDecks();
		}
		else{
			
		}
		
		//*********************check if player's score reach 0*******************
		int[] gamescore = {0, 0};
		if((p.get(0).getScore()<=0)&(p.get(1).getScore()<=0)){
			System.out.println("The game is a draw");
			gamecontrol1 = false;
			gamecontrol2 = false;
			break;
		}
		else if(p.get(0).getScore()<=0){
			System.out.println("Player "+p.get(0).getName()+" LOSES!!!!");
			gamecontrol1 = false;
			gamecontrol2 = false;
			gamescore[1] =gamescore[1]+2;
			System.out.println("BUT!!!!!!! Congradulation! Player "+p.get(1).getName()+"! You WIN the game!!!!"
					+ "\nYour game score is "+ gamescore[1]+"!");
			break;
		}
		else if(p.get(1).getScore()<=0){
			System.out.println("Player "+p.get(1).getName()+" LOSES!!!!");
			gamecontrol1 = false;
			gamecontrol2 = false;
			gamescore[0] =gamescore[0]+2;
			System.out.println("BUT!!!!!!! Congradulation! Player "+p.get(0).getName()+"! You WIN the game!!!!"
					+ "\nYour final score is "+ gamescore[0]+"!");
			break;
		}
		else{//ask if player want to continue the game to enter another round 
			for(int i =0;i<2;i++){
			System.out.print("***************************************************Player "+p.get(i).getName()+"*********************************************************");
			System.out.println("\nAre you ready for another round??? Enter 'Yes' to begin next round or 'Quit' to quit the game!");
			String input7 = scan.next();
			if(input7.equalsIgnoreCase("Yes")){
				gamecontrol1 = true;
				gamecontrol2 = true;
			}
			else if(input7.equalsIgnoreCase("Quit")){
				gamecontrol1 = false;
				gamecontrol2 = false;
			}
			else {
				System.out.println("Error, Enter again");
				// if error, user need to continue to enter the correct message 
				while(true){
					String input8 = scan.next();
					if(input8.equalsIgnoreCase("Quit")){
						gamecontrol1 = false;
						gamecontrol2 = false;
						
					}
					else if(input8.equalsIgnoreCase("Yes")){
						gamecontrol1 = true;
						gamecontrol2 = true;
					}
				}
				
			}
			}
		}
		
		//******************end of round or end of game ********************
		if(gamecontrol1 =false ){
			System.out.println("BYE! SEE YOU NEXT TIME");
		}
		else if(gamecontrol1 =true ){
			System.out.println("*****************************************************Round "+indexround+" End********************************************************");
			indexround ++;
		}
		
		} // end of round 
			
		} 
		//*****************player get to choose to exit the game or play another game**************************
		// end of game ask player if they want to play the game again 
		System.out.println("DO WANT TO PLAY AGAIN? ENTER 'YES' TO CONTINUE OR 'QUIT' TO QUIT THE GAME");
		while(true){
		String input8 = scan.next();
		if(input8.equalsIgnoreCase("YES")){
			gamecontrol3 = true; 
			break;
		}
		else if(input8.equalsIgnoreCase("QUIT")){
				gamecontrol3 = false; 
				break;
		}
		else{
			System.out.println("Error enter again!!!!");
			continue;
		}
		}
	}
	}
}
