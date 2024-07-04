import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int[][] res = new int[t][3];

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] parcels = new int[n][];

            in.nextLine();
            for (int j = 0; j<n; j++) {
                parcels[j] = new int[n];
                for (int k = 0; k < n; k++) {
                    parcels[j][k] = in.nextInt();
                }
            }
             res[i-1] = helper(parcels);
        }
        for (int i = 1; i <= res.length; i++) {
            System.out.println("Case #" + i + ": " + res[i - 1][0]+" "+res[i-1][1] +" "+res[i-1][2]);
        }
    }

    private static int[] helper(int[][] parcels) {
        int[] res = new int[3];
        for (int i = 0; i < parcels.length; i++) {
            if (validate(parcels[i])) {
                res[1]++;
            }
        }
        for (int i = 0; i < parcels[0].length; i++) {
            if (validateCol(parcels, i)) {
                res[2]++;
            }
        }

        res[0] = validateDiagonal(parcels);
        return res;
    }

    private static int validateDiagonal(int[][] parcels) {
        int sum = 0;
        for (int i=0; i< parcels.length; i++) {
            sum += parcels[i][i];
        }
        return sum;
    }

    static boolean validateCol(int[][] parcels, int col) {
        HashSet<Integer> h = new HashSet<>();
        for (int i = 0; i<parcels.length; i++) {
            if (h.contains(parcels[i][col])) {
                return true;
            }
            h.add(parcels[i][col]);
        }
        return h.size() != parcels[col].length;
    }

    static boolean validate(int[] array) {
        HashSet<Integer> h = new HashSet<>();
        for (int i: array) {
            if (h.contains(i)) {
                return true;
            }
            h.add(i);
        }
        return h.size() != array.length;
    }
}
