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


            char[] directions = new char[]{'N', 'S', 'W', 'E'};


            checking:
            while (true) {
                for (int first = 0; first < directions.length; first++) {
                    solution = "" + directions[first];
                    if (checkMatch(solution, x, y)) {
                        answer = solution;
                        break checking;
                    }
                }

                for (int first = 0; first < directions.length; first++) {
                    for (int second = 0; second < directions.length; second++) {
                        solution = "" + directions[first] + directions[second];
                        if (checkMatch(solution, x, y)) {
                            answer = solution;
                            break checking;
                        }
                    }
                }

                for (int first = 0; first < directions.length; first++) {
                    for (int second = 0; second < directions.length; second++) {
                        for (int third = 0; third < directions.length; third++) {
                            solution = "" + directions[first] + directions[second] + directions[third];
                            if (checkMatch(solution, x, y)) {
                                answer = solution;
                                break checking;
                            }
                        }
                    }
                }
                break;
            }
            if (answer.equals("XXX")) {
                answer = "IMPOSSIBLE";
            }
            System.out.println("Case #" + i + ": " + answer);
        }
    }

    public static boolean checkMatch(String directions, int x, int y) {
        int curX = 0;
        int curY = 0;
        for (int j = 0; j < directions.toCharArray().length; j++) {
            if (directions.toCharArray()[j] == 'E') {
                curX += Math.pow(2, j);
            } else if (directions.toCharArray()[j] == 'W') {
                curX -= Math.pow(2, j);
            } else if (directions.toCharArray()[j] == 'N') {
                curY += Math.pow(2, j);
            } else { // S
                curY -= Math.pow(2, j);
            }
        }
        if ((curX == x) && (curY == y)) return true;
        else return false;
    }
}
