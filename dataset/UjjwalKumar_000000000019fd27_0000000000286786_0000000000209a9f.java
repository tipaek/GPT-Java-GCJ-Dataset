import java.util.*;
public class Solution
{
      public static void main (String args [])
      {
           Scanner sc=new Scanner(System.in);
           int t=sc.nextInt();
           String res[]=new String[t];
           for(int c=1;c<=t;c++)
           {
                String s=sc.next();
                String str="";
                int len=s.length();
                int depth=0;
                int numf=0;
                
                for(int i=0;i<len;i++)
                {
                     int num=s.charAt(i)-'0';
                     if(i==len-1)
                          numf=0;
                     else
                          numf=s.charAt(i+1)-'0';
                     for(int j=1;j<=num-depth;j++)
                     {
                            str+="(";
                      }
                      depth=num;
                      str+=s.charAt(i);
                      
                      for(int j=1;j<=depth-numf;j++)
                     {
                            str+=")";
                            
                      }
                      
                }
                res[c-1]=str;
            }
            for(int i=0;i<t;i++)
            {
                  System.out.println("Case #"+(i+1)+": "+res[i]);
            }
       }
 }