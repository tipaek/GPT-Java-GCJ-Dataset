import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            processCase(i + 1, scanner);
        }
    }

    private static void processCase(int caseId, Scanner scanner) {
        int N = scanner.nextInt();
        int D = scanner.nextInt();
        List<Long> slices = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            slices.add(scanner.nextLong());
        }

        if (D == 2) {
            handleCaseD2(caseId, slices);
        } else {
            handleCaseD3(caseId, slices);
        }
    }

    private static void handleCaseD2(int caseId, List<Long> slices) {
        for (int i = 0; i < slices.size(); i++) {
            long a = slices.get(i);
            for (int j = i + 1; j < slices.size(); j++) {
                long b = slices.get(j);
                if (a == b) {
                    System.out.println("Case #" + caseId + ": 0");
                    return;
                }
            }
        }
        System.out.println("Case #" + caseId + ": 1");
    }

    private static void handleCaseD3(int caseId, List<Long> slices) {
        int best = 2;
        for (int i = 0; i < slices.size(); i++) {
            long a = slices.get(i);
            for (int j = i + 1; j < slices.size(); j++) {
                long b = slices.get(j);
                if (2 * a == b || 2 * b == a) {
                    best = 1;
                }
            }
        }

        for (int i = 0; i < slices.size(); i++) {
            long a = slices.get(i);
            for (int j = i + 1; j < slices.size(); j++) {
                long b = slices.get(j);
                for (int k = j + 1; k < slices.size(); k++) {
                    long c = slices.get(k);
                    if (a == b && a == c) {
                        System.out.println("Case #" + caseId + ": 0");
                        return;
                    } else if (a == b && c > a || a == c && b > a || b == c && a > b) {
                        best = 1;
                    }
                }
            }
        }

        System.out.println("Case #" + caseId + ": " + best);
    }
}