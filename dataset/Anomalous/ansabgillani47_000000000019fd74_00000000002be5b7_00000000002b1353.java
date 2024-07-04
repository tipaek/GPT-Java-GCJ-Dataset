public class PossibleWalkThroughMatrix {
    public static void main(String[] args) {
        System.out.println(countAllWalks(30, 30));
    }

    private static long countAllWalks(int col, int row) {
        long[][] paths = new long[col + 1][row + 1];

        for (int i = 0; i <= col; i++) {
            for (int j = 0; j <= row; j++) {
                if (i == 0 && j == 0) {
                    paths[i][j] = 1;
                } else {
                    paths[i][j] = (i > 0 ? paths[i - 1][j] : 0) + (j > 0 ? paths[i][j - 1] : 0);
                }
            }
        }

        return paths[col][row];
    }
}