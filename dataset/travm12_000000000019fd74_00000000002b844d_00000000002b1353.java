
import java.util.*;
import java.io.*;

public class Solution {
    public static PrintWriter out;
    public static long left;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = sc.nextInt(), cc = 0;
        while (t-->0) {
            left = sc.nextLong();
            out.printf("Case #%d:%n1 1%n", ++cc);
            if (left == 1) continue;
            TreeSet<Integer> row = new TreeSet<Integer>();
            int height = 0;
            long oLeft = left - 1;
            while(height + (1l<<(height)) <= left)
                height++;
            left -= height;
            long amt = (1l<<(height - 1));
            left -= amt;
            row.add(height);
            height--;
            while (left != 0 && amt != 0){
                if (amt <= left) {
                    row.add(height);
                    left -= amt;
                }
                height--;
                amt /= 2;
            }
            boolean onLeft = true;
            int last = 1;
            row.remove(0);
            for (Integer x : row){
                if (onLeft)
                    oLeft -= L2R(last, x);
                else
                    oLeft -= R2L(last, x);
                last = x;
                onLeft = !onLeft;
            }
            if (onLeft)
                slideL(last, oLeft);
            else
                slideR(last, oLeft);

        }
        out.close();
    }
    public static long L2R(int s, int e) {
        long total = 0;
        for (int i = s + 1; i <= e; i++){
            out.println(i + " " + 1);
            total++;
        }
        for (int i = 2; i <= e; i++) {
            total += choose(e-1, i-1);
            out.println(e + " " + i);
        }
        return total;
    }
    public static long choose(int a, int b) {
        long ret = 0;
        if (b == 0) return 1;
        return (choose(a-1, b-1) * a) / b;
    }
    public static long R2L(int s, int e) {
        long total = 0;
        for (int i = s + 1; i <= e; i++){
            out.println(i + " " + i);
            total++;
        }
        for (int i = e - 1; i >= 1; i--){
            total += choose(e-1, i-1);
            out.println(e + " " + i);
        }
        return total;
    }
    public static long slideL(int s, long amt){
        for (int i = 1; i <= amt; i++)
            out.println((i+s) + " " + 1);
        return amt;
    }
    public static long slideR(int s, long amt){
        for (int i = 1; i <= amt; i++)
            out.println((i+s) + " " + (i+s));
        return amt;
    }
}