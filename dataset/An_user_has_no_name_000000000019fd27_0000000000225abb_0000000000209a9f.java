import java.util.*;
import java.io.*;
public class Solution 
{
  public static void main(String[] args) throws Exception
  {
    int i,j,k,r=0,c,a,b=0,p=0;
    BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
    int t =Integer.parseInt(in.readLine());
    a=1;
    while(t-->0)
    {
      char ch[]=in.readLine().toCharArray();
      String sb="";
      for(i=0;i<ch.length;i++)
      {
          if(i==0)
          {
              p=ch[i]-48;
              b=p;
              for(j=0;j<p;j++)
              {
                  sb+="(";
              }
          }
          else
          {
              r=ch[i]-48;
              if(r==p)
              {
                  sb+=p;
              }
              else if(r<p)
              {
                  sb+=p;
                  for(j=0;j<(p-r);j++)
                  {
                      sb+=")";
                  }
                  b-=(p-r);
              }
              else
              {
                  sb+=p;
                  for(j=0;j<(r-p);j++)
                  {
                      sb+="(";
                  }
                  b+=(r-p);
              }
              p=r;
          }
          if(i==ch.length-1)
          {
              if(ch.length!=1)
                sb+=r;
              else
                sb+=p;
              for(j=0;j<b;j++)
              {
                  sb+=")";
              }
          } 
      }
      System.out.println("Case #" + a++ + ": " + sb );
    }
  }
}