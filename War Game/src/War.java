import java.util.*;
/**
 * War game
 * @author John Miner
 * @version 1.0.0
 * @since 2019-09-23
 */
public class War {
	public static void main(String[] Args) {

		/**
		 * 
		 */
		List<Card> freshDeck = new ArrayList<Card>(); 
		/**
		 * Build the deck
		 */
		for(int x = 0; x < 4; x++){ 
		for(int y = 1; y < 14; y++){ 
		freshDeck.add(new Card(y,x)); 
		} 
		}
		  /**
		   * Shuffle the deck
		   */
		Collections.shuffle(freshDeck, new Random()); 
		  
		
		LinkedList<Card> hand1 = new LinkedList<Card>();
		LinkedList<Card> hand2 = new LinkedList<Card>();
		  
		hand1.addAll(freshDeck.subList(0, 25));
		hand2.addAll(freshDeck.subList(26, freshDeck.size()));
		  /**
		   * Places one card from the top of each stack into temp card play
		   */
		while(true){
			System.out.println("Human cards left is " + (hand1.size() + 1));
			System.out.println("Computer cards left is " + hand2.size() + "\n");
			
		Card humanCard = hand1.pop(); 
		Card computerCard = hand2.pop();
		  
		/**
		 * Show cards face up
		 */

		System.out.println("Human card is " + humanCard.toString());
		System.out.println("Computer card is " + computerCard.toString() + "\n");

		  
		/**
		 * Comparing both cards and if human wins
		 */
		if(humanCard.getCard() > computerCard.getCard()){
		hand1.addLast(humanCard);
		hand1.addLast(computerCard);
		System.out.println("Human wins the round\n");
		}
		/**
		 * If computer player wins
		 */
		else if(humanCard.getCard() < computerCard.getCard()){
		hand2.addLast(humanCard);
		hand2.addLast(computerCard);  
		System.out.println("Da computa wins this one\n");
		}
		  /**
		   * War starts here
		   */
		else { 
		System.out.println("Time for some war\n");
		  
		/**
		 * Getting war ready
		 */
		List<Card> war1 = new ArrayList<Card>();
		List<Card> war2 = new ArrayList<Card>();
		  
		/**
		 * Making sure war can take place
		 */
		int tie = 0;
		int index = 2;
		while (tie != 1) {
		for(int x=0; x<4; x++){
		
		if(hand1.size() == 0 || hand2.size() == 0 ){   
			System.out.println("Someone is outta cards!\n");
			tie = 1;
		break;
	}
		  
		System.out.println("Cards are face down, here we go\n");

		war1.add(hand1.pop()); 
		war2.add(hand2.pop());   
	}

		
		if(war1.size() >= 3 && war2.size() >= 3 ){
		
		System.out.println("War card for the human is " + war1.get(0).toString());
		System.out.println("War card for the computer is " + war2.get(0).toString());
		  
		if(war1.get(index).getCard() == war2.get(index).getCard()) {
			index += 4;
			tie = 0;
		}
		
		else if(war1.get(index).getCard() > war2.get(index).getCard()){
		hand1.addAll(war1); 
		hand1.addAll(war2);
		System.out.println("Human wins this round\n");

		tie = 1;
		
		
	}
		
		else{
		hand2.addAll(war1);
		hand2.addAll(war2);
		System.out.println("Da computa wins this round\n");
		tie = 1;
		
				} 
		
			}
		}	  
	}
		  
		/**
		 * If a players deck runs out the lose
		 */
		if(hand2.size() == 0 ){
		System.out.println("Game over\nHuman prevails this game");
		break;
		}
		else if(hand1.size() == 0){
		System.out.println("Game over\nComputa wins I guess");
		break;
			}
		}  

	}
}
	
