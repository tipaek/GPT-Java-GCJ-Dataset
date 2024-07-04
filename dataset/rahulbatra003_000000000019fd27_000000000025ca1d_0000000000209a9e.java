import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    static boolean isPerfectSquare(int x)  
    { 
        double sr = Math.sqrt(Double.valueOf(x)); 
        return ((sr - Math.floor(sr)) == 0); 
    }   
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int B = in.nextInt();
        for(int k=0; k<T; k++) {
            int P = 1;
            System.out.println(P);
            StringBuilder sb = new StringBuilder();
            int x = in.nextInt();
            int y = x^1;
            for(int i=1;i<=B;i++) {
                if(isPerfectSquare(i)) {
                    sb.append(x);
                } else {
                    sb.append(y);
                }
            }
            System.out.println(sb.toString());
            String p = in.nextLine();
            if(p.contains("N")) break;
        }
    }
}