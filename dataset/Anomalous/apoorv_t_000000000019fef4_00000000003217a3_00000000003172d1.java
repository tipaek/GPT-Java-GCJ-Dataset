import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int c = 1; c <= t; c++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            long[] arr = new long[n];
            Map<Long, Integer> frequencyMap = new HashMap<>();

            boolean found = false;

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextLong();
                frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);

                if (frequencyMap.get(arr[i]) >= d) {
                    System.out.println("Case #" + c + ": 0");
                    found = true;
                    break;
                }
            }

            if (!found) {
                if (d == 2) {
                    System.out.println("Case #" + c + ": 1");
                } else {
                    Arrays.sort(arr);
                    boolean pairFound = false;

                    for (int i = 0; i < n - 1; i++) {
                        if (frequencyMap.get(arr[i]) == 2) {
                            System.out.println("Case #" + c + ": 1");
                            pairFound = true;
                            break;
                        }
                    }

                    if (!pairFound) {
                        System.out.println("Case #" + c + ": 2");
                    }
                }
            }
        }

        scanner.close();
    }
}