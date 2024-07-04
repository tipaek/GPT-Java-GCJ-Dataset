// One clear intuition - you will never move the last card

// Idea: always start out by moving R cards as pile A, then the
// remaining cards except for the last one as pile B

// The first move will ensure that one card gets put into the
// correct position, so now we can move everything except for 
// the last two cards

// In the next move, we take pile A until we find a card with
// the highest rank (use the floor function over the number
// of cards sorted correctly divided by the suit size to
// determine what suit value we need to be looking for)

// If we don't take some of the remaining cards in pile B, then
// we know that they are all sorted

import java.util.*;
import java.io.*;

public class Solution implements Comparable<Solution> {
    
    int rank;
    int suit;
    
    public Solution(int r, int s) {
        rank = r;
        suit = s;
    }
    
    public int compareTo(Solution other) {
        Integer one = new Integer(this.rank);
        Integer two = new Integer(other.rank);
        return one.compareTo(two);
    }
    
    public static Solution[] generateDeck(int r, int s) {
        Solution[] myDeck = new Solution[r * s];
        int count = 0;
        for (int i = 1; i <= s; i++) {
            for (int j = 1; j <= r; j++) {
                myDeck[count] = new Solution(j, i);
                count++;
            }
        }
        
        return myDeck;
    }
    
    
    // a denotes the size of pile a
    // b denotes the size of pile b
    public static Solution[] shuffle(Solution[] myDeck, int a, int b) {
        Solution[] shuffled = new Solution[myDeck.length];
        
        // move pile b into position
        for (int i = 0; i < b; i++) {
            shuffled[i] = myDeck[a + i];
        }
        
        // move pile a into position
        int count = 0;
        for (int j = b; j < a + b; j++) {
            shuffled[j] = myDeck[count];
            count++;
        }
        
        // save the remaining cards into position
        for (int k = a + b; k < shuffled.length; k++) {
            shuffled[k] = myDeck[k];
        }
        
        return shuffled;
    }
    
    public static Solution findOccurrences(Solution[] myDeck, int sortedCards, int r, int s) {
        int highestRank = r - sortedCards / s;
        
        if (highestRank == 1) {
            return null; // deck has been sorted!
        }
        
        Solution occurrences = new Solution(0,0);
        
        for (int i = 0; i < myDeck.length - sortedCards; i++) {
            if (myDeck[i].rank == highestRank) {
                occurrences.rank = i + 1;
                break;
            }
        }
        
        // Don't move the next last cards if it can be avoided
        int extraSorted = 1;
        while (myDeck[myDeck.length - (sortedCards + extraSorted)].rank == highestRank) {
            occurrences.suit = extraSorted; // we can ignore this "unsorted" card, as it is actually sorted!
            extraSorted++;
        }
        
        return occurrences;
    }
    
    public static ArrayList<Solution> generateMoves (Solution[] deck, int r, int s) {
        
        ArrayList<Solution> myPiles = new ArrayList<Solution>();
        int sortedCards = 1; // keep track of number of sorted cards
        
        // Perform the first move
        myPiles.add(new Solution(r, (r*s) - (r + sortedCards))); // (a,b) format
        deck = shuffle(deck, r, (r*s) - (r + sortedCards));
        sortedCards++;
        
        // Figure out the rest of our moves
        Solution values = findOccurrences(deck, sortedCards, r, s);
        while (values != null) {
            sortedCards = sortedCards + values.suit;
            myPiles.add(new Solution(values.rank, (r*s) - (values.rank + sortedCards))); // (a,b) format
            deck = shuffle(deck, values.rank, (r*s) - (values.rank + sortedCards));
            sortedCards++;
            values = findOccurrences(deck, sortedCards, r, s);
        }
        
        return myPiles;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();
        
        for (int x = 1; x <= testCases; x++) {
            String answer = "Case #" + x + ": ";
            
            // Create the deck
            int r = in.nextInt();
            int s = in.nextInt();
            Solution[] deck = generateDeck(r, s);
            
            // Generate answer
            ArrayList<Solution> myPiles = generateMoves(deck, r, s);
            
            answer = answer + myPiles.size() + "\n";
            
            for (int i = 0; i < myPiles.size(); i++) {
                Solution pile = myPiles.get(i);
                answer = answer + pile.rank + " " + pile.suit + "\n";
            }
            
            System.out.println(answer);
        }
        
        in.close();
    }
}