package googleCodeJam.t2020;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] matrix = new int[N][N];
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            for (int row = 0; row < N; row++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;

                for (int col = 0; col < N; col++) {
                    int num = Integer.parseInt(st.nextToken());
                    if (!rowHasDuplicate && !rowSet.add(num)) {
                        rowRepeats++;
                        rowHasDuplicate = true;
                    }
                    matrix[row][col] = num;
                    if (row == col) {
                        trace += num;
                    }
                }
            }

            for (int col = 0; col < N; col++) {
                Set<Integer> colSet = new HashSet<>();
                for (int row = 0; row < N; row++) {
                    int num = matrix[row][col];
                    if (!colSet.add(num)) {
                        colRepeats++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        br.close();
    }
}