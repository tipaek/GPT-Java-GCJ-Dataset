import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        int bitSize = scanner.nextInt();

        for (int test = 1; test <= testCases; ++test) {
            String verdict = "";
            if (bitSize == 10) {
                executeQueries(30);
                System.out.println(collectValues(1, 10));
                verdict = scanner.next();
            } else if (bitSize == 20) {
                executeQueries(30);
                String firstHalf = collectValues(1, 10);
                executeQueries(30);
                String secondHalf = collectValues(11, 20);
                System.out.println(firstHalf + secondHalf);
                verdict = scanner.next();
            } else if (bitSize == 100) {
                System.out.println("0");
                verdict = scanner.next();
            }

            if ("N".equals(verdict.trim())) {
                break;
            }
        }
    }

    private static void executeQueries(int numberOfQueries) {
        for (int i = 0; i < numberOfQueries; i++) {
            System.out.println(1);
            scanner.nextInt();
        }
    }

    private static String collectValues(int startIndex, int endIndex) {
        StringBuilder result = new StringBuilder();
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.println(i);
            result.append(scanner.nextInt());
        }
        return result.toString();
    }
}