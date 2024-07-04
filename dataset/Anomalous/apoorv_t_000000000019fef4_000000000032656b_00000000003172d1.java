import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            long[] arr = new long[n];
            Map<Long, Integer> frequencyMap = new HashMap<>();
            boolean resultFound = false;

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextLong();
                frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);

                if (frequencyMap.get(arr[i]) >= d) {
                    System.out.println("Case #" + caseIndex + ": 0");
                    resultFound = true;
                    break;
                }
            }

            if (!resultFound) {
                if (d == 2) {
                    System.out.println("Case #" + caseIndex + ": 1");
                } else {
                    Arrays.sort(arr);
                    for (int i = 0; i < n; i++) {
                        if (resultFound) break;

                        if ((frequencyMap.get(arr[i]) == 2 && i != n - 1 && arr[i] != arr[n - 1]) || frequencyMap.get(arr[i] / 2) != null) {
                            System.out.println("Case #" + caseIndex + ": 1");
                            resultFound = true;
                            break;
                        }

                        for (int j = 0; j < n; j++) {
                            if (arr[j] == arr[i] * 2) {
                                System.out.println("Case #" + caseIndex + ": 1");
                                resultFound = true;
                                break;
                            }
                        }
                    }

                    if (!resultFound) {
                        System.out.println("Case #" + caseIndex + ": 2");
                    }
                }
            }
        }
        scanner.close();
    }
}