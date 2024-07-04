import java.util.*;
import java.io.*;
import java.lang.*; 

public class Solution{
    public static void main(String[] args){
         Scanner in = new Scanner(System.in);
         int n = in.nextInt();
         for(int k = 0; k<n;k++){
            String s = in.nextLine();  
            StringBuffer str =  new StringBuffer(s);
            int correct = 0;
            for(int i = 0; i< s.length();){
                char digit = s.charAt(i);
                int f = 0;
                for(int j = 0; j<s.length(); j++){
                    if(s.charAt(j) != s.charAt(i)){
                        f = j;
                        break;
                    }
                }
                if (digit != '0'){
                    String rig = ")";
                    for(int b = 0; b< digit-1;b++){
                        rig += ")";
                    }
                    str.insert(i+correct+1+f, rig);
                    String left = "(";
                    for(int b = 0; b< digit-1;b++){
                        left += "(";
                    }
                    str.insert(i+correct, left);
                }
                correct+=digit*2;
                i = i +1 +f;
                
            }
            System.out.println("Case #" + (k+1) + ":" + str);
         }
    }
}