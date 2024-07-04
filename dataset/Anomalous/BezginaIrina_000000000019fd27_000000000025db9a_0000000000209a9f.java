import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(scanner.nextLine());

        for (int a = 0; a < T; a++) {
            char[] S = scanner.nextLine().toCharArray();
            StringBuilder result = new StringBuilder();

            int previousValue = 0;
            for (char c : S) {
                int currentValue = Character.getNumericValue(c);
                int diff = currentValue - previousValue;
                
                if (diff > 0) {
                    result.append("(".repeat(diff));
                } else if (diff < 0) {
                    result.append(")".repeat(-diff));
                }

                result.append(c);
                previousValue = currentValue;
            }
            
            result.append(")".repeat(previousValue));

            System.out.println("Case #" + (a + 1) + ": " + result.toString());
        }
    }
}