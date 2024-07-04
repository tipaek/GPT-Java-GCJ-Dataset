import java.util.*;

public class Solution 
{
    public static void main(String[] args) {
        // TODO code application logic here
         Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();
        for(int ii=0; ii<t; ii++)
        {
            int n = in.nextInt();
            int a[] = new int[n*2]; 
            for(int i=0; i<n; i++)
            {
                a[i] = in.nextInt();
                a[i+n] = in.nextInt();
            }
            char s[] = new char[n];
            IA(s);
            int j[]= new int[2];
            int jn=0;
            int c[]=new int[2];
            int cn=0;
            for(int k=0; k<n; k++)
            {
                if(jn == 0)
                {
                    j[1] = a[k+n];
                    j[0] = a[k];
                    s[k]='J';
                    jn++;
                    continue;
                }
                if(a[k]<j[0] && a[k+n]<=j[0])
                {
                    j[1] = a[k+n];
                    j[0] = a[k];
                    s[k]='J';
                    jn++;
                    continue;
                }
                if(a[k]>=j[1])
                {
                    j[1] = a[k+n];
                    j[0] = a[k];
                    s[k]='J';
                    jn++;
                    continue;
                }
                if(a[k]<c[0] && a[k+n]<=c[0])
                {
                    c[1] = a[k+n];
                    c[0] = a[k];
                    s[k]='C';
                    cn++;
                    continue;
                }
                if(a[k]>=c[1])
                {
                    c[1] = a[k+n];
                    c[0] = a[k];
                    s[k]='C';
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
                System.out.println("Case #"+(ii+1)+": "+Cs(s));
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
    public static void IA(char a[])
    {
        for(int i=0; i<a.length; i++)
        {
            a[i]='0';
        }
    }
}