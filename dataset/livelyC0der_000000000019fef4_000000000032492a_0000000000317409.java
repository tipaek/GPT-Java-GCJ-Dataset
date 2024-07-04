import java.util.Scanner;

public class Solution {

    public static int tryToMeet(int myX, int myY, int X, int Y, int minutesLeft) {
        if (myX < 0 || myY < 0 || myX > 1000 || myY > 1000) {
            return Integer.MIN_VALUE;
        } else if (myX == X && myY == Y && minutesLeft == 0) {
           return minutesLeft;
        } else if (minutesLeft == 0) {
            return Integer.MIN_VALUE;
        } else {
            // Go north
            int north = tryToMeet(myX, myY + 1, X, Y, minutesLeft - 1);
            // Go south
            int south = tryToMeet(myX, myY - 1, X, Y, minutesLeft - 1);
            // Go eastminutesTaken
            int east = tryToMeet(myX + 1, myY, X, Y, minutesLeft - 1);
            // Go west
            int west = tryToMeet(myX - 1, myY, X, Y, minutesLeft - 1);
            // Stay here
            int stay = tryToMeet(myX, myY, X, Y, minutesLeft - 1);

            int minutes = Integer.MIN_VALUE;
            minutes = Math.max(minutes, north);
            minutes = Math.max(minutes, south);
            minutes = Math.max(minutes, east);
            minutes = Math.max(minutes, west);
            minutes = Math.max(minutes, stay);
            return minutes;
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
            int minutesLeft = tryToMeet(0, 0, X, Y, i + 1);
            if (minutesLeft != Integer.MIN_VALUE) {
                return Math.max(i + 1 - minutesLeft, 1);
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