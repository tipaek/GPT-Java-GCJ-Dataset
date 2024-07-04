import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        testCaseNum = 0;
        int T = Integer.parseInt(reader.readLine());
        pow();
        while(T != 0) {
            T--;
            testCaseNum++;
            String[] XY = reader.readLine().split(" ");
            int X = Integer.parseInt(XY[0]);
            int Y = Integer.parseInt(XY[1]);
            destLength = Integer.MAX_VALUE;
            ansList.clear();
            ArrayList<Character> tmp = new ArrayList<>();
            dfs(0, 0, X, Y, tmp);
            if(destLength == Integer.MAX_VALUE) {
                System.out.println("Case #" + testCaseNum + ": " + "IMPOSSIBLE");
            } else {
                StringBuilder sb = new StringBuilder();
                for(Character e : ansList) {
                    sb.append(e);
                }
                System.out.println("Case #" + testCaseNum + ": " + sb.toString());
            }
        }
    }

    public static int testCaseNum;

    public static boolean dfs(int X, int Y, int destX, int destY, ArrayList<Character> moveList) {
        if(moveList.size() >= 33) return false;
        if(moveList.size() >= destLength) return false;
        if(Math.max(Math.abs(X - destX), Math.abs(Y - destY)) < zhishu[moveList.size()]) return false;
        boolean isX = true;
        if(Math.abs(X - destX) != 0) {
            if(Math.abs(X -destX) % zhishu[moveList.size()] != 0) {
                isX = false;
            }
        }
        boolean isY = true;
        if(Math.abs(Y - destY) != 0) {
            if(Math.abs(Y -destY) % zhishu[moveList.size()] != 0) {
                isX = false;
            }
        }
        if(!isX || !isY) return false;
        for(int i = 0; i < 4; i++) {
            int newX = X + xDir[i] * zhishu[moveList.size()];
            int newY = Y + yDir[i] * zhishu[moveList.size()];
            moveList.add(dirChars[i]);
            if(newX == destX && newY == destY) {
                if(moveList.size() < destLength) {
                    destLength = moveList.size();
                    ansList.clear();
                    ansList.addAll(moveList);
                }
            }
            dfs(newX, newY, destX, destY, moveList);
            moveList.remove(moveList.size() - 1);
        }
        return true;
    }

    public static char[] dirChars = new char[] {'N', 'S','W', 'E'};
    public static int[] xDir = new int[]{0, 0, -1, 1};
    public static int[] yDir = new int[]{1, -1, 0, 0};

    public static int destLength = Integer.MAX_VALUE;
    public static ArrayList<Character> ansList = new ArrayList<>();
    public static int[] zhishu = new int[33];
    public static void pow() {
        zhishu[0] = 1;
        zhishu[1] = 2;
        for(int t = 2; t <= 32; t++) {
            zhishu[t] = zhishu[t - 1] * 2;
        }
    }
}
