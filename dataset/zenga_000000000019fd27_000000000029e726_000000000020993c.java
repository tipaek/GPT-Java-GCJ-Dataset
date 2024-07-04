import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int k = 0, r = 0, c = 0;

            int n = Integer.parseInt(br.readLine());

            List<Set<Integer>> cols = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                cols.add(new HashSet<>());
            }
            boolean cDuplicates[] = new boolean[n];

            StringTokenizer st;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                Set<Integer> row = new HashSet<>();
                boolean rDuplicate = false;

                for (int j = 0; j < n; j++) {
                    int curr = Integer.parseInt(st.nextToken());

                    if (row.contains(curr) && !rDuplicate) {
                        r++;
                        rDuplicate = true;
                    }
                    row.add(curr);

                    if (cols.get(j).contains(curr) && !cDuplicates[j]) {
                        c++;
                        cDuplicates[j] = true;
                    }
                    cols.get(j).add(curr);

                    if (i == j) {
                        k += curr;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d\n", t, k, r, c);
        }
    }
}
