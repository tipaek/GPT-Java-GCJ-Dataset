import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    
    public static void nestingDepth(int t, String s){
        String res = "";
        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i) == '0' && s.charAt(i+1) == '0'){
                res += "0";
            }else if(s.charAt(i) == '0' && s.charAt(i+1) == '1'){
                res += "0(";
            }else if(s.charAt(i) == '1' && s.charAt(i+1) == '0'){
                if(i==0){
                    res += "(1)";
                }else{
                    res += "1)";
                }
            }else if(i > 0 && s.charAt(i-1) == '1' && s.charAt(i) == '1' && s.charAt(i+1) == '1'){
                res += "1";
            }else if(s.charAt(i) == '1' && s.charAt(i+1) == '1'){
                res += "(1";
            }
        }
        if(s.charAt(s.length()-1)=='0'){
            res += "0";
        }else{
            if(s.length()==1){
                res += "(1)";
            }else {
                res += "1)";
            }
        }
        System.out.println("Case #" + t + ": " + res);
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            nestingDepth(qItr+1, s);
        }

        scanner.close();
    }
}