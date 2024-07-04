public class SameArray {
    public static void main(String[] args) {
        int[][] arr = {
            {1, 2, 4, 5},
            {1, 4, 5, 2},
            {4, 2, 5, 1},
            {5, 4, 2, 1}
        };

        int rowCount = 0;
        int colCount = 0;
        int diagonalSum = 0;

        // Check for same elements in rows
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 3; y++) {
                if (arr[x][y] == arr[x][y + 1]) {
                    rowCount++;
                    break;
                }
            }
        }

        // Check for same elements in columns
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 3; i++) {
                if (arr[i][j] == arr[i + 1][j]) {
                    colCount++;
                    break;
                }
            }
        }

        // Sum of diagonal elements
        for (int n = 0; n < 4; n++) {
            diagonalSum += arr[n][n];
        }

        // Output the results
        System.out.println(diagonalSum + " " + colCount + " " + rowCount);
    }
}