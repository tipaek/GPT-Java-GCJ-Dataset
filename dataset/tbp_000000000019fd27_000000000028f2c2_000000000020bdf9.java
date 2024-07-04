import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);  
        int T = scr.nextInt();
        
        OUTER:
        for (int x = 1; x <= T; x++) {
            int jobsN = scr.nextInt();
            List<Tuple<Integer, Integer>> jobs = new ArrayList<>(jobsN);
            List<Integer> times = new ArrayList<>(jobsN*2);
            Map<Tuple<Integer, Integer>, Integer> map = new HashMap<>();
            for (int i = 0; i < jobsN; i++) {
                int tS = scr.nextInt();
                int tE = scr.nextInt();
                Tuple<Integer, Integer> temp = new Tuple<>(tS, tE);
                jobs.add(temp);
                map.put(temp, i);
            }
            Collections.sort(jobs);
            Tuple<Integer, Integer> c = null;
            Tuple<Integer, Integer> j = null;
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
                    arr[map.get(c)] = 'C';
                    continue;
                }
                
                if (j == null) {
                    j = jobs.get(i);
                    arr[map.get(j)] = 'J';
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