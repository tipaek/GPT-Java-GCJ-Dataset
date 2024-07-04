import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = Integer.parseInt(in.nextLine());
		
		for (int t=1; t<=T; t++){
			List<String> swaps;
			swaps = doit(in.nextInt(), in.nextInt());

			System.out.printf("Case #%d: %s%n", t, swaps.size());
			for (String result : swaps) {
				System.out.printf("%s%n", result);
			}
		}
	}

	private static List<String> doit(int ranks, int suits) {
		Solution s = new Solution();
		List<Card> deck = new LinkedList<Card>();
		for (int i = 1; i<= suits; i++) {
			for (int j = 1 ; j<=ranks; j++) {
				Card theCard = s.new Card(j, i);
				deck.add(theCard);
			}
		}
		
		List<String> swaps = new LinkedList<String>();
	//	System.out.println(deck);
		while (!isInorder(deck)) {
			deck = doSwapping(deck, ranks, suits, swaps);
			//System.out.println(deck);
		}
		
		
		//System.out.println("Deck in order after " + swaps + "swaps: " + isInorder(deck));
		return swaps;
	}
	
	private static List<Card> doSwapping(List<Card> deck, int ranks, int suits, List<String> swaps) {
		int topSuit = deck.get(0).suit;
		int firstCut = 0;
		for(int i = 0; i<deck.size() ; i++) {
			if (deck.get(i).suit != topSuit) {
				firstCut = i;
				break;
			}
		}
		int secondCut = deck.size()-1;
		if (ranks>suits) {
			int endFirstCutRank = deck.get(firstCut-1).rank;
			secondCut = firstCut;
			for(int i = firstCut+1; i<deck.size() ; i++) {
				if (deck.get(i).rank == endFirstCutRank) {
					secondCut = i;
					break;
				} 
			}
		} else {
			int firstCutRank = deck.get(firstCut).rank;
			for(int i = firstCut+1; i<deck.size() ; i++) {
				if (deck.get(i).rank == firstCutRank) {
					secondCut = i+1;
					break;
				} 
			}
			
		}
		
	//	System.out.println("swap " + firstCut + " " + (secondCut-firstCut));
		swaps.add(firstCut + " " + (secondCut-firstCut));
		secondCut = Math.min(secondCut, deck.size()-1);
		if (firstCut > 0 && secondCut > firstCut) {
			List<Card> a = deck.subList(0, firstCut);
			List<Card> b = deck.subList(firstCut, secondCut);
			List<Card> c = deck.subList(secondCut, deck.size());
			deck = new LinkedList<Card>();
			deck.addAll(b);
			deck.addAll(a);
			deck.addAll(c);
		}
		return deck;
		
		
	}

	private static boolean isInorder(List<Card> deck) {
		boolean first = true;
		Card lastCard = deck.get(0);
		for (Card theCard : deck) {
			if (!first) {
				if (theCard.rank < lastCard.rank) {
					return false;
				}
				lastCard = theCard;
			} else {
				first = !first;
			}
		}
		return true;
	}

	class Card{
		@Override
		public String toString() {
			return "Card [rank=" + rank + ", suit=" + suit + "]";
		}
		public Card(int rank, int suit) {
			super();
			this.rank = rank;
			this.suit = suit;
		}
		int rank;
		int suit;
	}

}
