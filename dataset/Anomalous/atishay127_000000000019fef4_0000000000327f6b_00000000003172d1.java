import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    static Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int testCaseIndex = 0; testCaseIndex < testCases; testCaseIndex++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            long[] array = new long[n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextLong();
            }

            if (d == 1) {
                System.out.println("Case #" + (testCaseIndex + 1) + ": 0");
                continue;
            }

            HashMap<Long, Integer> frequencyMap = new HashMap<>();
            boolean foundSolution = false;

            for (int i = 0; i < n; i++) {
                frequencyMap.put(array[i], frequencyMap.getOrDefault(array[i], 0) + 1);

                if (d == 2 && frequencyMap.get(array[i]) == 2) {
                    System.out.println("Case #" + (testCaseIndex + 1) + ": 0");
                    foundSolution = true;
                    break;
                }

                if (frequencyMap.get(array[i]) == 3) {
                    System.out.println("Case #" + (testCaseIndex + 1) + ": 0");
                    foundSolution = true;
                    break;
                }
            }

            if (foundSolution) {
                continue;
            }

            if (d == 2) {
                System.out.println("Case #" + (testCaseIndex + 1) + ": 1");
                continue;
            }

            for (long key : frequencyMap.keySet()) {
                if (frequencyMap.get(key) == 2) {
                    for (long innerKey : frequencyMap.keySet()) {
                        if (innerKey > key) {
                            System.out.println("Case #" + (testCaseIndex + 1) + ": 1");
                            foundSolution = true;
                            break;
                        }
                    }
                    if (foundSolution) {
                        break;
                    }
                }
            }

            if (foundSolution) {
                continue;
            }

            for (long key : frequencyMap.keySet()) {
                if (frequencyMap.containsKey(key / 2)) {
                    System.out.println("Case #" + (testCaseIndex + 1) + ": 1");
                    foundSolution = true;
                    break;
                }
            }

            if (!foundSolution) {
                System.out.println("Case #" + (testCaseIndex + 1) + ": 2");
            }
        }
    }
}