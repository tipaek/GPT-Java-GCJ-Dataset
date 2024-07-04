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
        int y = start[1];
        if ((x > path.length || x < 0 && -x > path.length) || (y > path.length || y < 0 && -y > path.length)) {
            return "IMPOSSIBLE";
        }

        int[] current = start;
        for (int time = 0; time <= path.length; time++) {
            if (current[0] == 0 &&  current[1] == 0) {
                return String.valueOf(time);
            }

            int distance = Math.abs(current[0]) + Math.abs(current[1]);
            if (distance <= time) {
                return String.valueOf(time);
            }

            if (time >= path.length) {
                return "IMPOSSIBLE";
            }

            String move = path[time];
            switch (move) {
                case "N":
                    current[1] = current[1] + 1;
                    break;
                case "S":
                    current[1] = current[1] - 1;
                    break;
                case "E":
                    current[0] = current[0] + 1;
                    break;
                case "W":
                    current[0] = current[0] - 1;
                    break;
            }
        }

        return "IMPOSSIBLE";
    }
}