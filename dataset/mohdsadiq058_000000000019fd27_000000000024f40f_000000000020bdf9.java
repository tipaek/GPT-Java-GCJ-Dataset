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
        StringBuffer sb = new StringBuffer();
        int n = obj.intVal();
        int[][] a = new int[n][2];
        for(int i=0;i<n;i++){
            int[] xx = obj.intArr();
            a[i][0] = xx[0];
            a[i][1] = xx[1];
        }
        int[][] c = new int[n][2];
        int[][] j = new int[n][2];
        j[0][0] = a[0][0];j[0][1] = a[0][1];
        int cc = 0;
        int cj = 1;
        sb.append("J");
        for(int i=1;i<n;i++){
//            System.out.println(sb);
//            boolean ch = true;
            int o = 0;
            for(int k=0;k<cc;k++){
                if(a[i][0] == c[k][0] && a[i][1] == c[k][1]){
                    o++;
                    break;
                }
                if((a[i][0]>c[k][0] && a[i][0]<c[k][1]) || (a[i][1]>c[k][0] && a[i][1]<c[k][1]) ){
                    o++;
                    break;
                }
            }
            if(o==0){
                c[cc][0] = a[i][0];
                c[cc][1] = a[i][1];
                cc++;
                sb.append("C");
                continue;
            }
//            if(i==3){
//                for(int k=0;k<cj;k++)
//                    System.out.println(j[k][0]+" "+j[k][1]);
//            }
            o = 0;
            for(int k=0;k<cj;k++){
                if(a[i][0] == j[k][0] && a[i][1] == j[k][1]){
                    o++;
                    break;
                }
                if((a[i][0]>j[k][0] && a[i][0]<j[k][1]) || (a[i][1]>j[k][0] && a[i][1]<j[k][1]) ){
                    o++;
//                    break;
                }
//                if(i==3)
//                    System.out.println((a[i][0]>j[k][0] && a[i][0]<j[k][1]) +" "+  (a[i][1]>j[k][0] && a[i][1]<j[k][1]));
//                System.out.println((a[i][0]+" "+j[k][0] +" "+ a[i][0]+" "+j[k][1]) +" "+ (a[i][1]+" "+j[k][0] +" "+ a[i][1]+" "+j[k][1]));
                if(o==1)
                    break;
            }
            if(o==0){
                j[cj][0] = a[i][0];
                j[cj][1] = a[i][1];
                cj++;
                sb.append("J");
                continue;
            }
            return "IMPOSSIBLE";
        }
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
            ans.append("Case #"+(test_case+1)+": "+k+"\n");
        }
        System.out.print(ans);
    }
}