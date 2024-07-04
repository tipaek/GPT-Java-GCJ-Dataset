class Solution
{
    public static void main(String args[])
    {
        int t,a[][]=new int[100][100];
        Scanner sc=new Scanner(System.in);
        t=sc.nextInt();
        for(int k=1;k<=t;k++)
        {
            int n=sc.nextInt();
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    a[i][j]=sc.nextInt();
                }
            }
            int trace=0,rows=0,cols=0;
            for(int i=0;i<n;i++)
            {
                trace+=a[i][i];
            }
            System.out.println("Case #"+k+": "+trace+" "+rows+" "+cols);
        }
        
    }
}