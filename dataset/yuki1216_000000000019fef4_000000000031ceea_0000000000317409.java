import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scan.nextInt();

        for (int i = 1; i <= T; i++) {

            int x = scan.nextInt();
            int y = scan.nextInt();
            int distance = Math.abs(x) + Math.abs(y);
            String[] routes = scan.next().split("");
            String ans = null;

            for (int j = 0; j < routes.length; j++) {

                switch (routes[j]) {
                case "N":
                    y++;
                    break;
                case "S":
                    y--;
                    break;
                case "E":
                    x++;
                    break;
                case "W":
                    x--;
                    break;
                default:
                }
                distance = Math.abs(x) + Math.abs(y);

                if (j + 1 >= distance) {
                    ans = String.valueOf(j + 1);
                    break;
                }
            }
            if (ans != null) {
                System.out.println("Case #" + i + ": " + ans);
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
        scan.close();
    }

}