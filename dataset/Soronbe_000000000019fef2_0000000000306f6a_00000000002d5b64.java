import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            System.out.print(String.format("Case #%d: ", i));
            solve(in);
        }

/*
        for(int i = -4; i <= 4; ++i) {
            for(int j = -4; j <=4; ++j) {

                Map<Long, Map<Long, String>> cache = new HashMap<>();
                System.out.println(String.format(
                        "%s %s: %s",
                        i,j,
                        solve(i,j,cache)
                ));
            }
        }*/
    }

    private static void solve(Scanner sc) {
        int R = sc.nextInt();
        int S = sc.nextInt();

        Card[] deck = new Card[R * S];
        for (int i = 0; i < S; ++i) {
            for (int j = 0; j < R; ++j) {
                deck[i * R + j] = new Card(j, i);
            }
        }

        List<Move> moves = solve(deck, R, S, new HashMap<>());
        System.out.println(moves.size());

        for(int i = moves.size() -1; i >=0; --i) {
            System.out.println(moves.get(i));
        }
    }

    public static List<Move> solve(Card[] deck, int R, int S, Map<String, Move[]> cache) {
        int lowestWrong = - 1;
        for(int i = deck.length - 1; i>=0; --i) {
            if(deck[i].rank != (i/S)) {
                lowestWrong = i;
                break;
            }
        }

        if(lowestWrong == -1) {
            return new ArrayList<>();
        }

        List<Move> solution = null;
        int intendedRank = lowestWrong%S;
        for(int i = 0; i < deck.length; ++i) {
            if(deck[i].rank != intendedRank) {
                continue;
            }

            Move next = new Move(i+1, lowestWrong - i);
            Card[] nextDeck = doMove(deck, next);

            List<Move> moves = solve(nextDeck, R, S, cache);
            if(moves == null) {
                continue;
            }
            if(solution == null) {
                solution = moves;
            } else if(solution.size() > moves.size() + 1) {
                moves.add(next);
                solution = moves;
            }
        }

        return solution;

    }


    public static Card[] doMove(Card[] deck, Move move) {
        Card[] result = new Card[deck.length];
        for(int i = 0; i < move.b; ++i) {
            result[i] = deck[move.a+i];
        }
        for(int i = 0; i < move.a; ++i) {
            result[move.b+i] = deck[i];
        }

        for(int i = move.a+move.b; i < deck.length; ++i) {
            result[i] = deck[i];
        }

        return result;
    }


    public static class Move {
        int a;
        int b;

        public Move(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public String toString() {
            return a+" "+b;
        }
    }

    public static class Card {
        int rank;
        int suit;

        public Card(int rank, int suit) {
            this.rank = rank;
            this.suit = suit;
        }

        public String toString() {
            return rank + ":" + suit;
        }
    }


}
  