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

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                Set<Integer> rowSet = new HashSet<>();
                boolean rowFlag = true;

                for (int k = 0; k < N; k++) {
                    int num = Integer.parseInt(st.nextToken());

                    if (!rowSet.add(num) && rowFlag) {
                        rowRepeats++;
                        rowFlag = false;
                    }
                    matrix[j][k] = num;

                    if (j == k) {
                        trace += num;
                    }
                }
            }

            for (int a = 0; a < N; a++) {
                Set<Integer> colSet = new HashSet<>();
                for (int b = 0; b < N; b++) {
                    int num = matrix[b][a];
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