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

        for (int[][] dancers : squares) {
            computeScore(dancers, i);
            i++;
        }
    }


    private static void computeScore(int[][] dancers, int testcaseId) {
        int eliminatedDancers = 1;

        long score = 0;

        while (eliminatedDancers > 0) {
            eliminatedDancers = 0;

            int[][] tmpDancers = cloneArray(dancers);

            eliminatedDancers += eliminateDancers(tmpDancers);

            score += calculateScore(dancers);

            dancers = cloneArray(tmpDancers);
        }

        System.out.println("case #" + testcaseId + ": " + score);
    }

    private static int[][] cloneArray(int[][] array) {
        int[][] clone = new int[array.length][array[0].length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                clone[i][j] = array[i][j];
            }
        }

        return clone;
    }

    private static void copyValues(int[][] source, int[][] dest) {
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[i].length; j++) {
                dest[i][j] = source[i][j];
            }
        }
    }

    private static int eliminateDancers(int[][] dancers) {
        int eliminatedDancers = 0;

        int[][] tmpDancers = cloneArray(dancers);

        for (int i = 0; i < dancers.length; i++) {
            for (int j = 0; j < dancers[i].length; j++) {
                if (dancers[i][j] != 0) {
                    int realValues = 0;

                    int above = 0;
                    int aboveOffset = 1;
                    while (above == 0 && i - aboveOffset >= 0) {
                        if (dancers[i - aboveOffset][j] != 0) {
                            above = dancers[i - aboveOffset][j];
                            realValues++;
                        } else {
                            aboveOffset++;
                        }
                    }

                    int below = 0;
                    int belowOffset = 1;
                    while (below == 0 && i + belowOffset < dancers.length) {
                        if (dancers[i + belowOffset][j] != 0) {
                            below = dancers[i + belowOffset][j];
                            realValues++;
                        } else {
                            belowOffset++;
                        }
                    }

                    int left = 0;
                    int leftOffset = 1;
                    while (left == 0 && j - leftOffset >= 0) {
                        if (dancers[i][j - leftOffset] != 0) {
                            left = dancers[i][j - leftOffset];
                            realValues++;
                        } else {
                            leftOffset++;
                        }
                    }

                    int right = 0;
                    int rightOffset = 1;
                    while (right == 0 && (j + rightOffset) < dancers[i].length) {
                        if (dancers[i][j + rightOffset] != 0) {
                            right = dancers[i][j + rightOffset];
                            realValues++;
                        } else {
                            rightOffset++;
                        }
                    }

                    float average = ((float) (above + below + right + left)) / realValues;

                    if (dancers[i][j] < average) {
                        tmpDancers[i][j] = 0;
                        eliminatedDancers++;
                    }
                }
            }
        }

        copyValues(tmpDancers, dancers);

        return eliminatedDancers;
    }

    private static long calculateScore(int[][] dancers) {
        long score = 0;

        for (int[] dancer : dancers) {
            for (int aDancer : dancer) {
                score += aDancer;
            }
        }

        return score;
    }

    public static void readSquares() {
        in = new BufferedReader(new InputStreamReader(System.in));

        try {
            String line = in.readLine();

            int numberOfTestCases = Integer.parseInt(line);

            for (int i = 0; i < numberOfTestCases; i++) {
                line = in.readLine();

                String[] fractals = line.split(" ");

                int rows = Integer.parseInt(fractals[0]);
                int columns = Integer.parseInt(fractals[1]);

                int[][] square = new int[rows][columns];

                for (int rowCount = 0; rowCount < rows; rowCount++) {
                    line = in.readLine();
                    fractals = line.split(" ");
                    for (int columnCount = 0; columnCount < columns; columnCount++) {
                        square[rowCount][columnCount] = Integer.parseInt(fractals[columnCount]);
                    }
                }

                squares.add(square);
            }
        } catch (IOException e) {
            System.out.println("something went wrong during reading input");
        }
    }
}
