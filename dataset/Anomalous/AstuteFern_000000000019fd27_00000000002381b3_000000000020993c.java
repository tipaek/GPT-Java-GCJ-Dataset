import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

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
            void onTest(int testCaseNumber, int totalTestCases) {
                int N = transpose.nextInt();
                int[][] matrix = new int[N + 1][N + 1];

                for (int i = 1; i <= N; i++) {
                    matrix[i] = prependZero(transpose.nextIntArray());
                }

                int trace = 0;
                for (int i = 1; i <= N; i++) {
                    trace += matrix[i][i];
                }

                int duplicateRows = 0;
                for (int i = 1; i <= N; i++) {
                    Set<Integer> rowSet = new HashSet<>();
                    for (int j = 1; j <= N; j++) {
                        if (!rowSet.add(matrix[i][j])) {
                            duplicateRows++;
                            break;
                        }
                    }
                }

                int duplicateColumns = 0;
                for (int i = 1; i <= N; i++) {
                    Set<Integer> columnSet = new HashSet<>();
                    for (int j = 1; j <= N; j++) {
                        if (!columnSet.add(matrix[j][i])) {
                            duplicateColumns++;
                            break;
                        }
                    }
                }

                transpose.addCase(testCaseNumber, trace + " " + duplicateRows + " " + duplicateColumns);
            }
        });
        transpose.flush();
    }
}

class Transpose {
    private BufferedReader br;
    private StringBuilder outputBuffer;
    private int totalTestCases;
    private int extraTestCases;

    public static Transpose getInstance() {
        return new Transpose();
    }

    private Transpose() {
        br = new BufferedReader(new InputStreamReader(System.in));
        outputBuffer = new StringBuilder();
    }

    public String nextLine() {
        try {
            return br.readLine();
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
        int[] result = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            result[i] = Integer.parseInt(tokens[i]);
        }
        return result;
    }

    public void start(Test test) {
        int[] testCaseInfo = nextIntArray();
        totalTestCases = testCaseInfo[0];
        if (testCaseInfo.length > 1) {
            extraTestCases = testCaseInfo[1];
        }
        for (int i = 1; i <= totalTestCases; i++) {
            test.onTest(i, totalTestCases);
        }
    }

    public Transpose add(String s) {
        outputBuffer.append(s);
        return this;
    }

    public Transpose addCase(int caseNumber, String result) {
        addLine("Case #" + caseNumber + ": " + result);
        return this;
    }

    public Transpose addLine(String s) {
        return add(s + "\n");
    }

    public void flush() {
        System.out.print(outputBuffer.toString());
        outputBuffer.setLength(0);
    }

    abstract static class Test {
        abstract void onTest(int testCaseNumber, int totalTestCases);
    }
}