import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        int t = Integer.parseInt(s.nextLine());
      forloop:  for (int ii = 1; ii <= t; ii++) {
             String s1 = s.nextLine();
             String res = "";
             int cL=0;
             if (s1.length() == 1){
                 for(int i=0; i < Integer.parseInt("" + s1.charAt(0)); i++){
                     res = res + "(";
                 }
                 res = res + s1.charAt(0);
                 for(int i=0; i < Integer.parseInt("" + s1.charAt(0)); i++){
                     res = res + ")";
                 }
                 System.out.println("Case #" +  ii + ": " + res);
                 continue forloop;
             }
             for(int i=0; i < s1.length()-1; i++){
//                 if (s1.charAt(i) == '0'){
//                     res = res + "0";
//                 }
//                 if (i ==0 && s1.charAt(i) == '1'){
//                     res = res + "(1";
//                 }
//                 if (i > 0 && s1.charAt(i-1) == '0' && s1.charAt(i) == '1'){
//                     res = res + "(1";
//                 }
//                 if (i > 0 && s1.charAt(i-1) == '1' && s1.charAt(i) == '1'){
//                     res = res + "1";
//                 }
//                 if (i >= 0 && s1.charAt(i) == '1' && i+1 < s1.length() && s1.charAt(i+1) == '0' ){
//                     res = res + ")";
//                 }
//                 if (i >= 0 &&  s1.charAt(i) == '1' && i == s1.length() - 1){
//                     res = res + ")";
//                 }
                 if (i == 0 && s1.charAt(i) == '0'){
                     res = res + "0";
                 }
                 if (i ==0 && s1.charAt(i) >= '1'){
                     for(int j=0; j < Integer.parseInt("" + s1.charAt(i));j++)
                    res = res + "(";
                     res = res + s1.charAt(i);
                     cL = cL + Integer.parseInt("" + s1.charAt(i));
                 }
                 if (s1.charAt(i+1) > s1.charAt(i)){
                     for(int j=0; j < Integer.parseInt("" + (s1.charAt(i+1) - s1.charAt(i)));j++)
                         res = res + "(";
                     res = res + s1.charAt(i+1);
                     cL = cL + Integer.parseInt("" + (s1.charAt(i+1) - s1.charAt(i)));
                 }
                 if (s1.charAt(i+1) < s1.charAt(i)){
                     for(int j=0; j < Integer.parseInt("" + (s1.charAt(i) - s1.charAt(i+1)));j++)
                         res = res + ")";
                     res = res + s1.charAt(i+1);
                     cL = cL - Integer.parseInt("" + (s1.charAt(i) - s1.charAt(i+1)));
                 }
                 if (s1.charAt(i+1) == s1.charAt(i)){
                     res = res + s1.charAt(i+1);
                 }
             }
             if (s1.charAt(s1.length() - 1) >= '1'){
                 for(int i=cL; i>=1;i--)
                 res = res + ")";
             }

            System.out.println("Case #" +  ii + ": " + res);
        }
    }
}
