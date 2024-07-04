
import java.util.*;
import java.io.*;

public class Solution {

    static int R;
    static int S;
    private static List<List<Integer>> nomove = new ArrayList<>();

    public static void main(String[] args) {
        main(System.in);
    }

    public static void main(InputStream is) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(is)));
        int t = in.nextInt();
        for (int run = 1; run <= t; ++run) {
            R = in.nextInt();
            S = in.nextInt();
            int moves = (R -1) * (S - 1);
            int items = R*S;
            System.out.println("Case #" + run + ": " + moves);
            //System.err.println("----start--" + run+ " "+ X + ", " + Y);
            for (int i = 0; i < moves; i++) {
                int colorsFixed = i / (R - 1);
                int first = S * (R - 1) - i;
                System.out.println(first + " " + (items-first- colorsFixed-1-i));
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
            if (desX * posX < 0 && moveMul > Math.abs(desX) + Math.abs(desY)) {
                return null;
            }
            if ((desX > 0 && posX > desX) || (desX < 0 && posX < desX)) {
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
            if (desY * posY < 0 && moveMul > Math.abs(desX) + Math.abs(desY)) {
                return null;
            }
            if ((desY > 0 && posY > moveMul) || (desY < 0 && posY < desY)) {
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
