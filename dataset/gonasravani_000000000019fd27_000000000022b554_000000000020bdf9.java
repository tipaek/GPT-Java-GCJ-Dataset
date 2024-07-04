import java.util.*;
class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int ca=1;ca<=t;ca++)
        {
            int n=sc.nextInt();
            int[][] a=new int[n][2];
            for(int i=0;i<n;i++)
            {
                a[i][0]=sc.nextInt();
                a[i][1]=sc.nextInt();
            }
            char[] c=new int[n];
            boolean imp=false;
            for(int i=0;i<c;i++)
            {
                boolean c=true,ja=true;
                for(int j=0;j<i;j++)
                {
                    if(overlapping(a[i],a[j]))
                    {
                        if(c[j]=='C')
                            c=false;
                        else ja=false;
                    }
                }
                if(c) c[i]='C';
                else if(ja) c[i]='J';
                else{
                    imp=true;
                    break;
                }
            }
            System.out.print("Case #"+ca+": ");
            if(imp)
                System.out.println("IMPOSSIBLE");
            else System.out.println(String.valueOf(c));
        }
    }
    public static boolean overlapping(int[] a,int[] b)
    {
        if(a[0]<b[0] && a[1]<=b[0])
            return true;
        if(b[0]<a[0] && b[1]<=a[0])
            return true;
        return false;
    }
}