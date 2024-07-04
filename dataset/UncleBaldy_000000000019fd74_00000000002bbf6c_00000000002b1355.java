import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader in;
    public static void main(String[] args) throws Exception {
        in = new BufferedReader(
                new InputStreamReader(System.in)
        );
        int T = Integer.parseInt(in.readLine());
        for (int x = 0; x++ < T;) {
            String[] line = in.readLine().split(" ");
            int R = Integer.parseInt(line[0]);
            int C = Integer.parseInt(line[1]);
            int N = 0;
            Dancer[][] D = new Dancer[R][C];
            Dancer[] all = new Dancer[R * C];
            long interest = 0;
            for (int i = 0; i < R; i++) {
                line = in.readLine().split(" ");
                for (int j = 0; j < C; j++) {
                    Dancer d = new Dancer();
                    d.skill = Integer.parseInt(line[j]);
                    interest += d.skill;
                    if (i > 0) {
                        d.north = D[i-1][j];
                        D[i-1][j].south = d;
                    }
                    if (j > 0) {
                        d.west = D[i][j-1];
                        D[i][j-1].east = d;
                    }
                    D[i][j] = d;
                    all[N] = d;
                    N++;
                }
            }
            long y = solve(N, all, interest);
            System.out.printf("Case #%d: %d\n", x, y);
        }
    }

    static long solve(int N, Dancer[] D, long interest) {
        long interestLevel = 0;
        for (int totalEliminated = 1; totalEliminated > 0;) {
            interestLevel += interest;
            totalEliminated = 0;
            for (int i = 0; i < N; i++) {
                Dancer d = D[i];
                if (d.hasSadMoves()) {
                    d.isEliminated = true;
                }
            }
            for (int i = 0; i < N;) {
                Dancer d = D[i];
                if (d.isEliminated) {
                    d.remove();
                    totalEliminated++;
                    interest -= d.skill;
                    D[i] = D[N-1];
                    N--;
                }
                else {
                    i++;
                }
            }
        }
        return interestLevel;
    }
}

class Dancer {
    Dancer north, south, east, west;
    long skill;
    boolean isEliminated;
    boolean hasSadMoves() {
        long avg = 0;
        long mine = 0;
        if (north != null) {
            avg += north.skill;
            mine += skill;
        }
        if (south != null) {
            avg += south.skill;
            mine += skill;
        }
        if (east != null) {
            avg += east.skill;
            mine += skill;
        }
        if (west != null) {
            avg += west.skill;
            mine += skill;
        }
        return mine < avg;
    }
    void remove() {
        if (north != null)
            north.south = south;
        if (south != null)
            south.north = north;
        if (east != null)
            east.west = west;
        if (west != null)
            west.east = east;
    }
}