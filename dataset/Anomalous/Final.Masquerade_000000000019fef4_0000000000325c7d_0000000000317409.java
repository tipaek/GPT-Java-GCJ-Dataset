import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        Solver solver = new Solver();
        for (int i = 1; i <= testCases; i++) {
            solver.solve(i, reader);
        }
    }

    static class Solver {

        public void solve(int caseNumber, BufferedReader reader) throws IOException {
            String[] input = reader.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            String[] path = input[2].split("");
            boolean isImpossible = true;
            int pathLength = path.length;
            int[] distances = new int[pathLength + 1];

            for (int i = 0; i <= pathLength; i++) {
                int distance;
                if (i == 0) {
                    distance = Math.abs(x) + Math.abs(y);
                } else {
                    switch (path[i - 1]) {
                        case "E":
                            x += 1;
                            break;
                        case "W":
                            x -= 1;
                            break;
                        case "N":
                            y += 1;
                            break;
                        case "S":
                            y -= 1;
                            break;
                    }
                    distance = Math.abs(x) + Math.abs(y);
                }
                distances[i] = distance;
            }

            for (int i = 0; i <= pathLength; i++) {
                if (i >= distances[i]) {
                    System.out.println("Case #" + caseNumber + ": " + i);
                    isImpossible = false;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
    }
}