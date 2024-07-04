import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int cas = 1; cas <= t; ++cas) {
            final int N = in.nextInt();
            final int D = in.nextInt();
            long[] sizes = new long[N];
            for (int i = 0; i < N; i++)
                sizes[i] = in.nextLong();
            Arrays.sort(sizes);
            int best = D;
            for (long a0 : sizes) {
                for (long k = 1; k <= D; k++) {
                    long max_slices = 0;
                    for (long a : sizes)
                        max_slices += (a * k) / a0;
                    if (max_slices < D)
                        continue;

                    int full_util = 0;
                    int d = D;
                    for (long a : sizes) {
                        if ((a * k) % a0 != 0)
                            continue;
                        long chops = (a * k) / a0;
                        if (d >= chops) {
                            full_util++;
                            d -= chops;
                        } else {
                            break;
                        }
                    }
                    //if (full_util != 0) {
                        //System.out.println(full_util+" "+max_slices+" "+a0+"/"+k);
                    //}
                    best = Math.min(best, D - full_util);
                }
            }
            System.out.println("Case #" + cas + ": " + best);
        }
    }
}
