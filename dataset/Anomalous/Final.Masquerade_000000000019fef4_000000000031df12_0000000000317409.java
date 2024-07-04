import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int testCount = Integer.parseInt(reader.readLine());
            Solver solver = new Solver();
            for (int i = 1; i <= testCount; i++) {
                solver.solve(i, reader);
            }
        }
    }

    static class Solver {

        private static final int[] COORDINATE_ADJUSTMENTS = {1, 1, -1, -1};

        public void solve(int caseNumber, BufferedReader reader) throws IOException {
            String[] input = reader.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            String path = input[2];

            int xySum = x + y;
            int pathLength = path.length();

            for (int i = 0; i <= pathLength; i++) {
                if (i == xySum) {
                    System.out.println("Case #" + caseNumber + ": " + i);
                    return;
                } else if (i < pathLength) {
                    char direction = path.charAt(i);
                    if (direction == 'S' || direction == 'W') {
                        xySum--;
                    } else {
                        xySum++;
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        }
    }
}

/*

5
4 4 SSSS
3 0 SNSS
2 10 NSNNSN
0 1 S
2 7 SSSSSSSS

*/