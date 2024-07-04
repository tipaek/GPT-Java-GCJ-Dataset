import java.util.Scanner;
import java.util.Arrays;

public class Solution
{  
    public static void main(String args[])
    {
        Scanner read = new Scanner(System.in);
        int t = read.nextInt();
        for (int it = 1; it <= t; it++) {
            int n = read.nextInt();
            int d = read.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = read.nextLong();
            }
            Arrays.sort(a);
            int i = 0;
            int max = 0;
            while (i < n) {
                int j = i;
                int k = 0;
                while (j < n && a[j] == a[i]) {
                    j++;
                    k++;
                }
                i = j;
                if (k > max) {
                    max = k;
                }
            }
            int print = 0;
            if (d == 2) {
                if (max >= 2) {
                    print = 0;
                } else {
                    print = 1;
                }
            }
            if (d == 3) {
                if (max >= 3) {
                    print = 0;
                }
                if (max == 2) {
                    print = 1;
                }
                if (max == 1) {
                    print = 2;
                    int l = 0;
                    int j = 0;
                    while (j < n) {
                        while (j < n && a[l]*2 > a[j]) {
                            j++;
                        }
                        if (j < n && a[l]*2 == a[j]) {
                            print = 1;
                        }
                        l++;
                    }
                }
            }
            System.out.println("Case #"+it+": " + print);
        }
    }
}