import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    static final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static final int mod = (int) (1e9 + 7);
    static final PrintWriter out = new PrintWriter(System.out);

    public static void main(final String[] args) throws IOException {
        int testcases = in.nextInt();
        int i = 1;
        while (testcases > 0) {
            out.print("Case #" + i + ": ");
            extractedSolution(testcases);
            --testcases;
            i++;
        }
        out.flush();
        out.close();
        in.close();
    }

    private static void extractedSolution(int t) throws IOException {
        int n = in.nextInt();
        int[][] array = new int[n][n];
        Set<Integer> set = new HashSet<>();
        long k = 0, row = 0, c = 0;
        for (int i = 0; i < array.length; i++) {
            set = new HashSet<>();
            for (int j = 0; j < array.length; j++) {
                array[i][j] = in.nextInt();
                k += (i == j) ? array[i][j] : 0;
                if (!set.contains(array[i][j]))
                    set.add(array[i][j]);
            }
            if (set.size() != n)
                row++;
        }
        for (int i = 0; i < array.length; i++) {
            set = new HashSet<>();
            for (int j = 0; j < array.length; j++) {
                if (!set.contains(array[j][i]))
                    set.add(array[j][i]);
            }
            if (set.size() != n)
                {c++;}

        }
        out.println(k + " " + row + " " + c);

    }
}