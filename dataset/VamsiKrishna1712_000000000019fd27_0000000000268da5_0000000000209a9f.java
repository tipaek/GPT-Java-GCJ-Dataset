import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            String res="";
            String s=sc.next();
            int c=0;
            for(int j=0;j<=s.length();j++)
            {
                if(j==s.length() && res.charAt(res.length()-1)=='1')
                {
                    res=res+')';
                    break;
                }
                else if(j==s.length() && res.charAt(res.length()-1)=='0')
                {
                    break;
                }
                else if(s.charAt(j)=='0' && c!=0 && res.charAt(res.length()-1)=='1')
                {
                    res=res+')';
                    res=res+s.charAt(j);
                }
                else if(s.charAt(j)=='0' )
                {
                    res=res+s.charAt(j);
                }
                
                else if(s.charAt(j)=='1' && c!=0 && res.charAt(res.length()-1)=='0')
                {
                    res=res+'(';
                    res=res+s.charAt(j);
                }
                else if(s.charAt(j)=='1' && c!=0)
                {
                    res=res+s.charAt(j);
                }
                else if(s.charAt(j)=='1' && c==0)
                {
                    res=res+'(';
                    res=res+s.charAt(j);
                    c=1;
                }
            }
            System.out.println("Case #"+(i+1)+": "+res);
        }
    }
}