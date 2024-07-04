import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());
        for (int i = 0; i < T; i++) solve(reader, i + 1);
    }

    static void solve(BufferedReader reader, int caseNum) throws Exception {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        long x = Long.parseLong(tokenizer.nextToken());
        long y = Long.parseLong(tokenizer.nextToken());

        System.out.printf("Case #%d: ", caseNum);
        dirs = new ArrayList<>();
        int result = solveCase((int)x, (int)y, 0);
        if (result >= Integer.MAX_VALUE / 2) {
            System.out.println("IMPOSSIBLE");
        } else {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < result; i++) {
                builder.append(dirs.get(dirs.size() - i - 1));
            }
            System.out.println(builder.toString());
        }
        // long[] powersOfTwo = new long[63];
        // powersOfTwo[0] = 1;
        // for (int i = 1; i < 63; i++) {
        //     powersOfTwo[i] = powersOfTwo[i - 1] * 2;
        // }

        // Queue<Posn> Q1 = new LinkedList<>();
        // Queue<Integer> Q2 = new LinkedList<>();
        // Set<Posn> visited = new HashSet<>();
        // boolean found = false;
        // int foundDist = -1;
        // Q1.add(new Posn(0, 0));
        // Q2.add(0);
        // int iter = 0;
        // while (!Q1.isEmpty()) {
        //     Posn cur = Q1.poll();
        //     int dist = Q2.poll();
        //     if (iter % 10000 == 0) {
        //         System.out.println("Iter " + iter);
        //     }
        //     iter++;
        //     if (dist > 30) break;
        //     if (cur.x == x && cur.y == y) {
        //         found = true;
        //         foundDist = dist;
        //         break;
        //     }
        //     visited.add(cur);

        //     Posn left = new Posn(cur.x - powersOfTwo[dist], cur.y);
        //     if (!visited.contains(left)) {
        //         Q1.add(left);
        //         Q2.add(dist + 1);
        //     }
        //     Posn right = new Posn(cur.x + powersOfTwo[dist], cur.y);
        //     if (!visited.contains(right)) {
        //         Q1.add(right);
        //         Q2.add(dist + 1);
        //     }
        //     Posn up = new Posn(cur.x, cur.y - powersOfTwo[dist]);
        //     if (!visited.contains(up)) {
        //         Q1.add(up);
        //         Q2.add(dist + 1);
        //     }
        //     Posn down = new Posn(cur.x, cur.y + powersOfTwo[dist]);
        //     if (!visited.contains(down)) {
        //         Q1.add(down);
        //         Q2.add(dist + 1);
        //     }
        // }
        // if (found) {
        //     System.out.printf("Case #%d: %d%n", caseNum, foundDist);
        // } else {
        //     System.out.printf("Case #%d: IMPOSSIBLE%n", caseNum);
        // }
    }

    static List<Character> dirs;

    static int solveCase(int x, int y, int depth) {
        if (x == 0 && y == 0) return depth;
        if (depth > 1000) return Integer.MAX_VALUE / 2;
        int min = Integer.MAX_VALUE / 2;
        Character dir = null;
        if ((x - 1) % 2 == 0 && y % 2 == 0) {
            int val = solveCase((x - 1) / 2, y / 2, depth + 1);
            if (val < min) {
                min = val;
                dir = 'E';
            }
        }
        if (x % 2 == 0 && (y - 1) %2 == 0) {
            int val = solveCase((x / 2), (y - 1) / 2, depth + 1);
            if (val < min) {
                min = val;
                dir = 'N';
            }
        }
        if ((x + 1) % 2 == 0 && y % 2 == 0) {
            int val = solveCase((x + 1) / 2, y / 2, depth + 1);
            if (val < min) {
                min = val;
                dir = 'W';
            }
        }
        if (x % 2 == 0 && (y + 1) %2 == 0) {
            int val = solveCase((x / 2), (y + 1) / 2, depth + 1);
            if (val < min) {
                min = val;
                dir = 'S';
            }
        }
        if (dir != null) {
            dirs.add(dir);
        }
        return min;
    }

    static class Posn {
        long x, y;

        Posn(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object o) {
            if (!(o instanceof Posn)) return false;

            Posn other = (Posn)o;

            return x == other.x && y == other.y;
        }

        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}