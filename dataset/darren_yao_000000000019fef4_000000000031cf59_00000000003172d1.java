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
            int d = r.nextInt();
            long[] arr = new long[n];
            for(int i = 0; i < n; i++){
                arr[i] = r.nextLong();
            }
            Arrays.sort(arr);
            if(d == 2){
                boolean f = false;
                for(int i = 0; i < n-1; i++){
                    if(arr[i] == arr[i+1]){
                        f = true;
                    }
                }
                if(f){
                    pw.println("Case #" + q + ": " + 0);
                } else {
                    pw.println("Case #" + q + ": " + 1);
                }
            } else {
                boolean three = false;
                boolean two = false;
                for(int i = 0; i < n-2; i++){
                    if(arr[i] == arr[i+1] && arr[i+1] == arr[i+2]){
                        three = true;
                    }
                }
                for(int i = 0; i < n-1; i++){
                    if(Arrays.binarySearch(arr, 2 * arr[i]) >= 0){
                        two = true;
                    }
                }
                if(three){
                    pw.println("Case #" + q + ": " + 0);
                } else if(two){
                    pw.println("Case #" + q + ": " + 1);
                } else {
                    pw.println("Case #" + q + ": " + 2);
                }
            }
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