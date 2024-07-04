import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    public static int[] prependZero(int[] arr) {
        int[] result = new int[arr.length + 1];
        System.arraycopy(arr, 0, result, 1, arr.length);
        return result;
    }

    public static void main(String[] args) {
        Transpose transpose = Transpose.getInstance();
        transpose.start(new Transpose.Test() {
            @Override
            void onTest(int testIndex, int totalTests) {
                int n = transpose.nextInt();
                int[][] matrix = new int[n + 1][n + 1];
                for (int i = 1; i <= n; i++) {
                    matrix[i] = prependZero(transpose.nextIntArray());
                }

                int trace = 0;
                for (int i = 1; i <= n; i++) {
                    trace += matrix[i][i];
                }

                int repeatedRows = 0;
                for (int i = 1; i <= n; i++) {
                    ArrayList<Integer> rowElements = new ArrayList<>();
                    for (int j = 1; j <= n; j++) {
                        if (rowElements.contains(matrix[i][j])) {
                            repeatedRows++;
                            break;
                        } else {
                            rowElements.add(matrix[i][j]);
                        }
                    }
                }

                int repeatedCols = 0;
                for (int j = 1; j <= n; j++) {
                    ArrayList<Integer> colElements = new ArrayList<>();
                    for (int i = 1; i <= n; i++) {
                        if (colElements.contains(matrix[i][j])) {
                            repeatedCols++;
                            break;
                        } else {
                            colElements.add(matrix[i][j]);
                        }
                    }
                }

                transpose.addCase(testIndex, trace + " " + repeatedRows + " " + repeatedCols);
            }
        });
        transpose.flush();
    }
}

class Transpose {
    private BufferedReader bufferedReader;
    private String outputQueue = "";
    private int totalTests = -1;
    private int extraTests = -1;

    private Transpose() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static Transpose getInstance() {
        return new Transpose();
    }

    public String nextLine() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int nextInt() {
        return Integer.parseInt(nextLine());
    }

    public int[] nextIntArray() {
        String[] tokens = nextLine().split(" ");
        int[] array = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            array[i] = Integer.parseInt(tokens[i]);
        }
        return array;
    }

    public void start(Test test) {
        int[] testConfig = nextIntArray();
        totalTests = testConfig[0];
        if (testConfig.length > 1) {
            extraTests = testConfig[1];
        }
        for (int i = 1; i <= totalTests; i++) {
            test.onTest(i, totalTests);
        }
    }

    public Transpose add(String s) {
        outputQueue += s;
        return this;
    }

    public Transpose addCase(int index, String s) {
        return addLine("Case #" + index + ": " + s);
    }

    public Transpose addLine(String s) {
        return add(s + "\n");
    }

    public void flush() {
        if (!outputQueue.isEmpty()) {
            System.out.print(outputQueue);
        }
        outputQueue = "";
    }

    static abstract class Test {
        abstract void onTest(int index, int totalTests);
    }
}