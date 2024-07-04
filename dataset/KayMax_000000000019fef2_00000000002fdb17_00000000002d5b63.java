import java.util.*;
import java.io.*;

public class Solution {
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int tc = in.nextInt();
        
        for(int i = 1; i <= tc; i++) {
            //System.out.printf("Case #%d: ", i);
            solve(in);
        }
    }
    
    public static void solve(Scanner in) {
        int A = in.nextInt();
        int B = in.nextInt();
        for(int i = -5; i <= 5; i++) {
            for(int j = -5; i <= 5; i++) {
                System.out.println(i + " " + j);
                String result = in.next();
                if(result.equals("CENTER"))
                    return;
            }
        }
    }
}
