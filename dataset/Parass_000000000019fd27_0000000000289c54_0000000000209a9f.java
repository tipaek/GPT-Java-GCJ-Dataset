import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt(),x=0;

        while (x++<t) {
            char arr[] = in.next().toCharArray();
            int open[] = new int[arr.length + 1];
            int close[] = new int[arr.length + 1];

            int o = 0, c = 0;
            for (int i = 0; i < arr.length; i++) {

                int num = arr[i] - '0';
                if(i!=0){
                    int prv = arr[i-1] - '0';
                    if(num>=prv){
                        close[i]=0;
                    }else{
                        int diff=prv-num;
                        close[i]=diff;
                        o-=diff;
                    }
                }

                open[i] = num - o;
                o = num;

            }
            close[arr.length]=arr[arr.length-1]-'0';


            out.print("Case #"+x+": " );

            for(int i=0;i<arr.length;i++){
                for(int j=0;j<open[i];j++)
                    out.print("(");

                out.print(arr[i]);

                for(int j=0;j<close[i+1];j++)
                    out.print(")");
            }


            out.println();

        }

        out.close();

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public int[] shuffle(int[] arr) {
            Random r = new Random();
            for (int i = 1, j; i < arr.length; i++) {
                j = r.nextInt(i);
                arr[i] = arr[i] ^ arr[j];
                arr[j] = arr[i] ^ arr[j];
                arr[i] = arr[i] ^ arr[j];
            }
            return arr;
        }

        public InputReader() {
            reader = new BufferedReader(new InputStreamReader(System.in), 32768);
            tokenizer = null;
        }

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(System.in), 32768);
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

        public char nextChar() {
            return next().charAt(0);
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }


    }

}

