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
            int print = 2;
            while (i < n) {
                int j = i;
                int k = 0;
                while (j < n && a[j] == a[i]) {
                    k++;
                    j++;
                }
                int doubles = 0;
                for (int dob = i; dob < n; dob++) {
                    if (a[dob] == 2*a[i]) {
                        doubles++;
                    }
                }
                if (d == 2) {
                    if (k >= 2) {
                        print = 0;
                    } else {
                        if (print > 1) {
                            print = 1;
                        }
                    }
                }
                if (d == 3) {
                    if (k >= 3) {
                        print = 0;
                    } else {
                        int needed = 0;
                        int have = k;
                        while (doubles > 0 && have < d) {
                            needed++;
                            have = have + 2;
                        }
                        if (print > needed && have >= d) {
                            print = needed;
                        }
                        if (have + n - doubles - j < d) {
                            needed = needed + (d - have);
                                if (have >= d && needed < print) {
                                print = needed;
                            }
                        }
                    }
                }
                i++;
                
            }
            System.out.println("Case #"+it+": " + print);
        }
    }
}