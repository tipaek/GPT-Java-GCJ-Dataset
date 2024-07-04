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
            String moves = in.nextLine().trim();

            int sol = -1;
            for (int j = 0; j < moves.length(); j++) {
                switch (moves.charAt(j)) {
                    case 'E':
                        x++;
                        break;
                    case 'N':
                        y++;
                        break;
                    case 'W':
                        x--;
                        break;
                    case 'S':
                        y--;
                        break;
                }

                if (j + 1 >= Math.abs(x) + Math.abs(y)) {
                    sol = j + 1;
                    break;
                }
            }

            if (sol != -1)
                System.out.printf("Case #%d: %d%n", i, sol);
            else
                System.out.printf("Case #%d: IMPOSSIBLE%n", i);
        }
    }
}