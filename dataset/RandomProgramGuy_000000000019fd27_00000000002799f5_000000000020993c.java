import java.util.*;
//import java.lang.*;
 class codejam
{

    public static void printMatrix(int Matrix[][])
    {
        for(int i=0;i<Matrix.length;i++)
        {
            for(int j=0;j<Matrix[i].length;j++)
            {
                System.out.print(Matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static int findTrace(int Matrix[][])
    {
        int mlength=Matrix.length;
        int trace= 0;
        for(int i=0;i<mlength;i++)
        {
            trace = Matrix[i][i] + trace;
        }
        return trace;
    }

    public static int repeatRows(int Matrix[][])
    {
        int count=0;
        int mlength = Matrix.length;
        int i=0;
        
        for(i=0;i<mlength;i++)
        {
            outer:
            for(int j=0;j<(mlength-1);j++)
            {
                for(int k=j+1;k<mlength;k++)
                {
                    if(Matrix[i][j]==Matrix[i][k] )
                    {
                        count++;
                        break outer;
                    }

                }

            }


        }
        return count;

    }

    public static int repeatCols(int Matrix[][])
    {
        int count=0;
        int mlength = Matrix.length;
        int j=0;
        
        for(j=0;j<mlength;j++)
        {
            outer:
            for(int i=0;i<(mlength-1);i++)
            {
                for(int k=i+1;k<mlength;k++)
                {
                    if(Matrix[j][i]==Matrix[k][j] )
                    {
                        count++;
                        break outer;
                    }

                }

            }


        }
        return count;
    }


    public static void main (final String args[])
    {
        int TestCase;
        final Scanner input = new Scanner(System.in);
        TestCase = input.nextInt();
        for(int i=1;i<=TestCase;i++)
        {
            int N;
            N = input.nextInt();
            int[][] Matrix = new int[N][N];
            for (int k=0;k<N;k++)
            {
                for (int j=0 ; j<N;j++)
                {
                    Matrix[k][j] = input.nextInt();
                }
            }
            //printMatrix(Matrix);
            //System.out.println(Matrix.length);
            System.out.println("Case #"+TestCase +": "+findTrace(Matrix)+" "+repeatRows(Matrix)+" "+repeatCols(Matrix));
            

        }
    }
}