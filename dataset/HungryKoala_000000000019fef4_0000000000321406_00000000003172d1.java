//package codejam2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int T = in.nextInt();

        for (int t = 1; t <= T; ++t) {

            final int N = in.nextInt();
            final int D = in.nextInt();

            if (D > 3) {
                System.exit(1);
            }

            boolean twoEqual = false;
            boolean threeEqual = false;
            final Map<Long, Integer> elements = new HashMap<>();

            final long[] A = new long[N];

            for (int i = 0; i < N; ++i) {

                A[i] = in.nextLong();

                if (!elements.containsKey(A[i])) {
                    elements.put(A[i], 1);
                } else {
                    elements.put(A[i], 1 + elements.get(A[i]));
                }
                
                if (elements.get(A[i]) == 2) {
                    twoEqual = true;
                }
                if (elements.get(A[i]) == 3) {
                    threeEqual = true;
                }
            }

            if (D == 2) {
                System.out.println("Case #" + t + ": " + (twoEqual ? 0 : 1) );
            } else if (D == 3) {
                if (threeEqual) {
                    System.out.println("Case #" + t + ": " + 0);
                } else {
                    Arrays.sort(A);
                    boolean oneCut = false;

                    for (int i = 0; i < N; ++i) {
                        if (elements.get(A[i]) >= 2 && ( ( i + 1 ) < N ) && ( A[i] < A[i + 1] ) ) {
                            oneCut = true;
                        } else if (elements.containsKey(2*A[i])) {
                            oneCut = true;
                        }
                    }

                    System.out.println("Case #" + t + ": " + (oneCut ? 1 : 2) );
                }
            }
        }
    }
}
