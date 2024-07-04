import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            long[] array = new long[n];
            Map<Long, Integer> frequencyMap = new HashMap<>();
            boolean found = false;

            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextLong();
                frequencyMap.put(array[i], frequencyMap.getOrDefault(array[i], 0) + 1);
                if (frequencyMap.get(array[i]) >= d) {
                    System.out.println("Case #" + caseNumber + ": 0");
                    found = true;
                    break;
                }
            }

            if (!found) {
                if (d == 2) {
                    System.out.println("Case #" + caseNumber + ": 1");
                } else {
                    Arrays.sort(array);
                    for (int i = 0; i < n; i++) {
                        if (frequencyMap.containsKey(array[i] * 2) || (frequencyMap.get(array[i]) == 2 && i != n - 1)) {
                            System.out.println("Case #" + caseNumber + ": 1");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Case #" + caseNumber + ": 2");
                    }
                }
            }
        }
    }
}