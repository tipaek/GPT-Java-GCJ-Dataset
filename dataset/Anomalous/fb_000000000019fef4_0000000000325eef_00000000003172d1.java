import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            solve(i + 1, scanner);
        }
    }

    private static void solve(int caseId, Scanner scanner) {
        int N = scanner.nextInt();
        int D = scanner.nextInt();
        List<Long> sizes = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            sizes.add(scanner.nextLong());
        }

        int minimumCuts = D - 1;

        for (long size : sizes) {
            int[] cuts = new int[D + 1];
            Arrays.fill(cuts, 1000);
            cuts[0] = 0;

            for (long currentSize : sizes) {
                if (currentSize == size) {
                    for (int i = D; i > 0; i--) {
                        cuts[i] = cuts[i - 1];
                    }
                } else if (currentSize % size == 0) {
                    long steps = currentSize / size;
                    if (steps <= D) {
                        for (int i = D; i >= steps; i--) {
                            cuts[i] = Math.min(cuts[i], cuts[i - (int) steps] + (int) (steps - 1));
                        }
                    }
                } else if (currentSize > size) {
                    for (int steps = 1; steps <= D && steps <= (currentSize / size); steps++) {
                        for (int i = D; i >= steps; i--) {
                            cuts[i] = Math.min(cuts[i], cuts[i - steps] + steps);
                        }
                    }
                }
            }

            minimumCuts = Math.min(minimumCuts, cuts[D]);
        }

        System.out.println("Case #" + caseId + ": " + minimumCuts);
    }
}