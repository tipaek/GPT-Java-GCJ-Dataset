import java.util.Scanner;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt(),tno=0;
        while(T-->0)
        {
            int N=sc.nextInt();
            int a[][]=new int[N][N];
            int nums[];
            int k=0,r=0,c=0,vr=-1;
            for(int i=0;i<N;i++)
            {
                nums=new int[N+1];
                for(int j=0;j<N;j++)
                {
                    a[i][j]=sc.nextInt();
                    nums[a[i][j]]++;
                    if(i==j)
                        k=k+a[i][j];
                    if(nums[a[i][j]]>1 && i>vr)
                    {
                        r++;
                        vr=i;
                    }
                }
            }
            for(int j=0;j<N;j++)
            {
                nums=new int[N+1];
                for(int i=0;i<N;i++)
                {
                    nums[a[i][j]]++;
                    if(nums[a[i][j]]>1)
                    {
                        c++;
                        break;
                    }
                }
            }
            System.out.println("Case #"+(++tno)+": "+k+" "+r+" "+c);
        }
    }
}