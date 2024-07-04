import java.util.*;
import java.io.*;

class nestingDepth
{
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        int T=s.nextInt();
        for(int t=1;t<=T;t++)
        {
            String str=s.next();
            String res="";
            for(int i=0;i<str.charAt(0)-48;i++)
            res+="(";
            res+=Character.toString((str.charAt(0)));
            for(int i=0;i<str.charAt(0)-48;i++)
            res+=")";
            for(int i=1;i<str.length();i++)
            {
                int x=Integer.parseInt(str.substring(i,i+1));
                if(x==0) res+=Integer.toString(x);
                else
                {
                    int j=0;
                    String tmp=Integer.toString(x);
                    while(j<x && res.length()-j-1>=0 &&res.charAt(res.length()-j-1)==')') j++;
                    for(int p=j;p<x;p++)  tmp="("+tmp+")";
                    res=res.substring(0,res.length()-j)+tmp+res.substring(res.length()-j);
                }
            }
            System.out.println("Case #"+Integer.toString(t)+": "+res);
        }
        s.close();
    }
}