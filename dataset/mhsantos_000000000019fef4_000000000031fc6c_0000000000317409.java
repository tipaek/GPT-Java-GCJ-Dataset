import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();
            String path = in.nextLine().trim();

            int count = 0;
            for (int w = 0; w < path.length(); w++) {
                if (x == 0 && y == 0) {
                    break;
                }
                if (x > 0) {
                    x--;
                }
                else {
                    if (y > 1) {
                        y--;
                    }
                    else if (y < -1) {
                        y++;
                    }
                    else if (y == 1 && path.charAt(w) == 'N') {
                        y--;
                    }
                    else if (y == -1 && path.charAt(w) == 'S') {
                        y++;
                    }
                }
                if (path.charAt(w) == 'N') {
                    y++;
                }
                else {
                    y--;
                }
                count++;
            }
            if (x == 0 && y == 0) System.out.println("Case #" + i + ": " + count);
            else System.out.println("Case #" + i + ": IMPOSSIBLE");
        }

    }

}
