import java.io.*;
import java.util.*;

public class Solution {

    public static int findMinIndex(int[] b, int[] c) {
        int minValue = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i] <= minValue && c[i] == 0) {
                minValue = b[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        
        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(sc.nextLine());
            int[] a = new int[t];
            int[] b = new int[t];
            int[] c = new int[t];
            String result = "";

            for (int j = 0; j < t; j++) {
                String[] input = sc.nextLine().split(" ");
                a[j] = Integer.parseInt(input[0]);
                b[j] = Integer.parseInt(input[1]);
            }

            int cameronEnd = 0, jamieEnd = 0;
            boolean isImpossible = false;

            for (int j = 0; j < t; j++) {
                int index = findMinIndex(b, c);

                if (j == 0) {
                    c[index] = 1;
                    cameronEnd = b[index];
                } else {
                    if (a[index] < cameronEnd && a[index] < jamieEnd) {
                        result = "IMPOSSIBLE";
                        isImpossible = true;
                        break;
                    } else if (a[index] < cameronEnd && a[index] >= jamieEnd) {
                        c[index] = 2;
                        jamieEnd = b[index];
                    } else if (a[index] < jamieEnd && a[index] >= cameronEnd) {
                        c[index] = 1;
                        cameronEnd = b[index];
                    } else if (a[index] - cameronEnd > a[index] - jamieEnd) {
                        c[index] = 2;
                        jamieEnd = b[index];
                    } else {
                        c[index] = 1;
                        cameronEnd = b[index];
                    }
                }
            }

            if (!isImpossible) {
                for (int k = 0; k < t; k++) {
                    if (c[k] == 0) {
                        result = "IMPOSSIBLE";
                        break;
                    } else if (c[k] == 1) {
                        result += "C";
                    } else {
                        result += "J";
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }
}