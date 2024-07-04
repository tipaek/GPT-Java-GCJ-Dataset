import java.util.*;

public class Solution 
{
    public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();
        for(int ii=0; ii<t; ii++)
        {
            int n = in.nextInt();
            //int a[] = new int[n*2]; 
            char ss[] = new char[n];
            //IA(s);
            int j[]= new int[2];
            int jn=0;
            int c[]=new int[2];
            int cn=0;
            for(int i=0; i<n; i++)
            {
                int s = in.nextInt();
                int e = in.nextInt();
                if(jn == 0)
                {
                    j[1] = e;
                    j[0] = s;
                    ss[i]='J';
                    jn++;
                    continue;
                }
                if(s<j[0] && e<=j[0])
                {
                    j[1] = e;
                    j[0] = s;
                    ss[i]='J';
                    jn++;
                    continue;
                }
                if(s>=j[1])
                {
                    j[1] = e;
                    j[0] = e;
                    ss[i]='J';
                    jn++;
                    continue;
                }
                if(e<c[0] && e<=c[0])
                {
                    c[1] = e;
                    c[0] = s;
                    ss[i]='C';
                    cn++;
                    continue;
                }
                if(s>=c[1])
                {
                    c[1] = e;
                    c[0] = s;
                    ss[i]='C';
                    cn++;
                    continue;
                }
            }
            if(cn+jn!=n)
            {
                System.out.println("Case #"+(ii+1)+": IMPOSSIBLE");
            }
            else
            {
                System.out.println("Case #"+(ii+1)+": "+ Cs(ss));
            }
        }
	}
	public static String Cs(char a[])
    {
        String s="";
        for(int i=0; i<a.length; i++)
        {
            s+=a[i];
        }
        return s;
    }
}