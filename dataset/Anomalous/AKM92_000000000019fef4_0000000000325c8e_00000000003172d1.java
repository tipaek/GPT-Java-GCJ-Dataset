import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int N = scanner.nextInt();
            int D = scanner.nextInt();
            int minChanges = D - 1;
            long[] numbers = new long[N];
            Map<Long, Integer> frequencyMap = new HashMap<>();

            for (int j = 0; j < N; j++) {
                long currentNumber = scanner.nextLong();
                int count = frequencyMap.getOrDefault(currentNumber, 0);
                count++;
                frequencyMap.put(currentNumber, count);
                numbers[j] = currentNumber;

                if (count >= D) {
                    minChanges = 0;
                }

                if (D == 3 && minChanges > 1) {
                    long doubleCurrent = numbers[j] * 2;
                    int doubleCount = frequencyMap.getOrDefault(doubleCurrent, 0);
                    if (doubleCount > 0) {
                        minChanges = 1;
                    }
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + minChanges);
        }

        scanner.close();
    }
}