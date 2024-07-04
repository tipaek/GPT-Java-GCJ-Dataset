package googleCodeJam;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_codejam_2020_qualification_round_1 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCnt = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCaseCnt; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            for (int i = 0; i < N; ++i) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
//            print(map);

            int vestigium = 0;
            for (int i = 0; i < N; i++) {
                vestigium += map[i][i];
            }

            int duplicatedRowCnt = 0;

            for (int i = 0; i < N; i++) {
                boolean[] duplicatedChecker = new boolean[N + 1];
                for (int j = 0; j < N; j++) {
                    if (!duplicatedChecker[map[i][j]]) {
                        duplicatedChecker[map[i][j]] = true;
                    } else {
                        duplicatedRowCnt++;
                        break;
                    }
                }
            }

            int duplicatedColCnt = 0;
            for (int i = 0; i < N; i++) {
                boolean[] duplicatedChecker = new boolean[N + 1];
                for (int j = 0; j < N; j++) {
                    if (!duplicatedChecker[map[j][i]]) {
                        duplicatedChecker[map[j][i]] = true;
                    } else {
                        duplicatedColCnt++;
                        break;
                    }
                }
            }


            System.out.printf("Case #%d: %d %d %d\n", t, vestigium, duplicatedRowCnt, duplicatedColCnt);
        }
        bw.close();
        br.close();
    }

    private static void print(int[][] map) {
        for (int[] ints : map) {
            for (int j = 0; j < map.length; j++) {
                System.out.printf("%d ", ints[j]);
            }
            System.out.println();
        }
    }


}
