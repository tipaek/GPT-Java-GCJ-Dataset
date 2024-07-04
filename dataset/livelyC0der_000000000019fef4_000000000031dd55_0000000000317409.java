import java.util.Scanner;

public class Solution {

    public static int tryToMeet(int myX, int myY, int X, int Y, int minutes) {
        if (myX < 0 || myY < 0 || myX > 1000 || myY > 1000) {
            return Integer.MAX_VALUE;
        } else if (myX == X && myY == Y && minutes >= 0) {
            return minutes;
        } else if (minutes == 0) {
            return Integer.MAX_VALUE;
        } else {
            // Go north
            int north = tryToMeet(myX, myY + 1, X, Y, minutes - 1);
            // Go south
            int south = tryToMeet(myX, myY - 1, X, Y, minutes - 1);
            // Go east
            int east = tryToMeet(myX + 1, myY, X, Y, minutes - 1);
            // Go west
            int west = tryToMeet(myX - 1, myY, X, Y, minutes - 1);
            // Stay here
            int stay = tryToMeet(myX, myY, X, Y, minutes - 1);

            int minutesLeft = Integer.MAX_VALUE;
            minutesLeft = Math.min(minutesLeft, north);
            minutesLeft = Math.min(minutesLeft, south);
            minutesLeft = Math.min(minutesLeft, east);
            minutesLeft = Math.min(minutesLeft, west);
            minutesLeft = Math.min(minutesLeft, stay);
            return minutesLeft;
        }
    }

    public static int meet(int X, int Y, String M) {
        for (int i = 0; i < M.length(); i++) {
            switch (M.charAt(i)) {
                case 'N':
                    Y++;
                    break;
                case 'S':
                    Y--;
                    break;
                case 'E':
                    X++;
                    break;
                case 'W':
                    X--;
                    break;
            }
            if (X == 0 && Y == 0) {
                return i + 1;
            } else {
                int minutes = tryToMeet(0, 0, X, Y, i + 1);
                if (minutes != Integer.MAX_VALUE) {

                    return i + 1 - minutes;
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            String M = sc.next();
            int minutes = meet(X, Y, M);
            if (minutes == Integer.MAX_VALUE) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", t);
            } else {
                System.out.printf("Case #%d: %d\n", t, minutes);
            }
        }
        sc.close();
    }
}