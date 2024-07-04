/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Solution{
    public static void main (String[] args) throws java.lang.Exception
    {   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++)
        {   int n=Integer.parseInt(br.readLine());
            ArrayList<String> s=new ArrayList<String>();
            for(int j=0;j<n;j++)
            {   s.add(br.readLine());
            }
            Collections.sort(s,new Comparator<String>()
                             {  public int compare(String s1,String s2)
                                {   int l1=s1.length(); 
                                    int l2=s2.length();
                                    if(l1<l2)
                                        return -1;
                                    return 1;
                                }
                             }
                            );
            //String ans=s.get(0).substring(1,);
            int len=s.get(0).length();
            int j=1;
            for(;j<n;j++)
            {   int k=s.get(j).length();
                String temp=s.get(j);
                int p1=len-1;int p2=k-1;
                while(p1>0 && p2>0)
                {   if(temp.charAt(p2)!=s.get(0).charAt(p1)){
                        //System.out.println(temp+" "+temp.charAt(m)+" "+s.get(0).charAt(m));
                        break;
                    }
                    p1--;
                    p2--;
                }
                if(p1!=0)
                    break;
            }
            if(j!=n)
            {   System.out.print("Case #"+i+": "+"*\n");
            }
            else
            {   String temp=s.get(n-1);
                int l=temp.length();
                String ans="";
                for(int z=1;z<l;z++)
                    ans=ans+temp.charAt(z);
                System.out.print("Case #"+i+": "+ans+"\n");
            }
        }
    }
}
