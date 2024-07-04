import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int testCase = input.nextInt();

        for (int testNumber = 1; testNumber <= testCase; testNumber++) {
            pw.print("Case #" + testNumber + ": ");
            solve(input, pw);
            pw.println();
        }
        pw.close();
    }

    public static void solve(Scanner input, PrintWriter pw) throws IOException {
        int X = input.nextInt();
        int Y = input.nextInt();
        HashMap<Long, HashSet<Long>> map = new HashMap<>();
        Queue<Pos> posQueue = new LinkedList<>();
        posQueue.add(new Pos(0, 0, "", 1));
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        char[] dir = {'E', 'W', 'N', 'S'};
        while (!posQueue.isEmpty()) {
            Pos p = posQueue.poll();
            if (map.containsKey(p.x) && map.get(p.x).contains(p.y)) {
                continue;
            }
            if (p.x == X && p.y == Y) {
                pw.print(p.dir);
                return;
            }
            if (map.containsKey(p.x)) {
                map.get(p.x).add(p.y);
            } else {
                HashSet<Long> set = new HashSet<>();
                set.add(p.y);
                map.put(p.x, set);
            }
            for (int i = 0; i < 4; i++) {
                long nx = dx[i] * p.two + p.x;
                long ny = dy[i] * p.two + p.y;
                if (Math.abs(nx) <= 500l && Math.abs(ny) <= 500)
                    posQueue.add(new Pos(nx, ny, p.dir + dir[i], p.two * 2));
            }

        }
        pw.print("IMPOSSIBLE");
    }

    public static class Pos {
        long x, y;
        long two;
        String dir;

        public Pos(long x, long y, String dir, long two) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.two = two;
        }
    }

    public static class Scanner {
        private BufferedReader bufferedReader;
        private StringTokenizer stk;

        public Scanner(InputStream inputStream) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        }

        public int nextInt() throws IOException {
            nullOrGet();
            return Integer.parseInt(stk.nextToken());
        }

        public long nextLong() throws IOException {
            nullOrGet();
            return Long.parseLong(stk.nextToken());
        }

        public String next() throws IOException {
            nullOrGet();
            return stk.nextToken();
        }

        private StringTokenizer nullOrGet() throws IOException {
            if (stk == null || !stk.hasMoreTokens()) {
                stk = new StringTokenizer(bufferedReader.readLine());
            }
            return stk;
        }
    }

}
