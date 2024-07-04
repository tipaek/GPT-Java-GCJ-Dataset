import java.io.*;
import java.util.*;
public class Solution{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < t; i ++) {
            String s = br.readLine();
            StringBuilder output = new StringBuilder();
            int depth = 0;
            for (int c = 0; c < s.length(); c ++) {
                int digit = Character.getNumericValue(s.charAt(c));
                while (depth != digit) {
                    if (digit > depth) {
                        output.append("(");
                        depth ++;
                    } else {
                        output.append(")");
                        depth --;
                    }
                }
                output.append(s.charAt(c));
            }
            while (depth > 0) {
                output.append(")");
                depth --;
            }
            System.out.println("Case #" + Integer.toString(i + 1) + ": " + output.toString());
        }
    }
}