class main {
    private static int[][] set;

    public static void main(String[] args) {
        int row = 0;
        int column = 0;
        for (int i = 0; i < set.length; i++) {
            for (int n = 0; n < set[i].length; n++) {
                for (int j = n + 1; j < set[i].length; j++) {
                    if (set[i][j] == set[n][j]) {
                        row++;
                    }
                    for (int k = i + 1; k < set.length; k++) {
                        if (set[k][n] == set[i][n]) {
                            column++;
                        }
                    }
                }
            }
        }
        System.out.println(set.length);
        System.out.println(row);
        System.out.println(column);
    }
}