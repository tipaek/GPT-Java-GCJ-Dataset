import java.util.*;
public class Solution{
    public static void main(String []args){
      Scanner s = new Scanner(System.in); 
      int T= s.nextInt(); 
      s.nextLine();
      for(int t=1;t<=T;t++){
          String p=s.nextLine();
          StringBuilder sb= new StringBuilder();
          int depth=0;
          for(char c: p.toCharArray()){
              int dp=c-'0';
             //  System.out.println(dp+"   "+c);
             while(depth<dp){
                 sb.append("(");
                 depth++;
             } 
             while(depth>dp){
                 sb.append(")");
                 depth--;
             }
             sb.append(c);
          }
          while(depth>0){
                 sb.append(")");
                 depth--;
             }
          System.out.println("Case #"+t+": "+sb.toString());
      }
    }
}