import java.util.*;
class Solution
{

    public static void main(String[] args)
    {
       // System.out.println();
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;i++)
        {
          int N=sc.nextInt();sc.nextLine();
          String[] P=new String[N];
          for(int j=0;j<N;j++)
          P[j]=sc.nextLine();
          int maxlen=-1;String s="";
          for(int j=0;j<N;j++)
          {            
            if(P[j].length()>maxlen)
            {maxlen=P[j].length();s=P[j];}
            }
          
          for(int j=0;j<N;j++)  
            P[j]=P[j].substring(1);            

          s=s.substring(1);int flag=1;String ans=s;
          for(int j=0;j<N;j++)
          {
            if(s.indexOf(P[j])==-1)
              {
                flag=0;break;
                }              
            }
          if(flag==0)
            ans="*";
          System.out.println("Case #"+i+": "+ans);
        }
    }
}