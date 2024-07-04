import java.util.Hashtable;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = calculateTrace(matrix, size);
            int rowDuplicates = countRowDuplicates(matrix, size);
            int colDuplicates = countColDuplicates(matrix, size);

            System.out.println("Case #" + t + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
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
            Hashtable<Integer, Boolean> hashtable = new Hashtable<>();
            for (int j = 0; j < size; j++) {
                if (hashtable.containsKey(matrix[i][j])) {
                    count++;
                    break;
                } else {
                    hashtable.put(matrix[i][j], true);
                }
            }
        }
        return count;
    }

    public static int countColDuplicates(int[][] matrix, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            Hashtable<Integer, Boolean> hashtable = new Hashtable<>();
            for (int j = 0; j < size; j++) {
                if (hashtable.containsKey(matrix[j][i])) {
                    count++;
                    break;
                } else {
                    hashtable.put(matrix[j][i], true);
                }
            }
        }
        return count;
    }
}