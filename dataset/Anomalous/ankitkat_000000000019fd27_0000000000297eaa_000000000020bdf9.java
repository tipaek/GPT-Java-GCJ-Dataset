import java.io.*;
import java.util.*;

public class Solution {

    public static int findMinIndex(int[] b, int[] c) {
        int minValue = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i] <= minValue && c[i] == 0) {
                minValue = b[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(sc.nextLine());
            int[] a = new int[t];
            int[] b = new int[t];
            int[] c = new int[t];
            StringBuilder res = new StringBuilder();

            for (int j = 0; j < t; j++) {
                String[] input = sc.nextLine().split(" ");
                a[j] = Integer.parseInt(input[0]);
                b[j] = Integer.parseInt(input[1]);
            }

            int xc = 0, xj = 0;
            boolean impossible = false;

            for (int j = 0; j < t; j++) {
                int index = findMinIndex(b, c);

                if (j == 0) {
                    c[index] = 1;
                    xc = b[index];
                } else {
                    if (a[index] < xc && a[index] < xj) {
                        res.append("IMPOSSIBLE");
                        impossible = true;
                        break;
                    } else if (a[index] == xc) {
                        c[index] = 1;
                        xc = b[index];
                    } else if (a[index] == xj) {
                        c[index] = 2;
                        xj = b[index];
                    } else {
                        if (a[index] < xc) {
                            c[index] = 2;
                            xj = b[index];
                        } else {
                            c[index] = 1;
                            xc = b[index];
                        }
                    }
                }
            }

            if (!impossible) {
                for (int k = 0; k < t; k++) {
                    if (c[k] == 0) {
                        res = new StringBuilder("IMPOSSIBLE");
                        break;
                    } else if (c[k] == 1) {
                        res.append("C");
                    } else {
                        res.append("J");
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + res);
        }
    }
}