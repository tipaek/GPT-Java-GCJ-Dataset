
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

    class Pair<A,B>{
        A first ;
        B second;
        Pair(A a , B b){
            first = a;
            second = b;
        }
    }

    private String solve() throws IOException {
        Solution obj = new Solution();
        StringBuffer sb = new StringBuffer();
        int n = obj.intVal();
        int[][] a = new int[n][2];
//        Pair a[] = new Pair[]
        for(int i=0;i<n;i++){
            int[] xx = obj.intArr();
            a[i][0] = xx[0];
            a[i][1] = xx[1];
        }
        ArrayList<Pair<Integer,Integer>> a1 = new ArrayList<>();
        ArrayList<Pair<Integer,Integer>> a2 = new ArrayList<>();
        a1.add(new Pair<Integer, Integer>(a[0][0],a[0][1]));
        sb.append("C");
        for(int i=1;i<n;i++){
            int o = 0;
            for(int j= 0;j<a1.size();j++){
                Pair<Integer,Integer> p = a1.get(j);
                if((a[i][0]>=p.second)||a[i][1]<=p.first){

                }
                else {
                    o++;
                    break;
                }
            }
            if(o==0){
                sb.append("C");
                a1.add(new Pair<Integer, Integer>(a[i][0],a[i][1]));
                continue;
            }
            o = 0;
            for(int j= 0;j<a2.size();j++){
                Pair<Integer,Integer> p = a2.get(j);
                if((a[i][0]>=p.second)||a[i][1]<=p.first){

                }
                else {
                    o++;
                    break;
                }
            }
            if(o==0){
                sb.append("J");
                a2.add(new Pair<Integer, Integer>(a[i][0],a[i][1]));
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