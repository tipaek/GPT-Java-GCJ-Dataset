import java.util.*;
import java.io.*;

class Solution{
    public static String nestParenthesis(String s){
        String res="";
        int[] numbers = new int[s.length()];
        for(int i=0;i<s.length();i++){
            int num = Character.getNumericValue(s.charAt(i));
            numbers[i]=num;
        }
        for(int i=0;i<numbers.length;i++){
          
          if(numbers[i] == 0){
            if(i>0 && res.charAt(res.length()-1)=='1'){
              res+=')';
            }
            res+="0";
            continue;
          }
          if(numbers[i]==1){
            if(res.length() ==0){
              res+='(';
              res+='1';
              if(i==numbers.length-1){
                res+=')';
              }
              continue;
            }
            if(res.charAt(res.length()-1)=='('){
              res+='1';
            }else{
              if(res.charAt(res.length()-1)=='1'){
                res+='1';
                continue;
              }
              res+='(';
              res+='1';
              if(i==numbers.length-1){
                res+=')';
              }
            }
          }
          
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
          String s = in.next();
          String res = nestParenthesis(s);
          System.out.println("Case #" + i + ": "+res);
        }
        in.close();
      }
}