import java.util.*;
import java.io.*;

public class ActivityScheduler {
    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(stdin.readLine().trim());

        for (int ll = 0; ll < t; ll++) {
            int N = Integer.parseInt(stdin.readLine().trim());
            int[][] ti = new int[N][2];
            Map<String, Integer> inds = new HashMap<>();

            for (int i = 0; i < N; i++) {
                String[] parts = stdin.readLine().trim().split(" ");
                int start = Integer.parseInt(parts[0]);
                int end = Integer.parseInt(parts[1]);
                ti[i][0] = start;
                ti[i][1] = end;
                inds.put(start + " " + end, i);
            }

            int[][] times2 = Arrays.copyOf(ti, N);
            Arrays.sort(ti, Comparator.comparingInt(a -> a[1]));

            char[] ans = new char[N];
            Arrays.fill(ans, 'C');
            boolean impossible1 = false;
            boolean impossible2 = false;
            int j = 0, c = 0;

            for (int i = 0; i < N; i++) {
                if (c <= ti[i][0]) {
                    ans[inds.get(ti[i][0] + " " + ti[i][1])] = 'C';
                    c = ti[i][1];
                } else if (j <= ti[i][0]) {
                    ans[inds.get(ti[i][0] + " " + ti[i][1])] = 'J';
                    j = ti[i][1];
                } else {
                    impossible1 = true;
                    break;
                }
            }

            if (impossible1) {
                Arrays.fill(ans, 'C');
                Arrays.sort(times2, Comparator.comparingInt(a -> a[0]));
                c = 0;
                j = 0;
                for (int i = 0; i < N; i++) {
                    if (c <= times2[i][0]) {
                        ans[inds.get(times2[i][0] + " " + times2[i][1])] = 'C';
                        c = times2[i][1];
                    } else if (j <= times2[i][0]) {
                        ans[inds.get(times2[i][0] + " " + times2[i][1])] = 'J';
                        j = times2[i][1];
                    } else {
                        impossible2 = true;
                        break;
                    }
                }
            }

            String result = (impossible1 && impossible2) ? "IMPOSSIBLE" : new String(ans);
            System.out.printf("Case #%d: %s%n", ll + 1, result);
        }
    }
}