import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            long[] numbers = new long[n];
            Map<Long, Integer> frequencyMap = new HashMap<>();
            int maxFrequency = 0;

            for (int j = 0; j < n; j++) {
                numbers[j] = scanner.nextLong();
                frequencyMap.put(numbers[j], frequencyMap.getOrDefault(numbers[j], 0) + 1);
                maxFrequency = Math.max(maxFrequency, frequencyMap.get(numbers[j]));
            }

            if (maxFrequency == d) {
                System.out.println("Case #" + testCase + ": " + 0);
            } else {
                boolean found = false;
                for (Map.Entry<Long, Integer> entry : frequencyMap.entrySet()) {
                    long number = entry.getKey();
                    int count = entry.getValue();

                    if (number % 2 == 0 && frequencyMap.containsKey(number / 2)) {
                        if (frequencyMap.get(number / 2) + 2 >= d) {
                            System.out.println("Case #" + testCase + ": " + 1);
                            found = true;
                            break;
                        }
                    }
                }

                if (!found) {
                    System.out.println("Case #" + testCase + ": " + 2);
                }
            }
        }
    }
}