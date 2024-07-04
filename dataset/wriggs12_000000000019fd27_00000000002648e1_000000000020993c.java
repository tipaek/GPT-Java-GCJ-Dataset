import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner keyboard  = new Scanner(System.in);
        int numCases = keyboard.nextInt();
        for (int z = 1; z <= numCases; z++) {
            int size = keyboard.nextInt();
            int trace = 0;
            int numRowRepeat = 0;
            int numColRepeat = 0;

            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = keyboard.nextInt();
                }
            }

            for (int j = 0; j < size; j++) {
                if (checkRow(matrix[j]))
                    numRowRepeat++;
            }

            for (int i = 0; i < size; i++) {
                int[] col = new int[size];
                for (int j = 0; j < size; j++) {
                    col[j] = matrix[j][i];
                }
                if (checkCol(col))
                    numColRepeat++;
            }
            
            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
            }

            System.out.println("Case #" + z + ": " + trace + " " + numRowRepeat + " " + numColRepeat);
        }
    }
    public static boolean checkCol(int[] nums) {
        Set tempSet = new HashSet();
        for (int j = 0; j < nums.length; j++) {
            int num = nums[j];
            if (!tempSet.add(num)) {
                return true;
            }
        }
        return false;
    }
    public static boolean checkRow(int[] input) {
        Set tempSet = new HashSet();
        for (int str : input) {
            if (!tempSet.add(str)) {
                return true;
            }
        }
        return false;
    }
}