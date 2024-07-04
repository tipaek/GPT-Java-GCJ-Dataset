import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 1; i<=T; ++i){
            String in = br.readLine();
            
            StringBuilder soln = new StringBuilder(); 
            
            int numOpen = 0; 
            
            for(char c : in.toCharArray()){
                int dig = Character.getNumericValue(c); 
                
                
                while(numOpen < dig){
                    soln.append('(');
                    numOpen++;
                }
                    
                while(numOpen > dig){
                    soln.append(')');
                    numOpen--;
                }
                    
                soln.append(dig);
            }
            
            while(numOpen > 0){
                soln.append(')');
                numOpen--;
            }
            
            System.out.println("Case #" + i + ": " + soln.toString());
        }
    }
}