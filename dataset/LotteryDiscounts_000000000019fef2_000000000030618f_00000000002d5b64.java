import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static class Move {
        int a, b;
    }

    static class Card {
        public Card(int r, int s, int position) {
            this.r = r;
            this.s = s;
            this.position = position;
        }
        int r, s, position;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        Scanner in = new Scanner(
//                "4\n" +
//                        "5 5\n" +
//                        "2 3\n" +
//                        "3 2\n" +
//                        "2 2"
// );


        int t = in.nextInt();
        for (int testCase = 1; testCase <= t; ++testCase) {
            int r = in.nextInt();
            int s = in.nextInt();

            HashMap<Integer, Card> cardLists[] = new HashMap[r];
            Card[] card = new Card[r * s];
            for (int i = 0; i < r; i++) {
                cardLists[i] = new HashMap<>();
                for(int j = 0; j < s; j++) {
                    Card c = new Card(i, j, j * r + i);
                    cardLists[i].put(c.s, c);
                    card[j * r + i] = c;
                }
            }
            cardLists[0].remove(0);

            ArrayList<Move> moves = new ArrayList<Move>();

            int index = 1;
            int currentR = 0;
            while(index < r * s) {
                Card c = cardLists[currentR].remove(cardLists[currentR].keySet().iterator().next());
                int foundPosition = c.position;
                Move move = new Move();
                move.a = r * s - foundPosition;
                move.b = foundPosition - index;
                moves.add(move);
                ArrayList<Card> swap = new ArrayList<>();
                for(int i = index; i < foundPosition; i++) {
                    // swap up
                    int newPos = r * s - (foundPosition - i);
                    swap.add(card[i]);
                    card[i].position = newPos;
                }
                for(int i = foundPosition; i < r * s; i++) {
                    // swap up
                    int newPos = index + i - foundPosition;
                    card[newPos] = card[i];
                    card[newPos].position = newPos;
                }
                for (Card swapper :
                        swap) {
                    card[swapper.position] = swapper;
                }
                index++;
                while(index < r * s && card[index].r == currentR) {
                    cardLists[currentR].remove(card[index].s);
                    index++;
                }
                if (cardLists[currentR].isEmpty()) {
                    currentR++;
                    while(index < r * s && card[index].r == currentR) {
                        cardLists[currentR].remove(card[index].s);
                        index++;
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + moves.size());
            for (Move move :
                    moves) {
                System.out.println("" + move.a + " " + move.b);
            }
        }
    }
}
