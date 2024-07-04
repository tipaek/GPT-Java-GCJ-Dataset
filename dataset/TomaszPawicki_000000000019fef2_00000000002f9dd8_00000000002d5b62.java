import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 1; t <= T; t++) {
            long x = s.nextLong();
            long y = s.nextLong();
            String str = check(Math.abs(x), Math.abs(y));
            StringBuilder sb = new StringBuilder();
            if("IMPOSSIBLE".equals(str.toString())) {
                sb.append(str);
            } else {
                for(char ch: str.toCharArray()) {
                    if(ch == 'W' && x < 0) {
                        sb.append('E');
                    } else if(ch == 'E' && x < 0) {
                        sb.append('W');
                    } else if(ch == 'S' && y < 0) {
                        sb.append('N');
                    } else if(ch == 'N' && y < 0) {
                        sb.append('S');
                    } else {
                        sb.append(ch);
                    }
                }
            }
            System.out.println("Case #" + t + ": " + sb.toString());
        }
    }

    private static String check(long x, long y) {
        if(x == 0 && y == 0) {
            return "";
        }
        if (x % 2 == y % 2) {
            return "IMPOSSIBLE";
        }
        if (x % 2 == 1) {
            x /= 2;
            y /= 2;
            if(x == 0 && y == 0) {
                return "E";
            }
            if (x % 2 == y % 2) {
                return "W" + check(x+1, y);
            } else {
                return "E" + check(x, y);
            }
        } else {
            x /= 2;
            y /= 2;
            if(x == 0 && y == 0) {
                return "N";
            }
            if (x % 2 == y % 2) {
                return "S" + check(x, y + 1);
            } else {
                return "N" + check(x, y);
            }
        }
    }
}
