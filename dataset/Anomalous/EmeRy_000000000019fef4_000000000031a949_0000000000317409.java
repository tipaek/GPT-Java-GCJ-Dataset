import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            writer.write(String.format("Case #%d: %s\n", t, solve(scanner)));
        }
        writer.flush();
    }

    private static String solve(Scanner scanner) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        String instructions = scanner.next();

        for (int i = 0; i < instructions.length(); i++) {
            char direction = instructions.charAt(i);
            switch (direction) {
                case 'S': y--; break;
                case 'N': y++; break;
                case 'E': x++; break;
                case 'W': x--; break;
            }

            int distance = Math.abs(x) + Math.abs(y);
            if (i + 1 >= distance) {
                return Integer.toString(i + 1);
            }
        }
        return "IMPOSSIBLE";
    }
}