import java.io.*;

public class Solution {

    static public void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine().replaceAll("\\s+$", ""));

        for (int i = 0; i < testCases; i++) {
            String[] line = readInput(bufferedReader);
            String[][] solution = solve(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
            if (solution[0][0] == null) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                continue;
            }
            System.out.println("Case #" + (i + 1) + ": POSSIBLE");
            for (String[] row : solution) {
                System.out.println(String.join(" ", row));
            }
        }
    }

    static private String[] readInput(BufferedReader bufferedReader) throws IOException {
        return bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
    }

    private static String[][] solve(int matrixSize, int diagonal) {
        int sum = sumDiagonal(matrixSize);
        if (diagonal == sum) {
            return generateMatrixForIncrementalDiagonal(matrixSize);
        }

        if (diagonal % matrixSize == 0) {
            return generateMatrixForConstantDiagonal(matrixSize, diagonal / matrixSize);
        }

        return new String[1][1];
    }

    private static String[][] generateMatrixForIncrementalDiagonal(int matrixSize) {
        switch (matrixSize) {
            case 3 : return new String[][]{
                    {"1", "3", "2"},
                    {"3", "2", "1"},
                    {"2", "1", "3"}
            };
            case 4 : return new String[][]{
                    {"1", "3", "4", "2"},
                    {"4", "2", "1", "3"},
                    {"2", "4", "3", "1"},
                    {"3", "1", "2", "4"}
            };
            case 5 : return new String[][]{
                    {"1", "3", "4", "5", "2"},
                    {"5", "2", "1", "3", "4"},
                    {"4", "5", "3", "2", "1"},
                    {"2", "1", "5", "4", "3"},
                    {"3", "4", "2", "1", "5"}
            };
        }
        return new String[1][1];
    }

    private static String[][] generateMatrixForConstantDiagonal(int size, int diagonal) {
        switch (size) {
            case 2 :
                switch (diagonal) {
                    case 2: return new String[][]{
                            {"1", "2"},
                            {"2", "1"}
                    };
                    case 4: return new String[][]{
                            {"2", "1"},
                            {"1", "2"}
                    };
                }
            case 3 :
                switch(diagonal){
                    case 3: return new String[][]{
                            {"1", "2", "3"},
                            {"3", "1", "2"},
                            {"2", "3", "1"}
                    };
                    case 6: return new String[][]{
                            {"2", "3", "1"},
                            {"1", "2", "3"},
                            {"3", "1", "2"}
                    };
                    case 9: return new String[][]{
                            {"3", "2", "1"},
                            {"1", "3", "2"},
                            {"2", "1", "3"}
                    };
                }

            case 4 :
                switch(diagonal){
                    case 4: return new String[][]{
                            {"1", "2", "3", "4"},
                            {"4", "1", "2", "3"},
                            {"3", "4", "1", "2"},
                            {"2", "3", "4", "1"}
                    };
                    case 8: return new String[][]{
                            {"2", "1", "3", "4"},
                            {"4", "2", "1", "3"},
                            {"3", "4", "2", "1"},
                            {"1", "3", "4", "2"}
                    };
                    case 12: return new String[][]{
                            {"3", "1", "2", "4"},
                            {"4", "3", "1", "2"},
                            {"2", "4", "3", "1"},
                            {"1", "2", "4", "3"}
                    };
                    case 16: return new String[][]{
                            {"4", "1", "2", "3"},
                            {"3", "4", "1", "2"},
                            {"2", "3", "4", "1"},
                            {"1", "2", "3", "4"}
                    };
                }
            case 5 : 
                switch(diagonal) {
                    case 5: return new String[][]{
                            {"1", "2", "3", "4", "5"},
                            {"5", "1", "2", "3", "4"},
                            {"4", "5", "1", "2", "3"},
                            {"3", "4", "5", "1", "2"},
                            {"2", "3", "4", "5", "1"}
                    };
                    case 10: return new String[][]{
                            {"2", "1", "3", "4", "5"},
                            {"5", "2", "1", "3", "4"},
                            {"4", "5", "2", "1", "3"},
                            {"3", "4", "5", "2", "1"},
                            {"1", "3", "4", "5", "2"}
                    };
                    case 15: return new String[][]{
                            {"3", "2", "1", "4", "5"},
                            {"5", "3", "2", "1", "4"},
                            {"4", "5", "3", "2", "1"},
                            {"1", "4", "5", "3", "2"},
                            {"2", "1", "4", "5", "3"}
                    };
                    case 20: return new String[][]{
                            {"4", "2", "3", "1", "5"},
                            {"5", "4", "2", "3", "1"},
                            {"1", "5", "4", "2", "3"},
                            {"3", "1", "5", "4", "2"},
                            {"2", "3", "1", "5", "4"}
                    };
                    case 25: return new String[][]{
                            {"5", "2", "3", "4", "1"},
                            {"1", "5", "2", "3", "4"},
                            {"4", "1", "5", "2", "3"},
                            {"3", "4", "1", "5", "2"},
                            {"2", "3", "4", "1", "5"}
                    };
                }
        }
        return new String[1][1];
    }

    private static int sumDiagonal(int matrixSize) {
        int sum = 0;
        for (int i = 1; i <= matrixSize; i++) {
            sum += i;
        }
        return sum;
    }
}