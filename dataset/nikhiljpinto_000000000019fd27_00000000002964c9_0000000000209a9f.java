import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();
        for (int t = 1; t <= tests; t++) {
            String S = in.next();
            int stackSize = 0;
            StringBuilder output = new StringBuilder("");
            for (int i = 0; i < S.length(); i++) {
                String digit = Character.toString(S.charAt(i));
                int num = Integer.parseInt(digit);
                int diff = stackSize - num;
                if (diff > 0) {
                    stackSize -= diff;
                    while (diff > 0) {
                        output.append(")");
                        diff--;
                    } 
                    output.append(digit);
                } else {
                    int abs = Math.abs(diff);
                    stackSize += abs;
                    while (abs > 0) {
                        output.append("(");
                        abs--;
                    } 
                    output.append(digit);
                }
            }
            while (stackSize > 0) {
                output.append(")");
                stackSize--;
            }
            String finalParenthesis = output.toString();
            System.out.println("Case #" + t + ": " + finalParenthesis);
        }
    }
}