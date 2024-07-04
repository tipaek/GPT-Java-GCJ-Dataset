import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= testCases; i++) {
            String[] params = reader.readLine().split(" ");
            int[] start = new int[2];
            start[0] = Integer.parseInt(params[0]);
            start[1] = Integer.parseInt(params[1]);

            String[] path = params[2].split("");

            String solution = findSolution(start, path);

            System.out.println("Case #" + i + ": " + solution);
        }
    }

    private static String findSolution(int[] start, String[] path) {
        int x = start[0];
        if (x > path.length || x < 0 && -x > path.length) {
            return "IMPOSSIBLE";
        }

        int current = start[1];

        for (int time = 0; time < x; time++) {
            if (path[time].equals("N")) {
                current++;
            } else {
                current--;
            }
        }

        for (int time = x; time < path.length; time++) {
            if (current == 0) {
                return String.valueOf(time);
            }
            if (path[time].equals("N")) {
                current++;
            } else {
                current--;
            }
            if (current > 0) {
                current--;
            } else if (current < 0) {
                current++;
            }
        }

        if (current == 0) {
            return String.valueOf(path.length);
        }

        return "IMPOSSIBLE";
    }
}