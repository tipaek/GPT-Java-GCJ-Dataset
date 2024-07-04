// 
// 4        
// 2 3      Case #1: SEN
// -2 -3    Case #2: NWS
// 3 0      Case #3: EE
// -1 1     Case #4: IMPOSSIBLE

// 3, -6    Case #5: WNES
// 3, 6     Case #6: WSEN

// 0010,  0011
// 0101
// 0110 - 0001

// 0011,  0110
// 1001
// 1010 - 0001
// 1100 - 0011




import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTC = sc.nextInt();

        for(int tc=1; tc<=numTC; tc++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            String result = solve(x,y);

            System.out.println("Case #" + tc + ": " + result);
        }
    }
    
    public static String solve(int x, int y) {
        String path = "";
        
        boolean signX = x >= 0;
        boolean signY = y >= 0;
        
        x = Math.abs(x);
        y = Math.abs(y);
        
        if ((x+y) % 2 == 0)
            return "IMPOSSIBLE";
        
        int A = x+y;
        int B = 0;
        
        int allOnes = (int)Math.pow(2, (int)Math.floor((Math.log(x+y) / Math.log(2))) + 1) - 1;
        
        while (((A^B) != allOnes) && A > B) {
            int index = PositionRightmostSetbit(A);
            A += Math.pow(2, index);
            B += Math.pow(2, index);
        }
        
        if ((A^B) != allOnes)
            return "IMPOSSIBILE";
        else {
            int base = 0;
            
            while (x > 0 || y > 0) {
                if (x > 0 && ((x >> base) % 2 == 1)) {
                    if ((A >> base) % 2 == 1) {
                        path += signX ? "E" : "W";
                        x -= Math.pow(2, base);
                    }
                    else {
                        path += signX ? "W" : "E";
                        x += Math.pow(2, base);
                    }
                }
                else {
                    if ((A >> base) % 2 == 1) {
                        path += signY ? "N" : "S";
                        y -= Math.pow(2, base);
                    }
                    else {
                        path += signY ? "S" : "N";
                        y += Math.pow(2, base);
                    }
                }
                
                base++;
            }
        }
        
        return path;
    }
    
    public static int PositionRightmostSetbit(int n) 
    { 
        // Position variable initialize 
        // with 1 m variable is used to 
        // check the set bit 
        int position = 0; 
        int m = 1; 
  
        while ((n & m) == 0) { 
  
            // left shift 
            m = m << 1; 
            position++; 
        } 
        return position; 
    } 
}
