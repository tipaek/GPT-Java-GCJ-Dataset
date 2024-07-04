import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        for (int t = 0; t < T; t++) {
            String[] nums = scanner.nextLine().split(" ");
            int X = Integer.parseInt(nums[0]);
            int Y = Integer.parseInt(nums[1]);
            String direction = nums[2];

            char[] C = direction.toCharArray();
            int x = 0, y = 0;
            int time = 0;
            for (int i = 0; i < C.length; i++) {
                //System.out.println(" X = " + X + " Y = " + Y + " x = " + x + " y = " + y);
                if (X == x) {
                    if (y + 1 == Y) {
                        y++;
                        break;
                    }
                    if (C[i] == 'E') {
                        x++;
                        X++;
                    } else if (C[i] == 'W') {
                        x--;
                        X--;
                    } else if (C[i] == 'N') {
                        y--;
                        Y++;
                    } else if (C[i] == 'S') {
                        y++;
                        Y--;
                    }

                } else {
                    x++;
                    //System.out.println(C[i]);
                    if (C[i] == 'E') {
                        X++;
                    } else if (C[i] == 'W') {
                        X--;
                    } else if (C[i] == 'N') {
                        Y++;
                    } else if (C[i] == 'S') {
                        //System.out.println(C[i]);
                        Y--;
                    }

                }
                if (x == X && y == Y) {
                    break;
                }
                time++;
            }
            if (X - x != 0 || Y - y != 0) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (t + 1) + ": " + (time+1));
            }
        }
    }
}