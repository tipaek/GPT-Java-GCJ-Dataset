import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);  
        int T = scr.nextInt();
        
        for (int x = 1; x <= T; x++) {
            int jobsN = scr.nextInt();
            List<Tuple<Integer, Integer>> jobs = new ArrayList<>(jobsN);
            List<Integer> times = new ArrayList<>(jobsN*2);
            while (jobsN-- > 0) {
                int tS = scr.nextInt();
                int tE = scr.nextInt();
                Tuple<Integer, Integer> temp = new Tuple<>(tS, tE);
                jobs.add(temp);
            }
            Collections.sort(jobs);
            Tuple<Integer, Integer> c = null;
            Tuple<Integer, Integer> j = null;
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < jobs.size(); i++) {
                int time = jobs.get(i).x;
                if (c != null && c.y <= time) {
                    c = null;
                }
                if (j != null && j.y <= time) {
                    j = null;
                }
                if (c != null && j != null) {
                    ans = new StringBuilder("IMPOSSIBLE");
                    break;
                }
                
                if (c == null) {
                    c = jobs.get(i);
                    ans.append('C');
                    continue;
                }
                
                if (j == null) {
                    j = jobs.get(i);
                    ans.append('J');
                }
            }
            System.out.println("Case #" + x + ": " + ans.toString());
        }
    }
    
 }
 
class Tuple<X extends Comparable<X>, Y extends Comparable<Y>> implements Comparable<Tuple<X,Y>>{
    X x;
    Y y;
        
    public Tuple(X x, Y y){
        this.x = x;
        this.y = y;
    }    
    
    public int compareTo(Tuple<X , Y> other) {
        if (x.compareTo(other.x) == 0) {
            return y.compareTo(other.y);
        }
        return x.compareTo(other.x);
    }
}