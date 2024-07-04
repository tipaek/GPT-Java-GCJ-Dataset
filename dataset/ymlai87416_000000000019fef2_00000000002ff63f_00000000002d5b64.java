import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static String   FILENAME;
    static Scanner sc;
    static String   IN;
    static String   OUT;
    static PrintStream out;

    static{
        try{
            /*
            FILENAME = "Solution-large";
            IN = FILENAME + ".in";
            OUT = FILENAME + ".out";
            sc = new Scanner(new File(IN));
            out      = new PrintStream(
                    new FileOutputStream(OUT, false));
                    */

            //IN = "C:\\GitProjects\\algorithm_practice\\temp\\src\\C\\C-test.in";
            IN = null;
            if(IN == null)
                sc = new Scanner(System.in);
            else
                sc = new Scanner(new File(IN));
            out = new PrintStream(System.out);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    private ArrayList<int[]> solve(Card[] deck, int R, int S){
        //we select the card from top which need to place to the bottom => 0...C1 = A
        //we then select C1+1...L = B

        int lastSort = 0;
        //find last sort
        for (int i = deck.length-1; i >=0 ; i--) {
            Card c = deck[i];
            int pos = (c.R-1) * S;
            int epos = c.R*S-1;
            //System.out.println("Card: " + c.R + ", " + c.S + ": S: "+pos + ",E: "+epos );
            if(!(i >= pos && i <= epos)) { //not sort
                lastSort = i + 1;
                break;
            }
        }

        ArrayList<int[]> result = new ArrayList<>();
        if(lastSort == 0)
            return result;

        while(true){
            int a = 0;
            int b = 0;
            //search a card which in place is too far away
            Card maxCard;
            int maxD;
            int loc;
            for(int i=lastSort-1; i>=0; --i){
                Card c = deck[i];
                int pos = (c.R-1) * S;
                int epos = c.R * S - 1;
                int diff = pos-i;
                if(diff > 0){
                    //System.out.println("Choose card: " + i + " " + c.R + "," + c.S);
                    a = i+1;
                    b = lastSort-i-1;
                    break;
                }
            }

            //do the operation
            result.add(new int[]{a, b});
            sortDeck(deck, a, b);

            //find lastSort
            int nlastSort = 0;
            for (int i = lastSort-1; i >=0 ; i--) {
                Card c = deck[i];
                int pos = (c.R-1) * S;
                int epos = c.R*S-1;
                //System.out.println("Card: " + c.R + ", " + c.S + ": S: "+pos + ",E: "+epos );
                if(!(i >= pos && i <= epos)) { //not sort
                    nlastSort = i + 1;
                    break;
                }
            }

            //System.out.println("Debug lastSort: " + nlastSort);

            if(nlastSort == 0)
                break;
            else
                lastSort = nlastSort;
        }

        return result;
    }

    private void sortDeck(Card[] deck, int a, int b){
        Card[] aDeck = new Card[a];

        int cnt = 0;
        for(int i=0; i<a; ++i){
            aDeck[i] = deck[i];
        }

        for(int i=0; i<b; ++i){
            deck[cnt] = deck[a+i];
            ++cnt;
        }

        for(int i=0; i<a; ++i){
            deck[cnt] = aDeck[i];
            ++cnt;
        }
    }


    private String solveBig(int t, int b){

        return "";
    }

    static class Card{
        int R;
        int S;
        public Card(int R, int S){
            this.R = R; this.S = S;
        }
    }

    private void run() throws Exception {
        int t = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= t; i++) {
            out.print("Case #" + i + ": ");
            int R = sc.nextInt();
            int S = sc.nextInt();

            Card[] deck = new Card[R*S];
            int cnt = 0;
            for (int j = 0; j < S; j++) {
                for (int k = 0; k < R; k++) {
                    deck[cnt++] = new Card(k+1, j+1);
                }
            }
            
            ArrayList<int[]> result = solve(deck, R, S);
            out.println(result.size());
            for (int j = 0; j < result.size(); j++) {
                int[] bb = result.get(j);
                out.format("%d %d\n", bb[0], bb[1]);
            }
        }
        sc.close();
        out.close();
    }

    public static void main(String args[]) throws Exception {
        new Solution().run();
    }
}