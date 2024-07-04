import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    static Scanner sc;

    public static void main(String[] args) throws Exception {
        sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int t = sc.nextInt();
        
        for (int test = 1; test <= t; test++) {
            solve(test);
        }
    }

    static void solve(int test) {
        int X = sc.nextInt();
        int Y = sc.nextInt();
        String path = sc.next();

        if (X == 0 && Y == 0) {
            System.out.println("Case #" + test + ": 0");
            return;
        }

        boolean isOddSum = (X + Y) % 2 != 0;

        if (isOddSum) {
            if (adjustCoordinates(path.charAt(0))) {
                if (X == 0 && Y == 0) {
                    System.out.println("Case #" + test + ": 1");
                    return;
                }
            }

            for (int i = 1; i < path.length(); i++) {
                if (adjustCoordinates(path.charAt(i))) {
                    if (X == 0 && Y == 0) {
                        System.out.println("Case #" + test + ": " + (i + 1));
                        return;
                    }
                }
            }
        } else {
            for (int i = 0; i < path.length(); i++) {
                if (adjustCoordinates(path.charAt(i))) {
                    if (X == 0 && Y == 0) {
                        System.out.println("Case #" + test + ": " + (i + 1));
                        return;
                    }
                }
            }
        }

        System.out.println("Case #" + test + ": IMPOSSIBLE");
    }

    static boolean adjustCoordinates(char direction) {
        switch (direction) {
            case 'N':
                Y++;
                break;
            case 'S':
                if (X == 0) {
                    Y -= 2;
                } else {
                    Y--;
                    X--;
                }
                break;
            case 'E':
                X++;
                break;
            case 'W':
                if (Y == 0) {
                    X -= 2;
                } else {
                    X--;
                    Y--;
                }
                break;
            default:
                return false;
        }
        return true;
    }
}