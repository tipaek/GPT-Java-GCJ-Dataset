//package codejam2020.round0.parenting;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
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

        Deque<String> q = new ArrayDeque<>();
        q.push("C");
        while (!q.isEmpty()) {
            String cur = q.pop();
            if (cur.length() == n) {
                char[] ret = new char[n];
                for (int i = 0; i < n; i++) {
                    ret[index[i]] = cur.charAt(i);
                }
                String check = String.valueOf(ret);
                for (int i = 0; i < n-1; i++) if (check.charAt(i) == 'C') {
                    for (int j = i+1; j < n; j++) if (check.charAt(j) == 'C') {
                        int ii = i, jj = j;
                        if (start[i] > start[j]) {
                            ii = j; jj = i;
                        }
                        if (end[ii] > start[jj]) return "IMPOSSIBLE";
                    }
                }
                for (int i = 0; i < n-1; i++) if (check.charAt(i) == 'J') {
                    for (int j = i+1; j < n; j++) if (check.charAt(j) == 'J') {
                        int ii = i, jj = j;
                        if (start[i] > start[j]) {
                            ii = j; jj = i;
                        }
                        if (end[ii] > start[jj]) return "IMPOSSIBLE";
                    }
                }
                return check;
            }
            if (end[index[cur.length()-1]] < start[index[cur.length()]]) {
                q.push(cur + "C");
                q.push(cur + "J");
            } else {
                q.push(cur.charAt(cur.length()-1) == 'C' ? cur + "J" : cur + "C");
            }
        }
        return "IMPOSSIBLE";
    }
}
