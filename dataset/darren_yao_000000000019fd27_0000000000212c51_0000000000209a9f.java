import java.io.*;
import java.util.*;

public class Solution {

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        String next() {
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

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    static InputReader r = new InputReader(System.in);
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {

        int t = r.nextInt();
        for(int q = 1; q <= t; q++){
            pw.print("Case #" + q + ": ");
            String s = r.next();
            int[] arr = new int[s.length()+2];
            int n = s.length();
            for(int i = 1; i <= n; i++){
                arr[i] = f(s.charAt(i-1));
            }
            for(int i = 1; i <= n; i++){
                int diff = arr[i]-arr[i-1];
                if(diff >= 0){
                    for(int j = 0; j < diff; j++){
                        pw.print("(");
                    }
                } else {
                    for(int j = 0; j < -diff; j++){
                        pw.print(")");
                    }
                }
                pw.print(arr[i]);
            }
            for(int i = 0; i < arr[n]; i++){
                pw.print(")");
            }
            pw.println();
        }

        pw.close();
    }

    static int f(char c){
        return c - '0';
    }
}

/**
*                _        _                 _                                                
*               | |      | |               | |                                               
*   ___ ___   __| | ___  | |__  _   _    __| | __ _ _ __ _ __ ___ _ __     _   _  __ _  ___  
*  / __/ _ \ / _` |/ _ \ | '_ \| | | |  / _` |/ _` | '__| '__/ _ \ '_ \   | | | |/ _` |/ _ \ 
* | (_| (_) | (_| |  __/ | |_) | |_| | | (_| | (_| | |  | | |  __/ | | |  | |_| | (_| | (_) |
*  \___\___/ \__,_|\___| |_.__/ \__, |  \__,_|\__,_|_|  |_|  \___|_| |_|   \__, |\__,_|\___/ 
*                                __/ |                               ______ __/ |            
*                               |___/                               |______|___/             
 */