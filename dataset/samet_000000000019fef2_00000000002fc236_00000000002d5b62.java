import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; i++) {
            int x = in.nextInt(); // people
            int y = in.nextInt(); // grid size
            System.out.println("Case #" + i + ": " + findPath(x,y));
        }
    }

    private static String findPath(int x, int y) {

        String response = "";
        while(x != 0 || y != 0) {
            if (Math.abs((x+y)) == 1) {
                if (x == 1 && y == 0) {
                    response += "E";
                    return response;
                } else if (x == -1 && y == 0) {
                    response += "W";
                    return response;
                } else if (x == 0 && y == 1) {
                    response += "N";
                    return response;
                } else if (x == 0 && y == -1) {
                    response += "S";
                    return response;
                }
            }

            if (Math.abs(x % 2) == 1 && y % 2 == 0) {

                if (Math.abs(((x-1)/2) % 2 + (y/2) % 2) % 2 == 1) {
                    response += "E";
                    x = (x-1) / 2;
                    y = y/2;
                } else if (Math.abs(((x+1)/2) % 2 + (y/2) % 2) % 2 == 1 ) {
                    response += "W";
                    x = (x+1) / 2;
                    y = y/2;
                } else {
                    return "IMPOSSIBLE";
                }

            } else if (Math.abs(y % 2) == 1 && x % 2 == 0){
                if (Math.abs(((y-1)/2) % 2 + (x/2) % 2) % 2 == 1) {
                    response += "N";
                    y = (y-1) / 2;
                    x = x/2;
                } else if (Math.abs(((y+1)/2) % 2 + (x/2) % 2) % 2 == 1){
                    response += "S";
                    y = (y+1) / 2;
                    x = x/2;
                } else {
                    return "IMPOSSIBLE";
                }
            } else {
                return "IMPOSSIBLE";
            }

        }

        return response;

    }

}

