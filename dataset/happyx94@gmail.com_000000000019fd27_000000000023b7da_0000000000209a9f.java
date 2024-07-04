import java.util.*;
import java.io.*;

public class Solution {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int caseNumber = 1; caseNumber <= t; ++caseNumber) {
            final String s = in.nextLine();
            final StringBuilder sp = new StringBuilder();
            int depth = 0;
            for (int i = 0; i < s.length(); i++) {
                final int d = s.charAt(i) - '0';
                int diff = d - depth;
                while (diff > 0) {
                    sp.append('(');
                    diff--;
                }
                while (diff < 0) {
                    sp.append(')');
                    diff++;
                }
                sp.append(s.charAt(i));
            }
            while (depth-- > 0) sp.append(')');
            
            System.out.println("Case #" + caseNumber + ": " + sp.toString());
        }
    }
}