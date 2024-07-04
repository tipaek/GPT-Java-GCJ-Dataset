import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        int bitSize = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            if (bitSize == 10) {
                executeQueries(30);
                System.out.println(retrieveValues(1));
                if ("N".equals(scanner.nextLine().trim())) {
                    break;
                }
            } else if (bitSize == 20) {
                executeQueries(30);
                String firstHalf = retrieveValues(1);
                executeQueries(30);
                String secondHalf = retrieveValues(11);
                System.out.println(firstHalf + secondHalf);
                if ("N".equals(scanner.nextLine().trim())) {
                    break;
                }
            }
        }
    }

    private static void executeQueries(int numQueries) {
        for (int i = 0; i < numQueries; i++) {
            System.out.println(1);
            scanner.nextInt();
        }
    }

    private static String retrieveValues(int startIndex) {
        StringBuilder values = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            System.out.println(startIndex + i);
            values.append(scanner.nextInt());
        }
        return values.toString();
    }
}