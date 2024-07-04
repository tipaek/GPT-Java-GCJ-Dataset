import java.util.*;

public class Solution {

    static Scanner in = new Scanner(System.in);

    public static int destX = 0;
    public static int destY = 0;
    public static int maxValue = (int) Math.pow(2, 9);
    public static String currentBestPath = "";
    public static String[][] array;

    public static void main(String[] args) {
        int tc = in.nextInt();
        for(int c = 1; c <= tc; c++) {
            destX = in.nextInt();
            destY = in.nextInt();

            String result = solve();
            System.out.println("Case #" + c + ": " + result);
        }
    }

    private static String solve() {
        array = new String[maxValue][maxValue];
        int currentX = 0;
        int currentY = 0;
        currentBestPath = "";

        move(currentX, currentY, new StringBuilder());
        if (currentBestPath != "")
            return currentBestPath;
        else
            return "IMPOSSIBLE";
    }

    private static void move(int currentX, int currentY, StringBuilder currentPath) {
//        System.out.println(currentPath.toString());
//        System.out.println(currentX + " " + currentY);
        //Have found a path, return as possible path
        if (currentX == destX && currentY == destY) {
            if (currentBestPath.length() == 0 || currentPath.toString().length() < currentBestPath.length()) {
                currentBestPath = currentPath.toString();
            }
        }
        //If above the currentMax then no point in persuing this path anymore
        else if ((!currentBestPath.isEmpty() && currentPath.length() > currentBestPath.length()) || Math.abs(currentX) > maxValue || Math.abs(currentY) > maxValue) {
            return;
        }
        //If there are no moves left and we aren't on the point, then take the next step. TODO check for impossible here
        else {
            int moves = (int) Math.pow(2, currentPath.length());
            //Move North
            move(currentX, currentY+moves, new StringBuilder(currentPath).append("N"));
            //Move East
            move(currentX+moves, currentY, new StringBuilder(currentPath).append("E"));
            //Move South
            move(currentX, currentY-moves, new StringBuilder(currentPath).append("S"));
            //Move West
            move(currentX-moves, currentY, new StringBuilder(currentPath).append("W"));
        }
        return;
    }

}
