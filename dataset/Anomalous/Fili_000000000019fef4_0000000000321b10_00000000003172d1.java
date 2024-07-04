import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            System.out.print("Case #" + i + ": ");
            solve();
        }
    }

    private static void solve() {
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        double[] array = new double[n];
        HashMap<Double, Integer> frequencyMap = new HashMap<>();
        int maxFrequency = 1;

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextDouble();
            frequencyMap.put(array[i], frequencyMap.getOrDefault(array[i], 0) + 1);
            maxFrequency = Math.max(maxFrequency, frequencyMap.get(array[i]));
        }

        if (maxFrequency >= d) {
            System.out.println("0");
        } else if (d == 2 || maxFrequency == 2) {
            System.out.println("1");
        } else {
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (array[i] == array[j] / 2 || array[i] == array[j] * 2) {
                        System.out.println("1");
                        return;
                    }
                }
            }
            System.out.println("2");
        }
    }
}