import java.io.*;
import java.util.*;
class Solution
{
public static void main(String[] args) 
{
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
        int n=sc.nextInt();
           int s[]=new int[n];
           HashMap<Integer,Integer>end=new HashMap<Integer, Integer>();
            HashMap<Integer,Integer>index=new HashMap<Integer, Integer>();
            StringBuilder sb=new StringBuilder("");
            sb.append("Case #"+(i+1)+": ");
           for(int j=0;j<n;j++)
           {
               s[j]=sc.nextInt();
               int e=sc.nextInt();
               end.put(s[j],e);
               index.put(s[j],j);

           }
           Arrays.sort(s);
           int ct=0;
           int jt=0;
           int f=1;
           char ch[]=new char[n];
           for(int j=0;j<n;j++)
           {
               if(ct<=s[j])
               {
                   ct=end.get(s[j]);
                   ch[index.get(s[j])]='C';
               }
               else if(jt<=s[j])
               {
                   jt=end.get(s[j]);
                   ch[index.get(s[j])]='J';
               }
               else
               {
                   f=0;
                   break;
               }

           }
           if(f==0)
           {
               sb.append("IMPOSSIBLE");
           }
           else
           {
               String ans="";
               for(int j=0;j<n;j++)
               {
                   ans=ans+ch[j];
               }
               sb.append(ans);
           }
           System.out.println(sb);



    }
}
}