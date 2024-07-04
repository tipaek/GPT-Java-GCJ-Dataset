import java.util.*;


class Solution {
    static long nr_read;

    private static void solve(StringBuffer sb, int B, int P, Scanner sc, int x) {
        nr_read++;
        System.out.println(P); System.out.flush();
        char ch = sc.next().toCharArray()[0];
        sb.append(ch);
        return;
    }

    private static String fluctuate(char[] base, int nrtries) {
        int n = base.length;
        StringBuffer sb = new StringBuffer();
        switch (nrtries) {
            case 0:
                for (int i = 0; i < n; i++) {
                    char ch = base[i];
                    if (ch == '0') {
                        sb.append('1');
                    } else {
                        sb.append('0');
                    }
                }
                break;
            case 1:
                for (int i = n - 1; i >= 0; i--) {
                    sb.append(base[i]);
                }
                break;
            case 2:
                for (int i = n - 1; i >= 0; i--) {
                    char ch = base[i];
                    if (ch == '0') {
                        sb.append('1');
                    } else {
                        sb.append('0');
                    }
                }
                break;
            case 3:
                for (int i = 0; i < n; i++) {
                    sb.append(base[i]);
                }
                break;
            default:
                System.exit(1);
                break;
        }
        return sb.toString();
    }

    private static void query(int B, Scanner sc, int x) {
        StringBuffer sb = new StringBuffer();
        boolean solved = false;
        // less than 10
        assert B <= 10;
        for (int i = 1; i <= B; i++) {
            solve(sb, B, i, sc, x);
        }

        char ans = 'N'; // skip Y
        int i = 0;
        //String cand = fluctuate(sb.toString().toCharArray(), i++);
        String cand = sb.toString();
        System.out.println(cand);
        System.out.flush();
        ans = sc.next().toCharArray()[0];
        if (ans == 'Y') {
            solved = true;
        } else {
            System.exit(1);
        }
        //while (ans != 'Y') {
        //    String cand = fluctuate(sb.toString().toCharArray(), i++);
        //    System.out.println(cand);
        //    System.out.flush();
        //    ans = sc.next().toCharArray()[0];
        //    if (ans == 'Y') {
        //        solved = true;
        //    } else {
        //        if (i >= 4) System.exit(1);
        //    }
        //}
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int B = sc.nextInt();

        nr_read = 0;

        for (int i = 0; i < T; i++) {
            query(B, sc, i + 1);
        }
    }
}
