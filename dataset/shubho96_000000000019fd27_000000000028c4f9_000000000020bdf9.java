
import java.util.*;
import java.io.*;

public class Solution{
    public static void main(String[] args) {
        FastReader in  = new FastReader();

        int t = in.nextInt();  
        
        int tt = 0;
        while(++tt <= t){
            int n = in.nextInt();
            
            Activity arr[] = new Activity[n];
            for(int i = 0; i < n; ++i){
                int s = in.nextInt();
                int e = in.nextInt();
                arr[i] = new Activity(s, e, i);
            }

            Arrays.sort(arr);

            char[] assign = new char[n];
            assign[arr[0].idx] = 'C';
            int cEnds = arr[0].end;
            int jEnds = 0;
            int i;
            for(i = 1; i < n; ++i){
                if(cEnds <= arr[i].start){
                    assign[arr[i].idx] = 'C';
                    cEnds = arr[i].end;
                }
                else if(jEnds <= arr[i].start){
                    assign[arr[i].idx] = 'J';
                    jEnds = arr[i].end;
                }else
                    break;

            }

            if(i < n){
                System.out.println("Case #" +tt +": "+ "IMPOSSIBLE");
            }
            else{
                System.out.println("Case #" +tt +": "+ String.valueOf(assign));
            }

        }
    }
}

class Activity implements Comparable<Activity>{
    int start, end, idx;
    Activity(int s, int e, int i){
        start = s;
        end = e;
        idx = i;
    }

    @Override
    public int compareTo(Activity a) {        
        if(a.start != start)
            return start - a.start;
        
        return end - a.end;
    }


}

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                String s = br.readLine();
                if (s == null || s.length() == 0)
                    return null;
                st = new StringTokenizer(s);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        // return Integer.parseInt(next());
        String s = next();
        // System.out.println("inputed s ::" + s);
        if (s == null)
            return -1;
        else
            return Integer.parseInt(s);

    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
            if (str == null || str.length() == 0)
                return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}