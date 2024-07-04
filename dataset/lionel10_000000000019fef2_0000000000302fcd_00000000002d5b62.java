import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static String im = "IMPOSSIBLE";
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int i = 1; i <= T; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            String str = util(0, 0, 1, x, y, "");
            System.out.println("Case #" + i + ": " + str);
        }
    }
    public static String util(int x, int y, int i, int tx, int ty, String s) {
        if (i >= 18) return im;
        //System.out.println(x + " " + y  + " " + tx + " " + ty + " " + s + " " + (1 << (i-1)));
        if ((x==tx) && (y==ty)) return s;
        if (x==tx) {
            if ((1 << (i-1)) == Math.abs(y-ty))
                return ty > y? s + "N": s + "S";
            else if ((1 << (i-1)) > Math.abs(y-ty)) return im;
        }else if (y==ty) {
            if ((1 << (i-1)) == Math.abs(x-tx))
                return tx > x? s + "E": s + "W";
            else if ((1 << (i-1)) > Math.abs(x-tx)) return im;
        }else if ((1 << (i-1)) > Math.abs(x-tx) || (1 << (i-1) > Math.abs(y-ty)))
            return im;

        String a = util(x+(1 << (i-1)), y, i+1, tx, ty, s + "E");
        String b = util(x-(1 << (i-1)), y, i+1, tx, ty, s + "W");
        String c = util(x, y + (1 << (i-1)), i+1, tx, ty, s + "N");
        String d = util(x, y - (1 << (i-1)), i+1, tx, ty, s + "S");
        //System.out.println(a + " " + b + " " + c + " " + d);
        List<String> list = new ArrayList<>();
        if (!a.equals(im)) list.add(a);
        if (!b.equals(im)) list.add(b);
        if (!c.equals(im)) list.add(c);
        if (!d.equals(im)) list.add(d);
        String res = ""; int min = Integer.MAX_VALUE;
        for (String ss: list) {
            if (ss.length() < min) {
                res = ss; min = Math.min(min, ss.length());
            }
        }
        return res.equals("")? im: res;
    }
}



