import java.util.*;

/**
 * 
 * @author MLMin
 *
 */
public class Deck extends Card{
	/**
	 * 
	 * @param rank
	 * @param suit
	 */
	public Deck(int rank, int suit) {
		super(rank, suit);
		// TODO Auto-generated constructor stub
	}
/**
 * 
 */
	public void newDeck() {
	List<Card> newDeck = new ArrayList<Card>(); 
	/**
	 * Initialize the deck arrayList then build 52 card
	 */
	for(int x = 0; x < 4; x++){ 
	for(int y = 0; y < 13; y++){ 
	newDeck.add(new Card(y,x)); 
	} 
	}
	  
	/**
	 * shuffle the newly constructed deck
	 */
	Collections.shuffle(newDeck, new Random());
	}

}