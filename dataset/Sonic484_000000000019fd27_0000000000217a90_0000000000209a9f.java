import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = in.nextInt();
            for (int t = 1; t <= testCases; ++t) {
                String input = in.next();
                StringBuilder result = new StringBuilder(input.length() * 3);
                int open = 0;

                for (char c : input.toCharArray()) {
                    int current = Character.getNumericValue(c);
                    if (open < current) {
                        for (int i = 0; i < current - open; ++i) {
                            result.append('(');
                        }
                        open += current - open;
                    } else if (current < open) {
                        for (int i = 0; i < open - current; ++i) {
                            result.append(')');
                        }
                        open -= open - current;
                    }
                    result.append(c);
                }

                if (0 < open) {
                    for (int i = 0; i < open; ++i) {
                        result.append(')');
                    }
                }

                System.out.println("Case #" + t + ": " + result.toString());
            }
        }
    }
    }