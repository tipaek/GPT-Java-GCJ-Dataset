import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.stream.IntStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.io.*;
/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author akhl
 */
class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int tt = in.nextInt();
            for (int t = 1; t <= tt; ++t) {
                int k = 0, r = 0, c = 0;
                int n = in.nextInt();
                int[][] arr = new int[n][n];
                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j < n; ++j) {
                        arr[i][j] = in.nextInt();
                    }
                }
                for (int i = 0; i < n; ++i) {
                    k += arr[i][i];
                }
                for (int j = 0; j < n; ++j)
                    if (Arrays.stream(arr[j]).distinct().toArray().length < arr.length) r++;

                for (int j = 0; j < n; ++j) {
                    int[] temp = new int[n];
                    for (int i = 0; i < n; ++i) {
                        temp[i] = arr[i][j];
                    }
                    if (Arrays.stream(temp).distinct().toArray().length < arr.length)
                        c++;
                }
                System.out.println("Case #" + t + ": " + k + " " + r + " " + c);
            }
    }
}

