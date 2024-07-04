import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(inputStream)));
        PrintWriter out = new PrintWriter(outputStream);
        Solver2 solver = new Solver2();
        int testCount = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    private static class Solver2 {

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            String ab = in.nextLine();
            for (int k = 0; k < 3; ++k) {
                for (int i = -10; i <= 10; ++i) {
                    for (int j = -10; j <= 10; ++j) {
                        out.printf("%d %d", i, j);
                        out.flush();
                        String response = in.nextLine();
                        if (response.equals("CENTER")) {
                            return;
                        } else if (response.equals("HIT") || response.equals("MISS")) {

                        } else {
                            throw new IllegalArgumentException();
                        }
                    }
                }
            }
        }

    }
}