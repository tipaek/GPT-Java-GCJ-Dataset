import java.util.HashSet;
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

            int traceValue = calculateTrace(mat, size);
            int rowDuplicates = countRowDuplicates(mat, size);
            int colDuplicates = countColDuplicates(mat, size);

            System.out.println("Case #" + z + ": " + traceValue + " " + rowDuplicates + " " + colDuplicates);
        }
        sc.close();
    }

    private static int calculateTrace(int[][] mat, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += mat[i][i];
        }
        return sum;
    }

    private static int countRowDuplicates(int[][] mat, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            HashSet<Integer> seen = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!seen.add(mat[i][j])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    private static int countColDuplicates(int[][] mat, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            HashSet<Integer> seen = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!seen.add(mat[j][i])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}