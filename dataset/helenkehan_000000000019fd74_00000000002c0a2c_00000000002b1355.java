import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


/**
 * Created by HelenHan on 3/6/20.
 */
public class Solution {
    static final int[][] offsets = new int[][]{{-1, 0} , {1, 0}, {0, -1} , {0, 1}};

    static class Point {
        int r;
        int c;
        HashSet<Point> neighbors;

        Point(int rr, int cc) {
            r = rr;
            c = cc;
            neighbors = new HashSet<>();
        }

        Point(int rr, int cc, HashSet<Point> set) {
            r = rr;
            c = cc;
            neighbors = set;
        }

        int[] direction(Point o) {
            int x = Integer.compare(r, o.r);
            int y = Integer.compare(c, o.c);
            return new int[]{x, y};
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Point)) {
                return false;
            }
            Point c = (Point) o;
            return c.r == this.r && c.c == this.c;
        }

        @Override
        public int hashCode() {
            return r * 100000 + c;
        }
    }

    public static boolean inBound(int R, int C, int rr, int cc) {
        return (rr >= 0 && rr < R) && (cc >= 0 && cc < C);
    }

    public static int solve(int[][] matrix, int R, int C) {
        int sum = 0;
        int sumGone = 0;
        int sumRound = 0;
        boolean[][] has = new boolean[R][C];
        HashMap<String, Point> map = new HashMap<>();
        Queue<Point> delete = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                Point point = new Point(i, j);
                String key = i + "," + j;
                map.put(key, point);
                has[i][j] = true;
                sumRound += matrix[i][j];
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                String key = i + "," + j;
                Point point = map.get(key);
                int neighbourSum = 0;
                for (int[] offset : offsets) {
                    int dx = i + offset[0];
                    int dy = j + offset[1];
                    if (inBound(R, C, dx, dy)) {
                        String neighborKey = dx + "," + dy;
                        point.neighbors.add(map.get(neighborKey));
                        neighbourSum += matrix[dx][dy];
                    }
                }
                if (point.neighbors.size() != 0) {
                    if (matrix[i][j] < 1.0*neighbourSum / point.neighbors
                            .size()) {
                        delete.add(point);
                        has[i][j] = false;
                    }
                }
            }
        }
        sum += (sumRound - sumGone);
        while (!delete.isEmpty()) {
            int deleteSize = delete.size();
            for (int i = 0; i < deleteSize; i++) {
                Point pointDelete = delete.poll();
                sumGone += matrix[pointDelete.r][pointDelete.c];
                for (Point neighbor : pointDelete.neighbors) {
                    neighbor.neighbors.remove(pointDelete);
                    if(neighbor.r==pointDelete.r){
                        int startc = pointDelete.c;
                        int step = (pointDelete.c>neighbor.c)?1:-1;
                        while(startc>=0&&startc<C){
                            if(has[neighbor.r][startc])break;
                            startc +=step;
                        }
                        if(startc<0 || startc>=C){
                        }else{
                            String key = neighbor.r+","+startc;
                            neighbor.neighbors.add(map.get(key));
                        }
                    }else{//c
                        int startr = pointDelete.r;
                        int step = (pointDelete.r>neighbor.r)?1:-1;
                        while(startr>=0&&startr<R){
                            if(has[startr][neighbor.c])break;
                            startr +=step;
                        }
                        if(startr<0 || startr>=R){
                        }else{
                            String key = startr+","+neighbor.c;
                            neighbor.neighbors.add(map.get(key));
                        }
                    }

                }
                String key = pointDelete.r + "," + pointDelete.c;
                map.remove(key);

            }
            sum += (sumRound - sumGone);
            sumRound -= sumGone;
            sumGone = 0;
            for (Point point : map.values()) {
                int neighborSum = 0;
                for (Point neighbor : point.neighbors) {
                    neighborSum +=matrix[neighbor.r][neighbor.c];
                }
                if (point.neighbors.size() != 0) {
                    if (matrix[point.r][point.c] < 1.0*neighborSum / point
                            .neighbors.size()) {
                        delete.add(point);
                        has[point.r][point.c]=false;
                    }
                }
            }

        }

        return sum;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] t = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int T = Integer.parseInt(t[0]);

        for (int j = 1; j <= T; j++) {
            String[] n = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            int R = Integer.parseInt(n[0]);
            int C = Integer.parseInt(n[1]);

            int[][] matrix = new int[R][C];
            for (int r = 0; r < R; r++) {
                String[] Items = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                for (int c = 0; c < C; c++) {
                    int temp = Integer.parseInt(Items[c]);
                    matrix[r][c] = temp;
                }
            }

            int res = solve(matrix, R, C);
            System.out.println("Case #" + j + ": " + res);
        }

        bufferedReader.close();
    }
}