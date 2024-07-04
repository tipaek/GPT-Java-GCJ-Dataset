

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Solution {
    static class Task {
        int start;
        int end;
        int id;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int T = in.nextInt();
            in.nextLine();


            for (int t = 1; t <= T; ++t) {
                int x = in.nextInt();
                int y = in.nextInt();
                String M = in.next();

                int sol = -1;
                int count = 0;
                for (char dir : M.toCharArray()) {
                    count ++;

                    switch (dir) {
                        case 'N':
                            y++;
                            break;
                        case 'S':
                            y--;
                            break;
                        case 'W':
                            x--;
                            break;
                        default:
                            x++;
                            break;
                    }

                    if (count >= Math.abs(x) + Math.abs(y)) {
                        sol = count;
                        break;
                    }

                }

                if (sol < 0) {
                    System.out.println("Case #" + t + ": IMPOSSIBLE");
                } else {
                    System.out.println("Case #" + t + ": " + sol);
                }
                in.nextLine();
            }
        }
    }
}