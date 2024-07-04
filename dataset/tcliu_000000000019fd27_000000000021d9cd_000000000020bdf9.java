import java.util.Arrays;
import java.util.Scanner;

import static java.util.Comparator.comparing;

public class Solution {

    public static String solve(Activity[] atvs, int n) {
        int e1 = 0;
        int e2 = 0;
        Arrays.sort(atvs, comparing(a -> a.s));
        boolean imp = false;
        for (int i=0; !imp && i<n; i++) {
            if (atvs[i].s >= e1) {
                e1 = atvs[i].e;
                atvs[i].p = 'C';
            } else if (atvs[i].s >= e2) {
                e2 = atvs[i].e;
                atvs[i].p = 'J';
            } else {
                imp = true;
            }
        }
        if (imp) {
            return "IMPOSSIBLE";
        } else {
            StringBuilder sb = new StringBuilder();
            Arrays.sort(atvs, comparing(a -> a.order));
            for (int i=0; i<n; i++) {
                sb.append(atvs[i].p);
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            for (int i=0; i<t; i++) {
                int n = sc.nextInt();
                Activity[] atvs = new Activity [n];
                for (int j=0; j<n; j++) {
                    atvs[j] = new Activity(sc.nextInt(), sc.nextInt(), j+1);
                }
                String sol = solve(atvs, n);
                System.out.printf("Case #%s: %s%n", i+1, sol);
            }
        }
    }

    static class Activity {

        int s;

        int e;

        int order;

        char p;

        Activity(int s, int e, int order) {
            this.s = s;
            this.e = e;
            this.order = order;
        }

    }

}
