import java.io.*;
class program{
public static void main(String args[])throws IOException
{
  InputStreamReader isr = new InputStreamReader(System.in);
  BufferedReader br = new BufferedReader(isr);
  int T=Integer.parseInt(br.readLine());
  for(int k=1;k<=T;k++){
      char ch;
      int open=0;
      int close=0;
      String str="";
      int x;
      String s=br.readLine();
      for(int j=0;j<s.length();j++){
          ch = s.charAt(j);
          x= Character.getNumericValue(ch);//to be checked(character to integer conversion).
          if(open<x){
              
              for(int i=1;i<=(x-open);i++){
                  str=str+"(";
              }
              str=str+String.valueOf(x);
              open=x;
            }
          else
          if(open>x){
              
               for(int i=1;i<=(open-x);i++){
                   str=str+")";
               }
               str=str+String.valueOf(x);
               open=x;
          }
          else
          if(open==x)
              str=str+String.valueOf(x);
      }
      if(open!=0){
          for(int i=1;i<=open;i++){
              str=str+")";
          }
      }
      open=0;
      System.out.println("Case #"+k+": "+str);
   }
 }
}