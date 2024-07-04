import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    
    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);
        PrintWriter output = new PrintWriter(System.out);
        
        
        int T;
        T = input.nextInt();
        int U;
        int sz = 10000;
        
        int[] Q = new int[sz];
        String[] R = new String[sz];
        
        for (int i = 0; i < T; i++) {
            U = input.nextInt();
            for (int j = 0; j < sz; j++) {
                Q[j] = input.nextInt();
                R[j] = input.next();
            }
            
            String res = solution(U, Q, R);
            output.println(String.format("Case #%d: %s",(i+1), res));
            output.flush();
        }

    }
    
    public static char getCharAtndx(int ndx, int[] Q, String[] R, Set<Character> seen) {
        char res = ' ';
        
        for (int i = 0; i < Q.length; i++) {
            if (R[i].length() == 0) {
                continue;
            }
            
            char tmp = R[i].charAt(0);
            if (Q[i] < ndx && !seen.contains(tmp)) {
                res = tmp;
                seen.add(res);
            }
        }
        return res;
    }
    
    public static String solution(int U, int[] Q, String[] R) {
       
       // D = string of length 10;
       // 
        
       char[] str = new char[10];
        
       Set<Character> chars = new HashSet<>();
       int i = 1;
       
       while (i <= 10) {
           str[i - 1] = getCharAtndx(i, Q, R, chars);
           i++;
       }
               
       
       return new String(str);
    }    

}