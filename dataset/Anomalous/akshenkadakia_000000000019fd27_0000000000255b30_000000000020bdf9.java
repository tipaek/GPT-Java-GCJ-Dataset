import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int caseN = 1; caseN <= T; caseN++) {
            int N = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder(N);
            TreeMap<Integer, Integer> J = new TreeMap<>();
            TreeMap<Integer, Integer> C = new TreeMap<>();
            boolean possible = true;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                if (possible) {
                    if (canFit(J, start, end)) {
                        sb.append('J');
                        J.put(start, end);
                    } else if (canFit(C, start, end)) {
                        sb.append('C');
                        C.put(start, end);
                    } else {
                        sb = new StringBuilder("IMPOSSIBLE");
                        possible = false;
                    }
                }
            }

            System.out.printf("Case #%d: %s\n", caseN, sb.toString());
        }
    }

    static boolean canFit(TreeMap<Integer, Integer> map, int start, int end) {
        Map.Entry<Integer, Integer> lower = map.floorEntry(start);
        Map.Entry<Integer, Integer> higher = map.higherEntry(start);

        if ((lower != null && start < lower.getValue()) || (higher != null && higher.getKey() < end)) {
            return false;
        }

        return map.get(start) == null;
    }
}