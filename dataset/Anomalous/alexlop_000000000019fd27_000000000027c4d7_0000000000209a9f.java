import java.util.*;
import java.io.*;

public class Solution {
    
    public static void createString(String depths, int caseNum) {
        StringBuilder sb = new StringBuilder();
        int currentDepth = 0, previousDepth = 0, parenCount = 0;

        for (int i = 0; i < depths.length(); i++) {
            currentDepth = Character.getNumericValue(depths.charAt(i));
            if (i > 0) {
                previousDepth = Character.getNumericValue(depths.charAt(i - 1));
            }

            if (currentDepth == previousDepth) {
                sb.append(depths.charAt(i));
            } else if (currentDepth > previousDepth) {
                parenCount = currentDepth - previousDepth;
                while (parenCount-- > 0) {
                    sb.append('(');
                }
                sb.append(depths.charAt(i));
            } else {
                parenCount = previousDepth - currentDepth;
                while (parenCount-- > 0) {
                    sb.append(')');
                }
                sb.append(depths.charAt(i));
            }
        }

        while (currentDepth-- > 0) {
            sb.append(')');
        }

        System.out.println("Case #" + caseNum + ": " + sb.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCases; i++) {
            String depths = scanner.nextLine();
            createString(depths, i);
        }
    }
}