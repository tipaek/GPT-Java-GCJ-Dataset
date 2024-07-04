import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String result = solveProblems(scanner);
        System.out.println(result);
    }

    public static String solveProblems(Scanner scanner) {
        StringBuilder result = new StringBuilder();
        int t = scanner.nextInt();
        for (int i = 1; i <= t; ++i) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String moves = scanner.next();
            result.append("Case #").append(i).append(": ").append(solveCase(x, y, moves)).append("\n");
        }
        return result.toString().trim();
    }

    public static String solveCase(int x, int y, String moves) {
        Position currentPosition = new Position(x, y);
        
        for (int i = 0; i < moves.length(); i++) {
            currentPosition = currentPosition.getNextPosition(moves.charAt(i));
            if (currentPosition.getDistance() <= i + 1) {
                return Integer.toString(i + 1);
            }
        }
        
        return "IMPOSSIBLE";
    }

    public static class Position {
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Position getNextPosition(char direction) {
            switch (direction) {
                case 'S':
                    return new Position(x, y - 1);
                case 'N':
                    return new Position(x, y + 1);
                case 'W':
                    return new Position(x - 1, y);
                case 'E':
                    return new Position(x + 1, y);
                default:
                    throw new IllegalArgumentException("Invalid direction: " + direction);
            }
        }

        public int getDistance() {
            return Math.abs(x) + Math.abs(y);
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}