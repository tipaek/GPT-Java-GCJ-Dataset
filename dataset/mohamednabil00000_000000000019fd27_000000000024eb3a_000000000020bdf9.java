import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

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

    public static class node implements Comparable<node>{
        int s;
        int e;
        int idx;
        node(int s , int e, int idx){
            this.s = s;
            this.e = e;
            this.idx =idx;
        }

        @Override
        public int compareTo(node node) {
            return s - node.s;
        }
    }

    public static void main(String[] args) throws IOException {
        in.init(System.in);
        int t = in.nextInt();
        for (int i = 1; i <=t ; i++) {
            int n = in.nextInt();
            PriorityQueue<node> q=  new PriorityQueue<>();
            for (int j = 0; j < n; j++) {
                q.add(new node(in.nextInt(), in.nextInt(), j));
            }
            int CLast = 0;
            int JLast = 0;
            char ans[] = new char[n];
            boolean good = true;
            while(!q.isEmpty()){
                node x = q.poll();
                if (x.s >= CLast){
                    ans[x.idx]= 'C';
                    CLast = x.e;
                }else if (x.s >= JLast){
                    ans [x.idx]= 'J';
                    JLast = x.e;
                }else{

                    good = false;
                    break;
                }
            }
            if (!good){
                System.out.println("Case #"+i+": IMPOSSIBLE");
                continue;
            }
            String f = "";
            for (int j = 0; j < n; j++) {
                f += ans[j];
            }
            System.out.println("Case #"+i+": " + f);

        }
    }
}
