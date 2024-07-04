import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
             PrintWriter out = new PrintWriter(System.out)) {
             
            Solver solver = new Solver();
            int testCount = Integer.parseInt(in.nextLine().trim());
            
            for (int i = 1; i <= testCount; i++) {
                solver.solve(i, in, out);
            }
        }
    }
}

class Solver {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        for (int i = 0; i < 302; ++i) {
            int a = (int) (Math.random() * 20 - 10);
            int b = (int) (Math.random() * 20 - 10);
            out.printf("%d %d%n", a, b);
            out.flush();
            
            String response = in.nextLine().trim();
            switch (response) {
                case "CENTER":
                    return;
                case "HIT":
                case "MISS":
                    break;
                default:
                    throw new IllegalArgumentException(a + " " + b);
            }
        }
        throw new IllegalArgumentException("Failed to find the center within the given attempts.");
    }
}