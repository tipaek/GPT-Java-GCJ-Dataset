import java.util.*;
public class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
     int t = Integer.valueOf(sc.nextLine());
     int testCase = 1;
     while(t-->0){
        
      String s = sc.nextLine();
      StringBuilder sb = new StringBuilder();
      char pch = '2';
      for(int i=0;i<s.length();i++){
          if(s.charAt(i)=='1'){
              if(pch=='2'||pch=='0'||pch==')'){
                  sb.append("(");
                  sb.append("1");
              }else{
                  sb.append("1");
              }
              pch = '1';
          }else{
              if(pch=='1'){
                  sb.append(")");
              }
              pch ='0';
              sb.append("0");
          }
      }
       if(pch=='1'){
                  sb.append(")");
              }
            System.out.println("Case #"+testCase+": "+sb.toString());
        

         testCase++;
         
     }
   
    }
}