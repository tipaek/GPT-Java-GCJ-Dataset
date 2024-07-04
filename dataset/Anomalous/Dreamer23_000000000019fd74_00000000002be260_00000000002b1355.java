import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Solution {

    private static void test() throws IOException {
        StringBuilder total = new StringBuilder();
        try (BufferedReader read = new BufferedReader(new FileReader("data/testIn"))) {
            String s;
            while ((s = read.readLine()) != null) {
                total.append(s).append("\n");
            }
        }
        InputStream testInput = new ByteArrayInputStream(total.toString().getBytes(StandardCharsets.UTF_8));
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
        int[] r = new int[line.length];
        for (int i = 0; i < line.length; i++) {
            r[i] = Integer.parseInt(line[i]);
        }
        return r;
    }

    private static String getResult(final Scanner in) {
        String[] settings = in.nextLine().split(" ");
        final int r = Integer.parseInt(settings[0]);
        final int c = Integer.parseInt(settings[1]);
        int[][] squares = new int[r][];
        for (int i = 0; i < r; i++) {
            squares[i] = readIntArray(in);
        }

        long sum = 0;
        boolean didEliminate = true;
        while (didEliminate) {
            didEliminate = false;
            int[][] newSquares = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (squares[i][j] == 0) continue;
                    sum += squares[i][j];
                    int neighborCount = 0;
                    int neighborTotal = 0;
                    for (int nr = i - 1; nr >= 0; nr--) {
                        if (squares[nr][j] > 0) {
                            neighborCount++;
                            neighborTotal += squares[nr][j];
                            break;
                        }
                    }
                    for (int nr = i + 1; nr < r; nr++) {
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
                    for (int nc = j + 1; nc < c; nc++) {
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

        return String.valueOf(sum);
    }
}