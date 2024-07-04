import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution{

    public static String sol(String a){
        String res="";
        int open=0;
        for(char c:a.toCharArray()){
            int val=Character.getNumericValue(c);
            
            if(open==val){
                res+=val+"";
            }else if(open<val){
                int diff=val-open;
                for(int i=0;i<diff;i++){
                    res+="(";
                }
                open+=diff;
                res+=val+"";
            }else{
              int diff=open-val;
                for(int i=0;i<diff;i++){
                    res+=")";
                } 
                open-=diff;
                res+=val+"";
            }
         
        }
        
        while(open>0){
            res+=")";
            open--;
        }
        
        return res;
    }
    
    public static void main(String[] args){
         Scanner in=new Scanner(System.in);
        
        int t=in.nextInt();
         for(int i=0;i<t;i++){
            String input=in.next();
            System.out.println(sol(input));
         }
    }
}