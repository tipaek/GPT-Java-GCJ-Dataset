import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String result = findPath("", x, y, 1, x, y);
            System.out.println("Case #" + i + ": " + (result.isEmpty() ? "IMPOSSIBLE" : result));
        }
    }

    private static String findPath(String path, int x, int y, int step, int initialX, int initialY) {
        if (x == 0 && y == 0) {
            return path;
        }
        if (step > Math.pow(2, 30)) {
            return "";
        }
        
        String west = "", east = "", south = "", north = "";
        
        if (Math.abs(2 * initialX) > Math.abs(x + step)) {
            west = findPath(path + "W", x + step, y, step * 2, initialX, initialY);
        }
        if (Math.abs(2 * initialX) > Math.abs(x - step)) {
            east = findPath(path + "E", x - step, y, step * 2, initialX, initialY);
        }
        if (Math.abs(2 * initialY) > Math.abs(y + step)) {
            south = findPath(path + "S", x, y + step, step * 2, initialX, initialY);
        }
        if (Math.abs(2 * initialY) > Math.abs(y - step)) {
            north = findPath(path + "N", x, y - step, step * 2, initialX, initialY);
        }
        
        if (west.isEmpty() && east.isEmpty() && south.isEmpty() && north.isEmpty()) {
            return "";
        }
        
        int westLength = west.isEmpty() ? Integer.MAX_VALUE : west.length();
        int eastLength = east.isEmpty() ? Integer.MAX_VALUE : east.length();
        int southLength = south.isEmpty() ? Integer.MAX_VALUE : south.length();
        int northLength = north.isEmpty() ? Integer.MAX_VALUE : north.length();
        
        if (westLength <= eastLength && westLength <= southLength && westLength <= northLength) {
            return west;
        }
        if (eastLength <= westLength && eastLength <= southLength && eastLength <= northLength) {
            return east;
        }
        if (southLength <= westLength && southLength <= eastLength && southLength <= northLength) {
            return south;
        }
        return north;
    }
}