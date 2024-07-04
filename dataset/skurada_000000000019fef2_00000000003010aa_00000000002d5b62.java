import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int loop=1; loop<=T; loop++) {
            int r = in.nextInt();
            int c = in.nextInt();

            int[][] grid = new int[r][c];

            ArrayList<Coordinates> coordinates = new ArrayList<>();

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    grid[i][j] = in.nextInt();
                    coordinates.add(new Coordinates(i, j));
                }
            }

            int result = solve(r, c, grid, coordinates);

            sb.append("Case #");
            sb.append(loop);
            sb.append(": ");
            sb.append(result);
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }

    private static int solve(int r, int c, int[][] grid, ArrayList<Coordinates> coordinates) {

        ArrayList<Coordinates> removed = new ArrayList<>();
        ArrayList<Coordinates> keep = new ArrayList<>();

        int totalInterest = 0;

        do {
            removed = new ArrayList<>();
            keep = new ArrayList<>();
            for (int i = 0; i < coordinates.size(); i++) {
                Coordinates cur = coordinates.get(i);

                totalInterest += grid[cur.r][cur.c];

                int[] res = neighbors(r, c, cur, grid);

                if (res[0] != 0) {
                    // actually has neighbors

                    if (grid[cur.r][cur.c] < ((double)res[0] / res[1])) {
                        removed.add(cur);
                    }
                    else {
                        keep.add(cur);
                    }
                }

            }

            for (Coordinates coordinate: removed) {
                grid[coordinate.r][coordinate.c] = 0;
            }

            coordinates = keep;

        } while (removed.size() > 0);

        return totalInterest;
    }

    private static int[] neighbors(int r, int c, Coordinates cur, int[][] grid) {
        int soFar = 0;
        int numPeople = 0;

        for (int i = cur.r+1; i < r; i++) {
            if (grid[i][cur.c] != 0) {
                soFar+= grid[i][cur.c];
                numPeople++;
                break;
            }
        }

        for (int i = 0; i < cur.r; i++) {
            if (grid[i][cur.c] != 0) {
                soFar+= grid[i][cur.c];
                numPeople++;
                break;
            }
        }

        for (int i = cur.c+1; i < c; i++) {
            if (grid[cur.r][i] != 0) {
                soFar+= grid[cur.r][i];
                numPeople++;
                break;
            }
        }

        for (int i = 0; i < cur.c; i++) {
            if (grid[cur.r][i] != 0) {
                soFar+= grid[cur.r][i];
                numPeople++;
                break;
            }
        }

        return new int[] {soFar, numPeople};
    }

    static class Coordinates {
        int r, c;

        Coordinates(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}


