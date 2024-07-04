
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;


// https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/000000000020993c?show=progress
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; i++) {
            int[][] a = readSquareMatrix(in);
            String[] answer = solve(a);
            System.out.println("Case #" + i + ": " + (String.join(" ", answer)));
        }
    }

    private static int[][] readSquareMatrix(Scanner in) {
        int n = in.nextInt();
        in.nextLine();
        int[][] a = new int[n][n];
        for(int i = 0; i < n; i++) {
            String line = in.nextLine();
            int[] l = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            a[i] = l;
        }
        return a;
    }

    static String[] solve(int[][] a) {
        int trace = 0, dupRows = 0, dupColumns = 0;
        int n = a.length;

        for(int i = 0; i < n; i++) {
            trace += a[i][i];

            HashSet<Integer> bag = new HashSet<>();
            for(int c = 0; c < n; c++) {
                int b = a[c][i];
                if (bag.contains(b)) {
                    dupColumns++;
                    break;
                } else {
                    bag.add(b);
                }
            }
            bag.clear();
            for(int r = 0; r < n; r++) {
                int b = a[i][r];
                if (bag.contains(b)) {
                    dupRows++;
                    break;
                } else {
                    bag.add(b);
                }
            }
        }

        return new String[] { Integer.toString(trace), Integer.toString(dupRows), Integer.toString(dupColumns) };
    }
}

