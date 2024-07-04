import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();

        int n = 10^9 / 2;

        for (int t = 1; t <= T;t++) {
            int ret = attempt(0, 0, sc);
            if (ret == 0) continue;
            else if (ret == 1) {
                solve(0, 0, sc);
                continue;
            } else if (ret == 3) {
                break;
            }

            ret = attempt(-n/2, 0, sc);
            if (ret == 0) continue;
            else if (ret == 1) {
                solve(-n/2, 0, sc);
                continue;
            } else if (ret == 3) {
                break;
            }

            ret = attempt(n/2, 0, sc);
            if (ret == 0) continue;
            else if (ret == 1) {
                solve(n/2, 0, sc);
                continue;
            } else if (ret == 3) {
                break;
            }

            ret = attempt(0, -n/2, sc);
            if (ret == 0) continue;
            else if (ret == 1) {
                solve(0, -n/2, sc);
                continue;
            } else if (ret == 3) {
                break;
            }

            ret = attempt(0, n/2, sc);
            if (ret == 0) continue;
            else if (ret == 1) {
                solve(0, n/2, sc);
                continue;
            } else if (ret == 3) {
                break;
            }

            break;
        }
    }

    static int attempt(int x, int y, Scanner sc) {
        System.out.println(x + " " + y);
        String ret = sc.next();
        if ("CENTER".equals(ret)) return 0;
        if ("HIT".equals(ret)) return 1;
        if ("MISS".equals(ret)) return 2;
        return 3;
    }

    static boolean solve(int x, int y, Scanner sc) {
        int r = -10^9, l = x - 1;
        while (r <= l) {
            int m = (r + l) / 2;
            int ret = attempt(m, y, sc);
            if (ret == 0) return true;

            if (ret == 1) {
                l = m - 1;
            } else if (ret == 2) {
                r = m + 1;
            } else {
                return false;
            }
        }

        int x1 = r;

        r = x + 1;
        l = 10 ^ 9;
        while (r <= l) {
            int m = (r + l) / 2;
            int ret = attempt(m, y, sc);
            if (ret == 0) return true;

            if (ret == 1) {
                l = m + 1;
            } else if (ret == 2) {
                r = m - 1;
            } else {
                return false;
            }
        }
        int x2 = l;

        int d = -10^9;
        int u = y - 1;
        while (d <= l) {
            int m = (d + u) / 2;
            int ret = attempt(x, m, sc);
            if (ret == 0) return true;

            if (ret == 1) {
                u = m - 1;
            } else if (ret == 2) {
                d = m + 1;
            } else {
                return false;
            }
        }
        int y1 = d;


        u = 10^9;
        d = x + 1;
        while (d <= u) {
            int m = (d + u) / 2;
            int ret = attempt(x, m, sc);
            if (ret == 0) return true;

            if (ret == 1) {
                d = m + 1;
            } else if (ret == 2) {
                u = m - 1;
            } else {
                return false;
            }
        }
        int y2 = u;

        attempt((x1 + x2) / 2, (y1 + y2) / 2, sc);
        return true;
    }
}
