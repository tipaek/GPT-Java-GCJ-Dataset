import java.util.Scanner;

public class Solution {

    public static int tryToMeet(int myX, int myY, int X, int Y, int totalTime, int minute) {
        if (myX < 0 || myY < 0 || myX > 1000 || myY > 1000) {
            return Integer.MAX_VALUE;
        } else if (myX == X && myY == Y) {
            if (minute < totalTime) {
                return minute + 1;
            } else if (minute == totalTime) {
                return minute;
            } else {
                return Integer.MAX_VALUE;
            }
        } else if (minute > totalTime) {
            return Integer.MAX_VALUE;
        } else {
            // Go north
            int north = tryToMeet(myX, myY + 1, X, Y, totalTime, minute + 1);
            // Go south
            int south = tryToMeet(myX, myY - 1, X, Y, totalTime, minute + 1);
            // Go east
            int east = tryToMeet(myX + 1, myY, X, Y, totalTime, minute + 1);
            // Go west
            int west = tryToMeet(myX - 1, myY, X, Y, totalTime, minute + 1);
            // Stay here
            int stay = tryToMeet(myX, myY, X, Y, totalTime, minute + 1);

            int minutesTaken = Integer.MAX_VALUE;
            minutesTaken = Math.min(minutesTaken, north);
            minutesTaken = Math.min(minutesTaken, south);
            minutesTaken = Math.min(minutesTaken, east);
            minutesTaken = Math.min(minutesTaken, west);
            minutesTaken = Math.min(minutesTaken, stay);
            return minutesTaken;
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
            int minute = tryToMeet(0, 0, X, Y, i + 1, 0);
            if (minute != Integer.MAX_VALUE) {
                return minute;
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