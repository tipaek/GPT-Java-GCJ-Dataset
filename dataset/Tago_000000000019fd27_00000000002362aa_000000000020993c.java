import java.util.Scanner;
class Main
{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int res[][] = new int[t][3];
        for(int i=0;i<t;i++)
        {
            res[i][0] = 0;
            res[i][1] = 0;
            res[i][2] = 0;
            int n = sc.nextInt();
            int mat[][] = new int[n][n];
            for(int j=0;j<n;j++)
            {
                boolean rowFlag = true;
                for(int k=0;k<n;k++)
                {
                    int nextInt = sc.nextInt();
                    if(rowFlag)
                    {
                        int rowArr[] = mat[j];
                        for (int element : rowArr)
                        {
                            if (element == nextInt) 
                            {
                                res[i][1]++;
                                rowFlag = false;
                            }
                        }
                    }
                    mat[j][k] = nextInt;
                    if(j==k)
                    {
                        res[i][0] = res[i][0] + mat[j][j];
                    }
                }
            }
            for(int j=0;j<n;j++)
            {
                int colArr[] = new int[n];
                outerloop:
                for(int k=0;k<n;k++)
                {
                    int nextInt = mat[k][j];
                    for (int element : colArr)
                    {
                        if (element == nextInt) 
                        {
                            res[i][2]++;
                            break outerloop;
                        }
                    }
                    colArr[k] = nextInt;
                }
            }
            
        }
        for(int i=0;i<t;i++)
        {
            System.out.println("Case #"+(i+1)+": "+res[i][0]+" "+res[i][1]+" "+res[i][2]);
        }
	}
}
