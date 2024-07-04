import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

    static int[][] locations;
    static boolean[][] eliminated;
    static int[][][] neighbors;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int cases = 1; cases <= T; cases++) {
            pw.print("Case #" + cases + ": ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            locations = new int[R][C];
            eliminated = new boolean[R][C];
            neighbors = new int[R][C][4];
            int count = 0;

            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C; j++) {
                    locations[i][j] = Integer.parseInt(st.nextToken());
                    count += locations[i][j];
                    Arrays.fill(neighbors[i][j], -1);
                }
            }

            boolean good = true;
            while (good) {
                good = false;
                int tempCount = 0;
                LinkedList<State> ll = new LinkedList<>();

                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (!eliminated[i][j]) {
                            int avg = 0;
                            int temp = 0;

                            temp = checkNeighbor(i - 1, j, i, j, 0, temp, avg);
                            temp = checkNeighbor(i + 1, j, i, j, 1, temp, avg);
                            temp = checkNeighbor(i, j - 1, i, j, 2, temp, avg);
                            temp = checkNeighbor(i, j + 1, i, j, 3, temp, avg);

                            if (avg > temp * locations[i][j]) {
                                good = true;
                                ll.add(new State(i, j));
                            } else {
                                tempCount += locations[i][j];
                            }
                        }
                    }
                }

                for (State s : ll) {
                    eliminated[s.x][s.y] = true;
                }

                if (good) {
                    count += tempCount;
                }
            }

            pw.println(count);
        }

        pw.close();
    }

    private static int checkNeighbor(int ni, int nj, int i, int j, int dir, int temp, int avg) {
        if (ni >= 0 && ni < locations.length && nj >= 0 && nj < locations[0].length && !eliminated[ni][nj]) {
            avg += locations[ni][nj];
            temp++;
        } else if (neighbors[i][j][dir] != -1 && !eliminated[neighbors[i][j][dir]][nj]) {
            avg += locations[neighbors[i][j][dir]][nj];
            temp++;
        } else {
            int a = dir % 2 == 0 ? i : j;
            int limit = dir % 2 == 0 ? locations.length : locations[0].length;
            int step = dir < 2 ? -1 : 1;
            while ((a += step) >= 0 && a < limit && eliminated[dir % 2 == 0 ? a : i][dir % 2 == 0 ? j : a]) ;
            if (a >= 0 && a < limit) {
                neighbors[i][j][dir] = a;
                avg += locations[dir % 2 == 0 ? a : i][dir % 2 == 0 ? j : a];
                temp++;
            }
        }
        return temp;
    }

    static class State {
        int x;
        int y;

        public State(int a, int b) {
            x = a;
            y = b;
        }
    }
}