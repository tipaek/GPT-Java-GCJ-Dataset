import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            String S = sc.next();
            StringBuilder str = new StringBuilder();

            int currentDepth = 0;
            for (int i = 0; i < S.length(); i++) {
                int num = S.charAt(i) - 48;

                if (num == currentDepth) {
                    str.append(num);
                    continue;
                }

                int depthDiff = currentDepth - num;

                if (depthDiff < 0) { // add '('
                    while (depthDiff < 0) {
                        str.append('(');
                        depthDiff++;
                    }
                } else { // add ')'
                    while (depthDiff > 0) {
                        str.append(')');
                        depthDiff--;
                    }
                }

                str.append(num);
                currentDepth = num;
            }

            // for ending the string
            int depthDiff = currentDepth - 0;
            while (depthDiff > 0) {
                str.append(')');
                depthDiff--;
            }

            String line = "Case #" + test_case + ": " + str.toString() + "\n";
            System.out.print(line);
        }
    }
}
