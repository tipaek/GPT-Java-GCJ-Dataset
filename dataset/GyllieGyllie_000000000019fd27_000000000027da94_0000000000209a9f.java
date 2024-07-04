import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int amountCases = in.nextInt();

        for (int i = 1; i <= amountCases; ++i) {
            StringBuilder builder = new StringBuilder();
            String input = in.next();

            int currentDepth = 0;

            for (int c = 0; c < input.length(); c++) {
                int nextDepth = Integer.parseInt(input.substring(c, c + 1));

                if (nextDepth > currentDepth) {
                    for (int j = 0; j < (nextDepth - currentDepth); j++) {
                        builder.append("(");
                    }
                } else if (nextDepth < currentDepth) {
                    for (int j = 0; j < (currentDepth - nextDepth); j++) {
                        builder.append(")");
                    }
                }

                builder.append(nextDepth);
                currentDepth = nextDepth;
            }

            for (int c = 0; c < currentDepth; c++) {
                builder.append(")");
            }
            
            System.out.println("Case #" + i + ": " + builder.toString());
        }
    }
}
