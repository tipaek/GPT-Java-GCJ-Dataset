import java.util.*;
import java.io.OutputStream.*;

public class Solution {
    
    private static Scanner scn = new Scanner(System.in);
    
    public static void main(String[] args) {
        int cases = scn.nextInt();
        int B = scn.nextInt();
        if (B == 10) {
        while(cases-- > 0) {
            StringBuilder str = new StringBuilder();
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
                str.append(scn.nextInt());
            }
            System.out.println(str.toString());
            if (scn.next() == "N") System.exit(0);
        
        } 
        } else System.exit(0);
    }
}