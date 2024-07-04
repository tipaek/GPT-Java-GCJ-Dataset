package codejamround1C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class PancakeChoppers {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int test = 1;  // Start test case numbering from 1
        while (test <= T) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            boolean flag = false;
            TreeMap<Long, Integer> pancakeCounts = new TreeMap<>();
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                long pancakeSize = Long.parseLong(st.nextToken());
                pancakeCounts.put(pancakeSize, pancakeCounts.getOrDefault(pancakeSize, 0) + 1);
                if (pancakeCounts.get(pancakeSize) == D) {
                    flag = true;
                    break;
                }
            }
            System.out.print("Case #" + test + ": ");
            if (flag) {
                System.out.println(0);
                test++;
                continue;
            }

            if (D == 2) {
                System.out.println(1);
                test++;
                continue;
            }

            if (N == 1) {
                System.out.println(D - 1);
                test++;
                continue;
            }

            for (Long pancakeSize : pancakeCounts.keySet()) {
                if (pancakeCounts.containsKey((D - 1) * pancakeSize)) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                System.out.println(D - 2);
            } else {
                System.out.println(3);
            }
            test++;
        }
    }
}