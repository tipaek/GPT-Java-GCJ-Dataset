import java.util.*;
class Solution
{
public static void main(String []args)
{
    Scanner s=new Scanner(System.in);
    int t=s.nextInt();
    String []str=new String[t];
    for(int i=0;i<t;i++)
    {   str[i]="";
       String s1=s.next();
       char []s2=s1.toCharArray();
       int c=1;
        int y=0;
       for(int x=0;x<s2.length;x++)
       {
          
           while(y<Integer.parseInt(String.valueOf(s2[x])) && c==1)
           {
               //System.out.print(Integer.parseInt(String.valueOf(s2[x])));
               str[i]+="(";
               y++;
               c=0;
           }
           str[i]+=s2[x];
           if(x<s2.length-1 && s2[x+1]==s2[x])
           {
              
           continue;
           }
           while(y>0 && c==0)
           {
               str[i]+=")";
               y--;
               c=1;
           }
       }
    }
    for(int i=0;i<t;i++)
    {
          System.out.println("Case #"+(i+1)+": "+str[i]);
    }
    
}
}