import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int u = scanner.nextInt();
            HashSet<Integer>[] charSets = new HashSet[26];

            for (int i = 0; i < 26; i++) {
                charSets[i] = new HashSet<>();
            }

            int[] queries = new int[10000];
            String[] strings = new String[10000];

            for (int i = 0; i < 10000; i++) {
                queries[i] = scanner.nextInt();
                strings[i] = scanner.next();

                for (char ch : strings[i].toCharArray()) {
                    int index = ch - 'A';
                    if (charSets[index].isEmpty()) {
                        for (int k = 0; k < 10; k++) {
                            charSets[index].add(k);
                        }
                    }
                }
            }

            for (int i = 0; i < 10000; i++) {
                if (queries[i] == -1) {
                    continue;
                }
                if (countDigits(queries[i]) == strings[i].length()) {
                    int firstCharIndex = strings[i].charAt(0) - 'A';
                    for (int j = queries[i] + 1; j < 10; j++) {
                        charSets[firstCharIndex].remove(j);
                    }
                }
            }

            int count = 0;
            boolean[] resolved = new boolean[26];

            while (count < 10) {
                for (int i = 0; i < 26; i++) {
                    if (charSets[i].isEmpty() || charSets[i].size() > 1 || resolved[i]) {
                        continue;
                    }

                    resolved[i] = true;
                    count++;
                    int value = charSets[i].iterator().next();

                    for (int j = 0; j < 26; j++) {
                        if (j != i) {
                            charSets[j].remove(value);
                        }
                    }
                }
            }

            char[] result = new char[10];
            for (int i = 0; i < 26; i++) {
                if (!charSets[i].isEmpty()) {
                    int value = charSets[i].iterator().next();
                    result[value] = (char) ('A' + i);
                }
            }

            System.out.println("Case #" + testCase + ": " + new String(result));
        }
    }

    private static int countDigits(int number) {
        if (number == 0) {
            return 1;
        }
        int count = 0;
        while (number != 0) {
            number /= 10;
            count++;
        }
        return count;
    }
}