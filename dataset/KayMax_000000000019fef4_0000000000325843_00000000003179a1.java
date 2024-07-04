import java.util.*;
import java.io.*;

public class Solution {
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int tc = in.nextInt();
        
        for(int i = 1; i <= tc; i++) {
            System.out.printf("Case #%d: ", i);
            solve(in);
        }
    }
    
    static class Tuple { 
        public final long x; 
        public final String y; 
        public Tuple(long x, String y) { 
            this.x = x; 
            this.y = y; 
        } 
        public String toString() {
            return x + " " + y;
        }
    } 
    
    public static void solve(Scanner in) {
        int U = in.nextInt();
        List<Tuple> pairs = new ArrayList<>();
        Set<Character> chars = new HashSet<>();
        for(int i = 0; i < 10000; i++) {
            long j = in.nextLong();
            String s = in.next();
            int len = s.length();
            for(int l = 0; l < len; l++) {
                chars.add(s.charAt(l));
            }
            pairs.add(new Tuple(j, s));
        }
        
        char[] D = new char[10];
        for(char c : chars) {
            int max = 9;
            Set<Character> appearedInFirst = new HashSet<Character>();
            for(Tuple t : pairs) {
                String i = ""+t.x;
                if(t.y.charAt(0) == c && t.y.length() == i.length() && 
                        Character.getNumericValue(i.charAt(0)) < max) {
                    max = Character.getNumericValue(i.charAt(0));
                }
                if(t.y.charAt(0) == c)
                    appearedInFirst.add(c);
            }
            if(!appearedInFirst.contains(c))
                D[0] = c;
            else
                D[max] = c;
        }
        for(char c : D) {
            System.out.print(c);
        }
        System.out.println();
    }
}
