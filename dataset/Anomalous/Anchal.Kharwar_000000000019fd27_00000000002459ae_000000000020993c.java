import java.util.Scanner;

class Non {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases > 0) {
            int n = scanner.nextInt();
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }

            calculate(arr, n);
            testCases--;
        }
    }

    public static void calculate(int[][] array, int n) {
        int diagonalSum = 0;
        int rowDuplicates = 0;
        int columnDuplicates = 0;

        // Calculate the sum of the diagonal elements
        for (int i = 0; i < n; i++) {
            diagonalSum += array[i][i];
        }

        // Check for duplicate elements in each row
        for (int i = 0; i < n; i++) {
            if (hasDuplicates(array[i])) {
                rowDuplicates++;
            }
        }

        // Check for duplicate elements in each column
        for (int i = 0; i < n; i++) {
            int[] column = new int[n];
            for (int j = 0; j < n; j++) {
                column[j] = array[j][i];
            }
            if (hasDuplicates(column)) {
                columnDuplicates++;
            }
        }

        System.out.println(diagonalSum + " , " + rowDuplicates + " , " + columnDuplicates);
    }

    public static boolean hasDuplicates(int[] array) {
        int[] frequency = new int[array.length];
        int visited = -1;

        for (int i = 0; i < array.length; i++) {
            int count = 1;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    count++;
                    frequency[j] = visited;
                }
            }
            if (frequency[i] != visited) {
                frequency[i] = count;
            }
        }

        for (int freq : frequency) {
            if (freq > 1) {
                return true;
            }
        }
        return false;
    }
}