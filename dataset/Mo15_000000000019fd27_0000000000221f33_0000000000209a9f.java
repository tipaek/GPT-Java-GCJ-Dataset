import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int i=0;i<tc;i++){
            String s = sc.next();
            String s_prime = print_paran(s);
            System.out.println("Case #" + (i+1) + ": " + s_prime);
        }
    }
    
    static String print_paran(String s) {
        int level = 0;
        StringBuilder s_prime = new StringBuilder();
        
        for(int i=0;i<s.length();i++){
            int digit = Character.digit(s.charAt(i), 10);
            if(level < digit)
                for(int j=0;j<digit-level;j++) 
                    s_prime.append("(");
            else if(level > digit) 
                for(int j=0;j<level-digit;j++) 
                    s_prime.append(")");
            s_prime.append(digit);
            level = digit;
        }
        for(int i=level;i>0;i--) s_prime.append(")");
        return s_prime.toString();
    }
}