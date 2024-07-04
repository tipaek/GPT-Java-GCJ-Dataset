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
            int n = r.nextInt();
            int[][] arr = new int[n][n];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    arr[i][j] = r.nextInt();
                }
            }
            int trace = 0;
            for(int i = 0; i < n; i++){
                trace += arr[i][i];
            }
            int rows = 0;
            int cols = 0;
            for(int i = 0; i < n; i++){ // row #
                HashSet<Integer> set = new HashSet<Integer>();
                for(int j = 0; j < n; j++){
                    set.add(arr[i][j]);
                }
                if(set.size() < n){
                    rows++;
                }
            } 
            for(int i = 0; i < n; i++){ // col #
                HashSet<Integer> set = new HashSet<Integer>();
                for(int j = 0; j < n; j++){
                    set.add(arr[j][i]);
                }
                if(set.size() < n){
                    cols++;
                }
            }
            pw.println("Case #" + q + ": " + trace + " " + rows + " " + cols);
        }

        pw.close();
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