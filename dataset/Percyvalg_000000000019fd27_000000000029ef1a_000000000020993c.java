public class Main {

    public static void main(String[] args) {

        int testCase[][] = {{1, 2, 3, 4}, {2, 1, 4, 3}, {3, 4, 1, 2}, {4, 3, 2, 1}};
        int testCase1[][] = {{2, 2, 2, 2}, {2, 3, 2, 3}, {2, 2, 2, 3}, {2, 2, 2, 2}};
        int testCase2[][] = {{2, 1, 3}, {1, 3, 2}, {1, 2, 3}};

        int testCases[][][] = {testCase, testCase1, testCase2};

        for (int i = 0; i < testCases.length; i++) {
            doVestigium(testCases[i], i+1);
        }


    }

    private static void doVestigium(int[][] testCase, int number) {
        int[] output = {0, 0, 0};
        for (int i = 0; i < testCase[0].length; i++) {
            int row[] = new int[testCase.length];
            int column[] = new int[testCase.length];

            for (int j = 0; j < testCase.length; j++) {
                row[j] = testCase[i][j];
                column[j] = testCase[j][i];
            }

            for (int j = 0; j < 1; j++) {
                output[0] += testCase[i][i];
            }

            for (int y = 0; y < row.length; y++) {
                boolean same = false;
                for (int z = y + 1; z < row.length; z++) {
                    if (row[y] == row[z]) {
                        same = true;
                    }
                }

                if (same) {
                    output[1]++;
                    break;
                }
            }

            for (int y = 0; y < column.length; y++) {
                boolean same = false;
                for (int z = y + 1; z < column.length; z++) {
                    if (column[y] == column[z]) {
                        if (column[y] == column[z]) {
                            same = true;
                        }
                    }
                }
                if (same) {
                    output[2]++;
                    break;
                }
            }
        }

        System.out.println("Case #"+number + " " + output[0] + " " + output[1] + " " + output[2] + " ");
    }
}
