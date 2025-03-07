
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Solution {

    int[][] valid = null;

    public static void main(String[] args) {

        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Solution S = new Solution();
        int testCases = input.nextInt();
        String[][] solution = new String[testCases][2];
        for (int c = 0; c < testCases; c++) {
            S.valid = null;
            int n = input.nextInt();
            int k = input.nextInt();

            int[] numbers = new int[n];

            for (int i = 0; i < n; i++) {
                numbers[i] = i + 1;
            }

            int[][] validLatinMatrix = S.permute(numbers, 0, k);

            if (null != validLatinMatrix) {
                solution[c][0] = "POSSIBLE";
                solution[c][1] = toString(validLatinMatrix);
            } else {
                solution[c][0] = "IMPOSSIBLE";
                solution[c][1] = "";
            }


        }


        for (int i = 0; i < testCases; i++) {
            System.out.format("Case #%d: %s \n%s", i + 1, solution[i][0], solution[i][1]);
        }


    }

    int[][] permute(int[] a, int k, int trace) {
        if (k == a.length) {
            int[][] latinMatrix = createLatinMatrix(a);
            if (isNatural(latinMatrix, trace)) {
                valid = latinMatrix;
            }
        } else {
            for (int i = k; i < a.length; i++) {
                int temp = a[k];
                a[k] = a[i];
                a[i] = temp;

                permute(a, k + 1, trace);

                temp = a[k];
                a[k] = a[i];
                a[i] = temp;
            }
        }
        return valid;
    }

    static int[][] createLatinMatrix(int[] a) {
        int[][] latin = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j< a.length; j++) {
                latin[i][j] = a[(i +j) % a.length];
            }
        }
        return latin;
    }

    static String toString(int[][] a) {
        String s = "";
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j< a.length; j++) {
                s+= a[i][j] + "  ";
            }
            s+= "\n";
        }
        return s;
    }

    static boolean isNatural(int[][] a, int trace) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i][i];
        }
        if (sum ==trace) return true;
        return false;
    }
}




