import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(inputStream)));
        PrintWriter out = new PrintWriter(outputStream);
        Solver2 solver = new Solver2();
        String[] asd = in.nextLine().split(" ");
        int testCount = Integer.parseInt(asd[0]);
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    private static class Solver2 {

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            for (int i = 0; i < 302; ++i) {
                int a = (int) (-10 + (Math.random() * 20));
                int b = (int) (-10 + (Math.random() * 20));
                out.printf("%d %d\n", a, b);
                out.flush();
                String response = in.nextLine();
                if (response.equals("CENTER")) {
                    return;
                } else if (response.equals("HIT") || response.equals("MISS")) {

                } else {
                    throw new IllegalArgumentException(a + " " + b);
                }
            }
            throw new IllegalArgumentException();
        }

    }
}