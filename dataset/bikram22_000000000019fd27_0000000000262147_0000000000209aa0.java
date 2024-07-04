import java.util.*;
import java.util.stream.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] inputs = new int[num][2];
        for (int i = 0; i < num; i++) {
            inputs[i][0] = sc.nextInt();
            inputs[i][1] = sc.nextInt();
        }
        for (int i = 0; i < num; i++) {
            printOut(inputs[i][0], inputs[i][1], i + 1);
        }
        System.out.println();
        sc.close();
    }
    public static void printOut(int n, int k, int idx) {
        int sort = sortK(n, k);
        if (sort == -2) {
            System.out.println("Case #" + idx + ": IMPOSSIBLE");
        } else if (sort == -1) {
            System.out.println("Case #" + idx + ": POSSIBLE");
            chrono(n, k);
        } else {
            if (n % 2 == 0) {
                System.out.println("Case #" + idx + ": POSSIBLE");
                evenTable(n, k, sort);
            } else {
                System.out.println("Case #" + idx + ": POSSIBLE");
                constant(n, k, sort);
            }
        }
    }
    public static int sortK(int n, int k) {
        if (n % 2 != 0) {
            if (k == IntStream.rangeClosed(1, n).sum()) return -1;
            for (int i = 1; i <= n; i++) {
                if (k == i * n) return i;
            }
        } else {
            if (k == evenProduct(n)) {
                return 2;
            } else if (k == oddProduct(n)) {
                return 1;
            }
        }
        return -2;
    }
    public static void evenTable(int n, int k, int e) {
        boolean even = e == 2 ? true : false;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int p;
                if (even) {
                    p = r + c + 2;
                } else {
                    p = r + c + 1;
                }
                if (p <= n) {
                    if (c == n - 1) {
                        System.out.print(p);
                    } else {
                        System.out.print(p + " ");
                    }
                } else {
                    p -= n;
                    if (c == n - 1) {
                        System.out.print(p);
                    } else {
                        System.out.print(p + " ");
                    }
                }
            }
            System.out.println();
        }
    }
    public static int evenProduct(int n) {
        return 2 * IntStream.rangeClosed(1, n).filter(x -> x % 2 == 0).sum();
    }
    public static int oddProduct(int n) {
        return 2 * IntStream.rangeClosed(1, n).filter(x -> x % 2 != 0).sum();
    }
    public static void chrono(int n, int k) {
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                int t = (r + c) - 1;
                if (t > n) {
                    t -= n;
                    if (c == n) {
                        System.out.print(t);
                    } else {
                        System.out.print(t + " ");
                    }
                } else {
                    if (c == n) {
                        System.out.print(t);
                    } else {
                        System.out.print(t + " ");
                    }
                }
            }
            System.out.println();
        }
    }
    public static void constant(int n, int k, int e) {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int t = (e - r) + c;
                if (t < 1) {
                    t = n + t;
                    if (c == n - 1) {
                        System.out.print(t);
                    } else {
                        System.out.print(t + " ");
                    }
                } else {
                    if (c == n - 1) {
                        System.out.print(t);
                    } else {
                        System.out.print(t + " ");
                    }
                }   
            }
            System.out.println();
        }
    }
}
