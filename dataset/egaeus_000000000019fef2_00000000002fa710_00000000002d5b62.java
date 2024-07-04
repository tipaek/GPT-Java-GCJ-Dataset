/**
 * @author egaeus
 * @date 04/04/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

import static java.lang.Integer.bitCount;
import static java.lang.Integer.parseInt;

public class Solution {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        TreeSet<Long> pot = new TreeSet<>();
        for(long i=0, p=1;i<60;i++,p*=2)
            pot.add(p);
        for (int t = 0; t++ < T; ) {
            sb.append("Case #").append(t).append(": ");
            StringTokenizer st = new StringTokenizer(in.readLine());
            long X = parseInt(st.nextToken()), Y = parseInt(st.nextToken());
            long x = Math.abs(X), y = Math.abs(Y);
            if (x % 2 == y % 2)
                sb.append("IMPOSSIBLE");
            else {
                boolean ws = false;
                if ((x & y) == 0 && pot.contains((x|y)+1)) {
                    ws=true;
                    for (int i = 0; i < Long.bitCount(x | y); i++)
                        if (((1 << i) & x) != 0)
                            sb.append(X > 0 ? "E" : "W");
                        else if (((1 << i) & y) != 0)
                            sb.append(Y > 0 ? "N" : "S");
                } else if (x % 2 == 1) {
                    x += 2;
                    if ((x & y) == 0 && pot.contains((x|y)+1)) {
                        ws=true;
                        sb.append(X < 0 ? "E" : "W");
                        for (int i = 1; i < Long.bitCount(x | y); i++)
                            if (((1 << i) & x) != 0)
                                sb.append(X > 0 ? "E" : "W");
                            else if (((1 << i) & y) != 0)
                                sb.append(Y > 0 ? "N" : "S");
                    }

                } else {
                    y += 2;
                    if ((x & y) == 0 && pot.contains((x|y)+1)) {
                        ws=true;
                        sb.append(Y < 0 ? "N" : "S");
                        for (int i = 1; i < Long.bitCount(x | y); i++)
                            if (((1 << i) & x) != 0)
                                sb.append(X > 0 ? "E" : "W");
                            else if (((1 << i) & y) != 0)
                                sb.append(Y > 0 ? "N" : "S");
                    }

                }
                if(!ws)
                    sb.append("IMPOSSIBLE");
            }

            sb.append("\n");
        }
        System.out.print(new String(sb));
    }
}
