import java.io.*;
import java.util.*;

public class A {

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
            int x = r.nextInt(); int y = r.nextInt();
            String s = r.next();
            int n = s.length();
            boolean ansFound = false;
            int i = 0;
            for(i = 0; i < n; i++){
                char c = s.charAt(i);
                if(c == 'N'){
                    y++;
                } else if (c == 'S'){
                    y--;
                } else if(c == 'E'){
                    x++;
                } else {
                    x--;
                }
                int dist = Math.abs(x) + Math.abs(y);
                if(dist <= i+1){
                    ansFound = true;
                    break;
                }
            }
            if(ansFound){
                pw.println("Case #" + q + ": " + (i+1));
            } else {
                pw.println("Case #" + q + ": " + "IMPOSSIBLE");
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