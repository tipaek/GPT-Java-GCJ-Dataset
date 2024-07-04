
import java.util.*;
import java.io.*;
public class Solution {
    static Scanner in;

    private static int[] bit = new int[32];
    private static int[] part = new int[32];

    private static long abs(long a){
        return a>=0?a:-a;
    }

    private static boolean search(int pos, long x, long y, long xx, long yy){
        if(pos<0){
            return x==xx&&y==yy;
        }
        long bb = bit[pos] * (1<<pos);

        if(x+bb > 0 && abs(x+bb-xx) < bb && xx != x) {
            part[pos] = 1;
            if(search(pos-1, x+bb, y, xx, yy)){
                return true;
            }
            part[pos] = 0;
        }

        if(y+bb > 0 && abs(y+bb-yy) < abs(bb) && yy != y){
            part[pos] = -1;
            if(search(pos-1, x, y+bb, xx, yy)){
                return true;
            }
            part[pos] = 0;
        }
        return false;
    }

    private static boolean trySolve(int maxwei, long xx, long yy) {
        long calcSum = 0;
        long sum = xx + yy;

        for(int i=maxwei;i>=0;i--){
            if(calcSum < sum) {
                calcSum += (1<<i);
                bit[i] = 1;
            } else if(calcSum > sum){
                calcSum -= (1<<i);
                bit[i] = -1;
            } else {
                return false;
            }
        }
        return search(maxwei, 0, 0, xx, yy);
    }

    private static void printans(int maxwei, long x, long y){
        for(int i = 0; i<=maxwei; i++) {
            if(part[i] > 0) {
                if(x*bit[i] > 0) {
                    System.out.print("E");
                } else {
                    System.out.print("W");
                }
            } else if(part[i] < 0) {
                if(y*bit[i] > 0) {
                    System.out.print("N");
                } else {
                    System.out.print("S");
                }
            } else {
                System.out.print("Debug error");
                return;
            }
        }
    }

    private static void solve() {
        long x = in.nextLong();
        long y = in.nextLong();
        long xx = Long.max(x, -x);
        long yy = Long.max(y,-y);
        long sum = xx+yy;
        int maxwei = 0;
        for(int i=0;sum>>i>0;i++){
            maxwei = i;
        }
        if(trySolve(maxwei, xx, yy)){
            printans(maxwei, x, y);
            return;
        }
        maxwei++;
        if(trySolve(maxwei, xx, yy)) {
            printans(maxwei, x, y);
            return;
        }
        System.out.print("IMPOSSIBLE");
    }

    public static void main(String[] args) {
        in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            System.out.print("Case #" + i + ": " );
            solve();
            System.out.println();
        }
    }
}