import java.util.*;
import java.io.*;
public class A {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();
            String endOfLine = in.nextLine().trim();
            char[] moves = endOfLine.toCharArray();

            int newX = x;
            int newY = y;
            int time = 0;

            boolean possible = x == 0 && y == 0;
            while (!possible && time < moves.length) {
                if (moves[time] == 'S') {
                    newY--;
                }
                if (moves[time] == 'N') {
                    newY++;
                }
                if (moves[time] == 'W') {
                    newX--;
                }
                if (moves[time] == 'E') {
                    newX++;
                }
                time++;
                if (Math.abs(newX) + Math.abs(newY) <= time) {
                    possible = true;
                }

            }

            System.out.println("Case #" + i + ": " + (possible ? time : "IMPOSSIBLE"));
        }
    }
}