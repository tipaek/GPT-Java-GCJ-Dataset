
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    Pair me = new Pair(0, 0);
    Pair cat = new Pair(0, 0);

    /*
    *
    5
    4 4 SSSS
    3 0 SNSS
    2 10 NSNNSN
    0 1 S
    2 7 SSSSSSSS
    * */
    public static void main(String[] args) {
        Solution solution = new Solution();
        try {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();
            for (int i = 1; i <= t; ++i) {
                solution.ans = "IMPOSSIBLE";
                solution.cur = Integer.MAX_VALUE;
                int cX = scanner.nextInt();
                int cY = scanner.nextInt();
                String path = scanner.next();
                solution.getAns(new Pair(0, 0), new Pair(cX, cY), 0, path.trim());
                System.out.println("Case #" + i + ": " + solution.ans);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    String ans = "";
    int cur = Integer.MAX_VALUE;

    public void getAns(Pair me, Pair cat, int currentIdx, String path) {
        int hope = path.length() - currentIdx;
        if (hope <= 0) {
            if (me.x == cat.x && me.y == cat.y) {
                cur = Math.min(cur, currentIdx);
                ans = String.valueOf(cur);
            }
            return;
        }
        if (me.x == cat.x && me.y == cat.y) {
            cur = Math.min(cur, currentIdx);
            ans = String.valueOf(cur);
        }

        Pair moveCat = move(path.charAt(currentIdx), cat);
        Pair copyMe = new Pair(me.x, me.y);

        int disY = cat.y - copyMe.y;
        int disX = cat.x - copyMe.x;
        getAns(new Pair(copyMe.x, copyMe.y), moveCat, currentIdx + 1, path);
        if (disX > 0) getAns(new Pair(copyMe.x + 1, copyMe.y), moveCat, currentIdx + 1, path);
        else if (disX < 0) getAns(new Pair(copyMe.x - 1, copyMe.y), moveCat, currentIdx + 1, path);
        if (disX != 0) return;
        if (disY > 0) getAns(new Pair(copyMe.x, copyMe.y + 1), moveCat, currentIdx + 1, path);
        else if (disY < 0) getAns(new Pair(copyMe.x, copyMe.y - 1), moveCat, currentIdx + 1, path);

    }

    public Pair move(char input, Pair cat) {
        switch (input) {
            case 'N':
                return new Pair(cat.x, cat.y + 1);
            case 'S':
                return new Pair(cat.x, cat.y - 1);
            case 'W':
                return new Pair(cat.x - 1, cat.y);
            case 'E':
                return new Pair(cat.x + 1, cat.y);
        }
        return cat;
    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
