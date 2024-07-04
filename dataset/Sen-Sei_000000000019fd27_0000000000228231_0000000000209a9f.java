import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i =1;i<=T;i++){
            String S = "";
            String input = br.readLine();
            //System.out.println("Current String " + input);
            int currentDepth = 0;
            for(int j = 0;j< input.length(); j++){
                int currentDigit = Character.getNumericValue(input.charAt(j));
                // System.out.println(currentDigit);
                if(currentDepth == currentDigit){
                    S += Integer.toString(currentDigit);
                }
                if(currentDepth < currentDigit){
                    for(int k=currentDepth;k<currentDigit;k++){
                        S += "(";
                        currentDepth++;
                    } 
                    S += Integer.toString(currentDigit);
                }
                if(currentDepth > currentDigit){
                    for(int k=currentDepth;k>currentDigit;k--){
                        S += ")";
                        currentDepth--;
                    }
                    S += Integer.toString(currentDigit);       
                }
                
            }
            if(currentDepth != 0){
                for(int k=currentDepth;k>0;k--){
                        S += ")";
                    } 
            }
            System.out.println("Case #"+i+" "+S);
        }
    }

}
