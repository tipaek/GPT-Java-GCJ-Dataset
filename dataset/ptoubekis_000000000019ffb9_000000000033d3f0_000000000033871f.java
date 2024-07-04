import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int tt = 1; tt <= cases; tt++) {
            int c = in.nextInt();
            int d = in.nextInt();
            int[] a = new int[c];
            for (int i = 1; i < c; i++) {
                a[i] = in.nextInt();
            }
            Pair[] p = new Pair[d];
            for (int i = 0; i < d; i++) {
                p[i] = new Pair(in.nextInt(), in.nextInt());
            }
            System.out.print("Case #" + tt + ": ");
            foo(c, d, a, p);
        }
    }

    private static void foo(int c, int d, int[] a, Pair[] pairs) {
        // neighbours
        List<List<Integer>> nei = new ArrayList<>(c);
        for (int i = 0; i < c; i++) {
            nei.add(new ArrayList<>());
        }
        for (Pair p : pairs) {
            p.a--;
            p.b--;
            nei.get(p.a).add(p.b);
            nei.get(p.b).add(p.a);
        }
        for (int i = 0; i < c; i++) {
            a[i] = -a[i];
        }
        int[] lat = new int[d];
        int[] time = new int[c];
        Arrays.fill(time, -1);
        time[0] = 0;
        int now = 1;
        while (now < c + 1) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < c; i++) {
                if (a[i] == now) {
                    list.add(i);
                }
            }
            for (int i : list) {
                for (int ni : nei.get(i)) {
                    if (time[ni] != -1) {
                        lat[findD(i, ni, pairs)] = now - time[ni];
                        time[i] = now;
                    }
                }
            }
            now++;
        }
        
        for (int i = 0; i < d; i++) {
            if (lat[i] == 0) {
                lat[i] = 10000;
            }
            System.out.print(lat[i] + " ");
        }
        System.out.println();
    }
    
    private static int findD(int a, int b, Pair[] pa) {
        for (int i = 0; i < pa.length; i++) {
            Pair p = pa[i];
            if (p.a == a && p.b == b || p.a == b && p.b == a) {
                return i;
            }
        }
        return -1;
    }

    private static class Pair {

        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

}
