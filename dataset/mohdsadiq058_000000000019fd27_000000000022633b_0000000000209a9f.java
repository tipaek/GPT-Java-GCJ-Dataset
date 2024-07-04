/*      MOHD SADIQ        */

import java.sql.Array;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class Solution {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private long longVal() throws IOException{
        return Long.parseLong(br.readLine().trim());
    }
    private int intVal() throws IOException{
        return Integer.parseInt(br.readLine().trim());
    }
    private double doubleVal() throws IOException{
        return Double.parseDouble(br.readLine().trim());
    }
    private int[] intArr() throws IOException{
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
    private String[] stringArr() throws IOException{
        String[] s = br.readLine().trim().split(" ");
        return s;
    }
    private char[] charArr() throws IOException{
        return br.readLine().trim().toCharArray();
    }
    private static boolean[] sieve(int n){
        boolean[] primes = new boolean[n + 1];
        int i;
        Arrays.fill(primes,true);
        for(i = 2; i * i <= n; ++i) {
            if (primes[i]) {
                for(int p = i * i; p <= n; p += i) {
                    primes[p] = false;
                }
            }
        }
        return primes;
    }



    private String solve() throws IOException {
        Solution obj = new Solution();
        char[] c = obj.charArr();
        boolean ch = true;
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<c.length;i++){
            if(c[i]==0 && ch) {
                sb.append("0");
            }
            else if(c[i]=='1' && ch){
                sb.append("(1");
                ch = false;
            }
            else if(c[i]=='0' && ch == false){
                sb.append(")0");
                ch = true;
            }
            else {
                sb.append(c[i]);
            }
        }
        if(c[c.length-1]=='1')
            sb.append(")");
        return sb+"";
    }

    public static void main(String[] args) throws IOException {
        Solution ob = new Solution();
        int total_test_case = ob.intVal();
//         int total_test_case = 1;
        StringBuffer ans = new StringBuffer();
        String k ;
        for(int test_case =0;test_case<total_test_case;test_case++){
            k = ob.solve();
//            System.out.println(k);
            ans.append(k+"\n");
        }
        System.out.print(ans);
    }
}