package googleCodeJam.t2020;

import java.io.*;
import java.util.*;

public class Vestigium {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] matrix = new int[N][N];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                Set<Integer> rowSet = new HashSet<>();
                boolean rowFlag = false;

                for (int k = 0; k < N; k++) {
                    int num = Integer.parseInt(st.nextToken());
                    matrix[j][k] = num;

                    if (j == k) {
                        trace += num;
                    }

                    if (!rowSet.add(num) && !rowFlag) {
                        rowRepeats++;
                        rowFlag = true;
                    }
                }
            }

            for (int a = 0; a < N; a++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colFlag = false;

                for (int b = 0; b < N; b++) {
                    int num = matrix[b][a];

                    if (!colSet.add(num) && !colFlag) {
                        colRepeats++;
                        colFlag = true;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        br.close();
    }
}