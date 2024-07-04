import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Tests number
        for (int i = 0; i < t; i++) {
            int intersection = -1;
            int x = in.nextInt(); // X
            int y = in.nextInt(); // Y

            String directions = in.nextLine().trim();

            int time = 0;
            for (char c: directions.toCharArray()) {
                if (distance(x, y) <= time) {
                    intersection = time;
                    break;
                } else {
                    switch (c) {
                        case 'N':
                            y += 1;
                            break;
                        case 'S':
                            y -= 1;
                            break;
                        case 'E':
                            x += 1;
                            break;
                        case 'W':
                            x -= 1;
                            break;
                    }
                }
                time++;
            }

            if (distance(x, y) <= time) {
                intersection = time;
            }


            if (intersection >= 0) {
                System.out.println("Case #" + (i + 1) + ": " + intersection);
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }

    private static int distance(int x, int y) {
        return Math.abs(x) + Math.abs(y);
    }
}
