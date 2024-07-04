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
            int u = r.nextInt();
            ArrayList<Query> queries = new ArrayList<Query>();
            for(int i = 0; i < 10000; i++){
                queries.add(new Query(r.nextInt(), r.next()));
            }
            Collections.sort(queries);
            String[] ans = new String[11];
            HashSet<String> set = new HashSet<String>();
            for(int i = 0; i < 10000; i++){
                int p = queries.get(i).num;
                if(p == 1){
                    ans[1] = queries.get(i).s;
                    set.add(queries.get(i).s);
                } if(p == 2){
                    if(!set.contains(queries.get(i).s)){
                        ans[2] = queries.get(i).s;
                        set.add(queries.get(i).s);
                    }
                } if(p == 3){
                    if(!set.contains(queries.get(i).s)){
                        ans[3] = queries.get(i).s;
                        set.add(queries.get(i).s);
                    }
                }if (p == 4){
                    if(!set.contains(queries.get(i).s)){
                        ans[4] = queries.get(i).s;
                        set.add(queries.get(i).s);
                    }
                }if(p == 5){
                    if(!set.contains(queries.get(i).s)){
                        ans[5] = queries.get(i).s;
                        set.add(queries.get(i).s);
                    }
                }if(p == 6){
                    if(!set.contains(queries.get(i).s)){
                        ans[6] = queries.get(i).s;
                        set.add(queries.get(i).s);
                    }
                }if(p == 7){
                    if(!set.contains(queries.get(i).s)){
                        ans[7] = queries.get(i).s;
                        set.add(queries.get(i).s);
                    }
                }if(p == 8){
                    if(!set.contains(queries.get(i).s)){
                        ans[8] = queries.get(i).s;
                        set.add(queries.get(i).s);
                    }
                }if(p == 9){
                    if(!set.contains(queries.get(i).s)){
                        ans[9] = queries.get(i).s;
                        set.add(queries.get(i).s);
                    }
                }if(p == 10){
                    if(!set.contains(queries.get(i).s)){
                        ans[10] = queries.get(i).s.substring(1);
                        set.add(queries.get(i).s);
                    }
                }
            }
            pw.print("Case #" + q + ": ");
            pw.print(ans[10]);
            for(int i = 1; i <= 9; i++){
                pw.print(ans[i]);
            }
            pw.println();
        }

        pw.close();
    }

    static class Query implements Comparable<Query>{
        int num; String s;
        public Query(int num, String s){
            this.num = num;
            this.s = s;
        }
        public int compareTo(Query q){
            return Integer.compare(this.num, q.num);
        }
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