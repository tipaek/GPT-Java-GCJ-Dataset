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
        node(int x, int y){
            this.x = x;
            this.y =y;
        }

    }

    public static void bfs(int x, int y) throws IOException {
        in.init(System.in);
        Queue<node> q = new LinkedList<>();

        HashSet<String> mp = new HashSet<>();
        q.add(new node(0 , 0));
        int dx[] = {1,-1, 0, 0, -1, 1, 1, -1};
        int dy [] = {0 ,0, 1, -1,-1, 1, -1, 1};
        while(!q.isEmpty()){
            node e = q.poll();
            System.out.println(e.x +" "+ e.y);
            String c = in.next();
            if (c.equals("CENTER")){
                return;
            }
            else{
                if(e.x > 50 || e.x < -50 || e.y > 50 || e.y < -50)
                    continue;
                for (int i = 0; i < 8; i++) {
                    int x2 = e.x + dx[i];
                    int y2 = e.y + dy[i];
                    if (!mp.contains(x2+" "+ y2)){
                        mp.add(x2+" "+ y2);
                        q.add(new node(x2, y2));
                    }
                }
            }
        }
        return ;
    }

    public static void main(String[] args) throws IOException {
        in.init(System.in);
        int t = in.nextInt();
        for (int i = 1; i <=t ; i++) {
            int a = in.nextInt();
            int b = in.nextInt();

            bfs(a, b);

        }
    }
}
