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
            String y [] = new String[n];
            boolean vis[][] = new boolean [n][101];
            ArrayList<String> beg = new ArrayList<>();
            ArrayList<String> end = new ArrayList<>();
            boolean good = true;

            for (int j = 0; j < n; j++) {
                String x = in.next();
                y[j] = x;
                int p = 0;
                int s= beg.size();
                for (int k = 0; k < x.length() && good; k++) {
                    if (x.charAt(k)== '*')
                        break;
                    vis[j][k] = true;
                    if (s > p){
                        if (!beg.get(p).equals(x.charAt(k)+"")){
                            good = false;
                        }
                        p++;
                    }else{
                        beg.add(x.charAt(k)+"");
                    }
                }
                p = 0;
                s = end.size();
                for (int k = x.length()-1; k>=0 && good; k--) {
                    if (x.charAt(k)== '*')
                        break;
                    vis[j][k] = true;
                    if (s > p){
                        if (!end.get(p).equals(x.charAt(k)+"")){
                            good = false;
                        }
                        p++;
                    }else{
                        end.add(x.charAt(k)+"");
                    }
                }
            }
            if (!good)
                System.out.println("Case #"+i+": *" );
            else{
               String ans = "";
                for (int j = 0; j < beg.size(); j++) {
                    ans += beg.get(j);
                }
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < y[j].length(); k++) {
                        if (y[j].charAt(k) != '*' && !vis[j][k])
                            ans+= y[j].charAt(k);
                    }
                }
                for (int j = end.size()-1; j>=0 ; j--) {
                    ans+= end.get(j);
                }
                System.out.println("Case #"+i+": "+ans );
            }

        }
    }
}
