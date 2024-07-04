import java.util.*;

public class Solution {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = SCANNER.nextInt();
        for (int i = 1; i <= testCases; i++) {
            System.out.print("Case #" + i + ": ");
            solve();
        }
    }

    private static void solve() {
        int n = SCANNER.nextInt();
        int d = SCANNER.nextInt();
        int maxFrequency = 1;
        double[] numbers = new double[n];
        Map<Double, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            numbers[i] = SCANNER.nextDouble();
            frequencyMap.put(numbers[i], frequencyMap.getOrDefault(numbers[i], 0) + 1);
            maxFrequency = Math.max(maxFrequency, frequencyMap.get(numbers[i]));
        }

        if (maxFrequency >= d) {
            System.out.println("0");
        } else if (d == 2 || maxFrequency == 2) {
            System.out.println("1");
        } else {
            if (checkHalfOrDouble(numbers)) {
                System.out.println("1");
            } else {
                System.out.println("2");
            }
        }
    }

    private static boolean checkHalfOrDouble(double[] numbers) {
        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (numbers[i] == numbers[j] / 2 || numbers[i] == numbers[j] * 2) {
                    return true;
                }
            }
        }
        return false;
    }
}