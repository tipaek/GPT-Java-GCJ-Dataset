import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    private static Scanner in;
    private static PrintStream out;

    private static final String CASE_PREFIX = "Case #";
    private static final String COLON_SPACE = ": ";

    private static final int MAX_QUERIES = 10001;
    private static int[] queries = new int[MAX_QUERIES];
    private static String[] responses = new String[MAX_QUERIES];

    public static void main(String[] args) throws Throwable {
        in = new Scanner(System.in);
        // in = new Scanner(new FileInputStream("./src/main/resources/codejam/year2020/round1c/B/B.in"));
        out = System.out;
        // out = new PrintStream(new FileOutputStream("A_RobotProgrammingStrategy.out"));

        int testCases = in.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int U = in.nextInt();
            LinkedList<String>[] digitResponses = new LinkedList[10];
            HashSet<Character> allDigits = new HashSet<>();

            for (int i = 0; i < 10; i++) {
                digitResponses[i] = new LinkedList<>();
            }

            for (int i = 0; i < 10000; i++) {
                int queryIndex = in.nextInt();
                String response = in.next();
                for (char ch : response.toCharArray()) {
                    allDigits.add(ch);
                }

                queries[i] = queryIndex;
                responses[i] = response;

                if (queryIndex < 10) {
                    digitResponses[queryIndex].add(response);
                }
            }

            char[] result = new char[10];
            for (int i = 1; i <= 9; i++) {
                for (String response : digitResponses[i]) {
                    char firstChar = response.charAt(0);
                    boolean found = false;
                    for (int j = 1; j < i; j++) {
                        if (firstChar == result[j]) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        result[i] = firstChar;
                        break;
                    }
                }
            }

            char missingChar = findMissingChar(allDigits, result, 1, 9);
            result[0] = missingChar;

            out.print(CASE_PREFIX);
            out.print(t);
            out.print(COLON_SPACE);
            out.println(new String(result));
        }
        out.flush();
    }

    private static char findMissingChar(HashSet<Character> allDigits, char[] result, int start, int end) {
        for (char ch : allDigits) {
            boolean found = false;
            for (int i = start; i <= end; i++) {
                if (ch == result[i]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return ch;
            }
        }
        throw new RuntimeException("Missing character not found");
    }
}