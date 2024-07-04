import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        int counter=1;
        while(t-->0)
        {
            String s=in.next();
            String ans=fun(s);
             System.out.println("Case #"+counter+": "+ans);
             counter++;
        }
    }
    public static String fun(String s)
    {
       String str="";
       int n=s.length();
       int noP=0;
       int noPa=0;
    
      for(int i=0;i<n;i++)
      {
          noPa=(s.charAt(i)-'0')-noP;
          if(noPa>=0)
          {
              for(int j=0;j<noPa;j++)
              {
                  str+="(";
                  noP++;
                   
              }
          }
          else
          {
              for(int k=0;k<Math.abs(noP);k++)//changed
              {
                  str+=")";
                  noP--;
              }
          }
          str+=s.charAt(i);
      }
      if(noP>0)
      {
          for(int l=0;l<noP;l++)
          {
              str+=")";
          }
      }
    
       return str;
    }
         
    
}