import java.io.*;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long testCaseCount = Long.parseLong(br.readLine());

        for (long t = 1; t <= testCaseCount; t++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            long d = Long.parseLong(input[1]);

            HashMap<Long, Long> frequencyMap = new HashMap<>();
            String[] arrInput = br.readLine().split(" ");
            long[] numbers = new long[n];
            boolean hasDuplicate = false;
            long maxFrequency = 1;

            for (int i = 0; i < n; i++) {
                long number = Long.parseLong(arrInput[i]);
                numbers[i] = number;
                frequencyMap.put(number, frequencyMap.getOrDefault(number, 0L) + 1);
                if (frequencyMap.get(number) > 1) {
                    hasDuplicate = true;
                    maxFrequency = Math.max(maxFrequency, frequencyMap.get(number));
                }
            }

            if (d == 2) {
                bw.write("Case #" + t + ": " + (hasDuplicate ? 0 : 1) + "\n");
            } else if (d == 3) {
                if (maxFrequency >= 3) {
                    bw.write("Case #" + t + ": " + 0 + "\n");
                } else if (maxFrequency >= 2) {
                    bw.write("Case #" + t + ": " + 1 + "\n");
                } else {
                    boolean found = false;
                    for (int i = 0; i < n; i++) {
                        if (numbers[i] % 2 == 0) {
                            for (int j = i + 1; j < n; j++) {
                                if (numbers[i] / 2 == numbers[j]) {
                                    found = true;
                                    break;
                                }
                            }
                        }
                        if (found) break;
                    }
                    bw.write("Case #" + t + ": " + (found ? 1 : 2) + "\n");
                }
            }
        }
        bw.flush();
    }
}