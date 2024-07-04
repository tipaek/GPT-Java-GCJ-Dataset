import java.util.Scanner;
import java.io.*;


//doesnt works properly but just to save i submit
public class Solution {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

            int testCases = in.nextInt();
            for (int i = 0; i < testCases; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                String d = in.next();

                int[][] a = move(x, y, d);
                if (a[0][0] == -5000)
                    System.out.println("Case #" + (i + 1) + ": " + "IMPOSSIBLE");
                else
                    System.out.println("Case #" + (i + 1) + ": " + a[0][1]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static int[][] move(int x1, int y1, String d) {
        int x = x1;
        int y = y1;
        int[][] a = new int[1][2];
        int steps = 0;
        for (int j = 0; j < d.length(); j++) {
            char ch = d.charAt(j);
            switch (ch) {
                case 'N':
                    y++;
                    steps++;
                    break;
                case 'S':
                    y--;
                    steps++;
                    break;
                case 'W':
                    x--;
                    steps++;
                    break;
                case 'E':
                    x++;
                    steps++;
                    break;
            }

            if (x == 0 && y == 0 || y == 0 && x == steps || x == 0 && y == steps) {
                a[0][0] = 0;
                a[0][1] = steps;
                return a;
            }

            if (x == 0 && y < steps) {

                a[0][0] = 0;
                a[0][1] = y;
                return a;
            }

            if (y == 0 && x < steps) {

                a[0][0] = 0;
                a[0][1] = x;
                return a;
            }
        }

        a[0][0] = -5000;
        return a;
    }
}
