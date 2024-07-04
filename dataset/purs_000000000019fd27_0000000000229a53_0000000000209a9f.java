import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import java.math.*;
import java.util.*;
import java.io.*;

public class Solution{
    static Scanner sc;
    public static void main(String[] args){
        sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int casenum = 1; casenum <= n; casenum++) {
            String num = sc.next();
            nestingDepth(num, casenum);
        }
    }
    
    public static void nestingDepth(String num, int casenum){
        int open = 0;
        StringBuilder sb = new StringBuilder();
        if(num.charAt(0) == '0') sb.append('0');
        else{
            sb.append('(');
            sb.append('1');
            open++;
        }
        for(int i=1; i<num.length(); i++){
            if(num.charAt(i) == '0'){
                while(open>0){
                    sb.append(')');
                    open--;
                }
                sb.append('0');
            }
            else if(num.charAt(i) == num.charAt(i-1)){
                sb.append(num.charAt(i));
            }
            else{
                sb.append('(');
                open++;
                sb.append('1');
            }
        }
        if(open>0) sb.append(')');
        String result = "Case #"+ casenum+": "+sb.toString();
        System.out.println(result);
    }
}