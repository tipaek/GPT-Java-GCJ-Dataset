//package codejam2020.round0.parenting;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        //String inFile = "sample.in";
        //Scanner sc = new Scanner(Solution.class.getResource(inFile).openStream());
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        sc.nextLine();
        for (int test=1; test<=tests; test++) {
            int n = sc.nextInt();
            int[] start = new int[n];
            int[] end = new int[n];
            for (int i = 0; i < n; i++) {
                start[i] = sc.nextInt();
                end[i] = sc.nextInt();
            }
            System.out.println("Case #" + test + ": " + doit(n, start, end));
        }
    }

    private static String doit(int n, int[] start, int[] end) {
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (i1, i2) -> {
            if (start[i1] != start[i2]) {
                return Integer.compare(start[i1], start[i2]);
            }
            return Integer.compare(end[i2], end[i1]);
        });
        boolean[] ret = new boolean[n];
        for (int i = 1; i < n; i++) {
            int cur = index[i];
            int prev = index[i-1];
            if (end[prev] <= start[cur]) {
                ret[cur] = ret[prev];
            } else {
                ret[cur] = !ret[prev];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(ret[i] ? 'J' : 'C');
        }
        String good = sb.toString();

        for (int i = 0; i < n-1; i++) if (good.charAt(i) == 'J') {
            for (int j = i+1; j < n; j++) if (good.charAt(j) == 'J') {
                int ii = i, jj = j;
                if (start[i] > start[j]) {
                    ii = j; jj = i;
                }
                if (end[ii] > start[jj]) return "IMPOSSIBLE";
            }
        }
        for (int i = 0; i < n-1; i++) if (good.charAt(i) == 'C') {
            for (int j = i+1; j < n; j++) if (good.charAt(j) == 'C') {
                int ii = i, jj = j;
                if (start[i] > start[j]) {
                    ii = j; jj = i;
                }
                if (end[ii] > start[jj]) return "IMPOSSIBLE";
            }
        }

        return good;
    }
}
