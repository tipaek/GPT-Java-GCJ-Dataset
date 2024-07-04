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


    public static void main(String[] args) {

        InputReader in =new InputReader();
        PrintWriter out=new PrintWriter(System.out);

        int t =in.nextInt(),x=0;
        while(x++<t) {
            int N =in.nextInt();
            int arr[][]=new int[N][N];
            int r=0,c=0,m=0;
            for (int i = 0; i <N; i++) {
                for (int j = 0; j <N; j++) {
                    arr[i][j]=in.nextInt();
                    if(i==j)
                        m+=arr[i][j];
                }
            }

            HashSet<Integer> set=new HashSet<>();
            for (int i = 0; i <N; i++) {
                set=new HashSet<>();
                for (int j = 0; j <N; j++) {
                    if(set.contains(arr[i][j])) {
                        r++;
                        break;
                    }
                    set.add(arr[i][j]);
                }
            }

            for (int i = 0; i <N; i++) {
                set=new HashSet<>();
                for (int j = 0; j <N; j++) {
                    if(set.contains(arr[j][i])) {
                        c++;
                        break;
                    }
                    set.add(arr[j][i]);
                }
            }


            out.println("Case #"+x+": " +m+" "+r+" "+c);
        }

        out.close();

    }
}

