import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int count = in.nextInt();
        for (int i = 1; i <= count; ++i) {
            String raw = in.next();
            raw += in.nextLine();
            String[] coordsArr = raw.split(" ");
            int x = Integer.parseInt(coordsArr[0]);
            int y = Integer.parseInt(coordsArr[1]);

            String solution = ""; // current trial
            String answer = "XXX"; // answer to be outputted
            int size = 3;

            char[] directions = new char[]{'N', 'S', 'W', 'E'};
            checking:
            for (int first = 0; first < directions.length; first++) {
                for (int second = 0; second < directions.length; second++) {
                    for (int third = 0; third < directions.length; third++) {
                        solution = "" + directions[first] + directions[second] + directions[third];
                        int curX = 0;
                        int curY = 0;
                        for (int j = 0; j < solution.toCharArray().length; j++) {
                            if (solution.toCharArray()[j] == 'E') {
                                curX += Math.pow(2, j);
                            } else if (solution.toCharArray()[j] == 'W') {
                                curX -= Math.pow(2, j);
                            } else if (solution.toCharArray()[j] == 'N') {
                                curY += Math.pow(2, j);
                            } else { // S
                                curY -= Math.pow(2, j);
                            }
                        }
                        if ((curX == x) && (curY == y)) {
                            answer = solution;
                            break checking;
                        }
                    }
                }
            }
            if (answer.equals("XXX")) {
                answer = "IMPOSSIBLE";
            }
            System.out.println("Case #" + i + ": " + answer);
        }
    }
}
