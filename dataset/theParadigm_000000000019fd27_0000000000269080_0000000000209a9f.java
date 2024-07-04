import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            String s = in.next();
            final String res = process(s);
            System.out.println("Case #"+i+": "+res);
        }
  }
      public static String process(String s) {
        StringBuilder sb = new StringBuilder();
        int openP= 0;
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i) - '0';
            if(a > openP){
                int p = a -openP;
                for(int j = 0; j < p; j++) {
                    sb.append("(");
                    openP++;
                }
                sb.append(a);
            }
            else if(a < openP){
                int p = openP-a;
                for(int j = 0; j < p; j++) {
                    sb.append(")");
                    openP--;
                }
                sb.append(a);
            }
            else sb.append(a);
        }
        if(openP > 0){
            for (int j = openP; j > 0; j--){
                sb.append(")");
            }
        }
        return sb.toString();
    }
}
