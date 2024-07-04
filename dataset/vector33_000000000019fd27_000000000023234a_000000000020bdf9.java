import java.util.*;
class Solution
{
    public static String partner(int s[], int f[], int n) 
    { 
        int i, j; 
        i = 0; 
        char a[]=new char[n];
        a[0]='J';
        for (j = 1; j < n; j++) 
        { 
            if (s[j] >= f[i]) 
            { 
               a[j]='J';
                i = j; 
            } 
        }
        int c=0;
        for(int k=0;k<n;k++)
        {
            if(a[k]=='J')
                c++;
        }
        if(c==1)
            return "IMPOSSIBLE";
        for(int k=0;k<n;k++)
        {
            if(a[k]!='J')
                a[k]='C';
        }
        return new String(a);
    }
    public static void main(String s[])
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        int x=1;
        while(x++<=t)
        {
            int n=sc.nextInt();
            int a[]=new int[n];
            int b[]=new int[n];
            for(int i=0;i<n;i++)
            {
                a[i]=sc.nextInt();
                b[i]=sc.nextInt();
            }
            System.out.println("Case #"+(x-1)+": "+partner(a,b,n));
        }
    }
}