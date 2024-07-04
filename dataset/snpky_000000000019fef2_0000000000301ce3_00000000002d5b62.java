import java.util.Scanner;

public class Solution {

    public void solve(Scanner in) {
        int x = in.nextInt();
        int y = in.nextInt();
//        System.out.print(" " + x + "," + y + " ");

        int a = Math.abs(x);
        int b = Math.abs(y);
        if (a == b) {
            System.out.println("IMPOSSIBLE");
            return;
        }
        int sum = a + b;
        int high = next(sum);
        int c = next(a);
        int d = next(b);

        StringBuilder sb = new StringBuilder();
        if (((sum + 1)&sum) == 0) {
            while (a > 0 || b > 0) {
                if (a % 2 == 1) {
                    if (x > 0) {
                        sb.append('E');
                    } else {
                        sb.append('W');
                    }
                    a = a / 2;
                    b = b/2;
                }
                if (b % 2 == 1) {
                    if (y > 0) {
                        sb.append('N');
                    } else {
                        sb.append('S');
                    }
                    b = b / 2;
                    a = a/2;
                }
            }
            System.out.println(sb.toString());
            return;
        }

        int cd = c - a;
        int dd = d - b;

        if ((c ^ d ^ cd ^ dd) != (high - 1)) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        while (c > 0 || d > 0 || cd > 0 || dd > 0) {
            if (c % 2 == 1) {
                if (x > 0) {
                    sb.append('E');
                } else {
                    sb.append('W');
                }
                c = c / 2;
                d = d / 2;
                cd = cd / 2;
                dd = dd / 2;
            }
            if (d % 2 == 1) {
                if (y > 0) {
                    sb.append('N');
                } else {
                    sb.append('S');
                }
                c = c / 2;
                d = d / 2;
                cd = cd / 2;
                dd = dd / 2;
            }
            if (cd % 2 == 1) {
                if (x < 0) {
                    sb.append('E');
                } else {
                    sb.append('W');
                }
                c = c / 2;
                d = d / 2;
                cd = cd / 2;
                dd = dd / 2;
            }
            if (dd % 2 == 1) {
                if (y < 0) {
                    sb.append('N');
                } else {
                    sb.append('S');
                }
                c = c / 2;
                d = d / 2;
                cd = cd / 2;
                dd = dd / 2;
            }
        }
        System.out.println(sb.toString());
    }

    public int next(int sum) {
        int high = 1;
        while (true) {
            if (sum <= high) {
                break;
            }
            high *= 2;
        }
        return high;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a = 1; a <= t; a++) {
            System.out.print("Case #" + a + ": ");
            obj.solve(in);
        }
    }
}