
import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String s = in.nextLine();
            StringBuilder sb = new StringBuilder();
            int currentDepth = 0;
            for (int j=0; j<s.length(); j++) {
                char c = s.charAt(j);
                int v = (c - '0');
                for (int k = 0; k < v - currentDepth; k++) {
                    sb.append("(");
                }
                for (int k = 0; k < currentDepth-v; k++) {
                    sb.append(")");
                }
                currentDepth += (v - currentDepth);
                sb.append(c);
            }
            for (int k = 0; k < currentDepth; k++) {
                sb.append(")");
            }

            System.out.println("Case #" + i + ": " + sb.toString());
        }
    }
}