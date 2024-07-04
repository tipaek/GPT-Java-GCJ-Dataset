import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        int bitSize = scanner.nextInt();

        for (int test = 1; test <= testCases; test++) {
            switch (bitSize) {
                case 10:
                    processQueries(30);
                    System.out.println(fetchValuesFrom(1));
                    break;
                case 20:
                    processQueries(30);
                    String firstHalf = fetchValuesFrom(1);
                    processQueries(30);
                    String secondHalf = fetchValuesFrom(11);
                    System.out.println(firstHalf + secondHalf);
                    break;
                default:
                    System.out.println("0");
                    break;
            }

            String verdict = scanner.next().trim();
            if ("N".equals(verdict)) {
                break;
            }
        }
    }

    private static void processQueries(int queryCount) {
        for (int i = 0; i < queryCount; i++) {
            System.out.println(1);
            scanner.nextInt();
        }
    }

    private static String fetchValuesFrom(int startIndex) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            System.out.println(startIndex + i);
            result.append(scanner.nextInt());
        }
        return result.toString();
    }
}