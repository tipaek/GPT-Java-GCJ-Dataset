class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int c=1;c<=t;c++)
        {
            int n=sc.nextInt();
            int[][] a=new int[n][n];
            int trace=0,rows=0,cols=0;
            HashSet<Integer> hs=new HashSet<>();
            for(int i=0;i<n;i++)
            {
                hs=new HashSet<>();
                for(int j=0;j<n;j++)
                {
                    a[i][j]=sc.nextInt();
                    if(hs.contains(a[i][j]))
                        rows++;
                    else hs.add(a[i][j]);
                    if(i==j) trace+=a[i][j];
                }
            }
            for(int i=0;i<n;i++)
            {
                hs=new HashSet<>();
                for(int j=0;j<n;j++)
                {
                    if(hs.contains(a[j][i]))
                        cols++;
                    else hs.add(a[j][i]);
                }
            }
            System.out.print("Case #"+c+": ");
            System.out.println(trace+" "+rows+" "+cols);
        }
    }
}