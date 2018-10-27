# poker_game

This is the readme file for CSC171 Project 2 assignment. 
There are 10 files inside the zipped folder named CSC171PROJECT2_HW. 

1) MainMethod.java contains the main method of the project. User should run this file to play the game.
2) Cards.java contains the parent class of all cards. 
3) Common.java is a subclass to the Cards class. 
4) Uncommon.java is a subclass to the Cards class.
5) Rare.java is a subclass to the Cards class. 
6) Players.java is class for players that generate variables that a players needs during the game.
7) Battle.java contains the battle method for cards in play to attack each other. 
8) Decks.java is a class that generate decks of cards for each player.
9) AssignPropeties.java is a class associated with cards and its subclasses to assign attack, health, resource points and name to
   each individual cards. 
10)README.txt is the readme file of this project. 

This card game is designed for two players to play against each other. At beginning of the new game, players need to enter their name to
start the game. At the beginning of the game, each player will have a base score of 30, a 0 resource point for playing cards and 4 hand cards. 
During each round, player has to draw a card from their deck and each draw of card give player one resource point and cost one score point.
Each player then can decide what combination of cards that they want to play with their own resource points after viewing their hand cards, 
and each played cards will be removed from players hand cards.  
Player can chose do not play any cards, but if there is card in play for both player battle mode will initiate automatically. Battle mode means 
that cards in play will attack each other to reduce the health of the card to zero. Once the card's health reaches zero, it is removed from cards 
in play, otherwise cards will still be played for next round. If player runs out of car in play, the extra damage will be taken from player's 
score. After battle, if any player has lose cards during the battle, it will be reported. The players will be prompted to enter whether they
want to enter next round or not. The new round then will begin. The player who first get to a score of 0 will lose the game and the game will end.
Player who wins the game will receive 2 points to their final score. Then, players get to chose again if they want to play again. 
*******************************************************************************************************************************************************
NOTE: For more detailed playing instruction and point deduction system, please refer to CSC 171 Project 02: Harspoon: the collectible car game for more 
detail information. 
*******************************************************************************************************************************************************

How to read the card: 
********
*NAME: depends on rarity, C stands for common card, U stands for uncommon cards and R stands for rare cards
*A: attack value 
*H: health 
*RC: cost of resource points to play 
********

Possible extra credit: 
I rearrange the way to display the hand cards. They are displayed horizontally in a line. 

