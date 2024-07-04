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
            int correct = 0;
            for(int i = 0; i< s.length();){
                char digit = s.charAt(i);
                int f = 0;
                for(int j = i+1; j<s.length(); j++){
                    if(s.charAt(j) != s.charAt(i)){
                        f = j-(i+1);
                        break;
                    }
                }
                int dig = Character.getNumericValue(digit);
                if (digit != '0'){
                    String rig = ")";
                    for(int b = 0; b< dig-1;b++){
                        rig += ")";
                    }
                    str.insert(i+correct+1+f, rig);
                    String left = "(";
                    for(int b = 0; b< dig-1;b++){
                        left += "(";
                    }
                    str.insert(i+correct, left);
                }
                correct+=dig*2;
                i = i +1 +f;
                
            }
            System.out.println("Case #" + (k+1) + ": " + str);
         }
    }
}