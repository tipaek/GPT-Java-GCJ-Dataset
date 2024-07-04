import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();

        for (int i = 1; i <= t; ++i) {
            String data = in.nextLine();
            System.out.println("Case #" + i + ": " + createNestedDepth(data));
        }

        in.close();
    }

    public static String createNestedDepth(String data) {
        StringBuilder sb = new StringBuilder();
        int currentDepth = 0;

        for (char ch : data.toCharArray()) {
            int digit = Character.getNumericValue(ch);
            while (currentDepth < digit) {
                sb.append('(');
                currentDepth++;
            }
            while (currentDepth > digit) {
                sb.append(')');
                currentDepth--;
            }
            sb.append(digit);
        }

        while (currentDepth > 0) {
            sb.append(')');
            currentDepth--;
        }

        return sb.toString();
    }
}