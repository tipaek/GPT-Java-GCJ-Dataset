
import java.util.*;
import java.io.*;
public class Solution {
    static Scanner in;

    static class Card{
        public int r,s;
        public Card(int r, int s){
            this.r=r;
            this.s=s;
        }
    }

    private static Card[] cards = new Card[1700];
    private static Card[] tmpcards = new Card[1700];

    private static Card[] history = new Card[1700];

    private static long abs(long a){
        return a>=0?a:-a;
    }

    private static void init(int r, int s) {
        int index = 0;
        for(int i=1;i<=s;i++)
            for(int j=1;j<=r;j++){
                index ++;
                cards[index] = new Card(j,i);
            }
    }

    private static void solve() {
        int r = in.nextInt();
        int s = in.nextInt();
        int lastr;
        int counts;
        int i;
        int historyIndex = 0;

        init( r,  s);
        int lastCard = r*s;
        lastr = cards[lastCard].r;
        counts = 0;
        while(lastCard > 0) {
            while(lastCard>0 && cards[lastCard].r==lastr) {
                counts ++;
                lastCard--;
            }
            if(lastCard==0) break;
            if(counts==s){
                counts=0;
                lastr=cards[lastCard].r;
                continue;
            }
            for(i=lastCard-1;i>0&&cards[i].r!=lastr;i--);

            history[++historyIndex]=new Card(i,lastCard-i);
            for(int j =i+1;j<=lastCard;j++){
                tmpcards[j-i] = cards[j];
            }
            for(int j =1;j<=i;j++){
                tmpcards[lastCard-i+j] = cards[j];
            }
            for(int j =1;j<=lastCard;j++){
                cards[j] = tmpcards[j];
            }
        }

        System.out.println(historyIndex);
        for(i=1;i<=historyIndex;i++){
            System.out.println(history[i].r + " " + history[i].s);
        }
    }

    public static void main(String[] args) {
        in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            System.out.print("Case #" + i + ": " );
            solve();
            System.out.println();
        }
    }
}