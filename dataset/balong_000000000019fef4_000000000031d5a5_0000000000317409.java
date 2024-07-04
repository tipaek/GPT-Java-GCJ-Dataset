import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        solve(in);
    }


    public static void solve(Scanner scanner) {

        int numberOfCase = scanner.nextInt();
        scanner.nextLine();

        for (int ca = 1; ca <= numberOfCase; ca++) {

            String caseStr = scanner.nextLine();
            String[] comp = caseStr.split(" ");
            int x = Integer.parseInt(comp[0]);
            int y = Integer.parseInt(comp[1]);

            Integer min = null;
            String path = comp[2];

            if (x == 0 && y == 0) {
                System.out.println("Case #" + ca + ": " + 0);
                continue;
            }
            for (int i = 1; i <= path.length(); i++) {
                char c = path.charAt(i - 1);
                switch (c) {
                    case 'S':
                        y -= 1;
                        break;
                    case 'N':
                        y += 1;
                        break;
                    case 'E':
                        x += 1;
                        break;
                    case 'W':
                        y -= 1;
                        break;
                }
                if (Math.abs(x) + Math.abs(y) == i) {
                    min = i;
                    System.out.println("Case #" + ca + ": " + min);
                    break;
                }
            }
            if (min == null) System.out.println("Case #" + ca + ": " + "IMPOSSIBLE");
        }
    }

}
