import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int x = 1; x <= t; x++) {
            int n = input.nextInt();
            int[][] m = new int[n][n];
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[i].length; j++) {
                    m[i][j] = input.nextInt();
                }
            }
            int[] arr = checkLatinSquare(m);
            System.out.println("Case #" + x + ": " + arr[0] + " " + arr[1] + " " + arr[2]);
        }
    }

    public static int[] checkLatinSquare(int[][] m) {

        int k = 0, r = 0, c = 0;
        int[] arr = new int[3];

        for (int i = 0; i < m.length; i++) {
            k += m[i][i];
			if (!isRowValid(m, i)) r++;
        }
		arr[0] = k;
        arr[1] = r;

        for (int j = 0; j < m[0].length; j++) {
            if (!isColumnValid(m, j)) c++;
        }
        arr[2] = c;

        return arr;
    }

    public static boolean isColumnValid(int[][] m, int column) {

        boolean[] hasBeenUsed = new boolean[m.length];

        for (int i = 0; i < m.length; i++) {

            int index = m[i][column] - 1;

            if (hasBeenUsed[index]) {
                return false;
            } else {
                hasBeenUsed[index] = true;
            }
        }

        return true;
    }

    public static boolean isRowValid(int[][] m, int row) {

        boolean[] hasBeenUsed = new boolean[m.length];

        for (int j = 0; j < m[row].length; j++) {

            int index = m[row][j] - 1;

            if (hasBeenUsed[index]) {
                return false;
            } else {
                hasBeenUsed[index] = true;
            }
        }

        return true;
    }
}