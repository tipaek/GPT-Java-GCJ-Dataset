import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        int b = scanner.nextInt();

        for (int tt = 0; tt < t; tt++) {
            int q = 0;

            boolean[] bits = new boolean[b];
            boolean[] known = new boolean[b];

            int sameIdx = -1;
            int diffIdx = -1;

            for (int i = 0; i < b / 2 + b % 2; i++) {

                System.out.println("q = " + (q + 1));

                if (q == 0 || q % 10 != 0) {
                    System.out.println(i);
                    boolean l = scanner.nextInt() != 0;

                    System.out.println(b - i - 1);
                    boolean r = scanner.nextInt() != 0;

                    bits[i] = l;
                    bits[b - i - 1] = r;

                    known[i] = true;
                    known[b - i - 1] = true;

                    q += 2;

                    if (sameIdx == -1 && l == r) {
                        sameIdx = i;
                    }

                    if (diffIdx == -1 && l != r) {
                        diffIdx = i;
                    }
                } else {
                    if (sameIdx != -1 && diffIdx != -1) {
                        System.out.println(sameIdx);
                        boolean s1 = scanner.nextInt() != 0;

                        System.out.println(b - sameIdx - 1);
                        boolean s2 = scanner.nextInt() != 0;

                        System.out.println(diffIdx);
                        boolean d1 = scanner.nextInt() != 0;

                        System.out.println(b - diffIdx - 1);
                        boolean d2 = scanner.nextInt() != 0;

                        q += 4;
                        i--;

                        if (bits[sameIdx] == s1 && bits[b - sameIdx - 1] == s2 && bits[diffIdx] == d1 && bits[b - diffIdx - 1] == d2) {
                            continue;
                        } else if (bits[sameIdx] != s1 && bits[b - sameIdx - 1] != s2 && bits[diffIdx] != d1 && bits[b - diffIdx - 1] != d2) {
                            flip(bits);
                        } else if (bits[sameIdx] == s2 && bits[b - sameIdx - 1] == s1 && bits[diffIdx] == d2 && bits[b - diffIdx - 1] == d1) {
                            reverse(bits);
                            reverse(known);
                        } else {
                            flip(bits);
                            reverse(bits);
                            reverse(known);
                        }
                    } else if (sameIdx != -1) {
                        System.out.println(sameIdx);
                        boolean s1 = scanner.nextInt() != 0;

                        System.out.println(b - sameIdx - 1);
                        boolean s2 = scanner.nextInt() != 0;

                        q += 2;

                        if (bits[sameIdx] == s1 && bits[b - sameIdx - 1] == s2) {
                            continue;
                        } else {
                            flip(bits);
                        }
                    }
                }
            }

            //print(known);
            print(bits);
            scanner.next();
        }
    }

    private static void flip(boolean[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = !a[i];
        }
    }

    private static void reverse(boolean[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            boolean tmp = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = tmp;
        }
    }

    private static void print(boolean[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i] ? '1' : '0');
        }

        System.out.println(sb.toString());
    }
}
