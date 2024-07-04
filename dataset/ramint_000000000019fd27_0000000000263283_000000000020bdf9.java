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
                times[i] = new Pair(start, end, i);
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
            char [] ids = new char[n];
            ans+="J";
            Pair JLast = new Pair(times[0].getFirst(), times[0].getSecond(), times[0].getThird());
            ids[times[0].getThird()] = 'J';
            Pair CLast = new Pair(-1,-1, -1);
            for(int i=1;i<n;i++) {
                int start = times[i].getFirst();
                int end = times[i].getSecond();
                int index = times[i].getThird();

                if(JLast.getSecond() > start && CLast.getSecond() <= start) {
                    ans+="C";
                    ids[index] = 'C';
                    CLast = new Pair(start,end,index);
                }
                else if (JLast.getSecond() <= start ) {
                    JLast = new Pair(start,end,index);
                    ans+="J";
                    ids[index] = 'J';
                }
                //else if(CLast.getSecond() <= start) {
                   // ans+="C";
                //}
                else {
                    break;
                }
            }

            if(ans.length() == n) {
                ans = "";
                for(int i=0;i<n;i++) {
                    ans+=ids[i];
                }
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
    private Integer third;

    public Pair(Integer first, Integer second, Integer third) {
        this.first = first; 
        this.second = second;            
        this.third = third;
    }

    public Integer getFirst() {
        return first;
    }

    public Integer getSecond() {
        return second;
    }

    public Integer getThird() {
        return third;
    }

    public void setFirst(Integer first  ) {
        this.first = first;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

    public void setThird(Integer third) {
        this.third = third;
    }

}