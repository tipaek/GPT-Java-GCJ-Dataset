import java.util.*;

public class Task33 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            solveCase(i + 1, scanner);
        }
    }

    private static void solveCase(int caseId, Scanner scanner) {
        int N = scanner.nextInt();
        int D = scanner.nextInt();

        List<Long> slices = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            slices.add(scanner.nextLong());
        }

        if (D == 2) {
            if (hasDuplicate(slices)) {
                System.out.println("Case #" + caseId + ": 0");
            } else {
                System.out.println("Case #" + caseId + ": 1");
            }
        } else {
            int best = findBestOutcome(slices);
            System.out.println("Case #" + caseId + ": " + best);
        }
    }

    private static boolean hasDuplicate(List<Long> slices) {
        Set<Long> seen = new HashSet<>();
        for (Long slice : slices) {
            if (!seen.add(slice)) {
                return true;
            }
        }
        return false;
    }

    private static int findBestOutcome(List<Long> slices) {
        int best = 2;
        int N = slices.size();

        for (int i = 0; i < N; i++) {
            long a = slices.get(i);
            for (int j = i + 1; j < N; j++) {
                long b = slices.get(j);
                if (2 * a == b || 2 * b == a) {
                    best = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            long a = slices.get(i);
            for (int j = i + 1; j < N; j++) {
                long b = slices.get(j);
                for (int k = j + 1; k < N; k++) {
                    long c = slices.get(k);
                    if (a == b && a == c) {
                        return 0;
                    } else if (a == b || a == c || b == c) {
                        if (Math.max(a, Math.max(b, c)) > Math.min(a, Math.min(b, c))) {
                            best = 1;
                        }
                    }
                }
            }
        }

        return best;
    }
}