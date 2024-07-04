import java.util.Scanner;

public class Solution {
    static int t, x, y, min;
    static String[] moves;
    static int[] x_list, y_list;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        t = input.nextInt();

        for (int a = 1; a <= t; a++) {
            x = input.nextInt();
            y = input.nextInt();
            moves = input.next().split("");

            x_list = new int[moves.length + 1];
            y_list = new int[moves.length + 1];
            x_list[0] = x;
            y_list[0] = y;

            for (int count = 1; count <= moves.length; count++) {
                String move = moves[count - 1];

                switch (move) {
                    case "N":
                        x_list[count] = x_list[count - 1];
                        y_list[count] = y_list[count - 1] + 1;
                        break;
                    case "S":
                        x_list[count] = x_list[count - 1];
                        y_list[count] = y_list[count - 1] - 1;
                        break;
                    case "W":
                        x_list[count] = x_list[count - 1] - 1;
                        y_list[count] = y_list[count - 1];
                        break;
                    case "E":
                        x_list[count] = x_list[count - 1] + 1;
                        y_list[count] = y_list[count - 1];
                        break;
                }
            }

            min = moves.length + 2;
            for (int look = 0; look < x_list.length; look++) {
                if (Math.abs(x_list[look]) + Math.abs(y_list[look]) <= look) {
                    min = Math.min(min, look);
                }
            }

            if (min == moves.length + 2) {
                System.out.println("Case #" + a + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + a + ": " + min);
            }
        }
        input.close();
    }
}