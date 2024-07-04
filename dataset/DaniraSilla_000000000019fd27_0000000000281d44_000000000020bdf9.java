import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    static class Act  {
        int st;
        int end;
        int ind;
        String p;
        Act(int s, int e, int i) {
            st = s;
            end = e;
            ind = i;
        }
    }

    static String solve(Act[] res) {
        int n = res.length;
        boolean j = false;
        boolean c = false;
        int ji = 1;
        int ci = 1;
        for (int i = 0; i < n; i++){
            int tim = res[i].st;
            if (!c) {
                c = true;
                ci = i;
                res[i].p = "C";
                continue;
            }else {
                if (res[ci].end <= tim){
                    c = true;
                    ci = i;
                    res[i].p = "C";
                    continue;
                }
            }
            if (!j) {
                j = true;
                ji = i;
                res[i].p = "J";
                continue;
            }else {
                if (res[ji].end <= tim){
                    j = true;
                    ji = i;
                    res[i].p = "J";
                    continue;
                }
            }
            if (res[i].p == null) {
                return "IMPOSSIBLE";
            }
        }
        String res1 = "";
        Arrays.sort(res, new Comparator<Act>() {
            @Override
            public int compare(Act o1, Act o2) {
                return Integer.compare(o1.ind, o2.ind);
            }
        });
        for (int i = 0; i < n; i++) {
            res1 = res1 + res[i].p;
        }
        return res1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int cas = 1; cas <= t; cas++) {
            int n = sc.nextInt();

            Act[] res = new Act[n];
            for (int i = 0; i < n; i++) {
                res[i] = new Act(sc.nextInt(), sc.nextInt(), i);
            }
            Arrays.sort(res, new Comparator<Act>() {
                @Override
                public int compare(Act o1, Act o2) {
                    return Integer.compare(o1.st, o2.st);
                }
            });
            String ans = solve(res);

            System.out.println("Case #" + cas + ": " + ans);
        }
    }
}
