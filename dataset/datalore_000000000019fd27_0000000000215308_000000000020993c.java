import java.util.*;
import java.io.*;
import java.lang.*;

/**
 * VESTIGIUM
 * Google Code Jam 2020 #1
 * 04/03/20
 */

public class Problem1 {

    private static int T;
    private static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        for (int i=0; i<T; i++) {
            N = sc.nextInt();

            int trace = 0;
            int rows = 0;
            int columns = 0;
            int arr[][] = new int[N][N];

            for (int j=0; j<N; j++) {
                Set<Integer> r = new HashSet<Integer>();
                for (int k=0; k<N; k++) {
                    arr[j][k] = sc.nextInt();
                    r.add(arr[j][k]);
                    if (j==k)
                        trace += arr[j][k];
                }
                if (r.size()!=N)
                    rows++;
            }

            for (int j=0; j<N; j++) {
                Set<Integer> c = new HashSet<Integer>();
                for (int k=0; k<N; k++)
                    c.add(arr[k][j]);
                if (c.size()!=N)
                    columns++;
            }

            System.out.println("Case #" + (i+1) + ": " + trace + " " + rows + " " + columns);
        }
    }
}
