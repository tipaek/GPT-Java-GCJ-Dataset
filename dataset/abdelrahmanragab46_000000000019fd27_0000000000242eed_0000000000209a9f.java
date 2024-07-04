import java.lang.*;
import java.util.*;
import java.io.*;

public class Solution {
  
    
    public static void main (String [] args){
        
        //Scanner
        Scanner input = new Scanner(System.in);
        
        char a = '(';
        char b = ')';
        
        
        int T = input.nextInt();    //test cases
        
        for(int i=0; i<T; i++){
            
            StringBuilder sb = new StringBuilder();
            
            String S = input.next();
            
            char [] s = S.toCharArray();
            
            for(int j =0; j<s[0]-48; j++)   //first digit opening parenthesis
                sb.append(a);
            
            sb.append(s[0]);    //first digit
            
            for(int j=0; j<S.length()-1; j++){
                
                if(s[j+1] == s[j])
                    sb.append(s[j+1]);
                
                else if(s[j+1] > s[j]){
                    for(int k=0; k<s[j]-48; k++)
                        sb.append(b);
                    for(int k =0; k<s[j+1]-48; k++)
                        sb.append(a);
                    sb.append(s[j+1]);
                }
                
                else{
                    for(int k =0; k<s[j]-s[j+1]; k++)
                        sb.append(b);
                    sb.append(s[j+1]);
                }
            }
            
            for (int j=0; j<s[s.length-1]-48; j++)
                sb.append(b);
            
            int x = i+1;
            String y = sb.toString();
            
            System.out.println("Case #" + x + ": " + y);
        }
    }
}
