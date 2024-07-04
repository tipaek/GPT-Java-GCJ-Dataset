import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int arraySize = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < testCases; i++) {
            processTestCase(scanner, arraySize);
        }
    }

    private static void processTestCase(Scanner scanner, int arraySize) {
        int[] resultArray = new int[arraySize];
        int index = 0;
        for (int queryCount = 1; queryCount <= 150; queryCount++) {
            if (index >= arraySize) {
                break;
            }

            resultArray[index] = performQuery(scanner, index + 1);
            if (queryCount % 10 == 1) {
                resultArray[index] = performQuery(scanner, index + 1);
                queryCount++;
            }
            index++;
        }

        StringBuilder result = new StringBuilder();
        for (int value : resultArray) {
            result.append(value);
        }
        System.out.println(result);
        System.out.flush();
        scanner.nextLine();
    }

    private static int performQuery(Scanner scanner, int position) {
        System.out.println(position);
        System.out.flush();
        return scanner.nextLine().charAt(0);
    }
}