import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int caseNum = in.nextInt();

        for (int caseIndex = 1; caseIndex <= caseNum; caseIndex++) {
            int x = in.nextInt();
            int y = in.nextInt();
            String way = in.next();

            String result = "IMPOSSIBLE";
            for (int i = 0; i < way.length(); i++) {
                char curMove = way.charAt(i);
                if (curMove == 'N') {
                    y++;
                }
                if (curMove == 'S') {
                    y--;
                }
                if (curMove == 'E') {
                    x++;
                }
                if (curMove == 'W') {
                    x--;
                }
                int curTime = i + 1;

                if (Math.abs(x) + Math.abs(y) <= curTime) {
                    result = String.valueOf(curTime);
                    break;
                }
            }

            System.out.println(String.format("Case #%s: %s", caseIndex, result));
        }
    }

}