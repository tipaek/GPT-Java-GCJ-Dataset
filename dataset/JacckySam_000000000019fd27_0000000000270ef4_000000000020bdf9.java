import java.util.*;
class Solution
{
    public static boolean check(int[] ar,int b,int e)
    {
        for(int i=b;i<=e;i++)
        {
            //System.out.print(ar[i]+" ");
            if(ar[i] == 1)
            {
                //System.out.println("false");
                return false;
            }
        }
       // System.out.println("true");
        return true;
    }
    public static void main(String[] arsghas)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- > 0)
        {
            int n=sc.nextInt();
            int[][] time=new int[n][2];
            for(int i=0;i<n;i++)
            {
                time[i][0]=sc.nextInt();
                time[i][1]=sc.nextInt();
            }
            String s="C";
            int[] c=new int[1441];
            int[] j=new int[1441];
            int tina=-1;
            for(int i=0;i<n;i++)
            {
                int b=time[i][0];
                    int e=time[i][1];
                   // System.out.println(b+" "+e);
                    tina=-1;
                if(i==0)
                {
                    
                    for(int x=b;x<=e;x++)
                    {
                        c[x]=1;
                    }
                }
                else
                {
                    if(check(c,b,e))
                    {
                        tina=1;
                        s=s+"C";
                        for(int k=b;k<=e;k++)
                        {
                            c[k]=1;
                        }
                    }
                    else if(check(j,b,e))
                    {
                        tina=1;
                        s=s+"J";
                        for(int k=b;k<=e;k++)
                        {
                            j[k]=1;
                        }
                    }
                    if(tina == -1 )
                    {
                        System.out.println("IMPOSSIBLE");
                        break;
                    }
                }
            }
            if(tina==1)
            {
                System.out.println(s);
            }
        }
        
    }
}