package ddddd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Vestigium {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tt = 0; tt < t; tt++) {
            int n = Integer.parseInt(br.readLine());
            int trace = 0;
            int rows = 0;
            HashSet<Integer> col = new HashSet<>();
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                int[] rowCheck = new int[n];
                boolean rowDuplicate = false;
                StringTokenizer str = new StringTokenizer(br.readLine());

                for (int j = 0; j < n; j++) {
                    int val = Integer.parseInt(str.nextToken()) - 1;

                    if (i == j) {
                        trace += val;
                    }

                    arr[val][j]++;
                    if (arr[val][j] > 1) {
                        col.add(j);
                    }

                    if (!rowDuplicate) {
                        rowCheck[val]++;
                        if (rowCheck[val] > 1) {
                            rowDuplicate = true;
                        }
                    }
                }

                if (rowDuplicate) {
                    rows++;
                }
            }

            trace += n;
            System.out.println(trace + " " + rows + " " + col.size());
        }
    }
}