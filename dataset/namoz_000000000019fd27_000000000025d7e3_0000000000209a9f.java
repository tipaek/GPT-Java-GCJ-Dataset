import java.util.*;
import java.io.*;

public class Solution{

    public static void solve(int test, String sequence){
        int currentNumber = 0;
        
        StringBuilder result = new StringBuilder();
        
        for(int i = 0; i < sequence.length(); i++){
            int digit = sequence.charAt(i) - '0';
            int diff = Math.abs(currentNumber - digit);
            
            if(diff > 0){
                if(digit < currentNumber){
                    while(diff > 0){
                        result.append(')');
                        diff--;
                    }
                }else{
                    while(diff > 0){
                        result.append('(');
                        diff--;
                    }
                }
            }
            
            currentNumber = digit;
            result.append(digit);
        }
        
        while(currentNumber > 0){
            result.append(')');
            currentNumber--;
        }
        
        System.out.println("Case #" + test + ": " + result.toString());
    }

    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        
        for(int i = 0; i < t; i++){
            String sequence = in.next();
            
            solve(i + 1, sequence);
        }
    }

}