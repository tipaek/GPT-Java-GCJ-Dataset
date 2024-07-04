import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int tt = 1; tt <= t; ++tt) {
            String str=in.next();
            StringBuilder sb=new StringBuilder();
            int now=-1;
            int prev=-1;
            int next=-1;
            for(int i=0;i<str.length();) {
                now = Integer.parseInt(str.charAt(i) + "");
                if(i+1<str.length()){
                    next=Integer.parseInt(str.charAt(i+1)+"");
                    if(now==next){
                        sb.append(now);
                        i++;
                        prev=now;
                        continue;
                    }
                }
                if(prev==now){
                    sb.append(now);
                    i++;
                    prev=-1;
                    continue;
                }
                if (prev != -1 && prev > now) {
                    for (int j = 1; j <= prev - now; j++)
                        sb.append(")");
                } else if (prev != -1 && prev < now) {
                    for (int j = 1; j <= prev; j++)
                        sb.append(")");
                    for (int j = 1; j <= now; j++)
                        sb.append("(");
                }
                if (prev == -1) {
                    for (int j = 1; j <= now; j++)
                        sb.append("(");
                }
                sb.append(now);
                prev = now;
                if (i + 1 < str.length()) {
                    next = Integer.parseInt(str.charAt(i + 1) + "");
                } else {
                    for (int j = 1; j <= now; j++)
                        sb.append(")");
                }
                i++;
            }
            System.out.println("Case #" + tt + ": " + sb.toString());
        }
    }
}