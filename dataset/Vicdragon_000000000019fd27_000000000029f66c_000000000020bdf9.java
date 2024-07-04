import java.util.*;
import java.io.*;

public class Solution {
    private static boolean overlap(int s1, int e1, int s2, int e2) {
        if (s1 == s2 || e1 == e2)
            return true;
        if (s1 < s2 && s2 < e1)
            return true;
        if (s1 > s2 && s1 < e2)
            return true;
        return false;
    }
    
    private static boolean forCJ(List<Integer> X, int s, int e, String o) {
        boolean assign = true;
        for (int x=0; x<X.size(); x+=2) {
            //System.out.println(o + " " + overlap(s, e, X.get(x), X.get(x+1)));
            if (overlap(s, e, X.get(x), X.get(x+1))) {
                assign = false;
                break;
            }
        }
        //System.out.println(assign);
        return assign;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int i=1; i<=T; i++) {
            int N = input.nextInt();
            String out = "";
            List<Integer> C = new ArrayList<>();
            List<Integer> J = new ArrayList<>();
            String prev = "C";
            //System.out.println(N);
            for (int j=0; j<N; j++) {
                int s = input.nextInt();
                int e = input.nextInt();
                boolean assign = false;
                if (prev == "C") {
                    assign = forCJ(C, s, e, "C");
                    //System.out.println("XC");
                    if (!assign) {
                        prev = "J";
                        assign = forCJ(J, s, e, "J");
                    }
                }
                else if (prev == "J") {
                    assign = forCJ(J, s, e, "J");
                    //System.out.println("XJ");
                    if (!assign) {
                        prev = "C";
                        assign = forCJ(C, s, e, "C");
                    }
                }
                if (assign) {
                    out += prev;
                    if (prev == "C") {
                        C.add(s);
                        C.add(e);
                    } else {
                        J.add(s);
                        J.add(e);
                    }
                } else {
                    out = "IMPOSSIBLE";
                    break;
                }
            }
            System.out.println(String.format("Case #%d: %s", i, out));
        }
    }
}