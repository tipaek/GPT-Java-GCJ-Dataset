import java.io.*;
import java.util.*;

public class Solution {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
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
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    private static FastReader s;
    public static void main(String[] args) {
        s = new FastReader();
        Solution c=new Solution();

        int T=s.nextInt();
        for (int t=1; t<=T; t++){
            c.solve(t);
        }
    }
    //System.out.println("Case #"+t+": "+ans);

    void solve(int t){
        int n = s.nextInt();
        int d = s.nextInt();

        long[] arr = new long[n];
        Map<Long, Integer> map = new HashMap<>();
        for (int i=0; i<n; i++){
            arr[i] = s.nextLong();
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        if (d == 2){
            boolean found = false;
            for (long k : map.keySet()){
                if (map.get(k) > 1){
                    found = true;
                }
            }
            if (found){
                System.out.println("Case #"+t+": "+0);
            }
            else {
                System.out.println("Case #"+t+": "+1);
            }
            return;
        }
        if (d == 3){
            boolean found = false;
            for (long k : map.keySet()){
                if (map.get(k) > 2){
                    found = true;
                }
            }
            if (found){
                System.out.println("Case #"+t+": "+0);
            }
            else {
                if (n==1){
                    System.out.println("Case #"+t+": "+2);
                }
                else {
                    for (int i=0; i<n-1; i++){
                        for (int j=i+1; j<n; j++){
                            if (arr[i]==2L*arr[j] || arr[j]==2L*arr[i]){
                                System.out.println("Case #"+t+": "+1);
                                return;
                            }
                        }
                    }
                    System.out.println("Case #"+t+": "+2);
                }
            }
        }
    }
}
