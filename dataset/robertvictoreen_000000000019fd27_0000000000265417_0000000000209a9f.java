import java.util.*;
import java.io.*;
class Solution {
public static void main(String[] args) {
    
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    int T = in.nextInt();

    String S;

    for (int Tcase = 1; Tcase <= T; Tcase++) {
    	S = in.next();

        StringBuilder sb = new StringBuilder();

        int nestingLevel = 0;

        for (int i = 0; i < S.length(); i++) {
            int val = S.charAt(i) - '0';

            while (nestingLevel != val) {
                //add nest
                if (nestingLevel < val) {
                    sb.append('(');
                    nestingLevel++;
                } else {
                    sb.append(')');
                    nestingLevel--;
                }
            }

            sb.append(val);

        }

        while (nestingLevel > 0) {
            sb.append(')');
            nestingLevel--;
        }



    	System.out.println("Case #" + Tcase + ": " + sb.toString());
    }
}
}