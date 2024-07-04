import java.io.*;
import java.lang.*;
import java.util.*;

  public class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int  t= in.nextInt();
        for(int j=0; j<t; j++){
            
            int x= in.nextInt();
           
            
            
            
            
            
            
            
            System.out.println("Case #"+(j+1)+": "+solve(x,in));
        }
        
    }
    
    public static String solve(int x,Scanner in) {
       String ans="";
       String m;
       String code;
       Character ch;
       String input="";
       Long val;
       HashMap<Character,Long> rule=new HashMap<>();
      for(int i=0;i<Math.pow(10,4);i++){
          m=in.next();
          code=in.next();
          
          if(m.length()==code.length()){
              ch=code.charAt(0);
              val=rule.get(ch);
              input+=code;
              if(val==null){
                    rule.put(ch,Long.parseLong(""+m.charAt(0)));
              }
              else if(val!=null&&val>Long.parseLong(m)){
                  rule.put(ch,Long.parseLong(m));
              }
              
          }
          
      }
      char[] charac=new char[10];
      long[] values= new long[10];
      
            
      int top=0;
      for (Character key : rule.keySet()) {
         // System.out.println(key);
          
		    charac[top]=key;
		    values[top]=rule.get(key);
		    top++;
		}
      long temp;
      char ctemp;
      for(int i=0;i<10;i++){
          for(int j=0;j<10-i-1;j++){
              if(values[j]>values[j+1]){
                  temp=values[j];
                  ctemp=charac[j];
                  values[j]=values[j+1];
                  charac[j]=charac[j+1];
                  values[j+1]=temp;
                  charac[j+1]=ctemp;
                  
              }
          }
      }
      
      for(char c: charac){
          ans+=""+c;
      }
      
      for(char c: input.toCharArray()){
          if(!ans.contains(""+c)){
              ans=c+ans;
          }
      }
       return ans;
    }
 }






