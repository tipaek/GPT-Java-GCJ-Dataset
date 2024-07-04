import javax.swing.*;
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastReader scanner = new FastReader();
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputString = scanner.next();
            List<Character> characters = new ArrayList<>();
            int maxDigit = Integer.MIN_VALUE;

            // Convert string to list of characters and find the maximum digit
            for (char ch : inputString.toCharArray()) {
                characters.add(ch);
                if (Character.isDigit(ch)) {
                    maxDigit = Math.max(maxDigit, Character.getNumericValue(ch));
                }
            }

            // Process each digit level from 0 to maxDigit
            for (int level = 0; level < maxDigit; level++) {
                List<Character> updatedList = new ArrayList<>();
                boolean isClosed = true;

                for (char ch : characters) {
                    if (Character.isDigit(ch)) {
                        int digit = Character.getNumericValue(ch);
                        if (isClosed) {
                            if (digit > level) {
                                updatedList.add('(');
                                updatedList.add(ch);
                                isClosed = false;
                            } else {
                                updatedList.add(ch);
                            }
                        } else {
                            if (digit <= level) {
                                updatedList.add(')');
                                updatedList.add(ch);
                                isClosed = true;
                            } else {
                                updatedList.add(ch);
                            }
                        }
                    } else {
                        updatedList.add(ch);
                    }
                }
                if (!isClosed) {
                    updatedList.add(')');
                }
                characters = updatedList;
            }

            // Construct the final result string
            StringBuilder result = new StringBuilder();
            for (char ch : characters) {
                result.append(ch);
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}

class FastReader {
    private BufferedReader bufferedReader;
    private StringTokenizer stringTokenizer;

    public FastReader() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() {
        while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
            try {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringTokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public String nextLine() {
        String str = "";
        try {
            str = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}