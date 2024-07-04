import java.io.*;
import java.util.*;

public class NestingDepth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int t = 1; t <= T; t++) {
            String s = sc.nextLine();
            StringBuilder output = new StringBuilder();
            int currentDepth = 0;

            for (char ch : s.toCharArray()) {
                int digit = Character.getNumericValue(ch);
                while (currentDepth < digit) {
                    output.append('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    output.append(')');
                    currentDepth--;
                }
                output.append(digit);
            }

            while (currentDepth > 0) {
                output.append(')');
                currentDepth--;
            }

            System.out.println("Case #" + t + ": " + output);
        }

        sc.close();
    }
}