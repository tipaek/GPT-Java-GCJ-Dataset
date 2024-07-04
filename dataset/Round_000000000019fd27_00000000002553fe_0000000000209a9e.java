import java.util.*;
import java.io.*;

class Solution{
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        String[] tb = scanner.next().split(" ");
        
        for(int i = 0 ; i < Integer.parseInt(tb[0]) ; i++){
            
            String p;
            for(int j = 1 ; j < Integer.parseInt(tb[1]) ; j++){
                
                p = Integer.toString(j);
                System.out.println(p);
                System.out.flush();
                
                String result = scanner.next();
            }
            String result = "1110110000";
            System.out.println(result);
            System.out.flush();
            String answer = scanner.next();
            if(answer.equals("N")) return;
        }
        
        return;
    }
}