import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);  
        int T = scr.nextInt();
        
        OUTER:
        for (int x = 1; x <= T; x++) {
            int jobsN = scr.nextInt();
            List<Tuple<Integer, Integer, Integer>> jobs = new ArrayList<>(jobsN);
            for (int i = 0; i < jobsN; i++) {
                int tS = scr.nextInt();
                int tE = scr.nextInt();
                Tuple<Integer, Integer, Integer> temp = new Tuple<>(tS, tE, i);
                jobs.add(temp);
      
            }
            Collections.sort(jobs);
            Tuple<Integer, Integer, Integer> c = null;
            Tuple<Integer, Integer, Integer> j = null;
            char[] arr = new char[jobsN];
            for (int i = 0; i < jobs.size(); i++) {
                int time = jobs.get(i).x;
                if (c != null && c.y <= time) {
                    c = null;
                }
                if (j != null && j.y <= time) {
                    j = null;
                }
                if (c != null && j != null) {
                    System.out.println("IMPOSSIBLE");
                    continue OUTER;
                }
                
                if (c == null) {
                    c = jobs.get(i);
                    arr[c.z] = 'C';
                    continue;
                }
                
                if (j == null) {
                    j = jobs.get(i);
                    arr[j.z] = 'J';
                }
            }
            StringBuilder result = new StringBuilder();
            for (char chr : arr) {
                result.append(chr);
            }
            System.out.println("Case #" + x + ": " + result.toString());
        }
    }
    
 }
 
class Tuple<X extends Comparable<X>, Y extends Comparable<Y>, Z extends Comparable<Z>> 
    implements Comparable<Tuple<X,Y,Z>>{
    X x;
    Y y;
    Z z;
    
    public Tuple(X x, Y y, Z z){
        this.x = x;
        this.y = y;
        this.z = z;
    }    
    
    public int compareTo(Tuple<X , Y, Z> other) {
        if (x.compareTo(other.x) == 0) {
            if (y.compareTo(other.y) == 0) {
                return z.compareTo(other.z);
            }
            return y.compareTo(other.y);
        }
        return x.compareTo(other.x);
    }
}