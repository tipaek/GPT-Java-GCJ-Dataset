
/* MOHD SADIQ
    mohdsadiq058
    */
import java.util.*;
import java.io.*;
import java.math.*;

public class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private String strVal() throws IOException {
        return br.readLine().trim();
    }

    private long longVal() throws IOException {
        return Long.parseLong(br.readLine().trim());
    }

    private int intVal() throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    private double doubleVal() throws IOException {
        return Double.parseDouble(br.readLine().trim());
    }

    private int[] intArr() throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int n = s.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        return a;
    }

    private long[] longArr() throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int n = s.length;
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(s[i]);
        }
        return a;
    }

    private double[] doubleArr() throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int n = s.length;
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = Double.parseDouble(s[i]);
        }
        return a;
    }

    private String[] stringArr() throws IOException {
        String[] s = br.readLine().trim().split(" ");
        return s;
    }

    private char[] charArr() throws IOException {
        return br.readLine().trim().toCharArray();
    }

    static class Pair<K, V> {
        K first;
        V second;

        Pair(K a, V b) {
            first = a;
            second = b;
        }

        Pair() {
        }
    }

    public long powMod(long x, long y, long mod) {
        long res = 1;
        while (y > 0) {
            if (y % 2 != 0) {
                res = (res * x) % mod;
            }
            y /= 2;
            x = (x * x) % mod;
        }
        return res;
    }

    public static long mod = (long) Math.pow(10, 9) + 7;

    // static HashSet<Integer> hs = new HashSet<Integer>();

    public static String listToString(ArrayList<Character> al) {
        StringBuffer sb = new StringBuffer();
        for (char i : al) {
            sb.append(i);
        }
        return sb.toString();
    }

    public static String solve() throws IOException {
        Solution obj = new Solution();
        String[] s =obj.stringArr();
        int x = Integer.parseInt(s[0]) , y = Integer.parseInt(s[1]);
        char[] path = s[2].toCharArray();
        if(x==0 && y==0)
            return "0";
        int ans= 0;
        for(int i=0;i<path.length;i++) {
            if(x==0 && y==0)
                return ans+"";
            if(path[i]=='S'){
                if(x>0){
                    x -= 1;
                    y -= 1;
                }
                else if(y==1)
                    y-=1;
                else{
                    y -= 2;
                }
                ans++;
            }
            if(path[i]=='N'){
                ans++;
            }
            if(path[i]=='W'){
                if(y>0){
                    x -= 1;
                    y-=1;
                }
                else if(x==1)
                    x-=1;
                else x-=2;
                ans++;
            }
            if(path[i]=='E'){
                ans ++;
            }
        }
        // System.out.println(x+" "+y);
        return (x == 0 && y == 0)?ans+"":"IMPOSSIBLE";
    }

    public static void main(String[] args) throws IOException {
        Solution ob = new Solution();
        int total_test_case = ob.intVal();
        // int total_test_case = 1;
        StringBuffer ans = new StringBuffer();
        String k;
        for (int test_case = 1; test_case <= total_test_case; test_case++) {
            k = ob.solve();
            // System.out.println(k);
            ans.append("Case #" + test_case + ": " + k + "\n");
            // ans.append(k + "\n");
        }
        System.out.print(ans);
    }
}
