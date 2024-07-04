import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] strings) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String path = scanner.nextLine();
            int dist = Math.abs(x)+Math.abs(y);
            int turn = 0;
            int pos = -1;
            if (turn >= dist){
                pos = turn;

            }
            else for (int j = 1; j < path.length(); j++) {

                turn ++;
                switch (path.charAt(j)) {
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                    case 'N':
                        y++;
                        break;
                    case 'S':
                        y--;
                        break;
                }

                dist = Math.abs(x)+Math.abs(y);

                if (turn >= dist){
                    pos = turn;
                    break;
                }
            }
            if (pos != -1)
                System.out.println("Case #" + (i+1) + ": " + pos);
            else
                System.out.println("Case #" + (i+1) + ": " + "IMPOSSIBLE");
        }

    }
}