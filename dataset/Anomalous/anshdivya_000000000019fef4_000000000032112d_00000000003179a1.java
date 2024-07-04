import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int u = scanner.nextInt();

            HashSet<Integer>[] letterSets = new HashSet[26];
            for (int i = 0; i < 26; i++) {
                letterSets[i] = new HashSet<>();
            }

            int[] queries = new int[10000];
            String[] strings = new String[10000];
            for (int i = 0; i < 10000; i++) {
                queries[i] = scanner.nextInt();
                strings[i] = scanner.next();

                for (char c : strings[i].toCharArray()) {
                    int index = c - 'A';
                    if (letterSets[index].isEmpty()) {
                        for (int k = 0; k < 10; k++) {
                            letterSets[index].add(k);
                        }
                    }
                }
            }

            for (int i = 0; i < 10000; i++) {
                if (queries[i] != -1 && countDigits(queries[i]) == strings[i].length()) {
                    int firstCharIndex = strings[i].charAt(0) - 'A';
                    for (int j = getFirstDigit(queries[i]) + 1; j < 10; j++) {
                        letterSets[firstCharIndex].remove(j);
                    }
                }
            }

            boolean[] processed = new boolean[26];
            int count = 0;
            while (count < 10) {
                for (int i = 0; i < 26; i++) {
                    if (letterSets[i].size() == 1 && !processed[i]) {
                        processed[i] = true;
                        count++;
                        int value = letterSets[i].iterator().next();
                        for (int j = 0; j < 26; j++) {
                            if (j != i) {
                                letterSets[j].remove(value);
                            }
                        }
                    }
                }
            }

            char[] result = new char[10];
            for (int i = 0; i < 26; i++) {
                if (!letterSets[i].isEmpty()) {
                    int value = letterSets[i].iterator().next();
                    result[value] = (char) ('A' + i);
                }
            }

            System.out.println("Case #" + testCase + ": " + new String(result));
        }
    }

    private static int countDigits(int value) {
        return String.valueOf(value).length();
    }

    private static int getFirstDigit(int value) {
        return String.valueOf(value).charAt(0) - '0';
    }
}