import java.util.*;
import java.io.*;
import java.lang.*; 

public class Solution{
    public static void main(String[] args){
         Scanner in = new Scanner(System.in);
         int n = in.nextInt();
         String ml = in.nextLine();
         for(int k = 0; k<n;k++){
            String s = in.nextLine(); 
            StringBuffer str =  new StringBuffer(s);
            int start = -1;
            int correct = 0;
            for(int i = 0; i< s.length();i++){
                if(start == -1){
                    if(s.charAt(i) == '1'){
                        start = i;
                    }
                }else if(s.charAt(i) == '0'){
                    str.insert(i+correct,")");
                    str.insert(start+correct, "(");
                    start = -1;
                    correct += 2;
                }
            }
            if(start != -1){
              str.insert(s.length()+correct,")");
              str.insert(start+correct, "(");
            }
            System.out.println("Case #" + (k+1) + ": " + str);
         }
    }
}