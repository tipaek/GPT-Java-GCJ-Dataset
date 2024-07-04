import java.util.*;
import java.io.OutputStream.*;

public class Solution {
    
    private static Scanner scn = new Scanner(System.in);
    
    public static void main(String[] args) {
        int cases = scn.nextInt();
        while(cases-- > 0) {
            int B = scn.nextInt();
            StringBuilder str = new StringBuilder();
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
                str.append(scn.nextInt());
                System.out.flush();
            }
            System.out.println(str.toString());
        }
    }
}