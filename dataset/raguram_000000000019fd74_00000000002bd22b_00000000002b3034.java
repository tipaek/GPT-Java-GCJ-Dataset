import java.util.*;
class PatternMatching
{
    public static Scanner sc=new Scanner(System.in);
    public static void main(String args[])
    {
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            try11(t);
        }
    }
    public static void try11(int t)
    {
        int n=sc.nextInt();
        String s[]=new String[n];
        int l=0,r=0;
        for(int i=0;i<=n;i++)
        {
            if(i!=0)
            {
                s[i-1]=sc.nextLine();
                if(s[i-1].length()>=s[l].length())
                    l=i-1;
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<s[i].length();j++)
            {
                if(s[i].charAt(j)=='*')
                {
                    r=try12(l,j,i,s);
                    j=s[i].length()+1;
                    if(r==0&&t!=0)
                    {
                        System.out.println("Case #"+t+": *");
                        t=0;
                    }
                }
            }
        }
        if(t!=0)
            {
                System.out.println("case #"+t+": ");
                for(int i=0;i<s[l].length();i++)
                {
                    if(s[l].charAt(i)!='*')
                        System.out.print(s[l].charAt(i));
                }
            }
    }
    public static int try12(int l,int j,int i,String s[])
    {
        if(j!=0&&s[l].charAt(0)!='*')
        {
            if(s[i].substring(0,j)!=s[l].substring(0,j))
                return 0;
        }
        if(s[i].charAt(s[i].length()-1)!='*'&&s[l].charAt(s[l].length()-1)!='*')
        {
            if(s[i].substring(j+1,s[i].length())!=s[l].substring(s[l].length()-s[i].length(),s[l].length()))
                return 0;
        }
        return 1;
    }
}