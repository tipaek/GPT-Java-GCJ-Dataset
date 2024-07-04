import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public static class in   {
        static BufferedReader reader;
        static StringTokenizer tokenizer;

        static void init(InputStream input) throws FileNotFoundException {
            //reader = new BufferedReader(new FileReader("jacks_candy_shop.txt"));
            reader = new BufferedReader(new InputStreamReader(input));
            tokenizer = new StringTokenizer("");
        }

        static String next() throws IOException {
            while (!tokenizer.hasMoreTokens())
                tokenizer = new StringTokenizer(reader.readLine());
            return tokenizer.nextToken();
        }

        static int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        static double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        static long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }
    // for bad input
    static String ReadLn(int maxLg) {
        byte lin[] = new byte[maxLg];
        int lg = 0, car = -1;
        String line = "";

        try {
            while (lg < maxLg) {
                car = System.in.read();
                if ((car < 0) || (car == '\n'))
                    break;
                lin[lg++] += car;
            }
        } catch (IOException e) {
            return (null);
        }

        if ((car < 0) && (lg == 0))
            return (null);
        return (new String(lin, 0, lg));
    }

    public static class node{
        int x;
        int y;
        String ans = "";
        node(int x, int y, String ans){
            this.ans = ans;
            this.x = x;
            this.y =y;
        }

    }

    public static String bfs(int x, int y){
        Queue<node> q = new LinkedList<>();
        int shift = 105;
        x += shift;
        y+= shift;
        HashSet<String> mp = new HashSet<>();
        mp.add("");
        q.add(new node(shift , shift, ""));
        while(!q.isEmpty()){
            node e = q.poll();
            if (e.x == x && e.y == y)
                return e.ans;
            if (e.ans.length() > 10)
                continue;

            int level =  1<< e.ans.length();

            int dx = e.x + level;
            int dy = e.y + level;
            int dx2 = e.x - level;
            int dy2 = e.y - level;


            if (dx >=0  && !mp.contains(e.ans +"E")){
                mp.add(e.ans +"E");
                q.add(new node(dx, e.y, e.ans +"E"));
            }
            if (dx2 >=0 && !mp.contains(e.ans +"W")){
                mp.add(e.ans +"W");
                q.add(new node(dx2, e.y, e.ans +"W"));
            }
            if (dy >=0  && !mp.contains(e.ans +"N")){
                mp.add(e.ans +"N");
                q.add(new node(e.x, dy, e.ans +"N"));
            }
            if (dy2 >=0  && !mp.contains(e.ans +"S")){
                mp.add(e.ans +"S");
                q.add(new node(e.x, dy2, e.ans +"S"));
            }

        }

        return "IMPOSSIBLE";
    }

    public static void main(String[] args) throws IOException {
        in.init(System.in);
        int t = in.nextInt();
        for (int i = 1; i <=t ; i++) {
            int x = in.nextInt();
            int y = in.nextInt();

            System.out.println("Case #" + i + ": " +bfs(x,y));
            }

    }
}
