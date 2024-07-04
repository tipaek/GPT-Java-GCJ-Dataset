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
           int end[]=new int[n];
            HashMap<Integer,Integer>hm=new HashMap<Integer, Integer>();
            HashMap<Integer,Integer>index=new HashMap<Integer, Integer>();
           for(int j=0;j<n;j++)
           {
               int s=sc.nextInt();
               end[j]=sc.nextInt();
               hm.put(end[j],s);
               index.put(end[j],j);
           }
           Arrays.sort(end);
           StringBuilder sb=new StringBuilder("");
           sb.append("Case #"+(i+1)+": ");

           char ch[]=new char[n];
           String ans="";

           int rs=-1;
            int f=1;
            int c=1;
            int ind=0;
            ch[index.get(end[ind])]='C';

            HashMap<Integer,Integer>del=new HashMap<Integer, Integer>();
            
            del.put(ind,1);
           for(int j=1;j<n;j++)
           {
               if(hm.get(end[j])>=end[ind])
               {
                   c++;
                   del.put(j,1);
                   ind=j;
                   ch[index.get(end[j])]='C';


               }
               else if(rs==-1)
               {
                   rs=j;

               }

           }


            if(rs!=-1)
            {
                ind=rs;
                c++;
            ch[index.get(end[ind])]='J';
            for(int j=ind+1;j<n;j++)
            {
                if(del.get(j)==null)
                {

                    if (hm.get(end[j]) >= end[ind])
                    {
                        c++;

                        ind = j;
                        ch[index.get(end[j])] ='J';


                    }
                }

            }}

           if(c!=n)
               sb.append("IMPOSSIBLE");
           else
           {

               for(int j=0;j<n;j++)
               {
                 ans+=ch[j];
               }
               sb.append(ans);

           }
           System.out.println(sb);
    }
}
}