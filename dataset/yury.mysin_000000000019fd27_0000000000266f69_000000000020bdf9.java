import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int k = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < k; i++) {
            solve(i + 1);
        }
    }

    private static void solve(int caseN) {
        int n = scanner.nextInt();
        List<int[]> jobs = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            jobs.add(new int[] {from, to, i});
        }
        jobs.sort(Comparator.comparingInt(a -> a[0] * 24 * 60 + a[1]));
        StringBuilder sb = new StringBuilder(jobs.size());
        jobs.forEach(a -> sb.append('K'));
        int cFree = -1;
        int jFree = -1;
        boolean fail = false;
        for (int i = 0; i < jobs.size(); i++) {
            if (cFree < jobs.get(i)[0]) {
                cFree = jobs.get(i)[1] - 1;
                sb.setCharAt(jobs.get(i)[2], 'C');
            } else if (jFree < jobs.get(i)[0]) {
                jFree = jobs.get(i)[1] - 1;
                sb.setCharAt(jobs.get(i)[2], 'J');
            } else {
                fail = true;
                break;
            }
        }
        System.out.println("Case #" + caseN + ": " + (fail ? "IMPOSSIBLE" : sb.toString()));
    }
}