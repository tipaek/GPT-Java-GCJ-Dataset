import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = Integer.parseInt(scan.nextLine());
        StringBuilder answer = new StringBuilder();    
        for (int i = 0; i < T; ++i) {
            int N = scan.nextInt();
            int sj = 3700, ej = -1;
            int sc = 3700, ec = -1;
            String res = "";
            for (int j = 0; j < N; ++j) {
                int s = scan.nextInt();
                int e = scan.nextInt();
                if (e <= sj || ej <= s) {
                    res += "J";                    
                    sj = Math.min(sj, s);
                    ej = Math.max(ej, e);
                } else if (e <= sc || ec <= s) {
                    res += "C";
                    sc = Math.min(sc, s);
                    ec = Math.max(ec, e);
                } else {
                    res = "IMPOSSIBLE";
                    break;
                }
            }
            answer.append("Case #" + (i + 1) + ": " + res + "\n");
            System.out.println("");
        }
        System.out.println(answer);
    }
}