import java.util.*;
class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int c=1;c<=t;c++)
        {
            int n=sc.nextInt(),k=sc.nextInt();
            int[][] a=new int[n][n];
            ArrayList<Integer> list=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                int start=i+1;
                list.add(i);
                for(int j=0;j<n;j++)
                {
                    a[i][j]=start;
                    start++;
                    if(start==n) start=1;
                }
            }
            int[] x=new int[n];
            System.out.print("Case #1"+": ");
            if(!possible(x,a,0,list,k))
                System.out.print("IM");
            System.out.println("POSSIBLE");
        }
    }
    public static boolean possible(int[] x,int[][] a,int index,ArrayList<Integer> list,int k)
    {
        if(index==a.length && k==0)
            return true;
        if(index==a.length || k<0)
            return false;
        for(int i=0;i<a.length;i++)
        {
            if(x[i]!=1)
            {
                x[i]=1;
                k=k-a[index][list.get(i)];
                if(possible(x,a,index+1,list,k))
                    return true;
                k=k+a[index][list.get(i)];
                x[i]=0;
            }
        }
        return false;
    }
}