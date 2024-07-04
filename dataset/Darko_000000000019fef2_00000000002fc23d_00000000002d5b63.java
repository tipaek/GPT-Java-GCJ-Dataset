import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private void work() {
        int lim = 1000000000;
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String line = sc.nextLine();
        String[] spl = line.split("\\s+");
        int t = Integer.parseInt(spl[0]);
        int a = Integer.parseInt(spl[1]);
        int b = Integer.parseInt(spl[2]);
        while (t-- > 0) {
            int left = getLeft(sc, -lim, 0);
            if (left == Integer.MAX_VALUE) continue;
            int right = getRight(sc, 0, lim);
            if (right == Integer.MAX_VALUE) continue;
            int up = getUp(sc, 0, lim);
            if (up == Integer.MAX_VALUE) continue;
            int down = getDown(sc, -lim, 0);
            if (down == Integer.MAX_VALUE) continue;
            int rx0, rx1, ry0, ry1;
            if (left == 0) {
                rx0 = lim / 4 - 5;
                rx1 = lim / 4 + 5;
                if (up == 0) {
                    ry0 = -lim / 4 - 5;
                    ry1 = -lim / 4 + 5;
                } else if (down == 0) {
                    ry0 = lim / 4 - 5;
                    ry1 = lim / 4 + 5;
                } else {
                    ry0 = (up + down) / 2 - 5;
                    ry1 = (up + down) / 2 + 5;
                }
            } else if (right == 0) {
                rx0 = -lim / 4 - 5;
                rx1 = -lim / 4 + 5;
                if (up == 0) {
                    ry0 = -lim / 4 - 5;
                    ry1 = -lim / 4 + 5;
                } else if (down == 0) {
                    ry0 = lim / 4 - 5;
                    ry1 = lim / 4 + 5;
                } else {
                    ry0 = (up + down) / 2 - 5;
                    ry1 = (up + down) / 2 + 5;
                }
            } else if (up == 0) {
                ry0 = -lim / 4 - 5;
                ry1 = -lim / 4 + 5;
                rx0 = (left + right) / 2 - 5;
                rx1 = (left + right) / 2 + 5;
            } else if (down == 0) {
                ry0 = lim / 4 - 5;
                ry1 = lim / 4 + 5;
                rx0 = (left + right) / 2 - 5;
                rx1 = (left + right) / 2 + 5;
            } else {
                rx0 = (left + right) / 2 - 5;
                rx1 = (left + right) / 2 + 5;
                ry0 = (up + down) / 2 - 5;
                ry1 = (up + down) / 2 + 5;
            }

            boolean found = false;
            for (int x = rx0; x <= rx1 && !found; x++) {
                for (int y = ry0; y <= ry1 && !found; y++) {
                    System.out.printf("%d %d\n", x, y);
                    System.out.flush();
                    String response = sc.nextLine().trim();
                    switch (response) {
                        case "HIT":
                        case "MISS":
                            break;
                        case "CENTER":
                            found = true;
                            break;
                        default:
                            System.exit(0);
                    }
                }
            }

            if (!found) System.exit(0);
        }
        sc.close();
        System.out.close();
    }

    private int getLeft(Scanner sc, int lo, int hi) {
        while (lo < hi) {
            int m = (lo + hi) / 2;
            System.out.printf("%d %d\n", m, 0);
            System.out.flush();
            String response = sc.nextLine().trim();
            switch (response) {
                case "HIT":
                    hi = m;
                    break;
                case "MISS":
                    lo = m + 1;
                    break;
                case "CENTER":
                    return Integer.MAX_VALUE;
                default:
                    System.exit(0);
            }
        }
        if (lo < 0) lo--;
        return lo;
    }

    private int getDown(Scanner sc, int lo, int hi) {
        while (lo < hi) {
            int m = (lo + hi) / 2;
            System.out.printf("%d %d\n", 0, m);
            System.out.flush();
            String response = sc.nextLine().trim();
            switch (response) {
                case "HIT":
                    hi = m;
                    break;
                case "MISS":
                    lo = m + 1;
                    break;
                case "CENTER":
                    return Integer.MAX_VALUE;
                default:
                    System.exit(0);
            }
        }
        if (lo < 0) lo--;
        return lo;
    }

    private int getRight(Scanner sc, int lo, int hi) {
        while (lo < hi) {
            int m = (lo + hi) / 2;
            System.out.printf("%d %d\n", m, 0);
            System.out.flush();
            String response = sc.nextLine().trim();
            switch (response) {
                case "HIT":
                    lo = m + 1;
                    break;
                case "MISS":
                    hi = m;
                    break;
                case "CENTER":
                    return Integer.MAX_VALUE;
                default:
                    System.exit(0);
            }
        }
        return lo;
    }

    private int getUp(Scanner sc, int lo, int hi) {
        while (lo < hi) {
            int m = (lo + hi) / 2;
            System.out.printf("%d %d\n", 0, m);
            System.out.flush();
            String response = sc.nextLine().trim();
            switch (response) {
                case "HIT":
                    lo = m + 1;
                    break;
                case "MISS":
                    hi = m;
                    break;
                case "CENTER":
                    return Integer.MAX_VALUE;
                default:
                    System.exit(0);
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        new Solution().work();
    }
}
