import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int N = scanner.nextInt();
            int D = scanner.nextInt();

            long[] nanoValues = new long[N];
            HashMap<Long, Integer> frequencyMap = new HashMap<>();

            for (int i = 0; i < N; i++) {
                nanoValues[i] = scanner.nextLong();
                frequencyMap.put(nanoValues[i], frequencyMap.getOrDefault(nanoValues[i], 0) + 1);
            }

            int result = Integer.MAX_VALUE;
            int maxFrequency = 0;
            long maxFrequencyValue = 0;

            for (Map.Entry<Long, Integer> entry : frequencyMap.entrySet()) {
                long value = entry.getKey();
                int frequency = entry.getValue();

                if (frequency == D) {
                    result = 0;
                    break;
                }
                
                if (frequency > maxFrequency) {
                    maxFrequency = frequency;
                    maxFrequencyValue = value;
                }
            }

            if (result != 0) {
                result = (D + maxFrequency - 1) / maxFrequency; // Ceiling of D / maxFrequency
            }

            System.out.println("Case #" + t + ": " + result);
        }
    }
}