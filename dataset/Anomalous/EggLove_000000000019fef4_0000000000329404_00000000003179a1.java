import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            solve(scanner, i);
        }
    }

    static void solve(Scanner scanner, int caseNumber) {
        Map<String, Integer> charToIndex = new HashMap<>();
        Map<Integer, String> indexToChar = new HashMap<>();
        Set<String> zeroChars = new HashSet<>();
        int u = scanner.nextInt();
        int counter = 0;
        boolean[][] constraints = new boolean[10][10];

        for (int i = 0; i < 10000; i++) {
            int m = scanner.nextInt();
            String r = scanner.next();
            for (char c : r.toCharArray()) {
                zeroChars.add(String.valueOf(c));
            }
            if (r.length() == getDigitCount(m)) {
                int leadingDigit = getLeadingDigit(m);
                String leadingChar = r.substring(0, 1);

                if (!charToIndex.containsKey(leadingChar)) {
                    charToIndex.put(leadingChar, counter);
                    indexToChar.put(counter, leadingChar);
                    Arrays.fill(constraints[counter], 0, leadingDigit, true);
                    counter++;
                } else {
                    int index = charToIndex.get(leadingChar);
                    Arrays.fill(constraints[index], leadingDigit, 10, false);
                }
            }
        }

        String[] solution = new String[10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (!constraints[i][j]) {
                    solution[j] = indexToChar.get(i);
                    break;
                }
            }
        }

        System.out.print("Case #" + caseNumber + ": ");
        for (String c : zeroChars) {
            if (!charToIndex.containsKey(c)) {
                System.out.print(c);
                break;
            }
        }
        for (int i = 1; i < 10; i++) {
            System.out.print(solution[i]);
        }
        System.out.println();
    }

    static int getDigitCount(int number) {
        int count = 1;
        while (number >= 10) {
            number /= 10;
            count++;
        }
        return count;
    }

    static int getLeadingDigit(int number) {
        while (number >= 10) {
            number /= 10;
        }
        return number;
    }
}