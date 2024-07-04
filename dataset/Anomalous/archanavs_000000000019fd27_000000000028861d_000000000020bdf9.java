import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            int N = in.nextInt();
            int[] start = new int[N];
            int[] end = new int[N];
            for (int j = 0; j < N; j++) {
                start[j] = in.nextInt();
                end[j] = in.nextInt();
            }
            processCase(i, N, start, end);
        }
    }

    private static void processCase(int caseNumber, int n, int[] start, int[] end) {
        int[] cSchedule = new int[1441];
        int[] jSchedule = new int[1441];
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int begin = start[i];
            int finish = end[i];
            boolean cConflict = false;
            boolean jConflict = false;

            for (int k = begin + 1; k < finish; k++) {
                if (cSchedule[k] != 0) cConflict = true;
                if (jSchedule[k] != 0) jConflict = true;
            }

            if (cConflict && jConflict) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                return;
            } else {
                if (!cConflict) {
                    for (int k = begin; k <= finish; k++) {
                        cSchedule[k] = 1;
                    }
                    result.append("C");
                } else {
                    for (int k = begin; k <= finish; k++) {
                        jSchedule[k] = 1;
                    }
                    result.append("J");
                }
            }
        }

        System.out.println("Case #" + caseNumber + ": " + result.toString());
    }
}