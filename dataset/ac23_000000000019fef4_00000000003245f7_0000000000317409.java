
import java.io.*;
import java.util.*;

public class Solution {
    public static char[] dirs = {'A', 'S', 'N', 'E', 'W'};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        int t = in.nextInt();
        for(int tc=1;tc<=t;tc++) {
            int x = in.nextInt();
            int y = in.nextInt();
            String m = in.next();
            int n = m.length();
            Pair[] intersections = new Pair[n+1];
            intersections[0] =new Pair(x, y);
            for(int i=0;i<n;i++) {
                intersections[i+1] = nextDir(m.charAt(i), intersections[i]);
            }
            Queue<Info> q = new LinkedList<>();
            int ans = -1;
            q.add(new Info(new Pair(0, 0),  0)); //make_pair(x, y),
            while(!q.isEmpty()) {
                Info p = q.poll();

                if (eq(p.p1, intersections[p.time])) {
                    ans = p.time;
                    break;
                }
                for (int i=0;i<5;i++) {
                    if (p.time < n)
                        q.add(new Info(nextDir(dirs[i], p.p1), p.time+1));
                }
            }
            out.print("Case #"+tc+": ");
            if(ans == -1) out.println("IMPOSSIBLE");
            else out.println(ans);
        }
        out.close();
    }

    public static boolean eq(Pair p1, Pair p12) {
        return p1.x == p12.x && p1.y == p12.y;
    }

    public static Pair nextDir(char c, Pair p1) {
        Pair p;
        int i = p1.x, j = p1.y;
        if (c == 'A') p = p1;
        else if (c == 'S') p =  new Pair(i, j-1);
        else if (c == 'N') p = new Pair(i, j+1);
        else if (c == 'E') p = new Pair(i+1, j);
        else p = new Pair(i-1, j);

        return p;
    }

    static class Info {
        public Pair p1;
        public int time;
        Info(Pair _p1, int _time){
            p1 = _p1;
            time = _time;
        }
    }
    static class Pair{
        public int x;
        public int y;
        Pair(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }

}
