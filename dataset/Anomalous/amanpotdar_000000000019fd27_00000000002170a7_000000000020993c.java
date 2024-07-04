public class SameArray {
    static int columnCount = 0;
    static int rowCount = 0;
    static int diagonalSum = 0;

    public static void main(String[] args) {
        int[][] arr = {
            {1, 2, 4, 5},
            {1, 4, 5, 2},
            {4, 2, 5, 1},
            {5, 4, 2, 1}
        };

        // Check for same elements in rows
        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr[x].length - 1; y++) {
                if (arr[x][y] == arr[x][y + 1]) {
                    rowCount++;
                    break;
                }
            }
        }

        // Check for same elements in columns
        for (int j = 0; j < arr[0].length; j++) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i][j] == arr[i + 1][j]) {
                    columnCount++;
                    break;
                }
            }
        }

        // Calculate the sum of diagonal elements
        for (int n = 0; n < arr.length; n++) {
            diagonalSum += arr[n][n];
        }

        System.out.println(diagonalSum + " " + columnCount + " " + rowCount);
    }
}