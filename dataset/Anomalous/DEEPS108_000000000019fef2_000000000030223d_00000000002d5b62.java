import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        String[] results = new String[T];
        
        for (int i = 0; i < T; i++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            results[i] = findPath(X, Y);
        }
        
        for (int i = 0; i < results.length; i++) {
            if (results[i].isEmpty()) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (i + 1) + ": " + results[i]);
            }
        }
    }
    
    private static String findPath(int X, int Y) {
        return findPathRecursive(0, 0, X, Y, 0, "");
    }
    
    private static String findPathRecursive(int x, int y, int X, int Y, int p, String path) {
        if (x == X && y == Y) {
            return path;
        }
        
        if (Math.abs(x) > Math.abs(X) || Math.abs(y) > Math.abs(Y)) {
            return "";
        }
        
        int step = (int) Math.pow(2, p);
        String east = findPathRecursive(x + step, y, X, Y, p + 1, path + "E");
        String west = findPathRecursive(x - step, y, X, Y, p + 1, path + "W");
        String north = findPathRecursive(x, y + step, X, Y, p + 1, path + "N");
        String south = findPathRecursive(x, y - step, X, Y, p + 1, path + "S");
        
        return getShortestPath(east, west, north, south);
    }
    
    private static String getShortestPath(String... paths) {
        String shortest = "";
        for (String path : paths) {
            if (!path.isEmpty() && (shortest.isEmpty() || path.length() < shortest.length())) {
                shortest = path;
            }
        }
        return shortest;
    }
}