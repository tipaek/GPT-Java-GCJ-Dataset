import java.util.*;
import java.io.*;


public class Solution {

    private static Scanner in;
    private static long[] a;
    private static int n,d;

    private static long cut(double pie, int dd, int i){
        if(dd==0){
            return 0;
        }
        if(dd > 0 && i>n){
            return -1000000000;
        }
        double cc = Math.floor(a[i]/pie);
        if(dd > cc) {
            if(a[i] == cc*pie) {
                return (long) (cc - 1 + cut(pie, (int) (dd-cc), i+1));
            } else {
                return (long) (cc + cut(pie, (int) (dd-cc), i+1));
            }

        } else if(dd < cc){
            return dd;
        } else{
            if(cc*pie==a[i]) {
                return dd - 1;
            } else {
                return dd;
            }
        }
    }

    private static long cut(double pie, int dd){
        if(dd==0){
            return 0;
        }
        int i;
        long totcut = 0;
        for (i = 1; i<=n; i++) {
            double cc = Math.floor(a[i]/pie);
            if(cc*pie!=a[i]) continue;

            if(dd > cc) {
                if(a[i] == cc*pie) {
                    totcut += cc - 1;
                } else {
                    totcut += cc;
                }
                dd-=cc;
            } else if(dd < cc){
                return totcut + dd;
            } else{
                if(cc*pie==a[i]) {
                    return totcut + dd - 1;
                } else {
                    return totcut + dd;
                }
            }
        }

        for (i = 1; i<=n; i++) {
            double cc = Math.floor(a[i]/pie);
            if(cc*pie==a[i]) continue;

            if(dd > cc) {
                if(a[i] == cc*pie) {
                    totcut += cc - 1;
                } else {
                    totcut += cc;
                }
                dd-=cc;
            } else if(dd < cc){
                return totcut + dd;
            } else{
                if(cc*pie==a[i]) {
                    return totcut + dd - 1;
                } else {
                    return totcut + dd;
                }
            }
        }
        return totcut;
    }

    private static void solve(){
        n=in.nextInt();
        d=in.nextInt();
        a = new long[n+1];
        for(int i=1;i<=n;i++){
            a[i] = in.nextLong();
        }
        Arrays.sort(a);

        long min = 1000000000;
        for(int i=1;i<=n;i++) {
            for(int j=d;j>0;j--) {
                long cutt=cut((double)a[i]/j, d, 1);
                if(cutt>=0) {
                    min = Long.min(cutt, min);
                } else {
                    break;
                }
            }
        }

        System.out.println(min);
    }

    public static void main(String[] args) {
        in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            System.out.print("Case #" + i + ": ");
            solve();
        }
    }
}
