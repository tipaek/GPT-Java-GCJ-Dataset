import java.util.HashMap;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int z = 1; z <= T; z++) {
            int size = sc.nextInt();
            int[][] mat = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }

            int k = calculateTrace(mat, size);
            int r = countRowDuplicates(mat, size);
            int c = countColumnDuplicates(mat, size);

            System.out.println("Case #" + z + ": " + k + " " + r + " " + c);
        }
    }

    public static int calculateTrace(int[][] matrix, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    public static int countRowDuplicates(int[][] matrix, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            HashMap<Integer, Integer> rowMap = new HashMap<>();
            for (int j = 0; j < size; j++) {
                if (rowMap.containsKey(matrix[i][j])) {
                    count++;
                    break;
                } else {
                    rowMap.put(matrix[i][j], 1);
                }
            }
        }
        return count;
    }

    public static int countColumnDuplicates(int[][] matrix, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            HashMap<Integer, Integer> colMap = new HashMap<>();
            for (int j = 0; j < size; j++) {
                if (colMap.containsKey(matrix[j][i])) {
                    count++;
                    break;
                } else {
                    colMap.put(matrix[j][i], 1);
                }
            }
        }
        return count;
    }
}