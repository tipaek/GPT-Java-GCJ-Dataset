import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int r = sc.nextInt();
            int s = sc.nextInt();
            List<String> ret = new ArrayList<>();
            check(r, s, ret);
            System.out.println("Case #" + t + ": " + ret.size());
            for (String str : ret) {
                System.out.println(str);
            }
        }
    }

    private static void check(int r, int s, List<String> ret) {
        if (r < 2 || s < 2) {
            return;
        }
        if(r == 3 && s == 3) {
            ret.add("2 2");
            ret.add("3 3");
            ret.add("4 4");
            return;
        }
        if(r == 4 && s == 2) {
            ret.add("2 3");
            ret.add("2 5");
            return;
        }
        for (int i = 0; i < s - 1; i++) {
            int total = r * s - i - 1;
            int b = r - 1;
            int a = total - b;
            ret.add(a + " " + b);
        }
        check(r - 1, s, ret);
    }

    private static void checkBrutforce(int r, int s, List<String> ret) {
        check(r, s, ret);
        long mod = r * s - 1;
        long total = 1L;
        for (int i = 0; i < ret.size(); i++) {
            total *= mod;
            total *= mod;
        }
        for (long i = 0; i < total; i++) {
            List<String> ret2 = new ArrayList<>();
            if (checkBrutforce(r, s, ret2, i, ret.size()-1)) {
                if (ret2.size() < ret.size()) {
                    ret.clear();
                    ret.addAll(ret2);
                }
            }
        }
    }

    private static boolean checkBrutforce(int r, int s, List<String> ret, long num, int max) {
        int[] tab = new int[r * s];
        int ind = 0;
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < r; j++) {
                tab[ind++] = j;
            }
        }
        int mod = r * s - 1;
        for (int t = 0; t < max; t++) {
            int a = (int) (num % mod + 1);
            num /= mod;
            int b = (int) (num % mod + 1);
            num /= mod;
            if (a + b < tab.length) {
                przeloz(tab, a, b);
                ret.add(a + " " + b);
                boolean ok = true;
                for (int i = 1; i < tab.length; i++) {
                    if (tab[i] < tab[i - 1]) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    private static void przeloz(int[] tab, int a, int b) {
        int[] p = new int[a];
        for (int i = 0; i < a; i++) {
            p[i] = tab[i];
        }
        for (int i = 0; i < b; i++) {
            tab[i] = tab[a + i];
        }
        for (int i = 0; i < a; i++) {
            tab[b + i] = p[i];
        }
    }
}
