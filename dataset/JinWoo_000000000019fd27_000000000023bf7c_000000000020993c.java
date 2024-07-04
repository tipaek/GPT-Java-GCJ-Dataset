import java.util.Scanner;

public class Solution {

    private static boolean isDuplicateRow(int[][] a, int index) {
        int[] map = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            map[a[index][i] - 1]++;
            if (map[a[index][i] - 1] > 1) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDuplicateCol(int[][] a, int index) {
        int[] map = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            map[a[i][index] - 1]++;
            if (map[a[i][index] - 1] > 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);

        int numOfTestCases = Integer.parseInt(in.nextLine());
        

        for (int i = 0; i < numOfTestCases; i++) {
            int arrSize = Integer.parseInt(in.nextLine());
            int trace = 0;
            int col = 0;
            int row = 0;
            int[][] arr = new int[arrSize][arrSize];
            
            for (int j = 0; j < arrSize; j++) {
                for (int k = 0; k < arrSize; k++) {
                    arr[j][k] = in.nextInt();
                    if (j == k) trace += arr[j][k];
                }
            }
            for (int j = 0; j < arrSize; j++) {
                if (isDuplicateRow(arr, j)) row++;
                if (isDuplicateCol(arr, j)) col++;
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + row + " " + col);
            in.nextLine();
        }
    }
}
