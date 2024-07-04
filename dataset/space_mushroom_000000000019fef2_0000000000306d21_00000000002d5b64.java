import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution{
    private static Scanner input = new Scanner(
            new BufferedReader(new InputStreamReader(System.in)));

    private static String solve(int R, int S){
        List<Card> cards = new ArrayList<>();
        List<List<Integer>> moves = new ArrayList<>();
        initializeCards(cards, R, S);

        while(true){
            boolean flag = false;
            int index = 0;
            int rToFind = 0;
            int totalCardsToMove = 0;
            int deck1CardsToMove = 0;
            int deck2CardsToMove = 0;

            for(int i=R-1; i>=0; i--){
                for(int j=S-1; j>=0; j--){
                    index = i * S + j;
                    if(cards.get(index).r != (i+1)){
                        flag = true;
                        break;
                    }
                }
                if(flag){
                    totalCardsToMove = index + 1;
                    rToFind = i + 1;
                    break;
                }
            }

            if(totalCardsToMove == 0)
                break;

            flag = false;
            for(int i=R-1; i>=0; i--){
                for(int j=S-1; j>=0; j--){
                    index = i * S + j;
                    if(cards.get(index).r == rToFind && index < totalCardsToMove-1){
                        flag = true;
                        break;
                    }
                }
                if(flag){
                    deck1CardsToMove = index + 1;
                    break;
                }
            }
            if(!flag)
                return "Error";

            deck2CardsToMove = totalCardsToMove - deck1CardsToMove;

            cards = moveCards(cards, deck1CardsToMove, deck2CardsToMove);
            moves.add(Arrays.asList(deck1CardsToMove, deck2CardsToMove));
        }

        return movesToString(moves);
    }

    private static List<Card> moveCards(List<Card> cards, int deck1CardsToMove, int deck2CardsToMove) {
        List<Card> deck1 = cards.subList(0, deck1CardsToMove);
        List<Card> deck2 = cards.subList(deck1CardsToMove, deck1CardsToMove + deck2CardsToMove);
        List<Card> deck3 = cards.subList(deck1CardsToMove + deck2CardsToMove, cards.size());

        List<Card> newCards = new ArrayList<>();
        newCards.addAll(deck2);
        newCards.addAll(deck1);
        newCards.addAll(deck3);

        return newCards;
    }

    private static String movesToString(List<List<Integer>> moves) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(moves.size()).append('\n');
        for(int i=0; i<moves.size(); i++){
            stringBuilder.append(moves.get(i).get(0)).append(' ').append(moves.get(i).get(1)).append('\n');
        }
        stringBuilder.setLength(stringBuilder.length()-1);
        return stringBuilder.toString();
    }

    private static void initializeCards(List<Card> cards, int R, int S) {
        for(int s=1; s<=S; s++)
            for(int r=1; r<=R; r++)
                cards.add(new Card(r, s));
    }

    public static void main(String[] args){
        int t = input.nextInt();
        for(int i = 0; i < t; i++){
            int R = input.nextInt();
            int S = input.nextInt();
            System.out.println("Case #" + (i + 1) + ": " + solve(R, S));
        }
    }

    private static class Card{
        int r;
        int s;

        public Card(int r, int s) {
            this.r = r;
            this.s = s;
        }
    }
}