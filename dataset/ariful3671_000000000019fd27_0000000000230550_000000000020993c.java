import java.util.Scanner;
 
class Solution {

    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        int caseNo=1;
        while(t>0)
        {
            int n=scanner.nextInt();
            int[][] m=new int[n][n];
            int trace=0;
            int row=0;
            int col=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    m[i][j]=scanner.nextInt();
                }
            }
            for(int i=0;i<n;i++)
            {
                trace+=m[i][i];
            }
            for(int i=0;i<n;i++)
            {
                boolean matchFound=false;
                for(int j=0;j<n-1;j++)
                {
                    for(int k=j+1;k<n;k++)
                    {
                        if(m[i][j]==m[i][k])
                        {
                            row++;
                            matchFound=true;
                            break;
                        }
                    }
                    if(matchFound)
                    {
                        break;
                    }
                }
            }
            for(int i=0;i<n;i++)
            {
                boolean matchFound=false;
                for(int j=0;j<n-1;j++)
                {
                    for(int k=j+1;k<n;k++)
                    {
                        if(m[j][i]==m[k][i])
                        {
                            col++;
                            matchFound=true;
                            break;
                        }
                    }
                    if(matchFound)
                    {
                        break;
                    }
                }
            }
            System.out.println("Case #"+caseNo+": "+trace+" "+row+" "+col);
            caseNo++;
            t--;
        }
    }

}
