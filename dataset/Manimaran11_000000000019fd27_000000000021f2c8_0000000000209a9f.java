import java.io.*;
import java.util.*;

public class Solution{
    
    public static StringBuilder app(StringBuilder sb,char ch,int num){
      for(int i=0;i<num;i++){
        sb.append(ch);
      }
      return sb;
    }
    public static void main(String[] args) throws Exception {

            
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    int y=1;
    while(t>0){
        System.out.print("Case #"+y+": ");
        String s = br.readLine();
        int op;
        op=0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
          int num = Integer.parseInt(String.valueOf(s.charAt(i)));
          if(num==0){
            sb= app(sb,')',op);
            op=0;
            sb.append(s.charAt(i));
          }
          else if(op==num){
              sb.append(s.charAt(i));
          } 
          else if(op>num){
              op = op-num;
             sb= app(sb,')',op);
            sb.append(s.charAt(i));
          }
          else{
              op = num-op;
             sb= app(sb,'(',op);
            sb.append(s.charAt(i));
          } 
        }
        while(op>0){
            sb.append(')');
            op--;
          }
          System.out.print(sb.toString());
          System.out.println();
          y++;
        t--;
    }
  }
}