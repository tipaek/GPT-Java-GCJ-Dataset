import java.util.*;
public class Solution
{
    static String reverse(String s)
    {
        String s1="";
        for(int i=s.length()-1;i>=0;i--)
        {
            s1 += s.charAt(i);
        }
        return s1;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n,c;
        String s[],s1[],s3,s4;
        for(int i=0;i<t;i++)
        {
            n = sc.nextInt();
            //s = sc.next();
            s = new String[n];
            s1 = new String[n];
            for(int j=0;j<n;j++)
            {
                s[j] = sc.next();
                //s1[j] = "";
            }
            for(int j=0;j<n;j++)
            {s1[j] = "";
                for(int k=0;k<s[j].length();k++)
                {
                    if(s[j].charAt(k)!='*')
                    {
                        s1[j] += s[j].charAt(k);
                    }
                }
                //System.out.println(s1[j]);
            }
            c = 0;
            for(int j=0;j<n;j++)
            {c=0;
                s3 = reverse(s1[j]);
                for(int k=0;k<n;k++)
                {
		            s4 = reverse(s1[k]);
                    if(!(s3.contains(s4)))
                    {
                        c=1;
                        break;
                    }
                }
                if(c==0)
                {
                    System.out.println("Case #"+(i+1)+": "+s1[j]);
                    break;
                }
            }
            if(c==1)
            {
                System.out.println("Case #"+(i+1)+": *");
            }
            
        }
    }
}