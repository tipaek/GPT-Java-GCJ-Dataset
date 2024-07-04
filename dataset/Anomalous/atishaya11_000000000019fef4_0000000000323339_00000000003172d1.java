import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            long[] numbers = new long[n];
            Map<Long, Integer> frequencyMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                numbers[i] = scanner.nextLong();
                frequencyMap.put(numbers[i], frequencyMap.getOrDefault(numbers[i], 0) + 1);
            }

            int result = 0;

            if (d == 2) {
                result = (frequencyMap.size() == n) ? 1 : 0;
            } else if (d == 3) {
                boolean hasThreeSame = false;
                boolean hasTwoSame = false;
                boolean hasDifferent = false;

                for (Long key : frequencyMap.keySet()) {
                    int count = frequencyMap.get(key);

                    if (count == 3) {
                        hasThreeSame = true;
                    } else if (count == 2) {
                        for (int i = 0; i < n; i++) {
                            if (numbers[i] != key) {
                                hasTwoSame = true;
                                break;
                            }
                        }
                    } else if (frequencyMap.containsKey(key * 2)) {
                        hasTwoSame = true;
                    }
                }

                if (hasThreeSame) {
                    result = 0;
                } else if (hasTwoSame) {
                    result = 1;
                } else {
                    result = 2;
                }
            }

            System.out.printf("Case #%d: %d\n", t, result);
        }
    }
}