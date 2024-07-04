import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int x = in.nextInt();
            int y = in.nextInt();

            char[] route = in.next().toCharArray();

            int answ =-1;
            for (int j = 0; j < route.length; j++) {
                if ((Math.abs(x) + Math.abs(y)) <= j) {
                    answ = j; break;
                } else {
                    if (route[j] == 'N') {
                        y++;
                    } else if (route[j] == 'S') {
                        y--;
                    } else if (route[j] == 'E') {
                        x++;
                    } else if (route[j] == 'W') {
                        x--;
                    }
                }
            }

            if (answ == -1 && (Math.abs(x) + Math.abs(y)) <= route.length) {
                answ = route.length;
            }

            System.out.println(String.format("Case #%d: %s", i + 1, answ == -1 ? "IMPOSSIBLE" : answ));
        }
    }
}
