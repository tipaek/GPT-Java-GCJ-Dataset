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
            System.out.println("Case #"+i+":");
            System.out.println(1+" "+1);
            if (n==1){
                continue;
            }else{
                n--;
                int s = 0 ;
                for (int j = 1; j < 499; j++) {
                    if (j *(j+1) <= n*2){
                        s= j;
                    }else{
                        break;
                    }
                }
                 int last_x = 0;
                int last_y = 0;
                for (int j = 0; j < s; j++) {
                    System.out.println((j+2) + " "+ (j+1));
                    last_x = j+2;
                    last_y = j+1;
                }

                int rem = n - (s*(s+1))/2;
                if (rem >0){
                    System.out.println(last_x +" "+ (last_y+1));
                    last_y++;
                    rem--;
                }
                for (int j = 1; j <= rem; j++) {
                    System.out.println((last_x-j) +" "+ (last_y-j));
                }

            }


        }

    }
}
