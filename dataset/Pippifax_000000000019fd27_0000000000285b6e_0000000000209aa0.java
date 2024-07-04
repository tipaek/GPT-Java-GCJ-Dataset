import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static List<int[]> testcases = new ArrayList<>();

    public static void main(String[] args) {
        readTestCases();

        int testcaseId = 1;

        for (int[] testcase : testcases) {
            cumputeTestcase(testcase[0], testcase[1], testcaseId);
            testcaseId++;
        }
    }

    private static void cumputeTestcase(int size, int trace, int testcaseId) {
        if (trace > size * size || trace < size || trace == size + 1 || trace == size * size - 1 || (size == 3 && trace % size != 0)) {
            impossible(testcaseId);
        } else {
            possible(testcaseId);

            int seed = ((trace - (trace % size)) / size) - 1;

            int[][] grid = new int[size][size];

            for (int row = 0; row < size; row++) {
                for (int column = 0; column < size; column++) {
                    int number = (seed + column + row * (size - 1)) % size + 1;
                    grid[row][column] = number;
                }
            }

            if (size == 4 && trace % 4 != 0) {
                dealWithFour(size, trace, grid);
            }

            if (size == 5 && trace % 5 != 0) {
                dealWithFive(size, trace, grid);
            }

            validateSolution(grid, trace);
            printGrid(grid);
        }
    }

    private static void dealWithFive(int size, int trace, int[][] grid) {
        int bigSeed = ((trace - (trace % size)) / size);
        int smallSeed = trace % size;

        int replace1 = 0;
        int replace2 = 0;

        if (bigSeed <= size / 2) {
            if (smallSeed == 1) {
                replace1 = bigSeed - 1;
                replace2 = bigSeed + 2;
            } else if (smallSeed == 4) {
                replace1 = bigSeed + 2;
            } else if (smallSeed == 2) {
                replace1 = bigSeed + 1;
            } else {
                replace1 = bigSeed + 1;
                replace2 = bigSeed + 2;
            }
        } else {
            bigSeed++;
            smallSeed = size - smallSeed;

            swapNumbers(grid, bigSeed - 1, bigSeed);

            if (smallSeed == 1) {
                replace1 = bigSeed + 1;
                replace2 = bigSeed - 2;
            } else if (smallSeed == 4) {
                replace1 = bigSeed - 2;
            } else if (smallSeed == 2) {
                replace1 = bigSeed - 1;
            } else {
                replace1 = bigSeed - 1;
                replace2 = bigSeed - 2;
            }
        }

        if (smallSeed % 2 == 0) {
            grid[0] = new int[]{1, 3, 2, 5, 4};
            grid[1] = new int[]{2, 1, 5, 4, 3};
            grid[2] = new int[]{4, 2, 1, 3, 5};
            grid[3] = new int[]{3, 5, 4, 2, 1};
            grid[4] = new int[]{5, 4, 3, 1, 2};

            swapNumbers(grid, 2, replace1);
            swapNumbers(grid, 1, bigSeed);
        } else {
            swapLastRows(grid);
            swapNumbers(grid, grid[grid.length - 2][grid.length - 2], replace1);
            swapNumbers(grid, grid[grid.length - 1][grid.length - 1], replace2);
        }
    }

    private static void dealWithFour(int size, int trace, int[][] grid) {
        int bigSeed = trace / size;
        int smallSeed = trace % size;

        int replace1 = 0;
        int replace2 = 0;

        if (bigSeed < size / 2) {
            if (smallSeed == 1) {
                replace1 = bigSeed - 1;
                replace2 = bigSeed + 2;
            } else if (smallSeed == 2) {
                replace1 = bigSeed + 1;
            } else {
                replace1 = bigSeed + 1;
                replace2 = bigSeed + 2;
            }
        } else {
            bigSeed++;
            if (bigSeed == 3 && smallSeed == 3) {
                swapNumbers(grid, 2, bigSeed);
            }

            if (smallSeed == 1) {
                replace1 = bigSeed - 1;
                replace2 = bigSeed - 2;
            } else if (smallSeed == 2) {
                replace1 = bigSeed - 1;
            } else {
                replace1 = bigSeed + 1;
                replace2 = bigSeed - 2;
            }
        }

        if (smallSeed == 2) {
            grid[0] = new int[]{1, 2, 3, 4};
            grid[1] = new int[]{2, 1, 4, 3};
            grid[2] = new int[]{4, 3, 2, 1};
            grid[3] = new int[]{3, 4, 1, 2};

            swapNumbers(grid, 1, bigSeed);
            swapNumbers(grid, 2, replace1);
        } else {
            swapLastRows(grid);
            swapNumbers(grid, grid[grid.length - 2][grid.length - 2], replace1);
            swapNumbers(grid, grid[grid.length - 1][grid.length - 1], replace2);
        }
    }

    private static void validateSolution(int[][] grid, int trace) {
        int actualTrace = 0;

        for (int i = 0; i < grid.length; i++) {
            actualTrace += grid[i][i];
        }

        if (actualTrace != trace) {
            System.out.println("============ ERROR =============");
        }
    }

    private static void swapNumbers(int[][] grid, int replace1, int replace2) {
        if (replace1 != replace2) {
            for (int row = 0; row < grid.length; row++) {
                for (int column = 0; column < grid.length; column++) {
                    if (grid[row][column] == replace1) {
                        grid[row][column] = -1;
                    }
                }
            }

            for (int row = 0; row < grid.length; row++) {
                for (int column = 0; column < grid.length; column++) {
                    if (grid[row][column] == replace2) {
                        grid[row][column] = replace1;
                    }
                }
            }

            for (int row = 0; row < grid.length; row++) {
                for (int column = 0; column < grid.length; column++) {
                    if (grid[row][column] == -1) {
                        grid[row][column] = replace2;
                    }
                }
            }
        }
    }

    private static void swapLastRows(int[][] grid) {
        int[] tmp = grid[grid.length - 2];
        grid[grid.length - 2] = grid[grid.length - 1];
        grid[grid.length - 1] = tmp;
    }

    private static void printGrid(int[][] grid) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid.length; column++) {
                stringBuilder.append(grid[row][column]);
                stringBuilder.append(' ');
            }

            if (row < grid.length - 1) {
                stringBuilder.append('\n');
            }
        }

        System.out.println(stringBuilder.toString());
    }

    private static void possible(int testcaseId) {
        System.out.println("Case #" + testcaseId + ": " + "POSSIBLE");
    }

    private static void impossible(int testcaseId) {
        System.out.println("Case #" + testcaseId + ": " + "IMPOSSIBLE");
    }

    public static void readTestCases() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        try {
            String line = in.readLine();

            int numberOfTestCases = Integer.parseInt(line);

            for (int testCaseId = 1; testCaseId <= numberOfTestCases; testCaseId++) {
                line = in.readLine();

                int[] testCase = new int[2];

                String[] fractals = line.split(" ");

                testCase[0] = Integer.parseInt(fractals[0]);
                testCase[1] = Integer.parseInt(fractals[1]);

                testcases.add(testCase);
            }
        } catch (IOException e) {
            System.out.println("something went wrong during reading input");
        }
    }
}
