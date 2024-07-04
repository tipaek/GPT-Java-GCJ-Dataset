import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

    private static void test() throws IOException {
        String s;
        StringBuilder total = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("data/testIn"))) {
            while ((s = reader.readLine()) != null) {
                total.append(s).append("\n");
            }
        }
        InputStream testInput = new ByteArrayInputStream(total.toString().getBytes("UTF-8"));
        System.setIn(testInput);
    }

    public static void main(String[] args) throws IOException {
        // test();
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = Integer.parseInt(in.nextLine());
            for (int c = 1; c <= t; ++c) {
                System.out.println("Case #" + c + ": " + getResult(in));
            }
        }
    }

    private static int[] readIntArray(Scanner in) {
        String[] line = in.nextLine().split(" ");
        int[] result = new int[line.length];
        for (int i = 0; i < line.length; i++) {
            result[i] = Integer.parseInt(line[i]);
        }
        return result;
    }

    private static String getResult(final Scanner in) {
        String[] settings = in.nextLine().split(" ");
        int rows = Integer.parseInt(settings[0]);
        int cols = Integer.parseInt(settings[1]);
        int[][] squares = new int[rows][];
        for (int i = 0; i < rows; i++) {
            squares[i] = readIntArray(in);
        }

        BigInteger sum = BigInteger.ZERO;
        boolean didEliminate = true;

        while (didEliminate) {
            didEliminate = false;
            int[][] newSquares = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (squares[i][j] == 0) continue;
                    sum = sum.add(BigInteger.valueOf(squares[i][j]));
                    int neighborCount = 0;
                    int neighborTotal = 0;

                    for (int nr = i - 1; nr >= 0; nr--) {
                        if (squares[nr][j] > 0) {
                            neighborCount++;
                            neighborTotal += squares[nr][j];
                            break;
                        }
                    }
                    for (int nr = i + 1; nr < rows; nr++) {
                        if (squares[nr][j] > 0) {
                            neighborCount++;
                            neighborTotal += squares[nr][j];
                            break;
                        }
                    }
                    for (int nc = j - 1; nc >= 0; nc--) {
                        if (squares[i][nc] > 0) {
                            neighborCount++;
                            neighborTotal += squares[i][nc];
                            break;
                        }
                    }
                    for (int nc = j + 1; nc < cols; nc++) {
                        if (squares[i][nc] > 0) {
                            neighborCount++;
                            neighborTotal += squares[i][nc];
                            break;
                        }
                    }

                    if (neighborCount > 0 && squares[i][j] * neighborCount < neighborTotal) {
                        didEliminate = true;
                    } else {
                        newSquares[i][j] = squares[i][j];
                    }
                }
            }
            squares = newSquares;
        }

        return sum.toString();
    }
}