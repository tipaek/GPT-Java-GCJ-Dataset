import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static class Pos {
        int x;
        int y;
        int minute;

        public Pos(int x, int y, int minute) {
            this.x = x;
            this.y = y;
            this.minute = minute;
        }
    }

    private static Pos nextPos(Pos currentPos, char direction) {
        int x = 0;
        int y = 0;

        switch (direction) {
            case 'S': {
                x = currentPos.x;
                y = currentPos.y - 1;
                break;
            }
            case 'N': {
                x = currentPos.x;
                y = currentPos.y + 1;
                break;
            }
            case 'E': {
                x = currentPos.x + 1;
                y = currentPos.y;
                break;
            }
            case 'W': {
                x = currentPos.x - 1;
                y = currentPos.y;
                break;
            }
        }

        return new Pos(x, y, currentPos.minute + 1);
    }

    private static String find(int x, int y, String path) {
        Pos current = new Pos(x, y, 0);

        for (int i = 0; i <= path.length(); i++) {
            int hamilton = Math.abs(current.x) + Math.abs(current.y);
            if (hamilton <= current.minute) {
                return Integer.toString(current.minute);
            }

            if (i < path.length()) {
                current = nextPos(current, path.charAt(i));
            }
        }

        return "IMPOSSIBLE";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine().trim());
        for (int testCase = 1; testCase <= t; ++testCase) {
            int x = in.nextInt();
            int y = in.nextInt();
            String path = in.nextLine().trim();
            System.out.println(String.format("Case #%d: %s", testCase, find(x, y, path)));
        }
    }
}
