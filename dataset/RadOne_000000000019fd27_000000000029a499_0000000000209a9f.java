import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int j=0;j<t;j++)
        {
            String s=sc.next();
            if(s.length()==1)
            {
                if(s.charAt(0)=='0')
                     System.out.println("Case #"+(j+1)+": "+s);
                else
                     System.out.println("Case #"+(j+1)+": "+"(1)");
            }
            else
            {
              StringBuilder sb=new StringBuilder();
            int prev=0;
            for(int i=0;i<s.length();i++)
            {
                if(s.charAt(i)=='0')
                {
                 if(prev==0)
                    sb.append("0");
                 else
                    sb.append(")0");
                }
                if(s.charAt(i)=='1')
                {
                    if(i==0)
                        sb.append("(1");
                    else if(i==s.length()-1)
                    {   if(prev==1)
                        sb.append("1)");
                        else
                            sb.append("(1)");
                    }
                    else
                    {
                    if(prev==1)
                        sb.append("1");
                    if(prev==0)
                        sb.append("(1)");
                    }
                }
                prev=s.charAt(i)-48;
            }
             System.out.println("Case #"+(j+1)+": "+sb); 
            }
            
        }
    }
}