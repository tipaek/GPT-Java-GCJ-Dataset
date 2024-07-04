package round1c.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTests = Integer.parseInt(reader.readLine());
        Solver solver = new Solver();
        for (int i = 1; i <= numberOfTests; i++) {
            solver.solve(i, reader);
        }
    }

    static class Solver {

        public void solve(int testCaseNumber, BufferedReader reader) throws IOException {
            String[] input = reader.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int D = Integer.parseInt(input[1]);
            input = reader.readLine().split(" ");
            
            int[] degrees = new int[N];
            HashMap<Integer, Integer> degreeCount = new HashMap<>();
            int result = 0;

            for (int i = 0; i < N; i++) {
                degrees[i] = Integer.parseInt(input[i]);
                degreeCount.put(degrees[i], degreeCount.getOrDefault(degrees[i], 0) + 1);
            }

            for (Map.Entry<Integer, Integer> entry : degreeCount.entrySet()) {
                if (D == entry.getValue()) {
                    System.out.println("Case #" + testCaseNumber + ": " + 0);
                    return;
                }
            }

            for (Map.Entry<Integer, Integer> entry : degreeCount.entrySet()) {
                int count = entry.getValue();
                for (Map.Entry<Integer, Integer> otherEntry : degreeCount.entrySet()) {
                    if (!entry.getValue().equals(otherEntry.getValue()) && entry.getValue() % otherEntry.getValue() == 0) {
                        count++;
                    }
                }
                degreeCount.put(entry.getKey(), count);
            }

            int maxCount = 0;
            for (Map.Entry<Integer, Integer> entry : degreeCount.entrySet()) {
                if (entry.getValue() > maxCount) {
                    maxCount = entry.getValue();
                }
            }

            if (maxCount > D) {
                result = D - maxCount;
            }

            System.out.println("Case #" + testCaseNumber + ": " + result);
        }
    }
}