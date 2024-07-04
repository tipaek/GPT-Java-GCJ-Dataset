

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numCases = sc.nextInt();
        int x, y;
        for (int k = 0; k < numCases; k++) {

            x = sc.nextInt();
            y = sc.nextInt();

            String ppath = sc.next();
            int m = -1;
            for (int i = 0; i < ppath.length(); i++) {
                switch (ppath.charAt(i)) {
                    case 'S':
                        y--;
                        break;
                    case 'N':
                        y++;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                    default:
                        break;
                }
                int dist = Math.abs(x) + Math.abs(y);
                if (dist <= i + 1) {
                    m = i + 1;
                    break;
                }
            }


            System.out.print("Case #" + (k + 1) + ": ");
            if (m != -1) {
                System.out.println(m);
            } else {
                System.out.println("IMPOSSIBLE");
            }

        }

        sc.close();
    }

}
