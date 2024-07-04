import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        int t = Integer.parseInt(s.nextLine());
        for (int ii = 1; ii <= t; ii++) {
             String s1 = s.nextLine();
             String res = "";
             for(int i=0; i < s1.length(); i++){
                 if (s1.charAt(i) == '0'){
                     res = res + "0";
                 }
                 if (i ==0 && s1.charAt(i) == '1'){
                     res = res + "(1";
                 }
                 if (i > 0 && s1.charAt(i-1) == '0' && s1.charAt(i) == '1'){
                     res = res + "(1";
                 }
                 if (i > 0 && s1.charAt(i-1) == '1' && s1.charAt(i) == '1'){
                     res = res + "1";
                 }
                 if (i >= 0 && s1.charAt(i) == '1' && i+1 < s1.length() && s1.charAt(i+1) == '0' ){
                     res = res + ")";
                 }
                 if (i >= 0 &&  s1.charAt(i) == '1' && i == s1.length() - 1){
                     res = res + ")";
                 }
             }
            System.out.println("Case #" +  ii + ": " + res);
        }
    }
}
