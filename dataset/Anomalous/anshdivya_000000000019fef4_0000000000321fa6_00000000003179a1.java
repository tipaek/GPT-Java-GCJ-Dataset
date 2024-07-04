import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int u = scanner.nextInt();
            HashSet<Integer>[] sets = initializeSets();
            int[] queries = new int[10000];
            String[] strings = new String[10000];

            for (int i = 0; i < 10000; i++) {
                queries[i] = scanner.nextInt();
                strings[i] = scanner.next();
                updateSets(sets, strings[i]);
            }

            refineSets(sets, queries, strings);

            char[] result = determineCharacters(sets);
            System.out.println("Case #" + testCase + ": " + new String(result));
        }
    }

    private static HashSet<Integer>[] initializeSets() {
        HashSet<Integer>[] sets = new HashSet[26];
        for (int i = 0; i < 26; i++) {
            sets[i] = new HashSet<>();
        }
        return sets;
    }

    private static void updateSets(HashSet<Integer>[] sets, String str) {
        for (int j = 0; j < str.length(); j++) {
            int charIndex = str.charAt(j) - 'A';
            if (sets[charIndex].isEmpty()) {
                for (int k = 0; k < 10; k++) {
                    if (k != 0 || j != 0) {
                        sets[charIndex].add(k);
                    }
                }
            }
        }
    }

    private static void refineSets(HashSet<Integer>[] sets, int[] queries, String[] strings) {
        for (int i = 0; i < 10000; i++) {
            if (queries[i] == -1) continue;
            if (countDigits(queries[i]) == strings[i].length()) {
                int charIndex = strings[i].charAt(0) - 'A';
                for (int j = getFirstDigit(queries[i]) + 1; j < 10; j++) {
                    sets[charIndex].remove(j);
                }
            }
        }

        boolean[] processed = new boolean[26];
        int processedCount = 0;

        while (processedCount < 10) {
            for (int i = 0; i < 26; i++) {
                if (sets[i].size() != 1 || processed[i]) continue;

                processed[i] = true;
                processedCount++;
                int value = sets[i].iterator().next();

                for (int j = 0; j < 26; j++) {
                    if (j != i) {
                        sets[j].remove(value);
                    }
                }
            }
        }
    }

    private static char[] determineCharacters(HashSet<Integer>[] sets) {
        char[] result = new char[10];
        for (int i = 0; i < 26; i++) {
            if (!sets[i].isEmpty()) {
                int value = sets[i].iterator().next();
                result[value] = (char) ('A' + i);
            }
        }
        return result;
    }

    private static int countDigits(int value) {
        return value == 0 ? 1 : (int) Math.log10(value) + 1;
    }

    private static int getFirstDigit(int value) {
        return Integer.toString(value).charAt(0) - '0';
    }
}