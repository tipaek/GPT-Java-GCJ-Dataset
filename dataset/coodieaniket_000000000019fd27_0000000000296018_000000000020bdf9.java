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
                a[i] = new Pair(sc.nextInt(), sc.nextInt());

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
                if (st >= prev_e) {
                    if (wh == 1) {
                        s.add('J');
                        j_end = a[i].e;
                    } else {
                        s.add('C');
                        c_end = a[i].e;
                    }
                } else {
                    wh = 1 - wh;
                    if (wh == 1) {
                        s.add('J');
                        j_end = a[i].e;
                    } else {
                        s.add('C');
                        c_end = a[i].e;
                    }
                }
                prev_e = a[i].e;
            }
            System.out.print("Case #" + (x++) + ": ");
            if (flag)
            {
                for (Character character : s) {
                    System.out.print(character);
                }
                System.out.println();
            }
            else
                System.out.println("IMPOSSIBLE");
           
        }
    }

}

class Pair {
    int s, e;

    Pair(int s, int e) {
        this.s = s;
        this.e = e;
    }
}