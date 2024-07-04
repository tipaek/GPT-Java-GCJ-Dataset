
import java.util.*;
import java.io.*;

public class Solution {

    static int X;
    static int Y;
    private static List<List<Integer>> nomove = new ArrayList<>();

    public static void main(String[] args) {
        main(System.in);
    }

    public static void main(InputStream is) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(is)));
        int t = in.nextInt();
        for (int run = 1; run <= t; ++run) {
            X = in.nextInt();
            Y = in.nextInt();
            //System.err.println("----start--" + run+ " "+ X + ", " + Y);
            List<String> res = attempt(0, 0, 1, X, Y);
            if(res!= null) {
                Collections.reverse(res);
                System.out.println("Case #" + run + ": "+String.join("", res));
            } else {
                System.out.println("Case #" + run + ": IMPOSSIBLE");
            }
        }
    }
    
    public static List<String> attempt(int posX, int posY,int moveMul, int desX, int desY) {
        //System.err.println(" " + posX + ", " + posY+", X "+moveMul);
        //S Y-1
        //E X +
        if (posX==desX && posY==desY) {
            return new ArrayList<String>();
        }
        
//        if (moveMul > Math.abs(posX)+Math.abs(desX) || moveMul > Math.abs(posY)+Math.abs(desY)) {
//            return null;
//        }
        List<String> res = null;
        if(posX!= desX) {
            if (moveMul > 2 * Math.abs(desX)) {
                return null;
            }
            res= attempt(posX + moveMul, posY, moveMul * 2, desX, desY);
            if (res != null) {
                res.add("E");
                return res;
            }
            res = attempt(posX - moveMul, posY, moveMul * 2, desX, desY);
            if (res != null) {
                res.add("W");
                return res;
            }
        }
        if (posY != desY) {
            if (moveMul > 2 * Math.abs(desY)) {
                return null;
            }
            res = attempt(posX, posY - moveMul, moveMul * 2, desX, desY);
            if (res != null) {
                res.add("S");
                return res;
            }
            res = attempt(posX, posY + moveMul, moveMul * 2, desX, desY);
            if (res != null) {
                res.add("N");
                return res;
            }
        }
        return res;
    }


}
