import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    static Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        int bitSize = scanner.nextInt();

        for (int test = 1; test <= testCases; ++test) {
            if (bitSize == 10) {
                executeQueries(30);
                System.out.println(fetchValues(1));
                if ("N".equals(scanner.next().trim())) {
                    break;
                }
            } else if (bitSize == 20) {
                executeQueries(30);
                String firstHalf = fetchValues(1);
                executeQueries(30);
                String secondHalf = fetchValues(11);
                System.out.println(firstHalf + secondHalf);
                if ("N".equals(scanner.next().trim())) {
                    break;
                }
            } else if (bitSize == 100) {
                System.out.println("0");
                if ("N".equals(scanner.next().trim())) {
                    break;
                }
            }
        }
    }

    static void executeQueries(int numberOfQueries) {
        for (int i = 0; i < numberOfQueries; i++) {
            System.out.println(1);
            scanner.nextInt();
        }
    }

    static String fetchValues(int startIndex) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            System.out.println(startIndex + i);
            result.append(scanner.nextInt());
        }
        return result.toString();
    }
}