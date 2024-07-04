import static java.lang.Math.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        // Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream(new File("a.in")))));
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String m = scanner.next();
            scanner.nextLine();
            boolean ok = false;
            for (int i = 0; i < m.length(); i++) {
                char c = m.charAt(i);
                if (c == 'N') {
                    y++;
                } else if (c == 'S') {
                    y--;
                } else if (c == 'E') {
                    x++;
                } else if (c == 'W') {
                    x--;
                }
                if (abs(x) + abs(y) <= i + 1) {
                    System.out.println("Case #" + t + ": " + (i + 1));
                    ok = true;
                    break;
                }
            }
            if (!ok) {
                System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
            }
        }

    }
}
