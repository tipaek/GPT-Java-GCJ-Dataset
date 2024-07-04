import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int caseNumber = 1;

        while (caseNumber <= t) {
            boolean found = false;
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            int[] array = new int[n];
            Map<Integer, Integer> frequencyMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
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
                        if (frequencyMap.get(array[i]) == 2 && i != n - 1) {
                            found = true;
                            System.out.println("Case #" + caseNumber + ": 1");
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Case #" + caseNumber + ": 2");
                    }
                }
            }
            caseNumber++;
        }
        scanner.close();
    }
}