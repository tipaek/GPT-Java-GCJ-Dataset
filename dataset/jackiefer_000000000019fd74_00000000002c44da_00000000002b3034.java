import java.util.*;
import java.io.*;
class Solution
{   
    public static String charRemoveAt(String str, int p) 
    {  
        return str.substring(0, p) + str.substring(p + 1);  
   }  
  public static void main(String args[]) throws Exception
   {
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     int tcases=Integer.parseInt(br.readLine());
     for(int t=0;t<tcases;t++)
      {
       int num=Integer.parseInt(br.readLine());
       String str[]=new String[num];
       String answer;
       int maxlen=0,index=0;
       for(int q=0;q<num;q++)
       {
           str[q]=br.readLine();
           str[q]=charRemoveAt(str[q],0);
           if(str[q].length()>maxlen)
           {
               maxlen=str[q].length();
               index=q;
           }
       }
       answer=str[index];
       for(int i=0;i<num;i++)
       {
          if(answer.contains(str[i]))
          continue;
          else
          answer+=str[i];
       }
       System.out.println("Case #"+tcases+": "+answer);
      }
   }
}