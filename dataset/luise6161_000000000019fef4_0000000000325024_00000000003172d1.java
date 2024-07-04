import java.util.*;
import java.io.*;


public class Solution {

    private static Scanner in;
    private static long[] a;
    private static int n,d;
    private static HashMap<Double, Long> mem = new HashMap<>();

    private static long min;

    private static long cut(double pie, int dd){
        if(mem.containsKey(pie)){
            return mem.get(pie);
        }
        if(dd==0){
            return 0;
        }
        int i;
        long totcut = 0;
        for (i = 1; i<=n; i++) {
            double cc = Math.floor(a[i]/pie);
            if(cc*pie!=a[i]) continue;
            if(dd==0)break;

            if(dd > cc) {
                if(a[i] == cc*pie) {
                    totcut += cc - 1;
                } else {
                    totcut += cc;
                }
                dd-=cc;
            } else if(dd < cc){
                mem.put(pie, totcut+dd);
                return totcut + dd;
            } else{
                if(cc*pie==a[i]) {
                    mem.put(pie, totcut+dd-1);
                    return totcut + dd - 1;
                } else {
                    mem.put(pie, totcut+dd);
                    return totcut + dd;
                }
            }
            if(totcut > min) {
                mem.put(pie, -100101L);
                return -100101;
            }
        }

        for (i = 1; i<=n; i++) {
            double cc = Math.floor(a[i]/pie);
            if(cc*pie==a[i]) continue;
            if(dd==0)break;

            if(dd > cc) {
                if(a[i] == cc*pie) {
                    totcut += cc - 1;
                } else {
                    totcut += cc;
                }
                dd-=cc;
            } else if(dd < cc){
                mem.put(pie, totcut+dd);
                return totcut + dd;
            } else{
                if(cc*pie==a[i]) {
                    mem.put(pie, totcut+dd-1);
                    return totcut + dd - 1;
                } else {
                    mem.put(pie, totcut+dd);
                    return totcut + dd;
                }
            }
            if(totcut > min) {
                mem.put(pie, -100101L);
                return -100101L;
            }
        }
        if(dd == 0) {
            mem.put(pie, totcut);
            return totcut;
        } else {
            mem.put(pie, -10010001L);
            return -10010001L;
        }
    }

    private static void solve(){
        mem.clear();
        n=in.nextInt();
        d=in.nextInt();
        a = new long[n+1];
        for(int i=1;i<=n;i++){
            a[i] = in.nextLong();
        }
        Arrays.sort(a);
        min = 1000000000;

        for(int i=1;i<=n;i++) {
            for(int j=d;j>0;j--) {
                long cutt=cut((double)a[i]/j, d);
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
