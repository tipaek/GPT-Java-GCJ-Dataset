import java.io.InputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        InputStream in = System.in;
        Scanner sc = new Scanner(in);

        int cases = sc.nextInt();
        for (int cs = 1; cs <= cases; cs++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            String path = sc.next();

            boolean reached = false;
            for (int i = 0; i < path.length(); i++) {
                switch (path.charAt(i)) {
                    case 'N':
                        y++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                }
                if (Math.abs(x) + Math.abs(y) <= i + 1) {
                    System.out.printf("Case #%d: %d%n", cs, i + 1);
                    reached = true;
                    break;
                }
            }
            if (!reached) {
                System.out.printf("Case #%d: IMPOSSIBLE%n", cs);
            }
        }
    }
}