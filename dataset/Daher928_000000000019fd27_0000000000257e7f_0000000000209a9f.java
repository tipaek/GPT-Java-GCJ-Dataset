import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class Solution {

    static void nestingDepth(String str) {
        if (str==null || str.isEmpty()){
            return;
        }
        
        StringBuilder res= new StringBuilder();
        int opened = 0;
        
        for (int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            int digit = c - '0';
            
            if (digit == opened){
                res.append(c);
            } else if (digit < opened){
                while (opened > digit){
                    opened--;
                    res.append(")");
                }
                res.append(c);
            } else {
                while (opened < digit){
                    opened++;
                    res.append("(");
                } 
                res.append(c);
            }
        }
        
        while (opened > 0){
            res.append(")");
            opened--;
        }
        
        System.out.println(res.toString());
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String str = scanner.nextLine();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int caseNum = tItr+1;
            System.out.print("Case #"+ caseNum + ": ");
            nestingDepth(str);
        }

        scanner.close();
    }
}
