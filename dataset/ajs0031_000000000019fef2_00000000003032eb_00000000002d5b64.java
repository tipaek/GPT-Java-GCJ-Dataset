
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static HashMap<String, String> map = new HashMap<String, String>();
	static List<Integer> Amoves = new LinkedList<Integer>();
	static List<Integer> Bmoves = new LinkedList<Integer>();
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numCases = scanner.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		List<Integer> coordinates = new LinkedList<Integer>();
		List<Card> deck = new LinkedList<Card>();
		for (int curCase = 1; curCase <= numCases; curCase++) {
			int R = scanner.nextInt();
			int S = scanner.nextInt();
			deck.clear();
			for (int s = 1; s <= S; s++) {
				for (int r = 1; r <= R; r++) {
					deck.add(new Card(r, s));
				}
			}
			sortDeck(deck);
			System.out.println("Case #" + curCase + ": " + Amoves.size());
			for(int i = 0; i < Amoves.size(); i++) {
				System.out.println(Amoves.get(i) + " " + Bmoves.get(i));
			}
			Amoves.clear();
			Bmoves.clear();
		}
		scanner.close();
	}

	public static void sortDeck(List<Card> deck) {
		int A = 0, B = 0;
		
		Card c = deck.remove(deck.size() - 1); // always remove one card at least
		int rank = c.rank;
		int maxRank = rank;
		if(deck.isEmpty() || allSame(deck)) {
			return;
		}
		while (deck.get(deck.size() - 1).rank == rank) {
			deck.remove(deck.size() - 1);
		}
		if(deck.isEmpty()) {
			return;
		}
		List<Integer> possibleB = new LinkedList<Integer>();
		for (int i = deck.size() - 1; i >= 0; i--) {
			if(deck.get(i).rank == maxRank) {
				possibleB.add(B);
			}
			B++;
		}
		if(possibleB.isEmpty()) {
			sortDeck(deck);
		} else {
			int bestB = -1;
			int bestScore = Integer.MAX_VALUE;
			for(int curB : possibleB) {
				int curA = deck.size() - curB;
				if(Math.abs(curA - curB) < bestScore) {
					bestB = curB;
					bestScore = Math.abs(curA - curB);
				}
			}
			B = bestB;
			A = deck.size() - B;
			Amoves.add(A);
			Bmoves.add(B);
			deck = cutDeck(deck, A, B);
			sortDeck(deck);
		}
	}

	public static List<Card> cutDeck(List<Card> deck, int A, int B) {
		
		List<Card> newDeck = new LinkedList<Card>();
		for (int i = A; i < A + B; i++) {
			newDeck.add(deck.get(i));
		}
		for (int i = 0; i < A; i++) {
			newDeck.add(deck.get(i));
		}
		return newDeck;
	}
	
	public static boolean allSame(List<Card> deck) {
		if(deck.size() <= 1) {
			return true;
		}
		for(int i = 0; i < deck.size() - 1; i ++) {
			if(deck.get(i).rank != deck.get(i+1).rank) {
				return false;
			}
		}
		return true;
	}
}

class Card {
	int rank;
	int suit;

	public Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public String toString() {
		return "(" + rank + "," + suit + ")";
	}
}
