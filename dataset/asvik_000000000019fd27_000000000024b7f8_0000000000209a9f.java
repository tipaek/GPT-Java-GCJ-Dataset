import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    
    public static void nestingDepth(String[] s){
        for(int a=0; a<s.length; a++){
            String res = "";
            if(s[a].charAt(0) == '0'){
                res += "0";
            }else{
                res += "(1";
            }
            for(int i=1; i<s[a].length()-1; i++){
                if(s[a].charAt(i-1) == '0' && s[a].charAt(i) == '0' && s[a].charAt(i+1) == '0'){
                    res += "0";
                }else if(s[a].charAt(i-1) == '0' && s[a].charAt(i) == '0' && s[a].charAt(i+1) == '1'){
                    res += "0(";
                }else if(s[a].charAt(i-1) == '0' && s[a].charAt(i) == '1' && s[a].charAt(i+1) == '0'){
                    res += "1)";
                }else if(s[a].charAt(i-1) == '0' && s[a].charAt(i) == '1' && s[a].charAt(i+1) == '1'){
                    res += "1";
                }else if(s[a].charAt(i-1) == '1' && s[a].charAt(i) == '0' && s[a].charAt(i+1) == '0'){
                    if(i==1){
                        res += ")0";
                    }else {
                        res += "0";
                    }
                }else if(s[a].charAt(i-1) == '1' && s[a].charAt(i) == '0' && s[a].charAt(i+1) == '1'){
                    if(i==1){
                        res += ")0(";
                    }else {
                        res += "0(";
                    }
                }else if(s[a].charAt(i-1) == '1' && s[a].charAt(i) == '1' && s[a].charAt(i+1) == '0'){
                    res += "1)";
                }else if(s[a].charAt(i-1) == '1' && s[a].charAt(i) == '1' && s[a].charAt(i+1) == '1'){
                    res += "1";
                }
            }
            if(s[a].charAt(s[a].length()-1)=='0'){
                res += "0";
            }else{
                if(s[a].length()==1){
                    res += ")";
                }else {
                    res += "1)";
                }
            }
            System.out.println("Case #" + (a+1) + ": " + res);   
        }
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] sArr = new String[q];

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();
            sArr[qItr] = s;
        }
        nestingDepth(sArr);
        scanner.close();
    }
}