import java.util.Scanner;
public class Solution
{
    public static void main(String s[])
    {
        Scanner sc=new Scanner(System.in);int d;
        int t=sc.nextInt();int l;String str;int ct[];
        String op="(((((((((";String cl=")))))))))";String res;
        for(int t1=0;t1<t;t1++)
        {
            res="";
            str=sc.next();l=str.length();
            ct=new int[l];ct[0]=(int)str.charAt(0)-48;
            for(int i=1;i<l;i++)
            {
                d=(int)str.charAt(i)-(int)str.charAt(i-1);
                ct[i]=ct[i-1]+d;
            }
            if(ct[0]>0) res+=op.substring(0,ct[0]);res+=str.charAt(0);
            for(int i=1;i<l;i++)
            {
                d=ct[i]-ct[i-1];
                if(d>0) res+=op.substring(0,d);
                else if(d<0) res+=cl.substring(0,-d);
                res+=str.charAt(i);
            }
            if(ct[l-1]>0) res+=cl.substring(0,ct[l-1]);
            System.out.println("Case #"+(t1+1)+": "+res);
        }
    }
}