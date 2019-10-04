/**
 * 
 * @author MLMin
 *
 */
public class Card {

	private int rank;
	private int suit;
	/**
	 * 
	 * @param rank
	 * @param suit
	 */
	public Card(int rank, int suit) {
	this.rank = rank;
	this.suit = suit;
	}

/**
 * 	
 * @return
 */
	public int getCard() {	
		return rank;
	}
	
	public void setCard(int rank) {
		this.rank = rank;
	}
	/**
	 * make int to string conversion
	 */
	@Override
	public String toString() {
		StringBuilder displayCard = new StringBuilder();
	
	
	switch(rank){
	case 11:
	displayCard.append("Jack");
	break;
	case 12:
	displayCard.append("Queen");
	break;
	case 13:
	displayCard.append("King");
	break;
	case 1:
	displayCard.append("Ace");
	break;   
	default:
	displayCard.append(rank); 
	break;
	}
	  
	displayCard.append(" of ");
	  /**
	   * converting suit to string
	   */
	switch(suit){
	case 0:
	displayCard.append("Spades");
	break;
	case 1:
	displayCard.append("Hearts");
	break;
	case 2:
	displayCard.append("Clubs");
	break;
	case 3:
	displayCard.append("Diamonds");
	break;
	default:
	break;
	}	  
	/**
	 * Display the built card
	 */
	return displayCard.toString();
	}
	  
	}