
import java.io.*;
import java.util.*;


class Solution {

    public static void main(String[] args) {

        InputReader in = new InputReader();
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt(), l = 0;

        while (t-- > 0) {

            out.print("Case #" + (++l) + ": ");

            int  x=in.nextInt(),y=in.nextInt();
            char steps[]=in.next().toCharArray();

            int cnt=0,ans=-1;
            for(int i =0;i<steps.length;i++){
                if(Math.abs(x)+Math.abs(y)<=cnt){
                    ans=cnt;
                    break;
                }
                if(steps[i]=='N')
                    y++;
                else if(steps[i]=='S')
                    y--;
                else if(steps[i]=='E')
                    x++;
                else
                    x--;
                cnt++;
                if(Math.abs(x)+Math.abs(y)<=cnt ){
                    ans=cnt;
                    break;
                }
            }


            if(ans==-1)
                out.println("IMPOSSIBLE");
            else
                out.println(ans);



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
