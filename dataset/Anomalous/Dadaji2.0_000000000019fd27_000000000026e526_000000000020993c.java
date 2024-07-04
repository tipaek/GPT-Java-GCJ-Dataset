import java.util.Scanner;

class Test {
    public int sum(int[][] matrix, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    public int rowCount(int[][] matrix, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!seen.add(matrix[i][j])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static int colCount(int[][] matrix, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!seen.add(matrix[j][i])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}

class Tester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        Test test = new Test();

        for (int t = 1; t <= testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int sum = test.sum(matrix, size);
            int rowCount = test.rowCount(matrix, size);
            int colCount = Test.colCount(matrix, size);

            System.out.println("Case #" + t + ": " + sum + " " + rowCount + " " + colCount);
        }

        scanner.close();
    }
}