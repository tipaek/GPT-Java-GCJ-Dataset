import java.util.*;


public class Solution {
    
    static Scanner SCNR = new Scanner(System.in);
    
    static void method1() {
        
        
        
        int r, c;
        
        for (r = -5; r <= 5; ++r ) {
            for (c = -5; c <= 5; ++c) {
                System.out.printf("%d %d\n", r, c);
                if (SCNR.next().equals("CENTER")) {
                    return;
                }
            }
        }
        
        

        

        
        
    }
    
    
    public static void main (String [] args) {
        
        
        int T = SCNR.nextInt();
                    int A = SCNR.nextInt();
            int B = SCNR.nextInt();
        String R;
        int i;
        String num;
        
        for (i = 1; i <= T; ++i) {
            

            method1();
        }
        
        SCNR.close();
    }
}