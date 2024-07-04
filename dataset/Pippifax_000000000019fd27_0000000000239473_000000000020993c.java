import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static BufferedReader in;
    static List<int[][]> squares = new ArrayList<>();

    public static void main(String[] args) {
        readSquares();

        int i = 1;

        for (int[][] square : squares) {
            computeSquare(square, i);
            i++;
        }
    }

    private static void computeSquare(int[][] square, int testcaseId) {
        int trace = 0;

        for (int i = 0; i < square.length; i++) {
            trace += square[i][i];
        }

        int faultyRows = 0;
        int faultyColumns = 0;

        for (int i = 0; i < square.length; i++) {
            List<Integer> horizontalNumbers = new ArrayList<>();
            List<Integer> verticalNumbers = new ArrayList<>();

            for (int j = 0; j < square.length; j++) {
                horizontalNumbers.add(square[i][j]);
                verticalNumbers.add(square[j][i]);
            }

            if (!(horizontalNumbers.stream().distinct().count() == horizontalNumbers.size())) {
                faultyRows++;
            }

            if (!(verticalNumbers.stream().distinct().count() == verticalNumbers.size())) {
                faultyColumns++;
            }
        }

        System.out.println("case #" + testcaseId + ": " + trace + " " + faultyRows + " " + faultyColumns);
    }

    public static void readSquares() {
        in = new BufferedReader(new InputStreamReader(System.in));

        try {
            String line = in.readLine();

            int numberOfTestCases = Integer.parseInt(line);

            for (int i = 0; i < numberOfTestCases; i++) {
                line = in.readLine();

                int numberOfRows = Integer.parseInt(line);

                int[][] square = new int[numberOfRows][numberOfRows];

                for (int j = 0; j < numberOfRows; j++) {
                    line = in.readLine();

                    String[] fractals = line.split(" ");

                    for (int k = 0; k < numberOfRows; k++) {
                        square[j][k] = Integer.parseInt(fractals[k]);
                    }
                }

                squares.add(square);
            }
        } catch (IOException e) {
            System.out.println("something went wrong during reading input");
        }
    }
}
