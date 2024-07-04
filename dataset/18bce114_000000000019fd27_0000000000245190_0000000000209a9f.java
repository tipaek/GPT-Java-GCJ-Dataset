import java.util.*;
import java.lang.Math;
public class Solution
{   
    public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    int t,op,cl;
    t=in.nextInt();
    String s,s1;
    for(int i=0;i<t;i++)
    {
        s=in.next();
        op=((int)(s.charAt(0))-48);
        cl=((int)(s.charAt(s.length()-1))-48);
        s1="";
        for(int j=0;j<op;j++)
        {
            s1+="(";
        }
        s1+=s.charAt(0);
        for(int j=0;j<s.length()-1;j++)
        {
            op=((int)(s.charAt(j))-48);
            cl=((int)(s.charAt(j+1))-48);
            if(op==cl)
            {
                s1=s1+s.charAt(j+1);
            }
            else if(op<cl)
            {
                for(int k=0;k<cl-op;k++)
                {
                    s1+="(";
                }
                 s1=s1+s.charAt(j+1);
            }
            else if(op>cl)
            {
                for(int k=0;k<op-cl;k++)
                {
                    s1+=")";
                }
                 s1=s1+s.charAt(j+1);
            }
        }
        for(int j=0;j<cl;j++)
        {
            s1+=")";
        }
        System.out.println("Case #"+(i+1)+": "+s1);
    }
}
}