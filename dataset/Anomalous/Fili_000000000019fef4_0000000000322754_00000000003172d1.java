import java.util.*;

public class OversizedPancakeChoppers {
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
        double[] pancakeSizes = new double[n];
        Map<Double, Integer> sliceCount = new HashMap<>();
        int maxSlices = 1;

        for (int i = 0; i < n; i++) {
            pancakeSizes[i] = scanner.nextDouble();
            sliceCount.put(pancakeSizes[i], sliceCount.getOrDefault(pancakeSizes[i], 0) + 1);
            maxSlices = Math.max(maxSlices, sliceCount.get(pancakeSizes[i]));
        }

        if (maxSlices >= d) {
            System.out.println(0);
        } else if (d == 2 || maxSlices == 2) {
            System.out.println(1);
        } else {
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (pancakeSizes[i] == pancakeSizes[j] / 2 || pancakeSizes[i] == pancakeSizes[j] * 2) {
                        System.out.println(1);
                        return;
                    }
                }
            }
            System.out.println(2);
        }
    }
}