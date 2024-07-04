import java.util.Scanner;

public class Prob1 {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        
        for (int i = 1; i <= T; i++) {
            int X = input.nextInt();
            int Y = input.nextInt();
            
            String rv = findPath(X, Y, 0, 0, 1);
            
            System.out.println("Case #" + i + ": " + rv);
        }
        input.close();
    }
    
    /**
     * When getting to a desired axis, after first jump, must be
     * an even number of spaces away. 
     */
    public static String findPath(int X, int Y, int sX, int sY, int jS) {
        if (X == sX && Y == sY) {return "";}
        
        final int dx = Math.abs(X - sX);
        final int dy = Math.abs(Y - sY);
        
        //System.out.println(sX + " " + sY);
        if ((dx < jS && dx != 0) || (dy < jS && dy != 0)) {
            return "IMPOSSIBLE";
        }
        
        
        // Only move on x axis
        if (dy == 0) {
            if (sX < X) {
                String res = findPath(X, Y, sX + jS, sY, jS*2);
                if (!res.equals("IMPOSSIBLE")) {return "E" + res;}
            }
            else {
                String res = findPath(X, Y, sX - jS, sY, jS*2);
                if (!res.equals("IMPOSSIBLE")) {return "W" + res;}
            }
            return "IMPOSSIBLE";
        }
            
        // Only move on y axis
        else if (dx == 0) {
            if (sY < Y) {
                String res = findPath(X, Y, sX, sY + jS, jS*2);
                if (!res.equals("IMPOSSIBLE")) {return "N" + res;}
            }
            else {
                String res = findPath(X, Y, sX, sY - jS, jS*2);
                if (!res.equals("IMPOSSIBLE")) {return "S" + res;}
            }
            return "IMPOSSIBLE";
        }
        
        
        String[] poss = new String[4];
        String[] possDir = new String[4];
        
        poss[0] = findPath(X, Y, sX - jS, sY, jS * 2);
        poss[1] = findPath(X, Y, sX, sY + jS, jS * 2);
        poss[2] = findPath(X, Y, sX + jS, sY, jS * 2);
        poss[3] = findPath(X, Y, sX, sY - jS, jS * 2);
        
        possDir[0] = "W";
        possDir[1] = "N";
        possDir[2] = "E";
        possDir[3] = "S";
        
        String rv = "IMPOSSIBLE";
        for (int i = 0; i < poss.length; i++) {
            if (!poss[i].equals("IMPOSSIBLE")) {
                if (rv.equals("IMPOSSIBLE")) {
                    rv = possDir[i] + poss[i]; 
                }
                else if (poss[i].length() - 1 > rv.length()) {
                    rv = possDir[i] + poss[i];
                }
            }
        }
        return rv;
    }
}