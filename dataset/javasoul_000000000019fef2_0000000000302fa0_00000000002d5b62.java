import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution {
    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            solve();
            in.close();
            out.close();
        } catch (Throwable t) {
            t.printStackTrace(System.err);
            System.exit(-1);
        }
    }

    String readString() throws IOException {
        while (!tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }
    // solution

    void solve() throws IOException {
        int tc = readInt();
        for (int t = 1; t <= tc; ++t) {
            int x = readInt();
            int y = readInt();
            String res="";
            if(x==0 && y==0){
                System.out.println(String.format("Case #%s: ",t));
                continue;
            }
            Queue<Point> queue = new LinkedList<>();
            queue.add(new Point(0,0, -1, ""));
            //HashSet<String> visited = new HashSet<>();
            //visited.add("0.0");
            while (!queue.isEmpty() && res.length()==0){
                Point point = queue.poll();
                if(point.x==x && point.y==y){
                    res=point.moves;
                    break;
                }
                if(point.pow>=30)
                    continue;
                int newpow = 1<<point.pow+1;
                //N possible +y
                if (Math.abs(point.y+newpow) <= Math.abs(y*2)){// && !visited.contains(point.x+"."+(point.y+newpow))) {
                    if(point.x == x && point.y+newpow == y){
                        res=point.moves+"N";
                        break;
                    }
                    queue.add(new Point(point.x, point.y+newpow, point.pow+1, point.moves+"N"));
                    //visited.add(point.x+"."+(point.y+newpow));
                }
                //S possible -y
                if (Math.abs(point.y-newpow) <= Math.abs(y*2)){// && !visited.contains(point.x+"."+(point.y-newpow))) {
                    if(point.x == x && point.y-newpow == y){
                        res=point.moves+"S";
                        break;
                    }
                    queue.add(new Point(point.x, point.y-newpow, point.pow+1, point.moves+"S"));
                    ///visited.add(point.x+"."+(point.y-newpow));
                }
                //E possible +x
                if (Math.abs(point.x+newpow) <= Math.abs(x*2)){// && !visited.contains((point.x+newpow)+"."+point.y)) {
                    if((point.x+newpow) == x && point.y == y){
                        res=point.moves+"E";
                        break;
                    }
                    queue.add(new Point((point.x+newpow), point.y, point.pow+1, point.moves+"E"));
                   // visited.add((point.x+newpow)+"."+point.y);
                }
                //W possible -x
                if (Math.abs(point.x-newpow) <= Math.abs(x*2)){// && !visited.contains((point.x-newpow)+"."+point.y)) {
                    if((point.x-newpow) == x && point.y == y){
                        res=point.moves+"W";
                        break;
                    }
                    queue.add(new Point((point.x-newpow), point.y, point.pow+1, point.moves+"W"));
                    //visited.add((point.x-newpow)+"."+point.y);
                }
            }
            if(res.length()==0)
                System.out.println(String.format("Case #%s: IMPOSSIBLE",t));
            else
                System.out.println(String.format("Case #%s: %s",t, res));
        }
        return;
    }

    class Point {
        public int x;
        public int y;
        public int pow;
        public String moves;

        public Point(int x, int y, int pow, String moves) {
            this.x = x;
            this.y = y;
            this.pow = pow;
            this.moves = moves;
        }
    }
}