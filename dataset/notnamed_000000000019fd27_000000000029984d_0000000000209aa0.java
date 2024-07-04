import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Math.min;
import static java.util.Arrays.asList;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = in.nextInt();
            int k = in.nextInt();
            int m = k % n;
            int r = k / n;
            List<Integer> mapping = range(1, n + 1);

            if (k < n || k == n + 1 || k == n * n - 1) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else if (n == 2) {
                switch (k) {
                    case 2:
                        printMatrix(t, 2, asList(1, 2), asList(0, 1));
                        break;
                    case 4:
                        printMatrix(t, 2, asList(2, 1), asList(0, 1));
                        break;
                    default:
                        System.out.println("Case #" + t + ": IMPOSSIBLE");
                }
            } else if (n == 3) {
                switch (k) {
                    case 3:
                        printMatrix(t, 3, asList(1, 2, 3), asList(0, 1, 2));
                        break;
                    case 6:
                        printMatrix(t, 3, asList(2, 1, 3), asList(0, 1, 2));
                        break;
                    case 9:
                        printMatrix(t, 3, asList(3, 1, 2), asList(0, 1, 2));
                        break;
                    default:
                        System.out.println("Case #" + t + ": IMPOSSIBLE");
                }
            } else if (m == 0) {

                setMapping(mapping, 0, r);
                printMatrix(t, n, mapping, range(0, n));
            } else if (m == 2) {
                setMapping(mapping, 0, r);
                setMapping(mapping, 1, r + 1);
                printSpecialMatrix(t, n, mapping);
            } else if (m == n - 2) {
                setMapping(mapping, 0, r + 1);
                setMapping(mapping, 1, r);
                printSpecialMatrix(t, n, mapping);
            } else {
                boolean reverseValues = false;
                if (k > n * (n - 1)) {
                    k = n * (n + 1) - k;
                    r = k / n;
                    m = k % n;
                    reverseValues = true;
                }
                int c = r + 2;
                int bc;

                if (m != 1) {
                    bc = m - 2;
                } else {
                    c = r - 1;
                    bc = 2;
                }
                int ac = n - bc - 1;
                List<Integer> colSource = range(0, n);
                colSource.remove(ac);
                colSource.add(ac);

                int cv = getA(n, n - 1, n - 1, colSource);
                if (!reverseValues) {
                    setMapping(mapping, 0, r);
                    setMapping(mapping, 1, r + 1);
                    setMapping(mapping, cv, c);
                } else {
                    setMapping(mapping, 0, n + 1 - r);
                    setMapping(mapping, 1, n - r);
                    setMapping(mapping, cv, n + 1 - c);
                }

                printMatrix(t, n, mapping, colSource);
            }
        }
    }

    private static int getA(int n, int x, int y, List<Integer> colSource) {
        int realX = colSource.get(x);
        return (realX - y + n) % n;
    }

    private static void printMatrix(int t, int n, List<Integer> mapping, List<Integer> colSource) {
        System.out.println("Case #" + t + ": POSSIBLE");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                print(mapping, getA(n, j, i, colSource));
            }
            System.out.println();
        }
    }

    private static void printSpecialMatrix(int t, int n, List<Integer> mapping) {
        System.out.println("Case #" + t + ": POSSIBLE");

        for (int i = 0; i < n - 3; i++) {
            List<Integer> colSource = range(0, n);
            for (int j = 0; j < n; j++) {
                print(mapping, getA(n, j, i, colSource));
            }
            System.out.println();
        }

        print(mapping, 1);
        for (int i = 3; i < n - 1; i++) {
            print(mapping, i);
        }
        print(mapping, 0, n - 1, 2);
        System.out.println();

        for (int i = 0; i < n - 2; i++) {
            print(mapping, min(2 + (i ^ 1), n - 1));
        }
        print(mapping, 1, 0);
        System.out.println();

        print(mapping, 2);
        for (int i = 0; i < n - 3; i++) {
            print(mapping, min(3 + (i ^ 1), n - 1));
        }
        print(mapping, 0, 1);
        System.out.println();
    }

    private static void print(List<Integer> mapping, int... xs) {
        for (int x : xs) {
            System.out.print(mapping.get(x) + " ");
        }
    }

    private static void swap(List<Integer> list, int a, int b) {
        int tmp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, tmp);
    }

    private static void setMapping(List<Integer> mapping, int from, int to) {
        int target = mapping.indexOf(to);
        swap(mapping, from, target);
    }

    private static List<Integer> range(int from, int to) {
        return IntStream.range(from, to).boxed().collect(Collectors.toCollection(ArrayList::new));
    }
}
