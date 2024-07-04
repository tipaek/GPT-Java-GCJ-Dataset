
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCnt = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCaseCnt; t++) {

            int N = Integer.parseInt(br.readLine());

            int[][] acts = new int[N][2];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                acts[i][0] = Integer.parseInt(st.nextToken());
                acts[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(acts, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    if (a[1] == b[1]) {
                        return a[0] - b[1];
                    }
                    return a[1] - b[1];
                }
            });

//            for (int i = 0; i < N; i++) System.out.printf("%d, %d\n", acts[i][0], acts[i][1]);

            int lastC = 0;
            int lastJ = 0;

            lastC = acts[0][1];
            boolean isJamieTurn = true;

            boolean isImpossible = false;

            StringBuilder result = new StringBuilder();
            result.append("J");

            for (int i = 1; i < N; i++) {
                if (isJamieTurn) {
                    if (acts[i][0] >= lastJ) {
                        result.append("J");
                        lastJ = acts[i][1];
                    } else if (acts[i][0] >= lastC) {
                        result.append("C");
                        lastC = acts[i][1];
                        isJamieTurn = false;
                    } else {
                        isImpossible = true;
                        break;
                    }
                } else {
                    if (acts[i][0] >= lastC) {
                        result.append("C");
                        lastC = acts[i][1];
                    } else if (acts[i][0] >= lastJ) {
                        result.append("J");
                        lastJ = acts[i][1];
                        isJamieTurn = true;
                    } else {
                        isImpossible = true;
                        break;
                    }
                }
            }

            if (isImpossible) {
                System.out.printf("Case #%d: %s\n", t, "IMPOSSIBLE");
            } else {
                System.out.printf("Case #%d: %s\n", t, result);
            }
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
