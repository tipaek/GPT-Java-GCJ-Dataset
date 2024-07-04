import java.util.Scanner; 
import java.io.*; 
import java.util.Arrays; 
import java.util.*;
 
public class Solution{

 

public static void main(String[] args){
    Scanner sc = new Scanner(System.in);  
    
    int tests = sc.nextInt();

     
    for(int test = 1; test <= tests; test++){
        String s = sc.next();
        int open = 0;
        String result = "";
      
        for(int i = 0; i < s.length(); i++){
            int curr = Character.getNumericValue(s.charAt(i));
            int toopen = curr - open;

            
            if(toopen > 0){
                for(int k = 0; k < toopen; k++){
                  result = result + '(';
                  open++;
                }
            }

            if(toopen < 0){
                for(int k = 0; k < Math.abs(toopen); k++){
                  result =result + ')';
                  open--;
                }
            }
            result = result + curr;

            if(i == s.length() - 1 && open != 0){
                for(int k = 0; k < open; k++)
                  result = result + ')';

            }

            
          }

         System.out.println("Case #" + test + ": " + result);
         } 



    }


    
    

  }
    
     
