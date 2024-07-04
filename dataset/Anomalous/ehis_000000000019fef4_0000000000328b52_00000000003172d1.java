import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(scanner.nextLine());

        try {
            for (int i = 1; i <= T; i++) {
                int N = scanner.nextInt();
                int D = scanner.nextInt();
                float[] crepes = new float[N];

                for (int j = 0; j < N; j++) {
                    crepes[j] = scanner.nextFloat();
                }
                calculateSlices(i, crepes, D);
            }
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
    }

    public static void calculateSlices(int iteration, float[] crepes, int clients) {
        Arrays.sort(crepes);

        Map<Float, Integer> countMap = new HashMap<>();
        int maxCount = 1;
        float maxValue = crepes[0];

        for (float crepe : crepes) {
            countMap.put(crepe, countMap.getOrDefault(crepe, 0) + 1);
            if (countMap.get(crepe) > maxCount) {
                maxCount = countMap.get(crepe);
                maxValue = crepe;
            }
        }

        if (maxCount >= clients) {
            System.out.println("Case #" + iteration + ": 0");
            return;
        }

        int remainingClients = clients - maxCount;
        int slices = 0;
        boolean optimalAttempt = true;
        boolean firstIteration = true;
        int iter = 0;

        while (true) {
            if (!optimalAttempt) {
                maxCount = countMap.get(crepes[iter]);
                maxValue = crepes[iter];
            }

            int tempSlices = 0;

            if (crepes.length == 1) {
                System.out.println("Case #" + iteration + ": " + (clients - 1));
                return;
            }

            for (int i = iter + 1; i < crepes.length; i++) {
                int slicesNeeded = (int) (crepes[i] / maxValue);
                maxCount += slicesNeeded;

                if (crepes[i] % maxValue == 0) {
                    slicesNeeded--;
                }

                if (maxCount < clients) {
                    tempSlices += slicesNeeded;
                } else {
                    slices = remainingClients;
                    System.out.println("Case #" + iteration + ": " + slices);
                    return;
                }
            }

            if (!firstIteration) {
                if (iter < crepes.length - 1) {
                    iter++;
                } else {
                    return;
                }
            }

            optimalAttempt = false;
            firstIteration = false;
        }
    }
}