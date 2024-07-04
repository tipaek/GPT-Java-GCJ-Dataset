import java.io.*;
import java.util.*;

public class Solution extends Thread {

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer st;

    private void solve() throws IOException {
        int numberOfTests = nextInt();

        for (int testNumber = 0; testNumber < numberOfTests; testNumber++) {
            testSquare(testNumber);
        };
    }

    private void testSquare(int testNumber) throws IOException {
        int squareSize = nextInt();

        int sum = 0;

        boolean[] rowsWithDups = new boolean[squareSize];
        boolean[] columnsWithDups = new boolean[squareSize];
        boolean[][] rowDups = new boolean[squareSize][squareSize];
        boolean[][] columnDups = new boolean[squareSize][squareSize];

        for (int row = 0; row < squareSize; row++) {
            for (int column = 0; column < squareSize; column++) {
                int value = nextInt();

                setDups(rowDups, rowsWithDups, row, value);
                setDups(columnDups, columnsWithDups, column, value);

                if (column == row) {
                    sum += value;
                }
            }
        }

        System.out.println(String.format("Case #%d: %d %d %d", testNumber + 1, sum, countDups(rowsWithDups), countDups(columnsWithDups)));
    }

    private void setDups(boolean[][] dupsMatrix, boolean[] dupsLine, int index, int value) {
        if (dupsMatrix[index][value - 1]) {
            dupsLine[index] = true;
        }

        dupsMatrix[index][value - 1] = true;
    }
    
    private int countDups(boolean[] array) {
        int i = 0;

        for (int index = 0; index < array.length; index++) {
            if (array[index]) {
                i++;
            }
        }

        return i;
    }

    public static void main(String[] args) {
        new Solution().run();
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace(System.err);
            System.exit(1);
        }
    }

    private String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = in.readLine();

            if (line == null) {
                return null;
            }

            st = new StringTokenizer(line);
        }

        return st.nextToken();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }
}