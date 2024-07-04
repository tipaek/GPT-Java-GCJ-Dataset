import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String [] args ) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for(int tt=0;tt<t;tt++) {
            
            int n = scanner.nextInt();
            Pair [] times = new Pair[n];
            for(int i=0;i<n;i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                times[i] = new Pair(start, end);
            }

             Arrays.sort(times, new Comparator<Pair>(){
                 @Override 
                 public int compare(Pair p1, Pair p2) {
                     if (p1.getFirst() == p2.getFirst()) {
                         return p1.getSecond().compareTo(p2.getSecond());
                     }
                     return p1.getFirst().compareTo(p2.getFirst());
                 }
             });

            String ans = "";
            ans+="J";
            Pair JLast = new Pair(times[0].getFirst(), times[0].getSecond());
            Pair CLast = new Pair(-1,-1);
            for(int i=1;i<n;i++) {
                int start = times[i].getFirst();
                int end = times[i].getSecond();

                if(JLast.getSecond() > start && CLast.getSecond() <= start) {
                    ans+="C";
                    CLast = new Pair(start,end);
                }
                else if (JLast.getSecond() <= start ) {
                    JLast = new Pair(start,end);
                    ans+="J";
                }
                else if(CLast.getSecond() <= start) {
                    ans+="C";
                }
                else {
                    break;
                }
            }

            if(ans.length() == n) {
                System.out.println("Case #" + (tt+1) + ": " + ans);
            }
            else {
                System.out.println("Case #" + (tt+1) + ": " + "IMPOSSIBLE");
            }
        }
    }
    
}

class Pair  {
        
    private Integer first;
    private Integer second; 

    public Pair(Integer first, Integer second) {
        this.first = first; 
        this.second = second;            
    }

    public Integer getFirst() {
        return first;
    }

    public Integer getSecond() {
        return second;
    }

    public void setFirst(Integer first  ) {
        this.first = first;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

}