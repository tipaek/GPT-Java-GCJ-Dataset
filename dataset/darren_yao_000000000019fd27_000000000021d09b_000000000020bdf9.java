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
            ArrayList<Event> list = new ArrayList<Event>();
            for(int i = 0; i < n; i++){
                int a = r.nextInt();
                int b = r.nextInt();
                list.add(new Event(a, b, i));
            }
            Collections.sort(list);

            int cBusyUntil = 0;
            int jBusyUntil = 0;
            boolean possible = true;

            for(int i = 0; i < list.size(); i++){
                if(cBusyUntil <= list.get(i).start){
                    cBusyUntil = list.get(i).end;
                    list.get(i).assignment = 1;
                } else if(jBusyUntil <= list.get(i).start){
                    jBusyUntil = list.get(i).end;
                    list.get(i).assignment = 2;
                } else {
                    possible = false;
                }
            }



            pw.print("Case #" + q + ": ");
            if(!possible){
                pw.print("IMPOSSIBLE");
            } else {
                Collections.sort(list, new Sort());
                for(int i = 0; i < list.size(); i++){
                    pw.print(list.get(i).assignment == 1 ? "J" : "C");
                }
            }
            pw.println();
        }

        pw.close();
    }

    static class Sort implements Comparator<Event>{
        public int compare(Event a, Event b){
            return Integer.compare(a.id, b.id);
        }
    }

    static class Event implements Comparable<Event>{
        int start;
        int end;
        int id;
        int assignment = -1;
        public Event(int s, int e, int i){
            start = s;
            end = e;
            id = i;
        }
        public int compareTo(Event e){
            return Integer.compare(start, e.start);
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