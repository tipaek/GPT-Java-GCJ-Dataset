import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();

        for (int i = 0; i < testCases; i++)
        {
            int x = in.nextInt();
            int y = in.nextInt();

            String directions = in.next();

            int time = 0;

            boolean edgeCase = false;

            if (x == 0 && y <= 1) {
                time = 1;
            }

            if (y == 0 && x <= 1) {
                time = 1;
            }

            if (y == 0 && x == 0) {
                time = 0;
                edgeCase = true;
            }

            if (!edgeCase && time == 0) {
                for (int j = 0; j < directions.length(); j++) {
                    int currTime = j + 1;
                    if (directions.charAt(j) == 'S')
                        y -= 1;
                    if (directions.charAt(j) == 'N')
                        y += 1;
                    if (directions.charAt(j) == 'E')
                        x += 1;
                    if (directions.charAt(j) == 'W')
                        x -= 1;

                    int newPos = Math.abs(x) + Math.abs(y);
                    if (newPos <= currTime) {
                        time = currTime;
                        break;
                    }
                }
            }

            int caseNo = i+1;
            if (time > 0 || edgeCase) {
                System.out.println("Case #" + caseNo + ": " + time);
            } else {
                System.out.println("Case #" + caseNo + ": IMPOSSIBLE");
            }

        }

    }


}
