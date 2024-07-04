import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter writer = new PrintWriter(System.out);
        Solver solver = new Solver();
        
        int testCount = Integer.parseInt(scanner.nextLine().split(" ")[0]);
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, scanner, writer);
        }
        writer.close();
    }

    private static class Solver {

        public void solve(int testNumber, Scanner scanner, PrintWriter writer) {
            for (int x = -10; x <= 10; x++) {
                for (int y = -10; y <= 10; y++) {
                    writer.printf("%d %d", x, y);
                    writer.flush();
                    
                    String response = scanner.nextLine();
                    if (response.equals("CENTER")) {
                        return;
                    } else if (!response.equals("HIT") && !response.equals("MISS")) {
                        throw new IllegalArgumentException("Unexpected response: " + response);
                    }
                }
            }
            throw new IllegalArgumentException("No CENTER found within the given range.");
        }
    }
}