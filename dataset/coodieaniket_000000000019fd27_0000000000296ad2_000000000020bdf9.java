import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(), x = 1;
        while (x <= t) {
            int n = sc.nextInt();
            Pair[] a = new Pair[n];
            for (int i = 0; i < a.length; i++)
                a[i] = new Pair(sc.nextInt(), sc.nextInt(), i);

            Arrays.sort(a, new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    // TODO Auto-generated method stub
                    return o1.s - o2.s;
                }
            });

            ArrayList<Character> s = new ArrayList<>();
            int prev_e = 0;
            int wh = 1, c_end = 0, j_end = 0;
            boolean flag = true;
            for (int i = 0; i < a.length; i++) {
                int st = a[i].s;
                if (st < c_end && st < j_end) {
                    flag = false;
                    break;
                }
                if (st >= c_end) {
                    a[i].wh = 'C';
                    c_end = a[i].e;
                } else {
                    a[i].wh = 'J';
                    j_end = a[i].e;
                }
            }
            Arrays.sort(a, new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    // TODO Auto-generated method stub
                    return o1.i - o2.i;
                }
            });

            System.out.print("Case #" + (x++) + ": ");
            if (flag) {
                for (Pair p : a) {
                    System.out.print(p.wh);
                }
                System.out.println();
            } else
                System.out.println("IMPOSSIBLE");

        }
    }

}

class Pair {
    int s, e, i;
    char wh;

    Pair(int s, int e, int i) {
        this.s = s;
        this.e = e;
        this.i = i;
    }
}