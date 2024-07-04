import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        int n, d, j;
        for (int i = 1; i <= t; ++i) {
            n = in.nextInt();
            d = in.nextInt();
            int numSlices = n;

            long[] slices = new long[n];
            for (j = 0; j < n; j++) {
                slices[j] = in.nextLong();
            }
            Arrays.sort(slices);

            long curr = slices[0];
            long best = slices[0];
            int num = 1;
            int _num = 1;

            for (int k = 1; k < n; k++) {
                if (slices[k] == curr) {
                    _num++;
                } else {
                    if (_num > num) {
                        best = slices[k - 1];
                        num = _num;
                    }
                    curr = slices[k];
                    _num = 1;
                }
            }
            
            if (num == d) {
                System.out.println("Case #" + i + ": " + 0);
            } else if (d == 2) {
                System.out.println("Case #" + i + ": " + 1);
            } else { // d==3
                if (num == 2) {
                    System.out.println("Case #" + i + ": " + 1);
                } else {
                    boolean found = false;
                    for (int k = n - 1; k >= 0; k--) {
                        if (slices[k] % 2 == 0) {
                            double newSlice = slices[k] / 2;
                            for (int l = 0; l < k; l++) {
                                if (newSlice == slices[l]) {
                                    System.out.println("Case #" + i + ": " + 1);
                                    found = true;
                                    break;
                                }
                            }
                        }
                        if (found) {
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Case #" + i + ": " + 2);
                    }
                }
            }
        }
    }
}

