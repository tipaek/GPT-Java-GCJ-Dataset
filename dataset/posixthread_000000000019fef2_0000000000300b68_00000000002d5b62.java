import java.util.Scanner;

public class Solution {

    static long x, y;
    static long[] twos = new long[32];
    static int maxLen;
    static String finalPath = "";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < twos.length; i++) {
            twos[i] = (int) Math.pow(2, i);
        }


        int numCases = sc.nextInt();

        for (int k = 0; k < numCases; k++) {

            x = sc.nextInt();
            y = sc.nextInt();

            System.out.print("Case #" + (k + 1) + ": ");

            char[] path = new char[32];
            maxLen = 100000;
            if (findPath(path, 0, 0, 0)) {
                System.out.println(finalPath);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }

        sc.close();
    }

    static boolean findPath(char[] path, int index, long curX, long curY) {
        long distX = Math.abs(curX - x);
        long distY = Math.abs(curY - y);
        long tmpTwo = (long) Math.pow(2, index);
        /*
         * if ((distX != 0 && tmpTwo >= distX) || (distY != 0 && tmpTwo >= distY)) {
         * return false;
         * }
         */
        if (distX == 0 && distY == 0) {
            if (index < maxLen) {
                maxLen = index;
                finalPath = new String(path, 0, index);
                return true;
            }
            return false;
        }
        boolean flag = false;

        if (distX == 0 && tmpTwo == distY) {
            if (y > curY) {
                path[index] = 'N';
                flag |= findPath(path, index + 1, curX, curY + tmpTwo);
            } else {
                path[index] = 'S';
                flag |= findPath(path, index + 1, curX, curY - tmpTwo);
            }
        } else if (distY == 0 && tmpTwo == distX) {
            if (x > curX) {
                path[index] = 'E';
                flag |= findPath(path, index + 1, curX + tmpTwo, curY);
            } else {
                path[index] = 'W';
                flag |= findPath(path, index + 1, curX - tmpTwo, curY);
            }
        } else if (distX == 0 && tmpTwo < distY) {
            path[index] = 'S';
            boolean newFlag = findPath(path, index + 1, curX, curY - tmpTwo);
            flag |= newFlag;
            if (!newFlag) {
                path[index] = 'N';
                flag |= findPath(path, index + 1, curX, curY + tmpTwo);
            }
        } else if (distY == 0 && tmpTwo < distX) {
            path[index] = 'E';
            boolean newFlag = findPath(path, index + 1, curX + tmpTwo, curY);
            flag |= newFlag;
            if (!newFlag) {
                path[index] = 'W';
                flag |= findPath(path, index + 1, curX - tmpTwo, curY);
            }
        } else if (tmpTwo <= distY && tmpTwo <= distX) {
            path[index] = 'S';
            flag |= findPath(path, index + 1, curX, curY - tmpTwo);
            path[index] = 'N';
            flag |= findPath(path, index + 1, curX, curY + tmpTwo);
            path[index] = 'E';
            flag |= findPath(path, index + 1, curX + tmpTwo, curY);
            path[index] = 'W';
            flag |= findPath(path, index + 1, curX - tmpTwo, curY);
        }

        return flag;
    }

}
