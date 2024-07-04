import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    static AbstractMap.SimpleEntry<List<Long>, Long> up_competitor(int i, int j, int r, int c, long[][] map) {
        List<Long> competitors = new ArrayList<>();
        long sum = 0;
        for (int a = i -1; a >= 0; --a) {
            if (0 != map[a][j]) {
                competitors.add(map[a][j]);
                sum += map[a][j];
                break;
            }
        }

        for (int a = i + 1; a < r; ++a) {
            if (0 != map[a][j]) {
                competitors.add(map[a][j]);
                sum += map[a][j];
                break;
            }
        }

        for (int b = j - 1; b >= 0; --b) {
            if (0 != map[i][b]) {
                competitors.add(map[i][b]);
                sum += map[i][b];
                break;
            }
        }

        for (int b = j + 1; b < c; ++b) {
            if (0 != map[i][b]) {
                competitors.add(map[i][b]);
                sum += map[i][b];
                break;
            }
        }

        return new AbstractMap.SimpleEntry<>(competitors, sum);
    }

    static long solve(int r, int c, long[][] map, int round) {
        long interestRound = 0;
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                interestRound += map[i][j];
            }
        }

        long[][] newmap = new long[r][c];
        boolean eliminated = false;
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (map[i][j] == 0) {
                    continue;
                }

                AbstractMap.SimpleEntry<List<Long>,Long> competitors = up_competitor(i, j, r, c, map);
                if (competitors.getKey().size() == 0) {
                    newmap[i][j] = map[i][j];
                    continue;
                }
                double dbl = competitors.getValue();
                dbl /= competitors.getKey().size();
                if (dbl <= map[i][j]) {
                    newmap[i][j] = map[i][j];
                } else {
                    eliminated = true;
                }
            }
        }

        if (!eliminated) {
            return interestRound;
        }
        return interestRound + solve(r, c, newmap, round + 1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int r = in.nextInt();
            int c = in.nextInt();
            long[][] map = new long[r][c];
            List<List<Long>> total = new ArrayList<>(r);
            for (int line = 0; line < r; ++line) {
                for (int intc = 0; intc < c; ++intc) {
                    map[line][intc] = in.nextLong();
                }
            }

            long sol = solve(r, c, map, 1);
            System.out.print(String.format("Case #%d: ", i));
            System.out.println(sol);
        }
    }
}