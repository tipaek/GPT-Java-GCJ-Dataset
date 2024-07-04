import java.util.*;


public class Solution {
    
    static Scanner SCNR = new Scanner(System.in);
    
    static String method1(long X, long Y, int i, long x, long y, String res) {
        
        long distX = Math.abs(X-x);
        long distY = Math.abs(Y-y);
        long jump = (long)Math.pow(2,i-1);
        //System.out.printf("%d %d\n",x,y );
        if (x == X && y ==Y) {
            return res;
        }
        
        else if ((distX > Math.abs(X) * 10) || (distY > Math.abs(Y) * 10)) {
            return "IMPOSSIBLE";
        }
        
        else if (x == X){
            if (jump > distY) {
                return "IMPOSSIBLE";  
            } 
        }
        
        else if (y == Y) {
            if (jump > distX) {
                return "IMPOSSIBLE";
            }
        }
        
        else if (jump > distX || jump > distY ) {
            return "IMPOSSIBLE";
        }
        
        String temp;
        
        temp = method1(X,Y,i + 1,x,y + jump,res + 'N');
        
        if (!temp.equals("IMPOSSIBLE")) {
            return temp;
        }
        
        temp = method1(X,Y,i + 1,x,y - jump,res + 'S');
        
        if (!temp.equals("IMPOSSIBLE")) {
            return temp;
        }
        
        temp = method1(X,Y,i + 1,x + jump,y,res + 'E');
        
        if (!temp.equals("IMPOSSIBLE")) {
            return temp;
        }
        
        temp = method1(X,Y,i + 1,x - jump,y,res + 'W');
        
        return temp;

    }
    
    
    public static void main (String [] args) {
        
        
        int T = SCNR.nextInt();
        long X, Y;
        int i, j, m;
        String res;
        
        for (i = 1; i <= T; ++i) {
            X = SCNR.nextLong();
            Y = SCNR.nextLong();
            
            res = method1(X, Y, 1, 0, 0, "");
            
            System.out.printf("Case #%d: %s\n", i, res);
        }
        
        SCNR.close();
    }
}