import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1 ; t <= T ; t++){
            String s = sc.next();
            System.out.print("Case #" + t + ": ");
            for(int i = 0 ; i < s.length() ; i++){
                char c = s.charAt(i);
                int digit = c - '0';
                validateDigit(digit);
                if(i == 0){
                    if(digit == 0)
                        System.out.print(c);
                    else{
                        System.out.print('(');
                        System.out.print(c);
                    }
                }else{
                    char pc = s.charAt(i - 1);
                    int prevDigit = pc - '0';
                    validateDigit(prevDigit);
                    if(digit == prevDigit){
                        System.out.print(c);
                    }else if(digit > prevDigit){
                        System.out.print('(');
                        System.out.print(c);
                    }else if(digit < prevDigit){
                        System.out.print(')');
                        System.out.print(c);
                    }
                }
            }
            if(s.charAt(s.length() - 1) == '1')
                System.out.println(')');
            else
                System.out.println();
        }
    }

    private static void validateDigit(int n){
        assert n >= 0 && n < 2;
    }
}