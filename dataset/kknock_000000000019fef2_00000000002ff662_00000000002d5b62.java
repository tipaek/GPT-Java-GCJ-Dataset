import java.util.Scanner;

public class Solution {
    public static int X, Y;
    public static boolean did = false;
    public static String ans = "IMPOSSIBLE";
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();

        String []res = new String[cases];
        for (int i = 1; i <= cases; i++) {
            X = in.nextInt();
            Y = in.nextInt();

            String sol = getSolution(0, 0, "", 0);
            res[i-1] = "Case #"+i+": "+ans;
            did = false;
            ans = "IMPOSSIBLE";
        }
        in.close();
        for (String s: res) {
            System.out.println(s);
        }
    }

    private static String getSolution(int x, int y, String s, int move) {
        if(x == X && y == Y) {
            if(did && s.length() < ans.length()) {
                ans = s;
            } else if(!did) {
                ans = s;
            }
            did = true;
        } else if(x > 100*X || y > 100*Y) {
            // nothingness
        } else if(x < -100*X || y < -100*Y) {
            // nothingness
        } else {
            Double moveVal = Math.pow(2.0, (double)move);
            int moveValInt = moveVal.intValue();
            getSolution(x+moveValInt, y, s+"E", move+1);
            getSolution(x-moveValInt, y, s+"W", move+1);
            getSolution(x, y+moveValInt, s+"N", move+1);
            getSolution(x, y-moveValInt, s+"S", move+1);
        }
        return s;
    }
}
