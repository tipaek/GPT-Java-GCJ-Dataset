import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = scanner.nextInt();
        for (int t = 1; t <= tests; ++t) {
            String seq = scanner.next();
            StringBuilder sb = new StringBuilder();
            int currNesting = 0;
            for (int i = 0; i < seq.length(); i++) {
                int toAppend = (seq.charAt(i) - '0') - currNesting;
                currNesting += toAppend;
                if (toAppend > 0) {
                    for (int j = 0; j < Math.abs(toAppend); j++) {
                        sb.append('(');
                    }
                } else {
                    for (int j = 0; j < Math.abs(toAppend); j++) {
                        sb.append(')');
                    }
                }
                sb.append(seq.charAt(i));
            }
            for (int j = 0; j < Math.abs(currNesting); j++) {
                sb.append(')');
            }
            System.out.println("Case #" + t + ": " + sb.toString());
        }
    }
}