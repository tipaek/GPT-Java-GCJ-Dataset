import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": " + solve(in));
        }
    }


    private static String solve(Scanner in) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] v = new int[n*m];
        List<String> mov = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                v[i*n + j] = j+1;
            }
        }
        int count = 1;
        int last = v.length - 1;
        while (last != 0) {
            int i = 0;
            while (i < last && v[i] <= v[i+1]) {
                i++;
            }
            if (last <= i) {
                return "" + mov.size() + "\n" + String.join("\n", mov);
            }
            mov.add("" + (i+1) + " " + (last-i-1));
            int[] auxA = Arrays.copyOfRange(v, 0, i+1);
            int[] auxB = Arrays.copyOfRange(v, i+1, last);
            int k = 0;
            for (int b : auxB) v[k++] = b;
            for (int a : auxA) v[k++] = a;
            last--;
            count++;
            if (count == m) {
                count = 1;
                last--;
            }
        }
        return "";
    }
}