import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i < testCases; i++) {
            solve(scanner, i);
        }
    }

    static void solve(Scanner scanner, int testCaseNumber) {
        Map<String, Integer> dictionary = new HashMap<>();
        int u = scanner.nextInt();
        int counter = 0;
        boolean[][] matrix = new boolean[10][10];

        for (int i = 0; i < 10000; i++) {
            int number = scanner.nextInt();
            String response = scanner.next();
            if (response.length() != getLength(number)) break;

            number = getFirstDigit(number);
            String firstChar = response.substring(0, 1);

            if (!dictionary.containsKey(firstChar)) {
                dictionary.put(firstChar, counter);
                for (int j = 0; j < number; j++) {
                    matrix[counter][i] = true;
                }
                counter++;
            } else {
                int index = dictionary.get(firstChar);
                for (int j = 9; j >= number; j--) {
                    if (matrix[index][i]) {
                        matrix[index][i] = false;
                    }
                }
            }
        }

        Set<String> keys = dictionary.keySet();
        String[] solution = new String[10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (!matrix[i][j]) {
                    for (String key : keys) {
                        if (dictionary.get(key) == j - 1) {
                            solution[j - 1] = key;
                        }
                    }
                }
            }
        }

        System.out.print("Case #" + testCaseNumber + ": ");
        for (String s : solution) {
            System.out.print(s);
        }
        System.out.println();
    }

    static int getLength(int number) {
        int length = 1;
        while (number >= 10) {
            number /= 10;
            length++;
        }
        return length;
    }

    static int getFirstDigit(int number) {
        while (number >= 10) {
            number /= 10;
        }
        return number;
    }
}