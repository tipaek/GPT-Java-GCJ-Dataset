import java.util.Scanner;

class Main {
    private static final int MAXN = 100;
    private static final int ROW = 0;
    private static final int COL = 1;

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicates(int[][] matrix, int size, int mode) {
        int duplicates = 0;
        int[] visited = new int[MAXN];

        for (int i = 0; i < size; i++) {
            Arrays.fill(visited, 0);

            for (int j = 0; j < size; j++) {
                int value = (mode == ROW) ? matrix[i][j] : matrix[j][i];
                if (visited[value] == 1) {
                    duplicates++;
                    break;
                }
                visited[value] = 1;
            }
        }
        return duplicates;
    }

    private static void evaluateLatinSquare(int[][] matrix, int size, int testCase) {
        int trace = calculateTrace(matrix, size);
        int rowDuplicates = countDuplicates(matrix, size, ROW);
        int columnDuplicates = countDuplicates(matrix, size, COL);

        System.out.println("Case #" + testCase + ": " + trace + " " + rowDuplicates + " " + columnDuplicates);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            evaluateLatinSquare(matrix, size, testCase);
        }
    }
}